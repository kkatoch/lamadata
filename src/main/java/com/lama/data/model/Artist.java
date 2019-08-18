package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private String education;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_type_id", nullable = false)
    private Set<ArtistType> artistTypes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "award_id")
    private Set<Award> awards;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "art_listings_id")
    private Set<ArtListing> artListings;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
