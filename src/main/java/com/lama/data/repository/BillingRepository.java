package com.lama.data.repository;

import com.lama.data.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingRepository extends JpaRepository<Billing, UUID> {
}
