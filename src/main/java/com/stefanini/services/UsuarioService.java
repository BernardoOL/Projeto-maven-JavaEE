package com.stefanini.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Objects;


import com.stefanini.dto.UsuarioDTO;
import com.stefanini.repository.UsuarioRepository;

import org.hibernate.query.NativeQuery;


//Toda regra negocião faz aqui

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public UsuarioService() {
    }

    //CRUD
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO pegarUsuarioPorID(Long id) {
        return usuarioRepository.pegarUsuarioPorID(id);
    }

    //Criar Usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        if(!Objects.nonNull(usuarioDTO.getIdUsuario())){
            throw new RuntimeException("Erro ao cadastrar, não mande o ID");
        }
        //Criptografando a senha
        String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
        usuarioDTO.setSenha(senha);
        return usuarioRepository.criarUsuario(usuarioDTO);
    }

    //Atualizar Usuário
    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        if(Objects.nonNull(usuarioDTO.getIdUsuario())){
            if(!usuarioDTO.getSenha().isEmpty()){ 
                //criptografando a senha  
                String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
                usuarioDTO.setSenha(senha);
            }
            return usuarioRepository.atualizarUsuario(usuarioDTO);
        }
        // usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        throw new RuntimeException("Erro ao cadastrar, Coloque um ID");
        }

    //Deletar Usuario
    public void deletarUsuario(Long idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);
    }

    //OUTROS MÉTODOS

    public List<UsuarioDTO> listarAniversariantesDoMes(){
        return usuarioRepository.listarAniversariantesDoMes();
    }

    public List<UsuarioDTO> listarInicialDoNome(String inicial){
        return usuarioRepository.listarInicialNome(inicial);
    }

    // public List<String> pegarProvedores() {
    //     List<String> listarProvedores = new ArrayList<>();
    //     for (UsuarioEntity usuarioEntity : usuarioRepository.listarUsuarios()) {
    //         String provedor = usuarioEntity.getEmail().substring(usuarioEntity.getEmail().indexOf("@"));
    //         listarProvedores.add(provedor);
    //     }
    //     return listarProvedores;
    // }
}
