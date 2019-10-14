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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Product must have a Color")
    private Color color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Product must have a Medium")
    private ArtMedium artMedium;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Product must have an Art Category")
    private ArtCategory artCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Product must have an Art Style")
    private ArtStyle artStyle;

    @NotNull(message = "Height is mandatory")
    private double height;

    @NotNull(message = "Width is mandatory")
    private double width;

    @NotNull(message = "Depth is mandatory")
    private double depth;

    @NotNull(message = "Weight is mandatory")
    private double weight;

    @NotNull(message = "Year of Creation is mandatory")
    private int createdYear;

    @NotBlank(message = "Inspiration is mandatory")
    private String inspiration;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_product_id")
    @NotNull(message = "Product must have a Product Tag")
    private Set<Tag> Tag;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
