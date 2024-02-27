package com.springcloudexample.serviceproduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;


    @NotEmpty(message = "Product name is empty")
    private String name;
    private String descricao;

    @Positive(message = "Stock must be greater than 0")
    private int    stock;

    @Positive(message = "Price must be greater than 0")
    private Double price;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date   createdAt;

    @NotNull(message = "Product category cannot be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
}
