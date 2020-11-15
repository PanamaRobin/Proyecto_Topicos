/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.herrera.clientecitas.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jlher
 */
@Entity
@Table(name = "citas")
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByIdcita", query = "SELECT c FROM Citas c WHERE c.idcita = :idcita"),
    @NamedQuery(name = "Citas.findByMotivo", query = "SELECT c FROM Citas c WHERE c.motivo = :motivo"),
    @NamedQuery(name = "Citas.findByIdsala", query = "SELECT c FROM Citas c WHERE c.idsala = :idsala"),
    @NamedQuery(name = "Citas.findByCedpaciente", query = "SELECT c FROM Citas c WHERE c.cedpaciente = :cedpaciente"),
    @NamedQuery(name = "Citas.findByFecha", query = "SELECT c FROM Citas c WHERE c.fecha = :fecha")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcita")
    private Integer idcita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "motivo")
    private String motivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsala")
    private int idsala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cedpaciente")
    private String cedpaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Citas() {
    }

    public Citas(Integer idcita) {
        this.idcita = idcita;
    }

    public Citas(Integer idcita, String motivo, int idsala, String cedpaciente, Date fecha) {
        this.idcita = idcita;
        this.motivo = motivo;
        this.idsala = idsala;
        this.cedpaciente = cedpaciente;
        this.fecha = fecha;
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getCedpaciente() {
        return cedpaciente;
    }

    public void setCedpaciente(String cedpaciente) {
        this.cedpaciente = cedpaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcita != null ? idcita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idcita == null && other.idcita != null) || (this.idcita != null && !this.idcita.equals(other.idcita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.herrera.clientecitas.entity.Citas[ idcita=" + idcita + " ]";
    }
    
}
