/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "activite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a"),
    @NamedQuery(name = "Activite.findByIdactivite", query = "SELECT a FROM Activite a WHERE a.idactivite = :idactivite"),
    @NamedQuery(name = "Activite.findByDescription", query = "SELECT a FROM Activite a WHERE a.description = :description")})
public class Activite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactivite")
    private Integer idactivite;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idactivite")
    private Collection<Sondage> sondageCollection;

    public Activite() {
    }

    public Activite(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public Integer getIdactivite() {
        return idactivite;
    }

    public void setIdactivite(Integer idactivite) {
        this.idactivite = idactivite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Sondage> getSondageCollection() {
        return sondageCollection;
    }

    public void setSondageCollection(Collection<Sondage> sondageCollection) {
        this.sondageCollection = sondageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idactivite != null ? idactivite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activite)) {
            return false;
        }
        Activite other = (Activite) object;
        if ((this.idactivite == null && other.idactivite != null) || (this.idactivite != null && !this.idactivite.equals(other.idactivite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Activite[ idactivite=" + idactivite + " ]";
    }
    
}
