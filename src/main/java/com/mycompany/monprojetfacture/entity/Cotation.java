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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cotation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotation.findAll", query = "SELECT c FROM Cotation c"),
    @NamedQuery(name = "Cotation.findByIdcotation", query = "SELECT c FROM Cotation c WHERE c.idcotation = :idcotation"),
    @NamedQuery(name = "Cotation.findByValeur", query = "SELECT c FROM Cotation c WHERE c.valeur = :valeur")})
public class Cotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcotation")
    private Integer idcotation;
    @Column(name = "valeur")
    private Long valeur;
    @OneToMany(mappedBy = "idcotation")
    private Collection<Personne> personneCollection;
    @JoinColumn(name = "idpers", referencedColumnName = "idpers")
    @ManyToOne(optional = false)
    private Personne idpers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotidcotation")
    private Collection<Factureproforma> factureproformaCollection;

    public Cotation() {
    }

    public Cotation(Integer idcotation) {
        this.idcotation = idcotation;
    }

    public Integer getIdcotation() {
        return idcotation;
    }

    public void setIdcotation(Integer idcotation) {
        this.idcotation = idcotation;
    }

    public Long getValeur() {
        return valeur;
    }

    public void setValeur(Long valeur) {
        this.valeur = valeur;
    }

    @XmlTransient
    public Collection<Personne> getPersonneCollection() {
        return personneCollection;
    }

    public void setPersonneCollection(Collection<Personne> personneCollection) {
        this.personneCollection = personneCollection;
    }

    public Personne getIdpers() {
        return idpers;
    }

    public void setIdpers(Personne idpers) {
        this.idpers = idpers;
    }

    @XmlTransient
    public Collection<Factureproforma> getFactureproformaCollection() {
        return factureproformaCollection;
    }

    public void setFactureproformaCollection(Collection<Factureproforma> factureproformaCollection) {
        this.factureproformaCollection = factureproformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcotation != null ? idcotation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotation)) {
            return false;
        }
        Cotation other = (Cotation) object;
        if ((this.idcotation == null && other.idcotation != null) || (this.idcotation != null && !this.idcotation.equals(other.idcotation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Cotation[ idcotation=" + idcotation + " ]";
    }
    
}
