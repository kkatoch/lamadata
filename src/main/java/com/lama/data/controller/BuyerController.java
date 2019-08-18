package com.lama.data.controller;

import com.lama.data.model.Buyer;
import com.lama.data.service.BuyerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buyers")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Buyers")
public class BuyerController {
    private final BuyerService buyerService;

    @GetMapping
    public ResponseEntity<List<Buyer>> findAll() {
        return ResponseEntity.ok(buyerService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.save(buyer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> findById(@PathVariable Long id) {
        Optional<Buyer> buyer = buyerService.findById(id);
        if (!buyer.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(buyer.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> update(@PathVariable Long id, @Valid @RequestBody Buyer buyer) {
        if (!buyerService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(buyerService.save(buyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!buyerService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        buyerService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
