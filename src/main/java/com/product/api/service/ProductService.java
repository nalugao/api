package com.product.api.service;

import com.product.api.models.DadosAtualizaProduct;
import com.product.api.models.DadosCadastroProduct;
import com.product.api.models.Product;
import com.product.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository; //injecao de dependencia

    public ProductService(ProductRepository repository){
        this.repository = repository;
    } //injecao de dependencia

    public Product cadastrar(DadosCadastroProduct dados) {
        return repository.save(new Product(dados));
    }

    public List<Product> listar() {
        return repository.findAll();
    }

    public Product buscaPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public Product atualizar(Long id, DadosAtualizaProduct dados) {
        Product produto = buscaPorId(id);
        produto.atualizarInformacoes(dados);
        return repository.save(produto);
    }

    public void deleta(Long id) {
        Product product = buscaPorId(id);
        repository.delete(product);
    }

}
