package com.stefanini.repository;

import java.security.KeyStore.PasswordProtection;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.stefanini.entity.UsuarioEntity;


import com.stefanini.dao.GenericDAO;
import com.stefanini.dto.UsuarioDTO;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long>{

    PasswordProtection passwordProtection;

    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioEntity> usuarios = this.listAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id){
        return new UsuarioDTO(this.findById(id));
    }

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);  
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void deletarUsuario(Long idUsuario){
        this.delete(idUsuario);  
    }

    public List<UsuarioDTO> listarAniversariantesDoMes(){
        Query nativeQuery = this.createNativeQuery("select * from tb_usuario WHERE month(data_de_nascimento) = ?");
        nativeQuery.setParameter(1 , LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarInicialNome(String inicial){
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tb_usuario WHERE nome LIKE ?");
        nativeQuery.setParameter(1, inicial + "%");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());

        
    }
    
}
