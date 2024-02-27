package com.springcloudexample.serviceproduct.repository;

import com.springcloudexample.serviceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategoryId(Long id);
}
