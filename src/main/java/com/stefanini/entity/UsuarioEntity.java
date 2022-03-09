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

import com.stefanini.dto.UsuarioDTO;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table (name = "tb_Usuario")
public class UsuarioEntity implements Serializable{
    
private static final Long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUsuario;

@Column(nullable = false, length = 50)
private String nome;

@Column(unique = true, nullable = false, length = 20)
private String login;

@Column(nullable = false)
private String email;

@Column(nullable = false)
private String senha;

@Column(name = "data_de_nascimento")
private LocalDate dataDeNascimento;

@CreationTimestamp
@Column(name = "data_de_criacao", nullable = false, updatable = false)
private LocalDateTime dataDeCriacao;

@UpdateTimestamp
@Column(name = "data_de_atualizacao")
private LocalDateTime dataDeAtualizacao;

public UsuarioEntity() {
}

public UsuarioEntity(UsuarioDTO usuarioDTO) {
    this.idUsuario = usuarioDTO.getIdUsuario();
    this.nome = usuarioDTO.getNome();
    this.login = usuarioDTO.getLogin();
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
    return login;
}

public void setLogin(String login) {
    this.login = login;
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
