package com.bernardo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bernardo.DTOs.ContaDTO;

@Entity
@Table(name = "tb_conta")
public class ContaModel implements Serializable{

    private static final Long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", nullable = false)
    private String numeroConta;

    @Column(nullable = false)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private PessoaModel pessoaModel;

    public ContaModel() {
    }

    public ContaModel(ContaDTO contaDTO) {
        this.id = contaDTO.getId();
        this.numeroConta = contaDTO.getNumeroConta();
        this.saldo = contaDTO.getSaldo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

}
