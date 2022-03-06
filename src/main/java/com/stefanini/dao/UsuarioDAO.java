package com.stefanini.dao;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.entity.UsuarioEntity;

//Extendendo essa classe do GenericDAO e passando os parâmetros(Nome da classe, tipo do id da classe 
@ApplicationScoped 
public class UsuarioDAO extends GenericDAO<UsuarioEntity, Long>{
    
}