/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
@Table(name = "facturedefinitive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturedefinitive.findAll", query = "SELECT f FROM Facturedefinitive f"),
    @NamedQuery(name = "Facturedefinitive.findByIdfacture", query = "SELECT f FROM Facturedefinitive f WHERE f.facturedefinitivePK.idfacture = :idfacture"),
    @NamedQuery(name = "Facturedefinitive.findByNofacturedef", query = "SELECT f FROM Facturedefinitive f WHERE f.facturedefinitivePK.nofacturedef = :nofacturedef"),
    @NamedQuery(name = "Facturedefinitive.findByClinumcli", query = "SELECT f FROM Facturedefinitive f WHERE f.clinumcli = :clinumcli"),
    @NamedQuery(name = "Facturedefinitive.findByClinumcli2", query = "SELECT f FROM Facturedefinitive f WHERE f.clinumcli2 = :clinumcli2"),
    @NamedQuery(name = "Facturedefinitive.findByEtatFacture", query = "SELECT f FROM Facturedefinitive f WHERE f.etatFacture = :etatFacture"),
    @NamedQuery(name = "Facturedefinitive.findByDocumentJuridique", query = "SELECT f FROM Facturedefinitive f WHERE f.documentJuridique = :documentJuridique")})
public class Facturedefinitive implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturedefinitivePK facturedefinitivePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cli_numcli")
    private int clinumcli;
    @Column(name = "Cli_numcli2")
    private Integer clinumcli2;
    @Size(max = 254)
    @Column(name = "etatFacture")
    private String etatFacture;
    @Size(max = 254)
    @Column(name = "documentJuridique")
    private String documentJuridique;
    @OneToMany(mappedBy = "facturedefinitive")
    private Collection<Paiement> paiementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturedefinitive")
    private Collection<Formation> formationCollection;
    @JoinColumn(name = "numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client numcli;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facture facture;
    @JoinColumn(name = "idpaiement", referencedColumnName = "idpaiement")
    @ManyToOne(optional = false)
    private Paiement idpaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturedefinitive")
    private Collection<Factureproforma> factureproformaCollection;
    @OneToMany(mappedBy = "facturedefinitive")
    private Collection<Client> clientCollection;

    public Facturedefinitive() {
    }

    public Facturedefinitive(FacturedefinitivePK facturedefinitivePK) {
        this.facturedefinitivePK = facturedefinitivePK;
    }

    public Facturedefinitive(FacturedefinitivePK facturedefinitivePK, int clinumcli) {
        this.facturedefinitivePK = facturedefinitivePK;
        this.clinumcli = clinumcli;
    }

    public Facturedefinitive(int idfacture, int nofacturedef) {
        this.facturedefinitivePK = new FacturedefinitivePK(idfacture, nofacturedef);
    }

    public FacturedefinitivePK getFacturedefinitivePK() {
        return facturedefinitivePK;
    }

    public void setFacturedefinitivePK(FacturedefinitivePK facturedefinitivePK) {
        this.facturedefinitivePK = facturedefinitivePK;
    }

    public int getClinumcli() {
        return clinumcli;
    }

    public void setClinumcli(int clinumcli) {
        this.clinumcli = clinumcli;
    }

    public Integer getClinumcli2() {
        return clinumcli2;
    }

    public void setClinumcli2(Integer clinumcli2) {
        this.clinumcli2 = clinumcli2;
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
        hash += (facturedefinitivePK != null ? facturedefinitivePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturedefinitive)) {
            return false;
        }
        Facturedefinitive other = (Facturedefinitive) object;
        if ((this.facturedefinitivePK == null && other.facturedefinitivePK != null) || (this.facturedefinitivePK != null && !this.facturedefinitivePK.equals(other.facturedefinitivePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Facturedefinitive[ facturedefinitivePK=" + facturedefinitivePK + " ]";
    }
    
}
