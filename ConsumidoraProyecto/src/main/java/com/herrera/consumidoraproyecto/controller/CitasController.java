/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.consumidoraproyecto.controller;


import com.herrera.clientecitas.entity.Citas;
import com.herrera.clientecitas.services.CitasServices;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named(value = "citasController")
@ViewScoped
public class CitasController implements Serializable {

    
    @Inject
    CitasServices citasservices; 

    
    private List<Citas> listacitas;
    Citas citas;

    public List<Citas> getListaCitas() {
        this.listacitas  = citasservices.listar(citas);
        return listacitas;
    }

    public void setListaCitas(List<Citas> listacitas) {
        this.listacitas = listacitas;
    }

    public Citas getCitas() {
        return citas;
    }

    public void setCitas(Citas citas) {
        this.citas = citas;
    }
    
    @PostConstruct
    public void init()
    {
        this.citas=new Citas();
    }
    public void reset() {
        PrimeFaces.current().resetInputs("form:actualizar");
    }
     public String crearCitas()
    {
        if(citasservices.crear(citas))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se creo correctamente.") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Se creo correctamente.") );
        }
        return "";
    }
    public String cargaractua(Citas citas)
    { 
        this.citas=citas;
        return "/faces/actualizar.xhtml";
    }
    public String cargaeli(Citas citas)
    { this.citas=citas;
    return "/faces/eliminar.xhtml";
    }
    public String crear()
    {
    return "/faces/crear.xhtml";
    }
    public String index()
    {
    return "/faces/index.xhtml";
    }
    public String actualizar()
    {
        if(citasservices.actualiza(citas))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se actualizo.") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Se actualizo correctamente.") );
        }
        return "";
    }
    public String eliminar()
    {
        String id=citas.getIdcita().toString();
        if(citasservices.eliminar(id))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se elimino") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Se elimino correctamente.") );
        }
        return "";
    }
    public void limpiar()
    { 
        this.citas=new Citas();
    }
}