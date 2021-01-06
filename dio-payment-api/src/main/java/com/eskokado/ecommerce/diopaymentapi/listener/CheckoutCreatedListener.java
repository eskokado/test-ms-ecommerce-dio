package com.eskokado.ecommerce.diopaymentapi.listener;


import com.eskokado.ecommerce.diocheckoutapi.event.CheckoutCreatedEvent;
import com.eskokado.ecommerce.diopaymentapi.event.PaymentCreatedEvent;
import com.eskokado.ecommerce.diopaymentapi.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(Message<?> message) {
        // Processa Pagamento gateway
        // Salvar os dados de pagamento
        // Enviar o evento de pagamento processado
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
//                .setCheckoutCode(event.getCheckoutCode())
//                .setCheckoutStatus((event.getStatus() == null) ? "nulo" : event.getStatus())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();

        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
