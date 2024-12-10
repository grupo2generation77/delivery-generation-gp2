package com.generation.deliveygeneration.service;

import com.generation.deliveygeneration.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.generation.deliveygeneration.model.Categoria;
import com.generation.deliveygeneration.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}




}
