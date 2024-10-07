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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
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
    @NamedQuery(name = "Factureproforma.findByIdfacture", query = "SELECT f FROM Factureproforma f WHERE f.idfacture = :idfacture"),
    @NamedQuery(name = "Factureproforma.findByIdcotation", query = "SELECT f FROM Factureproforma f WHERE f.idcotation = :idcotation"),
    @NamedQuery(name = "Factureproforma.findByEnregistrement", query = "SELECT f FROM Factureproforma f WHERE f.enregistrement = :enregistrement"),
    @NamedQuery(name = "Factureproforma.findByMontant", query = "SELECT f FROM Factureproforma f WHERE f.montant = :montant"),
    @NamedQuery(name = "Factureproforma.findByDocumentNonJuridique", query = "SELECT f FROM Factureproforma f WHERE f.documentNonJuridique = :documentNonJuridique")})
public class Factureproforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacture")
    private Integer idfacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcotation")
    private int idcotation;
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
    @JoinColumn(name = "Cli_numcli", referencedColumnName = "numcli")
    @ManyToOne(optional = false)
    private Client clinumcli;
    @JoinColumn(name = "Cot_idcotation", referencedColumnName = "idcotation")
    @ManyToOne(optional = false)
    private Cotation cotidcotation;
    @JoinColumn(name = "idfacture", referencedColumnName = "idfacture", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Facture facture;
    @JoinColumn(name = "Fac_idfacture", referencedColumnName = "idfacture")
    @ManyToOne(optional = false)
    private Facturedefinitive facidfacture;

    public Factureproforma() {
    }

    public Factureproforma(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public Factureproforma(Integer idfacture, int idcotation) {
        this.idfacture = idfacture;
        this.idcotation = idcotation;
    }

    public Integer getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(Integer idfacture) {
        this.idfacture = idfacture;
    }

    public int getIdcotation() {
        return idcotation;
    }

    public void setIdcotation(int idcotation) {
        this.idcotation = idcotation;
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

    public Client getClinumcli() {
        return clinumcli;
    }

    public void setClinumcli(Client clinumcli) {
        this.clinumcli = clinumcli;
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

    public Facturedefinitive getFacidfacture() {
        return facidfacture;
    }

    public void setFacidfacture(Facturedefinitive facidfacture) {
        this.facidfacture = facidfacture;
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
        if (!(object instanceof Factureproforma)) {
            return false;
        }
        Factureproforma other = (Factureproforma) object;
        if ((this.idfacture == null && other.idfacture != null) || (this.idfacture != null && !this.idfacture.equals(other.idfacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Factureproforma[ idfacture=" + idfacture + " ]";
    }
    
}
