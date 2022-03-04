package com.bernardo.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import com.bernardo.DTOs.PessoaDTO;
import com.bernardo.models.PessoaModel;
import com.bernardo.repositories.PessoaRepository;

@Stateless
public class PessoaService {
    
    @EJB
    PessoaRepository pessoaRepository;

    public PessoaService(){
    }

    public List<PessoaDTO> listarPessoas(){
        List<PessoaModel> list = pessoaRepository.listarUsuarios();
        return list.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }

    public PessoaDTO pegarPessoaPorId(Long idPessoa){
        return new PessoaDTO(pessoaRepository.pegarPessoaPorId(idPessoa));
    }

    public PessoaDTO criaPessoa(PessoaDTO pessoaDTO){
        return new PessoaDTO(pessoaRepository.criarPessoa(pessoaDTO));
    }

    public PessoaDTO atualizarPessoa(PessoaDTO pessoaDTO){
        return pessoaRepository.atualizarPessoa(pessoaDTO);
    }

    public void deletarPessoa(Long idPessoa){
        pessoaRepository.deletarPessoa(idPessoa);
    }
}
