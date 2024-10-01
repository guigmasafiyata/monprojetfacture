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
@Table(name = "facture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findByIdfacture", query = "SELECT f FROM Facture f WHERE f.idfacture = :idfacture"),
    @NamedQuery(name = "Facture.findByRemise", query = "SELECT f FROM Facture f WHERE f.remise = :remise"),
    @NamedQuery(name = "Facture.findByPrix", query = "SELECT f FROM Facture f WHERE f.prix = :prix"),
    @NamedQuery(name = "Facture.findByTermepaiement", query = "SELECT f FROM Facture f WHERE f.termepaiement = :termepaiement")})
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacture")
    private Integer idfacture;
    @Column(name = "remise")
    private Long remise;
    @Column(name = "prix")
    private Long prix;
    @Size(max = 254)
    @Column(name = "termepaiement")
    private String termepaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
    private Collection<Facturedefinitive> facturedefinitiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
    private Collection<Factureproforma> factureproformaCollection;

    public Facture() {
    }

    public Facture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Long getRemise() {
        return remise;
    }

    public void setRemise(Long remise) {
        this.remise = remise;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getTermepaiement() {
        return termepaiement;
    }

    public void setTermepaiement(String termepaiement) {
        this.termepaiement = termepaiement;
    }

    @XmlTransient
    public Collection<Facturedefinitive> getFacturedefinitiveCollection() {
        return facturedefinitiveCollection;
    }

    public void setFacturedefinitiveCollection(Collection<Facturedefinitive> facturedefinitiveCollection) {
        this.facturedefinitiveCollection = facturedefinitiveCollection;
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
        hash += (idfacture != null ? idfacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.idfacture == null && other.idfacture != null) || (this.idfacture != null && !this.idfacture.equals(other.idfacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Facture[ idfacture=" + idfacture + " ]";
    }
    
}
