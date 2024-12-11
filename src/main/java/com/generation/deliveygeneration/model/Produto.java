package com.generation.deliveygeneration.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nome;

    @NotBlank
    @Size(min = 2, max = 100)
    private String descricao;

    @NotBlank
    @Size(min = 2, max = 50)
    private String categoria;

    private boolean saudavel;

    @NotNull
    private long valor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
    @JsonIgnoreProperties({"usuario", "produto"})
    private List<Pedido> pedidos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 2, max = 50) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(min = 2, max = 50) String nome) {
        this.nome = nome;
    }

    public @NotBlank @Size(min = 2, max = 100) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank @Size(min = 2, max = 100) String descricao) {
        this.descricao = descricao;
    }

    @NotNull
    public long getValor() {
        return valor;
    }

    public void setValor(@NotNull long valor) {
        this.valor = valor;
    }

    public boolean isSaudavel() {
        return saudavel;
    }

    public void setSaudavel(boolean saudavel) {
        this.saudavel = saudavel;
    }

    public @NotBlank @Size(min = 2, max = 50) String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank @Size(min = 2, max = 50) String categoria) {
        this.categoria = categoria;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
