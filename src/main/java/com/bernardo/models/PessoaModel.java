package com.bernardo.models;

import java.io.Serializable;

import javax.persistence.*;

import com.bernardo.DTOs.PessoaDTO;

@Entity
@Table(name = "tb_pessoa")
public class PessoaModel implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public PessoaModel(){}

    public PessoaModel(PessoaDTO pessoaDTO){
        this.id = pessoaDTO.getId();
        this.nome = pessoaDTO.getNome();
        this.email = pessoaDTO.getEmail();
        this.senha = pessoaDTO.getSenha();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
