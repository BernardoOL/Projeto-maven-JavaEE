package com.stefanini.resources;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.entity.UsuarioEntity;
import com.stefanini.services.UsuarioService;


@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    Calendar calendario = Calendar.getInstance();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");

    //CRUD
    @GET
    public Response listarUsuarios() {
        //Adicionando o método listarUsuarios em uma lista do tipo usuarioDTO
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuarios();
        //Resposta para o front-end usando o verbo http 200 - OK
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    //Adicionando um path para fazer a consulta com id. Esse path vai ser tratado como valor e ser usado como parâmetro
    @Path("/{idUsuario}")
    //Passando o id recebido no Path como parâmetro
    public Response pegarUsuarioPorID(@PathParam("idUsuario") Long id) {
        //Fazendo o variável usarioDTO receber o método pegarUsuarioPorID da usuarioService
        UsuarioDTO usuarioDTO = usuarioService.pegarUsuarioPorID(id);
        //Resposta para o front-end usando o verbo http 200 - OK
        return Response.status(Response.Status.OK).entity(usuarioDTO).build();
    }

    @POST
    @Valid //Validar as anotações da entidade
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        //Criando um usuario Entity recebendo o método criarUsuario vindo da usuarioService
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioService.criarUsuario(usuarioDTO));
        //Fazendo a verificação para saber o usuarioEntity recebendo o método criarUsuario não está vazio
        if (Objects.nonNull(usuarioEntity)) {
            //Caso não esteja vazio irá retornar um verbo http 200 - OK 
            return Response.ok(new UsuarioDTO(usuarioEntity)).build();
        }
        //Caso esteja vazio irá retornar um verbo http 400 - BAD_REQUEST - Servidor não entendeu a requisição ou está com uma sintaxe errada
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro na sua requisição").build();
    }

    @PUT
    @Valid //Validar as anotações da entidade
    public Response atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioUpdate = usuarioService.atualizarUsuario(usuarioDTO);
        return Response.status(Response.Status.OK).entity(usuarioUpdate).build();
    }

    @DELETE
    //Adicionando um path para deletar um usuário pelo id dele de aniversariantes do mês. Esse path vai ser tratado como valor e ser usado como parâmetro
    @Path("/{idUsuario}")
    //Passando o id recebido no Path como parâmetro
    public Response deletarUsuario(@PathParam("idUsuario") Long idUsuario) {
        //Chamando o método deletarUsuario da usuarioService
        usuarioService.deletarUsuario(idUsuario);
        //Caso de tudo certo retornando um verbo http 202 - ACCEPTED - A requisição foi recebida mas nenhuma ação foi tomada sobre ela.
        return Response.status(Response.Status.ACCEPTED).build();
    }

    //OUTROS MÉTODOS

    @GET
    //Adicionando um path para fazer a consulta de aniversariantes do mês. Esse path não vai ser tratado como valor
    @Path("/aniversariantes")
    public Response pegarMes() {
        //Pegando a lista de pessoas que passando na verificação de mês
        List<UsuarioDTO> listarUsuarios = usuarioService.pegarMes();
        //Caso não tenha ninguém na lista irá retornar um verbo http 204 - NO_CONTENT - Sem conteúdo
        if(listarUsuarios.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).entity(listarUsuarios).build();
        }
        //Caso tenha pessoas na lista irá retornar um verbo http 200 - OK 
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();

    }

    @GET
    //Adicionando um path para fazer a consulta dos Provedores de email dos usuários. Esse path não vai ser tratado como valor
    @Path("/provedores")
    public Response pegarProvedores(){
        List<String> listarProvedores = usuarioService.pegarProvedores();
        //Caso não tenha email na lista irá retornar um verbo http 204 - NO_CONTENT - Sem conteúdo
        if(listarProvedores.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).entity(listarProvedores).build();
        }
        //Caso tenha email na lista irá retornar um verbo http 200 - OK 
        return Response.status(Response.Status.OK).entity(listarProvedores).build();
    }
}
