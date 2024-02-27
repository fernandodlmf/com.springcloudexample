package com.springcloudexample.serviceproduct.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloudexample.serviceproduct.Service.IProductService;
import com.springcloudexample.serviceproduct.entity.Category;
import com.springcloudexample.serviceproduct.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService serviceProducto;

    @GetMapping
    public ResponseEntity<List<Product>> listAllProduct(@RequestParam(name = "categoryId", required = false) Long id) {
        List<Product> produtcs;

        if ( id == null ) {
            produtcs = serviceProducto.listaAllProducts();
            if ( produtcs.isEmpty() )
                return ResponseEntity.noContent().build();

        } else {
            produtcs = serviceProducto.getProductsByCategory(Category.builder().id(id).build());
            if ( produtcs.isEmpty() )
                return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(produtcs);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = serviceProducto.getProductById(id);

        if (product == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(product);

    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result) {
        Product product1 = serviceProducto.createProduct(product);

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, formatMessages(result));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(product1);

    }

    private String formatMessages(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(er -> {
                        Map<String,String> error = new HashMap<>();
                    error.put(er.getField(), er.getDefaultMessage());
                    return error;
                }).toList();
        ErrorMessage message = ErrorMessage.builder()
                .codigo("01")
                .messages(errors)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString;

        try{
            jsonString = mapper.writeValueAsString(message);

        } catch (Exception e) {
            e.printStackTrace();
        }



        return "";
    }
}
