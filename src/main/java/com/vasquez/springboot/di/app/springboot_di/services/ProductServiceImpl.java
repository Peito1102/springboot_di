package com.vasquez.springboot.di.app.springboot_di.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vasquez.springboot.di.app.springboot_di.models.Product;
import com.vasquez.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    //@Autowired
    //@Qualifier("productList")
    public ProductRepository repository;

    //@Autowired AUNQUE NO ES NECESARIO PARA EL CONSTRUCTOR
    public ProductServiceImpl(@Qualifier("productFoo") ProductRepository repository) {
        this.repository = repository;
    }

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

    public ProductRepository getRepository() {
        return repository;
    }
    //@Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

}
