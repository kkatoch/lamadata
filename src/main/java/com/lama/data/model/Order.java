package com.lama.data.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @NotNull(message = "Order must have a buyer ID")
    private Buyer buyer;

    @OneToMany
    @NotNull(message = "An Order must have Order Items")
    @JoinColumn
    private Set<OrderItem> orderItems;

    @OneToOne
    @JoinColumn
    @NotNull(message = "Order must have a Currency")
    private Currency currency;

    @NotNull(message = "Order must have an Order Status")
    private OrderStatus orderStatus = OrderStatus.DRAFT;
}
