package com.vct.springbasicauth.controller;

import com.vct.springbasicauth.entities.Produto;
import com.vct.springbasicauth.entities.ProdutoDTO;
import com.vct.springbasicauth.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> addProduct(@RequestBody ProdutoDTO produto) {
        Produto prod = new Produto();
        prod.converte(produto);
        repository.save(prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(prod.getId()).toUri();
        return ResponseEntity.created(uri).body(prod);
    }

}
