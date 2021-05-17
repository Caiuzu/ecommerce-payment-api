package br.com.ecommerce.payment.config;

import checkout.event.CheckoutCreatedEvent;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import lombok.val;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import payment.event.PaymentCreatedEvent;

import java.util.Map;

@Configuration
public class StreamingConfig {
    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;

    @Value("${spring.cloud.stream.bindings.payment-paid-output.destination}")
    private String defaultTopic;

    @Bean
    public KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate(final KafkaProperties kafkaProperties) {
        val kafkaTemplate = new KafkaTemplate<>(producerFactory(kafkaProperties));
        kafkaTemplate.setDefaultTopic(defaultTopic);
        return kafkaTemplate;
    }

    private ProducerFactory<String, PaymentCreatedEvent> producerFactory(final KafkaProperties kafkaProperties) {
        Map<String, Object> configProps = kafkaProperties.buildProducerProperties();
        configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    private ConsumerFactory<String, CheckoutCreatedEvent> consumerFactory(final KafkaProperties kafkaProperties) {
        Map<String, Object> props = kafkaProperties.buildConsumerProperties();
        KafkaAvroDeserializer kafkaAvroDeserializer = new KafkaAvroDeserializer();
        kafkaAvroDeserializer.configure(props, false);
        return new DefaultKafkaConsumerFactory(props, new StringDeserializer(), kafkaAvroDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CheckoutCreatedEvent>
    kafkaListenerContainerFactory(final KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, CheckoutCreatedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConcurrency(1);
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        return factory;
    }
}
