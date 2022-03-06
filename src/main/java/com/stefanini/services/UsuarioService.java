package com.stefanini.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<UsuarioDTO> listarUsuarios() {
        List<UsuarioEntity> list = usuarioRepository.listarUsuarios();
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id) {
        return new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(id));
    }

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

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        usuarioDTO.setDataDeCriacao(LocalDateTime.now());
        return usuarioRepository.criarUsuario(usuarioDTO);
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuario = new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(usuarioDTO.getIdUsuario()));
        usuarioDTO.setDataDeCriacao(usuario.getDataDeCriacao());
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        return usuarioRepository.atualizarUsuario(usuarioDTO);
    }

    public void deletarUsuario(Long idUsuario) {
        usuarioRepository.deletarUsuario(idUsuario);
    }

}