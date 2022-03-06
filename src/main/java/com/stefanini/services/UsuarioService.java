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

    //Método para listar Usuarios
    public List<UsuarioDTO> listarUsuarios(){
        //Pegamos o que recebemos do listarUsuarios e colocamos ele dentro de uma lista
        List<UsuarioEntity> list = usuarioRepository.listarUsuarios();
        return list.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    //Método para Pegar usuarios por id
    public UsuarioDTO pegarUsuarioPorID(Long id){
        //Retornando um new UsuarioDTO com o Usuario que foi achado a partir do parâmetro recebido
        return new UsuarioDTO(usuarioRepository.pegarUsuarioPorID(id));
    }

    //Método para retornar os aniversáriantes de acordo com o mês atual
    public List<UsuarioDTO> pegarMes(){
        //Criando uma lista nova para adicionar a lista de aniversariantes do mês
        List<UsuarioEntity> listarUsuarios = new ArrayList<>();
        //passando um for no método listarUsuarios onde você recebe todos os usuários cadastrados no banco
        for (UsuarioEntity UsuarioEntity : usuarioRepository.listarUsuarios()) {
            //Criando uma variável usuarioMonth recebendo o atributo dataDeNascimento de cada usuário
            LocalDate usuarioMonth = UsuarioEntity.getDataDeNascimento();
            //If verificando se o mês do usuário é o mesmo mês da data atual da sua máquina.
            if (usuarioMonth.getMonth() == LocalDate.now().getMonth()) {
                //Método para adicionar o usuário na lista criada lá em cima(listarUsuarios)
                listarUsuarios.add(UsuarioEntity);
            }
        }
        //Retornando a lista de usuários depois do for
        return listarUsuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    //Método para criar um novo usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        //Usando o método set para Colocar no atributo 
        usuarioDTO.setDataDeAtualizacao(LocalDateTime.now());
        usuarioDTO.setDataDeCriacao(LocalDateTime.now());
        return usuarioRepository.criarUsuario(usuarioDTO);
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
        //Chamando o método deletarUsuario da UsuarioRepository passando o id recebido como par
        usuarioRepository.deletarUsuario(idUsuario);
    }
    
}