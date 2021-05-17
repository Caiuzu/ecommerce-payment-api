package br.com.ecommerce.payment.listener;

import br.com.ecommerce.payment.service.PaymentService;
import checkout.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {

    private final PaymentService paymentService;

    @KafkaListener(topics = "${spring.cloud.stream.bindings.checkout-payment-input.destination}",
            groupId = "${spring.cloud.stream.bindings.checkout-payment-input.group}")
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
        log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);
        paymentService.create(checkoutCreatedEvent).orElseThrow(IllegalArgumentException::new);
    }
}
