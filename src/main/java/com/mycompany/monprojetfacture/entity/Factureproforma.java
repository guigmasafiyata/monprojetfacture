/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "factureproforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factureproforma.findAll", query = "SELECT f FROM Factureproforma f"),
    @NamedQuery(name = "Factureproforma.findByIdfacture", query = "SELECT f FROM Factureproforma f WHERE f.factureproformaPK.idfacture = :idfacture"),
    @NamedQuery(name = "Factureproforma.findByNofacturepro", query = "SELECT f FROM Factureproforma f WHERE f.factureproformaPK.nofacturepro = :nofacturepro"),
    @NamedQuery(name = "Factureproforma.findByIdcotation", query = "SELECT f FROM Factureproforma f WHERE f.idcotation = :idcotation"),
    @NamedQuery(name = "Factureproforma.findByClinumcli", query = "SELECT f FROM Factureproforma f WHERE f.clinumcli = :clinumcli"),
    @NamedQuery(name = "Factureproforma.findByEnregistrement", query = "SELECT f FROM Factureproforma f WHERE f.enregistrement = :enregistrement"),
    @NamedQuery(name = "Factureproforma.findByMontant", query = "SELECT f FROM Factureproforma f WHERE f.montant = :montant"),
    @NamedQuery(name = "Factureproforma.findByDocumentNonJuridique", query = "SELECT f FROM Factureproforma f WHERE f.documentNonJuridique = :documentNonJuridique")})
public class Factureproforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactureproformaPK factureproformaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcotation")
    private int idcotation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cli_numcli")
    private int clinumcli;
    @Column(name = "enregistrement")
    private Short enregistrement;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant")
    private Float montant;
    @Size(max = 254)
    @Column(name = "documentNonJuridique")
    private String documentNonJuridique;
    @JoinColumn(name = "numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client numcli;
    @JoinColumn(name = "Cot_idcotation", referencedColumnName = "idcotation")
    @ManyToOne(optional = false)
    private Cotation cotidcotation;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Facture facture;
    @JoinColumns({
        @JoinColumn(name = "Fac_idfacture", referencedColumnName = "idfacture"),
        @JoinColumn(name = "nofacturedef", referencedColumnName = "nofacturedef")})
    @ManyToOne(optional = false)
    private Facturedefinitive facturedefinitive;

    public Factureproforma() {
    }

    public Factureproforma(FactureproformaPK factureproformaPK) {
        this.factureproformaPK = factureproformaPK;
    }

    public Factureproforma(FactureproformaPK factureproformaPK, int idcotation, int clinumcli) {
        this.factureproformaPK = factureproformaPK;
        this.idcotation = idcotation;
        this.clinumcli = clinumcli;
    }

    public Factureproforma(int idfacture, int nofacturepro) {
        this.factureproformaPK = new FactureproformaPK(idfacture, nofacturepro);
    }

    public FactureproformaPK getFactureproformaPK() {
        return factureproformaPK;
    }

    public void setFactureproformaPK(FactureproformaPK factureproformaPK) {
        this.factureproformaPK = factureproformaPK;
    }

    public int getIdcotation() {
        return idcotation;
    }

    public void setIdcotation(int idcotation) {
        this.idcotation = idcotation;
    }

    public int getClinumcli() {
        return clinumcli;
    }

    public void setClinumcli(int clinumcli) {
        this.clinumcli = clinumcli;
    }

    public Short getEnregistrement() {
        return enregistrement;
    }

    public void setEnregistrement(Short enregistrement) {
        this.enregistrement = enregistrement;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public String getDocumentNonJuridique() {
        return documentNonJuridique;
    }

    public void setDocumentNonJuridique(String documentNonJuridique) {
        this.documentNonJuridique = documentNonJuridique;
    }

    public Client getNumcli() {
        return numcli;
    }

    public void setNumcli(Client numcli) {
        this.numcli = numcli;
    }

    public Cotation getCotidcotation() {
        return cotidcotation;
    }

    public void setCotidcotation(Cotation cotidcotation) {
        this.cotidcotation = cotidcotation;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
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
        hash += (factureproformaPK != null ? factureproformaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factureproforma)) {
            return false;
        }
        Factureproforma other = (Factureproforma) object;
        if ((this.factureproformaPK == null && other.factureproformaPK != null) || (this.factureproformaPK != null && !this.factureproformaPK.equals(other.factureproformaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Factureproforma[ factureproformaPK=" + factureproformaPK + " ]";
    }
    
}
