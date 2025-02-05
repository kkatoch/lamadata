package com.lama.data.service;

import com.lama.data.model.Seller;
import com.lama.data.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellerService {
    @Autowired
    private final SellerRepository sellerRepository;

    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> findById(UUID id) {
        return sellerRepository.findById(id);
    }

    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteById(UUID id) {
        sellerRepository.deleteById(id);
    }
}
