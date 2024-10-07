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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "physique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Physique.findAll", query = "SELECT p FROM Physique p"),
    @NamedQuery(name = "Physique.findByIdpers", query = "SELECT p FROM Physique p WHERE p.idpers = :idpers"),
    @NamedQuery(name = "Physique.findByPrenom", query = "SELECT p FROM Physique p WHERE p.prenom = :prenom")})
public class Physique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpers")
    private Integer idpers;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;

    public Physique() {
    }

    public Physique(Integer idpers) {
        this.idpers = idpers;
    }

    public Integer getIdpers() {
        return idpers;
    }

    public void setIdpers(Integer idpers) {
        this.idpers = idpers;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpers != null ? idpers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Physique)) {
            return false;
        }
        Physique other = (Physique) object;
        if ((this.idpers == null && other.idpers != null) || (this.idpers != null && !this.idpers.equals(other.idpers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Physique[ idpers=" + idpers + " ]";
    }
    
}
