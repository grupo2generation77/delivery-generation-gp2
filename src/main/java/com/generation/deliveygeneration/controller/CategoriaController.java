package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Categoria;
import com.generation.deliveygeneration.repository.CategoriaRepository;
import com.generation.deliveygeneration.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
