package com.vasquez.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.vasquez.springboot.di.app.springboot_di.models.Product;

@Primary //el primary se considera cuando no hay qualifiers, es como si fuera por defecto
@RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(new Product(1L,"Memoria corsair 32", 300L),
        new Product(2L,"Cpu Intel Core i9", 850L),new Product(3L,"Teclado Razer Mini 60%", 180L),
        new Product(4L,"Motherboard Gigabyte", 490L));
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
