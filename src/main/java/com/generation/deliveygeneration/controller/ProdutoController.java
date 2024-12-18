package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Produto;

import com.generation.deliveygeneration.repository.ProdutoRepository;
import java.util.Optional;
import com.generation.deliveygeneration.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

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


    @GetMapping("/saudaveis")
    public ResponseEntity <List<Produto>> getAllSaudaveis(){
        return ResponseEntity.ok(produtoService.findAllSaudaveis());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        
        if(produto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        produtoRepository.deleteById(id);  
    }            
    

    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
       return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(produto.get());
    }

    @PostMapping
    public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
       return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@Valid @RequestBody Produto produto) {
        if(produtoRepository.existsById(produto.getId())) {
            return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
