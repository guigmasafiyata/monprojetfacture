/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "sondage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sondage.findAll", query = "SELECT s FROM Sondage s"),
    @NamedQuery(name = "Sondage.findByIdsondage", query = "SELECT s FROM Sondage s WHERE s.idsondage = :idsondage"),
    @NamedQuery(name = "Sondage.findByIdactivite", query = "SELECT s FROM Sondage s WHERE s.idactivite = :idactivite"),
    @NamedQuery(name = "Sondage.findByDatedebut", query = "SELECT s FROM Sondage s WHERE s.datedebut = :datedebut"),
    @NamedQuery(name = "Sondage.findByDatefin", query = "SELECT s FROM Sondage s WHERE s.datefin = :datefin")})
public class Sondage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsondage")
    private Integer idsondage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactivite")
    private int idactivite;
    @Column(name = "datedebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefin;

    public Sondage() {
    }

    public Sondage(Integer idsondage) {
        this.idsondage = idsondage;
    }

    public Sondage(Integer idsondage, int idactivite) {
        this.idsondage = idsondage;
        this.idactivite = idactivite;
    }

    public Integer getIdsondage() {
        return idsondage;
    }

    public void setIdsondage(Integer idsondage) {
        this.idsondage = idsondage;
    }

    public int getIdactivite() {
        return idactivite;
    }

    public void setIdactivite(int idactivite) {
        this.idactivite = idactivite;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsondage != null ? idsondage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sondage)) {
            return false;
        }
        Sondage other = (Sondage) object;
        if ((this.idsondage == null && other.idsondage != null) || (this.idsondage != null && !this.idsondage.equals(other.idsondage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Sondage[ idsondage=" + idsondage + " ]";
    }
    
}
