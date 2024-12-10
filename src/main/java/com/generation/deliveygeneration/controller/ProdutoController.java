package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Produto;
import com.generation.deliveygeneration.repository.ProdutoRepository;
import com.generation.deliveygeneration.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
       return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<?> atualizarCategoria(@Valid @RequestBody Produto produto) {
        if(produtoRepository.existsById(produto.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
