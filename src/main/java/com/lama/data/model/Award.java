package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "awards")
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private Set<Artist> artists;

    @OneToMany
    @JoinColumn(name = "seller_id")
    private Set<Seller> sellers;

    @NotNull(message = "Award Date is mandatory")
    private Date awardDate;
}
