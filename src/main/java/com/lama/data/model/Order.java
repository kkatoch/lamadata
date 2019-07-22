package com.lama.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "buyer_id", nullable = false)
    private Buyer buyer;

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    private Set<Product> product;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private OrderStatus orderStatus = OrderStatus.DRAFT;
}
