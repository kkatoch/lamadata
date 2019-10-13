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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "art_medium_id", nullable = false)
    private ArtMedium artMedium;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "art_category_id", nullable = false)
    private ArtCategory artCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "art_style_id", nullable = false)
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", nullable = false)
    private Set<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", nullable = false)
    private Set<Image> images;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
