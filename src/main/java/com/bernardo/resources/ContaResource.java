package com.bernardo.resources;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bernardo.DTOs.ContaDTO;
import com.bernardo.models.ContaModel;
import com.bernardo.services.ContaService;


@Path("/contas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContaResource {

    @EJB
    ContaService contaService;

    @POST
    public Response getConta(ContaDTO contaDTO){
        ContaModel contaModel = contaService.salvar(contaDTO);
        return Response.ok(contaModel).build();

    }
    
}
