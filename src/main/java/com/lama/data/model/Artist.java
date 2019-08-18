package com.lama.data.model;

import com.lama.data.model.Seller;
import com.lama.data.repository.ArtistType;
import com.lama.data.repository.Award;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @NotBlank(message = "Description is mandatory")
    private String description;

    private String education;

    @OneToMany
    @JoinColumn(name = "artist_type_id", nullable = false)
    private Set<ArtistType> artistTypes;

    @OneToMany
    @JoinColumn(name = "award_id")
    private Set<Award> awards;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
