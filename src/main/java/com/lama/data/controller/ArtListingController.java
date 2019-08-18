package com.lama.data.controller;

import com.lama.data.model.ArtListing;
import com.lama.data.service.ArtListingService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artListings")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "ArtListings")
public class ArtListingController {
    private final ArtListingService artListingService;

    @GetMapping
    public ResponseEntity<List<ArtListing>> findAll() {
        return ResponseEntity.ok(artListingService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ArtListing artListing) {
        return ResponseEntity.ok(artListingService.save(artListing));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtListing> findById(@PathVariable Long id) {
        Optional<ArtListing> artListing = artListingService.findById(id);
        if (!artListing.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(artListing.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtListing> update(@PathVariable Long id, @Valid @RequestBody ArtListing artListing) {
        if (!artListingService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(artListingService.save(artListing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!artListingService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        artListingService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
