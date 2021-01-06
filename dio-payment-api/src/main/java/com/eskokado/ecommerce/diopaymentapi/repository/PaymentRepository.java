package com.eskokado.ecommerce.diopaymentapi.repository;

import com.eskokado.ecommerce.diopaymentapi.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
