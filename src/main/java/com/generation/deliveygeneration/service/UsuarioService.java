package com.generation.deliveygeneration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.deliveygeneration.repository.CategoriaRepository;
import com.generation.deliveygeneration.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
}
