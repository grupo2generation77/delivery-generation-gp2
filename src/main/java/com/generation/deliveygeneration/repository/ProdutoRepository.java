package com.generation.deliveygeneration.repository;

import com.generation.deliveygeneration.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findAllBySaudavelTrue();
}
