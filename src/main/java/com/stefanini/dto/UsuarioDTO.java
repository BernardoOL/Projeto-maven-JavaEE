package com.stefanini.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.stefanini.entity.UsuarioEntity;

public class UsuarioDTO {

    private Long idUsuario;

    private String nome;

    private String Login;

    private String email;

    private String senha;

    private LocalDate dataDeNascimento;

    private LocalDateTime dataDeCriacao;

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
