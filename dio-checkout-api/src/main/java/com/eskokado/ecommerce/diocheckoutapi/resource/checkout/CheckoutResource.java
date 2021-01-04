package com.eskokado.ecommerce.diocheckoutapi.resource.checkout;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@ModelAttribute CheckoutRequest checkoutRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
