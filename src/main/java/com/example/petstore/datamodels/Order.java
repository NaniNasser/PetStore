package com.example.petstore.datamodels;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Entity
@Accessors(chain = true)
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private long petID;
    private long quantity;
    private LocalDateTime shipDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private boolean complete;
}
