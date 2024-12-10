package com.generation.deliveygeneration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.deliveygeneration.model.Produto;
import com.generation.deliveygeneration.repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
}
