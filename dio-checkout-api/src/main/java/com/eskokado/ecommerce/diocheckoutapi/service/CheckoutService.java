package com.eskokado.ecommerce.diocheckoutapi.service;

import com.eskokado.ecommerce.diocheckoutapi.entity.CheckoutEntity;
import com.eskokado.ecommerce.diocheckoutapi.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
