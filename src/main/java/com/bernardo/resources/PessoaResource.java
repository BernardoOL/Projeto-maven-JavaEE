package com.bernardo.resources;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bernardo.DTOs.PessoaDTO;
import com.bernardo.models.PessoaModel;
import com.bernardo.services.PessoaService;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {
    
    @EJB
    private PessoaService pessoaService;

    @GET
    public Response listarPessoas(){
        List<PessoaDTO> listarPessoas = pessoaService.listarPessoas();
        return Response.status(Response.Status.OK).entity(listarPessoas).build();
    }

    @GET
    @Path("/{idPessoa}")
    public Response pegarPessoaPorId(@PathParam("idPessoa") Long idPessoa){
        PessoaDTO pessoaDTO = pessoaService.pegarPessoaPorId(idPessoa);
        return Response.status(Response.Status.OK).entity(pessoaDTO).build();
    }

    @POST
    public Response criarPessoa(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel(pessoaService.criaPessoa(pessoaDTO));
        if(Objects.nonNull(pessoaModel)){
            return Response.ok(new PessoaDTO(pessoaModel)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Ocorreu um erro ao processar a sua requisição").build();
    }

    @PUT
    public Response atualizarUsuario(PessoaDTO pessoaDTO){
        PessoaDTO pessoaUpdate = pessoaService.atualizarPessoa(pessoaDTO);
        return Response.status(Response.Status.OK).entity(pessoaUpdate).build();
    }

    @DELETE
    @Path("/{idPessoa}")
    public Response deletarPessoa(@PathParam("idPessoa") Long idPessoa){
        pessoaService.deletarPessoa(idPessoa);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
