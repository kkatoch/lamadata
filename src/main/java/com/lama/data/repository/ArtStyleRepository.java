package com.lama.data.repository;

import com.lama.data.model.ArtStyle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtStyleRepository extends JpaRepository<ArtStyle, UUID> {
}
