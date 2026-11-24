package com.product.api.controller;

import com.product.api.models.DadosCadastroProduct;
import com.product.api.models.Product;
import com.product.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("products")
@RestController

public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProduct dados) {
        repository.save(new Product(dados));
    }

}
