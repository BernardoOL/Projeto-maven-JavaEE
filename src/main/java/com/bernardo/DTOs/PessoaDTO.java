package com.bernardo.DTOs;

import javax.validation.constraints.NotNull;

import com.bernardo.models.PessoaModel;

public class PessoaDTO {

    private Long id;

    @NotNull(message = "Nome não pode ser nulo!")
    private String nome;

    @NotNull(message = "Email não pode ser nulo!")
    private String email;
    
    @NotNull(message = "Senha não pode ser nulo!")
    private String senha;

    public PessoaDTO(){
    }
    
    public PessoaDTO(PessoaModel pessoaModel){
        this.id = pessoaModel.getId();
        this.nome = pessoaModel.getNome();
        this.email = pessoaModel.getEmail();
        this.senha = pessoaModel.getSenha();
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
