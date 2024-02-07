package com.vct.springbasicauth.controller;

import com.vct.springbasicauth.entities.Produto;
import com.vct.springbasicauth.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

}
