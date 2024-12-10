package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import com.generation.deliveygeneration.model.Categoria;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
    	List<Categoria> categorias = categoriaRepository.findAll();
    	return ResponseEntity.ok(categorias);
    }


}
