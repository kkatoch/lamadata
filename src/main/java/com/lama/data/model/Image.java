package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Small URL is mandatory")
    private String smallUrl;

    @NotBlank(message = "Medium URL is mandatory")
    private String mediumUrl;

    @NotBlank(message = "Large URL is mandatory")
    private String largeUrl;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
