package com.eskokado.ecommerce.diocheckoutapi.service;

import com.eskokado.ecommerce.diocheckoutapi.entity.CheckoutEntity;
import com.eskokado.ecommerce.diocheckoutapi.event.CheckoutCreatedEvent;
import com.eskokado.ecommerce.diocheckoutapi.repository.CheckoutRepository;
import com.eskokado.ecommerce.diocheckoutapi.resource.checkout.CheckoutRequest;
import com.eskokado.ecommerce.diocheckoutapi.streaming.CheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .build();

        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);
        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus((entity.getStatus() == null) ? "null" : entity.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(entity);
    }
}
