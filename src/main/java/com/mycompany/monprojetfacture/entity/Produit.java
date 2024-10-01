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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByNopro", query = "SELECT p FROM Produit p WHERE p.nopro = :nopro"),
    @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom"),
    @NamedQuery(name = "Produit.findByDesignation", query = "SELECT p FROM Produit p WHERE p.designation = :designation")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nopro")
    private Integer nopro;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "designation")
    private String designation;
    @ManyToMany(mappedBy = "produitCollection")
    private Collection<Commande> commandeCollection;
    @JoinColumn(name = "noliv", referencedColumnName = "noliv")
    @ManyToOne(optional = false)
    private Livraison noliv;

    public Produit() {
    }

    public Produit(Integer nopro) {
        this.nopro = nopro;
    }

    public Integer getNopro() {
        return nopro;
    }

    public void setNopro(Integer nopro) {
        this.nopro = nopro;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public Livraison getNoliv() {
        return noliv;
    }

    public void setNoliv(Livraison noliv) {
        this.noliv = noliv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nopro != null ? nopro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.nopro == null && other.nopro != null) || (this.nopro != null && !this.nopro.equals(other.nopro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Produit[ nopro=" + nopro + " ]";
    }
    
}
