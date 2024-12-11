package com.generation.deliveygeneration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O Atributo Nome é obrigatorio!")
    @Size(min = 2, max = 50,message = "minimo de 2 caracteres e maximo de 50")
    private String nome;

    @NotBlank(message = "O Atributo Descricao é obrigatorio")
    @Size(min = 2, max = 100,message = "minimo de 2 caracteres e maximo de 100")
    private String descricao;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "O Atributo Nome é obrigatorio!") @Size(min = 2, max = 50, message = "minimo de 2 caracteres e maximo de 50") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O Atributo Nome é obrigatorio!") @Size(min = 2, max = 50, message = "minimo de 2 caracteres e maximo de 50") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O Atributo Descricao é obrigatorio") @Size(min = 2, max = 100, message = "minimo de 2 caracteres e maximo de 100") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "O Atributo Descricao é obrigatorio") @Size(min = 2, max = 100, message = "minimo de 2 caracteres e maximo de 100") String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
