package com.generation.deliveygeneration.controller;


import com.generation.deliveygeneration.model.Pedido;
import com.generation.deliveygeneration.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidoController {


    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }

    @PostMapping
    public ResponseEntity<List<Pedido>> post(@Valid @RequestBody List<Pedido> pedido) {
        return ResponseEntity.ok(pedidoRepository.saveAll(pedido));
    }

    @PutMapping
    public ResponseEntity<?> atualizarPedido(@Valid @RequestBody Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getId())) {
            return ResponseEntity.ok(pedidoRepository.save(pedido));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if(pedido.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pedidoRepository.deleteById(id);
    }
}
