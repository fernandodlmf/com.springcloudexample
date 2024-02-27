package com.springcloudexample.serviceproduct;

import com.springcloudexample.serviceproduct.Service.IProductService;
import com.springcloudexample.serviceproduct.Service.ProductService;
import com.springcloudexample.serviceproduct.entity.Category;
import com.springcloudexample.serviceproduct.entity.Product;
import com.springcloudexample.serviceproduct.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
class ProductServiceMockTest {

    @Mock
    private IProductRepository productRepository;

    private IProductService productService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductService(productRepository);

        Product product = Product.builder()
                .id(1L)
                .stock(5)
                .name("Novo Drone")
                .category(Category.builder().id(1L).build())
                .createdAt(new Date())
                .price(300.2).build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));
    }

    @Test
    void whenValidGetIdThenReturnProduct() {
        Product product = productService.getProductById(1L);
        Assertions.assertThat(product.getName())
                .isEqualTo("Novo Drone");
    }


}
