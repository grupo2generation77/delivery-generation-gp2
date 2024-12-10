package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Produto;
import com.generation.deliveygeneration.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/saudaveis")
    public ResponseEntity <List<Produto>> saudaveis(){
        return ResponseEntity.ok(produtoRepository.findAllBySaudavelTrue());
    }


}
