package com.eskokado.ecommerce.diopaymentapi.service;


import com.eskokado.ecommerce.diocheckoutapi.event.CheckoutCreatedEvent;
import com.eskokado.ecommerce.diopaymentapi.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
