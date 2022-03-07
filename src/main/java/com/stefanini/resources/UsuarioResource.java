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
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuarios();
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorID(@PathParam("idUsuario") Long id) {
        UsuarioDTO usuarioDTO = usuarioService.pegarUsuarioPorID(id);
        return Response.status(Response.Status.OK).entity(usuarioDTO).build();
    }

    @POST
    @Valid 
    public Response criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioService.criarUsuario(usuarioDTO));
        if (Objects.nonNull(usuarioEntity)) {
            return Response.status(Response.Status.CREATED).entity(new UsuarioDTO(usuarioEntity)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro na sua requisição").build();
    }

    @PUT
    @Valid 
    public Response atualizarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioUpdate = usuarioService.atualizarUsuario(usuarioDTO);
        return Response.status(Response.Status.OK).entity(usuarioUpdate).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response deletarUsuario(@PathParam("idUsuario") Long idUsuario) {
        usuarioService.deletarUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    //Outros End-points
    
    @GET
    @Path("/aniversariantes")
    public Response pegarMes() {
        List<UsuarioDTO> listarUsuarios = usuarioService.pegarMes();
        if(listarUsuarios.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).entity(listarUsuarios).build();
        }
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    @Path("/provedores")
    public Response pegarProvedores(){
        List<String> listarProvedores = usuarioService.pegarProvedores();
        if(listarProvedores.isEmpty()){
            return Response.status(Response.Status.NO_CONTENT).entity(listarProvedores).build();
        }
        return Response.status(Response.Status.OK).entity(listarProvedores).build();
    }
}
