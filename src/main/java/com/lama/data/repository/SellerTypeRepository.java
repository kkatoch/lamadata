package com.lama.data.repository;

import com.lama.data.model.SellerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerTypeRepository extends JpaRepository<SellerType, UUID> {
}
