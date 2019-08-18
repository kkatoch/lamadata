package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
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
}
