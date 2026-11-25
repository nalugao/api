package com.product.api.controller;

import com.product.api.models.DadosAtualizaProduct;
import com.product.api.models.DadosCadastroProduct;
import com.product.api.models.Product;
import com.product.api.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")

public class ProductController {
    private final ProductService service;//injecao de dependencia

    public ProductController(ProductService service) {
        this.service = service;
    }//injecao de dependencia

    @PostMapping
    public Product cadastrar(@RequestBody DadosCadastroProduct dados) {
        return service.cadastrar(dados);
    }

    @GetMapping
    public List<Product> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Product buscarPorId(@PathVariable Long id) {
        return service.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public Product atualizar(@PathVariable Long id, @RequestBody DadosAtualizaProduct dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void deleta(@PathVariable Long id) {
        service.deleta(id);
    }
}
