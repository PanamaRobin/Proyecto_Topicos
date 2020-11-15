/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.proyectocitas.ejb;

import com.herrera.proyectocitas.entity.Citas;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author jlher
 */
@Stateless
public class CitasFacade extends AbstractFacade<Citas>{
    
    @Inject
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager(){
        return em;
    }
    
    public CitasFacade(){
        super(Citas.class);
    }
    
    public Boolean actualizar(Citas m)
    {
        try
        {
            em.createNativeQuery("UPDATE citas SET motivo = ?1, idsala = ?2 , cedpaciente = ?3, fecha = ?4 WHERE idcita = ?5")
                    .setParameter(1, m.getMotivo())
                    .setParameter(2, m.getIdsala())
                    .setParameter(3, m.getCedpaciente())
                    .setParameter(4, m.getFecha())
                    .setParameter(5, m.getIdcita())
                    .executeUpdate();
            return true;
        }catch(Exception e)
        {
            throw e;
        }
    }
    public Boolean eliminar(String id)
    {
        try
        {
            em.createNativeQuery("DELETE FROM citas WHERE idcita= ?1")
                    .setParameter(1,id)
                    .executeUpdate();
            return true;
        }catch(Exception e)
        {
            throw e;
        }
    }
    
    public Citas citaIndividual(String id)
    {
        Citas c = new Citas();
        try {
            c = (Citas) em.createNativeQuery("SELECT * FROM citas WHERE idcita= ?1",Citas.class)
                    .setParameter(1,id)
                    .getSingleResult();
            return c;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public List<Citas> obtenerCita()
    {
        try {
            return (List<Citas>) em.createNativeQuery("SELECT * FROM citas",Citas.class)
                    .getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
}
