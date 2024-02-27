package com.springcloudexample.serviceproduct;

import com.springcloudexample.serviceproduct.entity.Category;
import com.springcloudexample.serviceproduct.entity.Product;
import com.springcloudexample.serviceproduct.repository.IProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ProductRepositoryMockTest {

    @Autowired
    private IProductRepository productRepository;

    @Test
    void whenFindByCategoryThenReturnListProducts() {
        Product product = Product.builder()
                .name("Professional XMAX-Pro")
                .price(200.0)
                .stock(2)
                .descricao("bom drone")
                .createdAt(new Date())
                .category(Category.builder().id(1L).name("Drones").build())
                .build();

        productRepository.save(product);

        List<Product> list = productRepository.findByCategoryId(product.getCategory().getId());

        list.forEach(e -> System.out.println("Produtoo" + e.toString()));

        Assertions.assertThat(list.size()).isEqualTo(1);

    }
}
