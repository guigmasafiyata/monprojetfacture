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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByNumcomnde", query = "SELECT c FROM Commande c WHERE c.numcomnde = :numcomnde"),
    @NamedQuery(name = "Commande.findByEtatComnde", query = "SELECT c FROM Commande c WHERE c.etatComnde = :etatComnde"),
    @NamedQuery(name = "Commande.findByDateComnde", query = "SELECT c FROM Commande c WHERE c.dateComnde = :dateComnde")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcomnde")
    private Integer numcomnde;
    @Size(max = 254)
    @Column(name = "etatComnde")
    private String etatComnde;
    @Column(name = "dateComnde")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateComnde;
    @JoinTable(name = "association23", joinColumns = {
        @JoinColumn(name = "numcomnde", referencedColumnName = "numcomnde")}, inverseJoinColumns = {
        @JoinColumn(name = "nopro", referencedColumnName = "nopro")})
    @ManyToMany
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client numcli;

    public Commande() {
    }

    public Commande(Integer numcomnde) {
        this.numcomnde = numcomnde;
    }

    public Integer getNumcomnde() {
        return numcomnde;
    }

    public void setNumcomnde(Integer numcomnde) {
        this.numcomnde = numcomnde;
    }

    public String getEtatComnde() {
        return etatComnde;
    }

    public void setEtatComnde(String etatComnde) {
        this.etatComnde = etatComnde;
    }

    public Date getDateComnde() {
        return dateComnde;
    }

    public void setDateComnde(Date dateComnde) {
        this.dateComnde = dateComnde;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Client getNumcli() {
        return numcli;
    }

    public void setNumcli(Client numcli) {
        this.numcli = numcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcomnde != null ? numcomnde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.numcomnde == null && other.numcomnde != null) || (this.numcomnde != null && !this.numcomnde.equals(other.numcomnde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Commande[ numcomnde=" + numcomnde + " ]";
    }
    
}
