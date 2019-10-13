package com.lama.data.repository;

import com.lama.data.model.ArtListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtListingRepository extends JpaRepository<ArtListing, UUID> {
}
