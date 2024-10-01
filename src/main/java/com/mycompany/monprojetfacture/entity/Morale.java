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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "morale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Morale.findAll", query = "SELECT m FROM Morale m"),
    @NamedQuery(name = "Morale.findByIdpers", query = "SELECT m FROM Morale m WHERE m.idpers = :idpers"),
    @NamedQuery(name = "Morale.findByNoentreprise", query = "SELECT m FROM Morale m WHERE m.noentreprise = :noentreprise")})
public class Morale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpers")
    private Integer idpers;
    @Column(name = "noentreprise")
    private Long noentreprise;
    @JoinColumn(name = "idpers", referencedColumnName = "idpers", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;

    public Morale() {
    }

    public Morale(Integer idpers) {
        this.idpers = idpers;
    }

    public Integer getIdpers() {
        return idpers;
    }

    public void setIdpers(Integer idpers) {
        this.idpers = idpers;
    }

    public Long getNoentreprise() {
        return noentreprise;
    }

    public void setNoentreprise(Long noentreprise) {
        this.noentreprise = noentreprise;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
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
        if (!(object instanceof Morale)) {
            return false;
        }
        Morale other = (Morale) object;
        if ((this.idpers == null && other.idpers != null) || (this.idpers != null && !this.idpers.equals(other.idpers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Morale[ idpers=" + idpers + " ]";
    }
    
}
