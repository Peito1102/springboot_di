package com.vasquez.springboot.di.app.springboot_di.services;

import java.util.List;

import com.vasquez.springboot.di.app.springboot_di.models.Product;
import com.vasquez.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    public ProductRepository repository = new ProductRepository(); 

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
        Double priceImp = p.getPrice() * 1.25;
        //p.setPrice(priceImp.longValue());
        //habia otra forma en la que devolvia un objeto nuevo
        Product newProd = (Product) p.clone();
        newProd.setPrice(priceImp.longValue());
        return newProd;
        }).toList();
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }

}
