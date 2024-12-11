package com.generation.deliveygeneration.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O Atributo Nome é Obrigatório!")
    @Size(min = 2, max = 50, message = "Minimo de 2 caracteres maximo de 50")
    private String nome;

    @NotBlank(message = "O Atributo Usuário é Obrigatório!")
    @Email(message = "O Atributo Usuário deve ser um email válido!")
    private String email;

    private String foto;

    @NotBlank(message = "O Atributo Senha é Obrigatório!")
    @Size(message = "A Senha deve ter no mínimo 8 caracteres")
    private String senha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties
    private List<Produto> produtos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public @NotBlank(message = "O Atributo Nome é Obrigatório!") @Size(min = 2, max = 50, message = "Minimo de 2 caracteres maximo de 50") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O Atributo Nome é Obrigatório!") @Size(min = 2, max = 50, message = "Minimo de 2 caracteres maximo de 50") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O Atributo Usuário é Obrigatório!") @Email(message = "O Atributo Usuário deve ser um email válido!") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O Atributo Usuário é Obrigatório!") @Email(message = "O Atributo Usuário deve ser um email válido!") String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public @NotBlank(message = "O Atributo Senha é Obrigatório!") @Size(message = "A Senha deve ter no mínimo 8 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O Atributo Senha é Obrigatório!") @Size(message = "A Senha deve ter no mínimo 8 caracteres") String senha) {
        this.senha = senha;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
