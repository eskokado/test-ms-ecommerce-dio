package com.eskokado.ecommerce.diocheckoutapi.config;

import com.eskokado.ecommerce.diocheckoutapi.streaming.CheckoutCreatedSource;
import com.eskokado.ecommerce.diocheckoutapi.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
