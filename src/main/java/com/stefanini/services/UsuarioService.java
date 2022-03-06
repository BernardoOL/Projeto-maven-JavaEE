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

    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioEntity> list = usuarioRepository.listarUsuarios();
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id){
        return new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(id));
    }

    //Método para retornar os aniversáriantes de acordo com o mês atual
    public List<UsuarioDTO> pegarMes(){
        List<UsuarioEntity> listarUsuarios = new ArrayList<>();
        for (UsuarioEntity UsuarioEntity : usuarioRepository.listarUsuarios()) {
            LocalDate usuarioMonth = UsuarioEntity.getDataDeNascimento();
            if (usuarioMonth.getMonth() == LocalDate.now().getMonth()) {
                listarUsuarios.add(UsuarioEntity);
            }
        }
        return listarUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        usuarioDTO.setDataDeCriacao(LocalDateTime.now());
        return new UsuarioDTO(usuarioRepository.criarUsuario(usuarioDTO));
    }

    public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO){
        //Buscando o usuario requisitado e instanciando ele em uma new DTO
        UsuarioDTO usuario = new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(usuarioDTO.getIdUsuario()));
        //Pegando o valor dataDeCriacao do banco (a partir do new DTO no código anterior) e setando no mesmo atributo para que não haja alteração. Assim o campo não será nulo
        usuarioDTO.setDataDeCriacao(usuario.getDataDeCriacao());
        //Mudando o atributo dataDeAtualização para a hora atual, fazendo assim toda vez que for modificado ele alterar para a data atual em que foi modificado.
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        //chamando o método atualizarUsuario da UsuarioRepository
        return usuarioRepository.atualizarUsuario(usuarioDTO);
    }

    public void deletarUsuario(Long idUsuario){
        usuarioRepository.deletarUsuario(idUsuario);
    }
    
}