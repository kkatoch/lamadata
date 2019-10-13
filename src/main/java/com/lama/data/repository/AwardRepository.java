package com.lama.data.repository;

import com.lama.data.model.Award;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AwardRepository extends JpaRepository<Award, UUID> {
}
