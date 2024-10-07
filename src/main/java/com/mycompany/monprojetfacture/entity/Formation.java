/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "formation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formation.findAll", query = "SELECT f FROM Formation f"),
    @NamedQuery(name = "Formation.findByNoform", query = "SELECT f FROM Formation f WHERE f.noform = :noform"),
    @NamedQuery(name = "Formation.findByIntitule", query = "SELECT f FROM Formation f WHERE f.intitule = :intitule"),
    @NamedQuery(name = "Formation.findByPrixHt", query = "SELECT f FROM Formation f WHERE f.prixHt = :prixHt"),
    @NamedQuery(name = "Formation.findByDuree", query = "SELECT f FROM Formation f WHERE f.duree = :duree")})
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "noform")
    private Integer noform;
    @Size(max = 254)
    @Column(name = "intitule")
    private String intitule;
    @Column(name = "prixHt")
    private Long prixHt;
    @Column(name = "duree")
    private Character duree;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture")
    @ManyToOne(optional = false)
    private Facturedefinitive idfacture;
    @JoinColumn(name = "idretenue", referencedColumnName = "idretenue")
    @ManyToOne
    private Retenue idretenue;

    public Formation() {
    }

    public Formation(Integer noform) {
        this.noform = noform;
    }

    public Integer getNoform() {
        return noform;
    }

    public void setNoform(Integer noform) {
        this.noform = noform;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Long getPrixHt() {
        return prixHt;
    }

    public void setPrixHt(Long prixHt) {
        this.prixHt = prixHt;
    }

    public Character getDuree() {
        return duree;
    }

    public void setDuree(Character duree) {
        this.duree = duree;
    }

    public Facturedefinitive getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Facturedefinitive idfacture) {
        this.idfacture = idfacture;
    }

    public Retenue getIdretenue() {
        return idretenue;
    }

    public void setIdretenue(Retenue idretenue) {
        this.idretenue = idretenue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noform != null ? noform.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formation)) {
            return false;
        }
        Formation other = (Formation) object;
        if ((this.noform == null && other.noform != null) || (this.noform != null && !this.noform.equals(other.noform))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Formation[ noform=" + noform + " ]";
    }
    
}
