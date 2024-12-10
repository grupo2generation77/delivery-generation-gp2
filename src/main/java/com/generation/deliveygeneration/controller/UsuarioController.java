package com.generation.deliveygeneration.controller;

import com.generation.deliveygeneration.model.Usuario;
import com.generation.deliveygeneration.repository.UsuarioRepository;
import com.generation.deliveygeneration.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<?> atualizarCategoria(@Valid @RequestBody Usuario usuario) {
        if(usuarioRepository.existsById(usuario.getId())) {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

    }

}
