package com.lama.data.repository;

import com.lama.data.model.ArtListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtListingRepository extends JpaRepository<ArtListing, Long> {
}
