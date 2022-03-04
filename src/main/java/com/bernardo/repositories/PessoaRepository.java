package com.bernardo.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.bernardo.DAO.PessoaDAO;
import com.bernardo.DTOs.PessoaDTO;
import com.bernardo.models.PessoaModel;

@Stateless
public class PessoaRepository{

    @Inject
    PessoaDAO pessoaDAO;

    public List<PessoaModel> listarUsuarios(){
        return pessoaDAO.list();
    }

    public PessoaModel pegarPessoaPorId(Long idPessoa){
        return pessoaDAO.findById(idPessoa);
    }

    @Transactional
    public PessoaModel criarPessoa(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel(pessoaDTO);
        pessoaDAO.insert(pessoaModel);
        return pessoaModel;
    }

    @Transactional
    public PessoaDTO atualizarPessoa(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel(pessoaDTO);
        pessoaModel = pessoaDAO.update(pessoaModel);
        return new PessoaDTO(pessoaModel);
    }

    @Transactional
    public void deletarPessoa(Long idPessoa){
        PessoaModel pessoaModel = pessoaDAO.findById(idPessoa);
        pessoaDAO.remove(pessoaModel);
    }

}