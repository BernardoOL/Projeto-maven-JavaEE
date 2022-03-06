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

    public List<UsuarioEntity> listarUsuarios(){
        return usuarioDAO.listAll();
    }

    public UsuarioEntity pegarUsuarioPorID(Long id){
        return usuarioDAO.findById(id);
    }

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        usuarioDAO.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void deletarUsuario(Long id){
        usuarioDAO.delete(id);
    }

    
}
