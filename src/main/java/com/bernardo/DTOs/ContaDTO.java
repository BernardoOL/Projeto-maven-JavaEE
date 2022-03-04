package com.bernardo.DTOs;

import java.io.Serializable;

import com.bernardo.models.ContaModel;
import com.bernardo.models.PessoaModel;

public class ContaDTO implements Serializable{

    private static final Long serialVersionUID = 1L;
    
    private Long id;
    private String numeroConta;
    private Double saldo;
    private PessoaModel pessoaModel;

    public ContaDTO() {
    }

    public ContaDTO(ContaModel contaModel) {
        this.id = contaModel.getId();
        this.numeroConta = contaModel.getNumeroConta();
        this.saldo = contaModel.getSaldo();
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

    
    

}
