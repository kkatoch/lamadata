package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "artist_types")
public class ArtistType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany
    @JoinColumn(name = "artist_id", nullable = false)
    private Set<Artist> artist;
}
