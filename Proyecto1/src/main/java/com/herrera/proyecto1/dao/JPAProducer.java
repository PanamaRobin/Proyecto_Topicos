/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.proyecto1.dao;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jose Luis
 */
@Named(value = "jPAProducer")
@ApplicationScoped
public class JPAProducer {
    @PersistenceContext
    @Produces
    private EntityManager em;
    /**
     * Creates a new instance of JPAProducer
     */
    public JPAProducer() {
    }
    
}
