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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "retenue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Retenue.findAll", query = "SELECT r FROM Retenue r"),
    @NamedQuery(name = "Retenue.findByIdretenue", query = "SELECT r FROM Retenue r WHERE r.idretenue = :idretenue"),
    @NamedQuery(name = "Retenue.findByTauxretention", query = "SELECT r FROM Retenue r WHERE r.tauxretention = :tauxretention")})
public class Retenue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idretenue")
    private Integer idretenue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tauxretention")
    private Float tauxretention;
    @OneToMany(mappedBy = "idretenue")
    private Collection<Formation> formationCollection;

    public Retenue() {
    }

    public Retenue(Integer idretenue) {
        this.idretenue = idretenue;
    }

    public Integer getIdretenue() {
        return idretenue;
    }

    public void setIdretenue(Integer idretenue) {
        this.idretenue = idretenue;
    }

    public Float getTauxretention() {
        return tauxretention;
    }

    public void setTauxretention(Float tauxretention) {
        this.tauxretention = tauxretention;
    }

    @XmlTransient
    public Collection<Formation> getFormationCollection() {
        return formationCollection;
    }

    public void setFormationCollection(Collection<Formation> formationCollection) {
        this.formationCollection = formationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idretenue != null ? idretenue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Retenue)) {
            return false;
        }
        Retenue other = (Retenue) object;
        if ((this.idretenue == null && other.idretenue != null) || (this.idretenue != null && !this.idretenue.equals(other.idretenue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Retenue[ idretenue=" + idretenue + " ]";
    }
    
}
