package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private String education;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Artist must have Artist Types")
    private Set<ArtistType> artistTypes;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "award_artist_id")
    private Set<Award> awards;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "artist")
    private Set<ArtListing> artListings;

    @ManyToOne
    @NotNull(message = "Artist must have a Seller Id")
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
