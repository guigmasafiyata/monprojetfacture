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
import jakarta.persistence.OneToOne;
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
@Table(name = "facturedefinitive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturedefinitive.findAll", query = "SELECT f FROM Facturedefinitive f"),
    @NamedQuery(name = "Facturedefinitive.findByIdfacture", query = "SELECT f FROM Facturedefinitive f WHERE f.idfacture = :idfacture"),
    @NamedQuery(name = "Facturedefinitive.findByEtatFacture", query = "SELECT f FROM Facturedefinitive f WHERE f.etatFacture = :etatFacture"),
    @NamedQuery(name = "Facturedefinitive.findByDocumentJuridique", query = "SELECT f FROM Facturedefinitive f WHERE f.documentJuridique = :documentJuridique")})
public class Facturedefinitive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacture")
    private Integer idfacture;
    @Size(max = 254)
    @Column(name = "etatFacture")
    private String etatFacture;
    @Size(max = 254)
    @Column(name = "documentJuridique")
    private String documentJuridique;
    @OneToMany(mappedBy = "idfacture")
    private Collection<Paiement> paiementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfacture")
    private Collection<Formation> formationCollection;
    @JoinColumn(name = "Cli_numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client clinumcli;
    @JoinColumn(name = "Cli_numcli2", referencedColumnName = "numcli")
    @ManyToOne
    private Client clinumcli2;
    @JoinColumn(name = "numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client numcli;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Facture facture;
    @JoinColumn(name = "idpaiement", referencedColumnName = "idpaiement")
    @ManyToOne(optional = false)
    private Paiement idpaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facidfacture")
    private Collection<Factureproforma> factureproformaCollection;
    @OneToMany(mappedBy = "idfacture")
    private Collection<Client> clientCollection;

    public Facturedefinitive() {
    }

    public Facturedefinitive(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public String getEtatFacture() {
        return etatFacture;
    }

    public void setEtatFacture(String etatFacture) {
        this.etatFacture = etatFacture;
    }

    public String getDocumentJuridique() {
        return documentJuridique;
    }

    public void setDocumentJuridique(String documentJuridique) {
        this.documentJuridique = documentJuridique;
    }

    @XmlTransient
    public Collection<Paiement> getPaiementCollection() {
        return paiementCollection;
    }

    public void setPaiementCollection(Collection<Paiement> paiementCollection) {
        this.paiementCollection = paiementCollection;
    }

    @XmlTransient
    public Collection<Formation> getFormationCollection() {
        return formationCollection;
    }

    public void setFormationCollection(Collection<Formation> formationCollection) {
        this.formationCollection = formationCollection;
    }

    public Client getClinumcli() {
        return clinumcli;
    }

    public void setClinumcli(Client clinumcli) {
        this.clinumcli = clinumcli;
    }

    public Client getClinumcli2() {
        return clinumcli2;
    }

    public void setClinumcli2(Client clinumcli2) {
        this.clinumcli2 = clinumcli2;
    }

    public Client getNumcli() {
        return numcli;
    }

    public void setNumcli(Client numcli) {
        this.numcli = numcli;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Paiement getIdpaiement() {
        return idpaiement;
    }

    public void setIdpaiement(Paiement idpaiement) {
        this.idpaiement = idpaiement;
    }

    @XmlTransient
    public Collection<Factureproforma> getFactureproformaCollection() {
        return factureproformaCollection;
    }

    public void setFactureproformaCollection(Collection<Factureproforma> factureproformaCollection) {
        this.factureproformaCollection = factureproformaCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        if (!(object instanceof Facturedefinitive)) {
            return false;
        }
        Facturedefinitive other = (Facturedefinitive) object;
        if ((this.idfacture == null && other.idfacture != null) || (this.idfacture != null && !this.idfacture.equals(other.idfacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Facturedefinitive[ idfacture=" + idfacture + " ]";
    }
    
}
