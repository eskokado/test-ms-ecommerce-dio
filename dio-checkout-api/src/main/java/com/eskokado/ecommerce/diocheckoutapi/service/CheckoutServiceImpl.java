package com.eskokado.ecommerce.diocheckoutapi.service;

import com.eskokado.ecommerce.diocheckoutapi.entity.CheckoutEntity;
import com.eskokado.ecommerce.diocheckoutapi.repository.CheckoutRepository;
import com.eskokado.ecommerce.diocheckoutapi.resource.checkout.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
