package com.lama.data.service;

import com.lama.data.model.Buyer;
import com.lama.data.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyerService {
    @Autowired
    private final BuyerRepository buyerRepository;

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    public Optional<Buyer> findById(Long id) {
        return buyerRepository.findById(id);
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public void deleteById(Long id) {
        buyerRepository.deleteById(id);
    }
}
