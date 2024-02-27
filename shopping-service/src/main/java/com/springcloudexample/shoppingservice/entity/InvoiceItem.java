package com.springcloudexample.shoppingservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "invoice_item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive(message = "Quantity must be greater than 0")
    private Double quantity;

    @Positive(message = "Price cannot be 0")
    private Double price;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Transient
    private Double subTotal;

    public Double calculeSubTotal() {
        if (this.price > 0 && this.quantity > 0)
            return this.price * this.quantity;
        else
            return (double) 0;
    }

}
