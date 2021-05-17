package br.com.ecommerce.payment.service;

import br.com.ecommerce.payment.entity.PaymentEntity;
import br.com.ecommerce.payment.repository.PaymentRepository;
import checkout.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import payment.event.PaymentCreatedEvent;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final KafkaTemplate<String, PaymentCreatedEvent> kafkaTemplate;

    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = getPaymentEntity(checkoutCreatedEvent);
        paymentRepository.save(paymentEntity);
        final PaymentCreatedEvent paymentCreatedEvent = getPaymentCreatedEvent(paymentEntity);
        kafkaTemplate.send(MessageBuilder.withPayload(paymentCreatedEvent).build());

        return Optional.of(paymentEntity);
    }

    private PaymentEntity getPaymentEntity(final CheckoutCreatedEvent checkoutCreatedEvent) {
        return PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
    }

    private PaymentCreatedEvent getPaymentCreatedEvent(final PaymentEntity paymentEntity) {
        return PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
    }
}