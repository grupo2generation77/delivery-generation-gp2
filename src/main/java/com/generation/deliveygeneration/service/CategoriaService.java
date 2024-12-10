package com.generation.deliveygeneration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.deliveygeneration.repository.CategoriaRepository;

@Service
public class CategoriaService{


    @Autowired
    private CategoriaRepository categoriaRepository;
	
}
