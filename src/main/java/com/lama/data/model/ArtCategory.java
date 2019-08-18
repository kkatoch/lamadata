package com.lama.data.model;

import com.lama.data.model.Product;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Table(name = "art_categories")
public class ArtCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany
    @JoinColumn(name = "product_id")
    private Set<Product> products;
}
