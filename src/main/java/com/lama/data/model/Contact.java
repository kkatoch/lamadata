package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Phone Number is mandatory")
    private int phoneNumber;

    @OneToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @NotBlank(message = "First Line of Address is mandatory")
    private String addressFirst;

    @NotBlank(message = "Second Line of Address is mandatory")
    private String addressSecond;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @NotBlank(message = "Pin Code is mandatory")
    private String pinCode;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
