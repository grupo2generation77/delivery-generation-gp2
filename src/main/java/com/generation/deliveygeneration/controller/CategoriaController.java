package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Categoria;
import com.generation.deliveygeneration.repository.CategoriaRepository;
import com.generation.deliveygeneration.service.CategoriaService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
    	List<Categoria> categorias = categoriaService.findAll();
    	return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(categoria.get());
    }

    @PostMapping
    public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@Valid @RequestBody Categoria categoria) {
        if(categoriaRepository.findById(categoria.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        
        if(categoria.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        categoriaRepository.deleteById(id);    
    }
}