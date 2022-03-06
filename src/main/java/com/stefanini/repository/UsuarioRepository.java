package com.stefanini.repository;

import java.security.KeyStore.PasswordProtection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.stefanini.entity.*;
import com.stefanini.dao.UsuarioDAO;
import com.stefanini.dto.UsuarioDTO;

@ApplicationScoped
public class UsuarioRepository {

    PasswordProtection passwordProtection;

    @Inject
    UsuarioDAO usuarioDAO;

    //Criando o método para listar usuários chamando o método listAll a partir do UsuárioDAO
    //Esse método manda o conteúdo dentro de uma lista
    public List<UsuarioEntity> listarUsuarios(){
        return usuarioDAO.listAll();
    }

    //Criando o método para pegar usuários por is chamando o método findById a partir do UsuárioDAO
    public UsuarioEntity pegarUsuarioPorID(Long id){
        //Procurando um usuário a partir do id que foi passado como parâmetro
        return usuarioDAO.findById(id);
    }

    //Criando o método para criar usuários chamando o método Save a partir do UsuárioDAO
    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        //Transformando o parâmetro UsuarioDTO recebido em um UsuarioEntity para persistir no banco.
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.save(usuarioEntity);
        //Retornando um new UsuarioDTO para que o usuarioEntity não fique transitando pelo sistema deixando o sistema mais seguro
        return new UsuarioDTO(usuarioEntity);
    }

    //Criando o método para atualizar usuários chamando o método update a partir do UsuárioDAO
    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        //Transformando o parâmetro UsuarioDTO recebido em um UsuarioEntity para persistir no banco.
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.update(usuarioEntity);
        //Retornando um new UsuarioDTO para que o usuarioEntity não fique transitando pelo sistema deixando o sistema mais seguro
        return new UsuarioDTO(usuarioEntity);
    }

    //Criando o método para deletar usuários chamando o método delete a partir do UsuárioDAO
    @Transactional
    public void deletarUsuario(Long id){
        //Deletando um usuário a partir do id que foi passado como parâmetro 
        usuarioDAO.delete(id);
    }

    
}
