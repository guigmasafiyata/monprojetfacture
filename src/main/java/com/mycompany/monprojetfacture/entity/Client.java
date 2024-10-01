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
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByNumcli", query = "SELECT c FROM Client c WHERE c.numcli = :numcli"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numcli")
    private Integer numcli;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numcli")
    private Collection<Commande> commandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numcli")
    private Collection<Facturedefinitive> facturedefinitiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numcli")
    private Collection<Factureproforma> factureproformaCollection;
    @JoinColumns({
        @JoinColumn(name = "idfacture", referencedColumnName = "idfacture"),
        @JoinColumn(name = "nofacturedef", referencedColumnName = "nofacturedef")})
    @ManyToOne
    private Facturedefinitive facturedefinitive;

    public Client() {
    }

    public Client(Integer numcli) {
        this.numcli = numcli;
    }

    public Integer getNumcli() {
        return numcli;
    }

    public void setNumcli(Integer numcli) {
        this.numcli = numcli;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
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

    public Facturedefinitive getFacturedefinitive() {
        return facturedefinitive;
    }

    public void setFacturedefinitive(Facturedefinitive facturedefinitive) {
        this.facturedefinitive = facturedefinitive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numcli != null ? numcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numcli == null && other.numcli != null) || (this.numcli != null && !this.numcli.equals(other.numcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Client[ numcli=" + numcli + " ]";
    }
    
}
