package com.lama.data.service;

import com.lama.data.model.ArtListing;
import com.lama.data.repository.ArtListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArtListingService {
    @Autowired
    private final ArtListingRepository artListingRepository;

    public List<ArtListing> findAll() {
        return artListingRepository.findAll();
    }

    public Optional<ArtListing> findById(UUID id) {
        return artListingRepository.findById(id);
    }

    public ArtListing save(ArtListing artListing) {
        return artListingRepository.save(artListing);
    }

    public void deleteById(UUID id) {
        artListingRepository.deleteById(id);
    }
}
