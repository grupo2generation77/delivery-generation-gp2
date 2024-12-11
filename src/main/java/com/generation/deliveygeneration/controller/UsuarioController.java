package com.generation.deliveygeneration.controller;
import com.generation.deliveygeneration.model.Usuario;
import com.generation.deliveygeneration.repository.UsuarioRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.generation.deliveygeneration.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        
        if(usuario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        usuarioRepository.deleteById(id);
     }              
    

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
    	return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok(usuario.get());
    }


    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<?> updateCategoria(@Valid @RequestBody Usuario usuario) {
        if(usuarioRepository.existsById(usuario.getId())) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }

    }

}
