package com.lama.data.repository;

import com.lama.data.model.ArtMedium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtMediumRepository extends JpaRepository<ArtMedium, UUID> {
}
