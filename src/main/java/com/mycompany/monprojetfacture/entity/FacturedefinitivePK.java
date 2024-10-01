/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author GUIGMA Safiyata
 */
@Embeddable
public class FacturedefinitivePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacture")
    private int idfacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nofacturedef")
    private int nofacturedef;

    public FacturedefinitivePK() {
    }

    public FacturedefinitivePK(int idfacture, int nofacturedef) {
        this.idfacture = idfacture;
        this.nofacturedef = nofacturedef;
    }

    public int getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public int getNofacturedef() {
        return nofacturedef;
    }

    public void setNofacturedef(int nofacturedef) {
        this.nofacturedef = nofacturedef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfacture;
        hash += (int) nofacturedef;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturedefinitivePK)) {
            return false;
        }
        FacturedefinitivePK other = (FacturedefinitivePK) object;
        if (this.idfacture != other.idfacture) {
            return false;
        }
        if (this.nofacturedef != other.nofacturedef) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.FacturedefinitivePK[ idfacture=" + idfacture + ", nofacturedef=" + nofacturedef + " ]";
    }
    
}
