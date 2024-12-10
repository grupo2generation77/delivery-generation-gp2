package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Categoria;
import com.generation.deliveygeneration.repository.CategoriaRepository;
import com.generation.deliveygeneration.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import com.generation.deliveygeneration.model.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
    	List<Categoria> categorias = categoriaRepository.findAll();
    	return ResponseEntity.ok(categorias);
    }



    @PostMapping
    public ResponseEntity<Categoria> adicionaCategoria(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@Valid @RequestBody Categoria categoria) {
        if(categoriaRepository.findById(categoria.getId()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }
}
