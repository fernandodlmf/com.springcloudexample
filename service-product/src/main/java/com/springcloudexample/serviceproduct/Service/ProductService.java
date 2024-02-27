package com.springcloudexample.serviceproduct.Service;

import com.springcloudexample.serviceproduct.entity.Category;
import com.springcloudexample.serviceproduct.entity.Product;
import com.springcloudexample.serviceproduct.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{


    private final IProductRepository repository;

    @Override
    public List<Product> listaAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setCreatedAt(new Date());

        return repository.save(product);
    }

    @Override
    public Product deleteProduct(Product product) {

        return null;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {

        return repository.findByCategoryId(category.getId());
    }
}
