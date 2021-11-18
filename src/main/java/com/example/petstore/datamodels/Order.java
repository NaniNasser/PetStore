package com.example.petstore.datamodels;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Integer petID;
    private Integer quantity;
    private LocalDateTime shipDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private boolean complete;
}
