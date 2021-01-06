package com.eskokado.ecommerce.diopaymentapi.config;

import com.eskokado.ecommerce.diopaymentapi.streaming.CheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
}
