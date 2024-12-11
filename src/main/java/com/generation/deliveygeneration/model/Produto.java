package com.generation.deliveygeneration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O Atributo Nome é obrigatorio!")
    @Size(min = 2, max = 50,message = "minimo de 2 caracteres e maximo de 50")
    private String nome;

    @NotBlank(message = "O Atributo Descricao é obrigatorio")
    @Size(min = 2, max = 100,message = "minimo de 2 caracteres e maximo de 100")
    private String descricao;

    @NotNull(message = "coloque um valor")
    private long valor;

    private boolean saudavel;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Usuario usuario;

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

    @NotNull(message = "coloque um valor")
    public long getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "coloque um valor") long valor) {
        this.valor = valor;
    }

    public boolean isSaudavel() {
        return saudavel;
    }

    public void setSaudavel(boolean saudavel) {
        this.saudavel = saudavel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
