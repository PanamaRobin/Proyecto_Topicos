/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.clientecitas.services;

import com.herrera.clientecitas.entity.Citas;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Herrera
 */
@Stateless
public class CitasServices {
    Citas citas;
    final String URL="http://127.0.0.1:8080/ProyectoBD/resources/Citas";
    protected WebTarget preparar()
    {
        return ClientBuilder.newClient().target(URL);
    }
    public Boolean crear(Citas citas)
    {
        try
        {Client client=ClientBuilder.newClient();
            WebTarget preparo=client.target(URL+"/crearcitas");
            Invocation.Builder invocationBuiler=preparo
                    .request(MediaType.APPLICATION_JSON);
            Response respuesta=invocationBuiler
                    .post(Entity.entity(citas,MediaType.APPLICATION_JSON));
            return true; 
            /*if(respuesta.getStatus()!=201)
            {
                return false;
            }*/
        }catch(Exception e)
        {
            System.out.println("Error"+e.getLocalizedMessage());
            return false;
        }    
    }
    public Boolean actualiza(Citas citas)
    {
        System.out.println("entreeee");
        try
            
        {
            Client client=ClientBuilder.newClient();
            WebTarget preparo=client.target(URL);
            Response respuesta=preparo.path("/actualizarcitas")
                    .request()
                    .put((Entity.entity(citas,MediaType.APPLICATION_JSON)));
            System.out.println(respuesta.getStatus());
            return true;
        }catch(Exception e)
        {
            System.out.println("Error"+e.getLocalizedMessage());
            return false;
        }    
    }
    public Boolean eliminar(String id)
    {
        try
        {
            Client client=ClientBuilder.newClient();
            WebTarget preparo=client.target(URL).path("/eliminarcitas").queryParam("id",id);
            Invocation.Builder invocationBuiler=preparo
                    .request(MediaType.APPLICATION_JSON);
            Response respuesta=invocationBuiler
                    .delete();
            
            System.out.println(respuesta.getStatus());
            return true;
        }catch(Exception e)
        {
            System.out.println("Error"+e.getLocalizedMessage());
            return false;
        }    
    }
    public List<Citas> listar(Citas citas)
    {
        Client client=ClientBuilder.newClient();
        List<Citas> m=client.target(URL+"/consultacitas")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Citas>>(){});
        return m;
        //return m;
        
    }
}
