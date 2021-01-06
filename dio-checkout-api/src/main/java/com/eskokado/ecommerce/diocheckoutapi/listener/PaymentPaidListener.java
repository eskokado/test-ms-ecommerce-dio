package com.eskokado.ecommerce.diocheckoutapi.listener;

import com.eskokado.ecommerce.diocheckoutapi.entity.CheckoutEntity;
import com.eskokado.ecommerce.diocheckoutapi.event.PaymentCreatedEvent;
import com.eskokado.ecommerce.diocheckoutapi.service.CheckoutService;
import com.eskokado.ecommerce.diocheckoutapi.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
