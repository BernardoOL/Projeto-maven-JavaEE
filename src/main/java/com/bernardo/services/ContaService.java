package com.bernardo.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.bernardo.DAO.ContaDAO;
import com.bernardo.DTOs.ContaDTO;
import com.bernardo.models.ContaModel;

@Stateless
public  class ContaService{
    
    @EJB
    ContaDAO contaDAO;

    public ContaService(){
    }

    public ContaModel salvar(ContaDTO contaDTO){
        ContaModel conta = new ContaModel(contaDTO);
        contaDAO.insert(conta);
        return conta;
    }



}
