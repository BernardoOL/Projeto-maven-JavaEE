package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_pessoa")
public class PessoaModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    public PessoaModel(){
    }

    public Long getId() {
        return idPessoa;
    }

    public void setId(Long id) {
        this.idPessoa = id;
    }

}
