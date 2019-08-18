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
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "password is mandatory")
    private String password;

    private boolean isEmailVerified = false;

    @OneToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "billing_id")
    private Billing billing;

    @OneToOne
    @JoinColumn(name = "seller_type_id", nullable = false)
    private SellerType sellerType;

    private boolean isVerified = false;

    private String description;

    @OneToMany
    @JoinColumn(name = "artist_id")
    private Set<Artist> artists;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
