package com.lama.data.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "Currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Symbol is mandatory")
    private String symbol;

    @NotBlank(message = "Base Name is mandatory")
    private String baseName;

    @NotBlank(message = "Base Symbol is mandatory")
    private String baseSymbol;

    @NotNull(message = "SOD Rate is mandatory")
    private BigDecimal sodRate;

    @NotNull(message = "MOD Rate is mandatory")
    private BigDecimal modRate;

    @NotNull(message = "EOD Rate is mandatory")
    private BigDecimal eodRate;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
