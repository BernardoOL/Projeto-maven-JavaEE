package com.stefanini.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entity.UsuarioEntity;
import com.stefanini.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public UsuarioService() {
    }

    //CRUD
    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> list = usuarioRepository.listarUsuarios();
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id) {
        return new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(id));
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioNull = null;
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        usuarioDTO.setDataDeCriacao(LocalDateTime.now());
        
        if(usuarioDTO.getSenha().length() >=4 && usuarioDTO.getSenha().length() <= 10){
            //criptografando a senha
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
            return usuarioRepository.criarUsuario(usuarioDTO);
        }else{
            return usuarioNull;
        }
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(usuarioDTO.getIdUsuario()));
        usuarioDTO.setDataDeCriacao(usuario.getDataDeCriacao());
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());

        if(usuarioDTO.getSenha().isEmpty()){
            usuarioDTO.setSenha(usuario.getSenha());

        return usuarioRepository.atualizarUsuario(usuarioDTO);
        }else{
            //criptografando a senha
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
            return usuarioRepository.atualizarUsuario(usuarioDTO);
        }
    }

    public void deletarUsuario(Long idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);
    }

    //OUTROS MÉTODOS

    public List<UsuarioDTO> pegarMes() {
        List<UsuarioEntity> listarUsuarios = new ArrayList<>();
        for (UsuarioEntity UsuarioEntity : usuarioRepository.listarUsuarios()) {
            LocalDate usuarioMonth = UsuarioEntity.getDataDeNascimento();
            if (usuarioMonth.getMonth() == LocalDate.now().getMonth()) {
                listarUsuarios.add(UsuarioEntity);
            }
        }
        return listarUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<String> pegarProvedores() {
        List<String> listarProvedores = new ArrayList<>();
        for (UsuarioEntity usuarioEntity : usuarioRepository.listarUsuarios()) {
            String provedor = usuarioEntity.getEmail().substring(usuarioEntity.getEmail().indexOf("@"));
            listarProvedores.add(provedor);
        }
        return listarProvedores;
    }
}
