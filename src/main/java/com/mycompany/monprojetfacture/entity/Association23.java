/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Entity
@Table(name = "association23")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Association23.findAll", query = "SELECT a FROM Association23 a"),
    @NamedQuery(name = "Association23.findByNumcomnde", query = "SELECT a FROM Association23 a WHERE a.association23PK.numcomnde = :numcomnde"),
    @NamedQuery(name = "Association23.findByNopro", query = "SELECT a FROM Association23 a WHERE a.association23PK.nopro = :nopro")})
public class Association23 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Association23PK association23PK;

    public Association23() {
    }

    public Association23(Association23PK association23PK) {
        this.association23PK = association23PK;
    }

    public Association23(int numcomnde, int nopro) {
        this.association23PK = new Association23PK(numcomnde, nopro);
    }

    public Association23PK getAssociation23PK() {
        return association23PK;
    }

    public void setAssociation23PK(Association23PK association23PK) {
        this.association23PK = association23PK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (association23PK != null ? association23PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Association23)) {
            return false;
        }
        Association23 other = (Association23) object;
        if ((this.association23PK == null && other.association23PK != null) || (this.association23PK != null && !this.association23PK.equals(other.association23PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Association23[ association23PK=" + association23PK + " ]";
    }
    
}
