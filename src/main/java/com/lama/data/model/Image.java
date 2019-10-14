package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    @NotBlank(message = "Small URL is mandatory")
    private String smallUrl;

    @Column(unique = true)
    @NotBlank(message = "Medium URL is mandatory")
    private String mediumUrl;

    @Column(unique = true)
    @NotBlank(message = "Large URL is mandatory")
    private String largeUrl;

    @ManyToOne
    @NotNull(message = "Image must have a Product")
    @JoinColumn(name = "product_id")
    private Product product;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
