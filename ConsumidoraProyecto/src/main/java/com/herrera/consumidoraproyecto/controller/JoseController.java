/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.consumidoraproyecto.controller;

import com.jose.clientmedicamento.entity.Medicamentos;
import com.jose.clientmedicamento.services.MedicamentoServices;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author jlher
 */
@Named(value = "joseController")
@ViewScoped
public class JoseController implements Serializable{
    @Inject
    MedicamentoServices medicamentoServices;
    
    private List<Medicamentos> listamedicamentos;
    Medicamentos medicamentos;
    
    public List<Medicamentos> getListaMedicamentos() {
        this.listamedicamentos  = medicamentoServices.listar(medicamentos);
        return listamedicamentos;
    }

    public void setListaMedicamentos(List<Medicamentos> listamedicamentos) {
        this.listamedicamentos = listamedicamentos;
    }

    public Medicamentos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }
    
    @PostConstruct
    public void init()
    {
        this.medicamentos=new Medicamentos();
    }
    public void reset() {
        PrimeFaces.current().resetInputs("form:actualizar");
    }
     public String crearMedicamentos()
    {
        if(medicamentoServices.crear(medicamentos))
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","No se creo correctamente.") );
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Informacion","Se creo correctamente.") );
        }
        
        return "/faces/medicamentos.xhtml";
    }
   
    public String actualizar(Medicamentos m)
    {
        if(medicamentoServices.actualiza(m))
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
    
    public String eliminar(Medicamentos m)
    {
        String id=m.getId().toString();
        if(medicamentoServices.eliminar(id))
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
        this.medicamentos=new Medicamentos();
    }
    
    public void cargarMedicamento(Medicamentos m)
    {
        String id = m.getId().toString();
        this.medicamentos = medicamentoServices.obtenerporid(id);
    }
}
