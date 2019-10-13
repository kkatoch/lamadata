package com.lama.data.repository;

import com.lama.data.model.ArtCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArtCategoryRepository extends JpaRepository<ArtCategory, UUID> {

}
