package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Country Code is mandatory")
    private int code;
}
