package com.generation.deliveygeneration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.deliveygeneration.repository.ProdutoRepository;

import com.generation.deliveygeneration.model.Produto;


import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> findAllSaudaveis() {
        return produtoRepository.findAllBySaudavelTrue();
    }

}
