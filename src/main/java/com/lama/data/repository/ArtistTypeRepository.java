package com.lama.data.repository;

import com.lama.data.model.ArtistType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtistTypeRepository extends JpaRepository<ArtistType, UUID> {
}
