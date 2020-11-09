/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.proyecto1.resources;

import com.herrera.proyecto1.ejb.CitasFacade;
import com.herrera.proyecto1.entity.Citas;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jlher
 */
@Path("Citas")
public class OperacionesCitas {
    
    @Inject
    CitasFacade citasFacade;
    
    //Crear Cita
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crearcitas")
    public Response crearCitas(Citas citas){
        citasFacade.create(citas);
        return Response
                .ok()
                .build();
    }
    
    //Consultar tabla de citas
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/consultacitas")
    public List<Citas> consultarCitas()
    {   
       List<Citas> cp=citasFacade.findAll();
       return cp;
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actualizarcitas")
    public Response actualizarCitas(Citas citas)
    {   
        citasFacade.actualizar(citas);
        return Response
                .ok()
                .build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eliminarcitas")
    public Response eliminarCitas(@QueryParam(value="id")String id)
    {  
       citasFacade.eliminar(id);
       return Response
                .ok()
                .build();
    }
}
