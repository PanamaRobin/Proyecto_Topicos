/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.proyectocitas.resources;

import com.herrera.proyectocitas.ejb.CitasFacade;
import com.herrera.proyectocitas.entity.Citas;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtenercitaid/{id}")
    public Citas obtenerCitasId(@PathParam(value = "id")String id)
    {
        Citas c = citasFacade.citaIndividual(id);
        return c;
    }
    
    
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
       List<Citas> cp=citasFacade.obtenerCita();
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
