package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "art_listings")
public class ArtListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    private BigDecimal rentPrice;

    @NotNull(message = "Is Rent is mandatory")
    private boolean isRent;
    @NotNull(message = "Is Sell is mandatory")
    private boolean isSell;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
