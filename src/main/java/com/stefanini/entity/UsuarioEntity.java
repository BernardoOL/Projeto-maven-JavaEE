package com.stefanini.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.stefanini.dto.UsuarioDTO;


@Entity
@Table (name = "tb_Usuario")
public class UsuarioEntity implements Serializable{
    
private static final Long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUsuario;


@NotEmpty(message = "Nome não pode ser vazio")//Não pode ser vazio.
@Column(nullable = false, length = 50)//Não pode ser nulo - limite de 50 caracteres
private String nome;


@Size(min = 5, max = 20)//Mínimo e máximo
@NotEmpty(message = "Login não pode ser nulo")//Não pode ser vazio.
@Column(unique = true, nullable = false)//Tipo unico - Não pode ser nulo
private String Login;

@Size(min = 10)
@NotEmpty(message = "Email não pode ser nulo")
@Email //Fazer com que o campo seja email
@Column(nullable = false)
private String email;

@Size(min = 4, max = 10)
@NotEmpty(message = "senha não pode ser nulo")
@Column(nullable = false)
private String senha;

@Column(name = "data_de_nascimento", nullable = true)
private LocalDate dataDeNascimento;//Tipo LocalDate vai retornar somente a data

@Column(name = "data_de_criacao",nullable = false)
private LocalDateTime dataDeCriacao;//Tipo LocalDateTime vai retornar data e hora

@Column(name = "data_de_atualizacao",nullable = true)
private LocalDateTime dataDeAtualizacao;

public UsuarioEntity() {
}

public UsuarioEntity(UsuarioDTO usuarioDTO) {
    this.idUsuario = usuarioDTO.getIdUsuario();
    this.nome = usuarioDTO.getNome();
    this.Login = usuarioDTO.getLogin();
    this.email = usuarioDTO.getEmail();
    this.senha = usuarioDTO.getSenha();
    this.dataDeNascimento = usuarioDTO.getDataDeNascimento();
    this.dataDeCriacao = usuarioDTO.getDataDeCriacao();
    this.dataDeAtualizacao = usuarioDTO.getDataDeAtualizacao();
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
