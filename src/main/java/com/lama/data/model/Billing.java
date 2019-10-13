package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotNull(message = "Account Number is mandatory")
    private int accountNumber;

    @NotNull(message = "Sort Code is mandatory")
    private int sortCode;

    @NotNull(message = "IBAN Number is mandatory")
    private int ibanNumber;

    @NotNull(message = "Swift Code is mandatory")
    private int swiftCode;

    @NotNull(message = "IFSC Code is mandatory")
    private int ifscCode;

    @NotBlank(message = "PaypalAddress is mandatory")
    private String paypalAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;
}
