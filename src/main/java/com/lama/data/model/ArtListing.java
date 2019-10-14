package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class ArtListing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Art Listing must have a Product")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private Product product;

    @NotNull(message = "Listing must have an Artist Id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Artist artist;

    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    private BigDecimal rentPrice;

    @NotNull(message = "Is Rent is mandatory")
    private boolean isRent;
    @NotNull(message = "Is Sell is mandatory")
    private boolean isSell;

    @NotNull(message = "Art Listing must have a Currency")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Currency currency;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
