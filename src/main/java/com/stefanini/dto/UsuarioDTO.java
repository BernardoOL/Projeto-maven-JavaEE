package com.stefanini.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stefanini.entity.UsuarioEntity;



public class UsuarioDTO {

    private Long idUsuario;

    @NotEmpty(message = "Nome não pode ser vazio - Preencha-o por favor")
    @Size(max = 50)
    private String nome;

    @NotEmpty(message = "Login não pode ser vazio - Preencha-o por favor")
    @Size(min = 5, max = 20)
    private String Login;

    @NotEmpty(message = "Email não pode ser vazio - Preencha-o por favor")
    @Size(min = 10)
    @Email
    private String email;

    @NotEmpty(message = "Email não pode ser vazio - Preencha por favor")
    @Size(min = 4, max = 10)
    private String senha;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDeNascimento;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDeCriacao;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDeAtualizacao;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.nome = usuarioEntity.getNome();
        this.Login = usuarioEntity.getLogin();
        this.email = usuarioEntity.getEmail();
        this.senha = usuarioEntity.getSenha();
        this.dataDeNascimento = usuarioEntity.getDataDeNascimento();
        this.dataDeCriacao = usuarioEntity.getDataDeCriacao();
        this.dataDeAtualizacao = usuarioEntity.getDataDeAtualizacao();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long id) {
        this.idUsuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
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

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }

    public LocalDateTime getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }
    
}
