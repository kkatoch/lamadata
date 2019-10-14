package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @NotNull(message = "Address must have country")
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
