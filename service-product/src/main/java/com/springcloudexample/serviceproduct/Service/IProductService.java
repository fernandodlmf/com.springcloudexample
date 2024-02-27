package com.springcloudexample.serviceproduct.Service;

import com.springcloudexample.serviceproduct.entity.Category;
import com.springcloudexample.serviceproduct.entity.Product;

import java.util.List;

public interface IProductService {

    List<Product> listaAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product deleteProduct(Product product);
    List<Product> getProductsByCategory(Category category);
}
