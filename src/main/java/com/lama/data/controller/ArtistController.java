package com.lama.data.controller;

import com.lama.data.model.Artist;
import com.lama.data.service.ArtistService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artists")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Artists")
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> findAll() {
        return ResponseEntity.ok(artistService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.save(artist));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> findById(@PathVariable Long id) {
        Optional<Artist> artist = artistService.findById(id);
        if (!artist.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(artist.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> update(@PathVariable Long id, @Valid @RequestBody Artist artist) {
        if (!artistService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(artistService.save(artist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!artistService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        artistService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
