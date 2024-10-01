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
public class FactureproformaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idfacture")
    private int idfacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nofacturepro")
    private int nofacturepro;

    public FactureproformaPK() {
    }

    public FactureproformaPK(int idfacture, int nofacturepro) {
        this.idfacture = idfacture;
        this.nofacturepro = nofacturepro;
    }

    public int getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public int getNofacturepro() {
        return nofacturepro;
    }

    public void setNofacturepro(int nofacturepro) {
        this.nofacturepro = nofacturepro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idfacture;
        hash += (int) nofacturepro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureproformaPK)) {
            return false;
        }
        FactureproformaPK other = (FactureproformaPK) object;
        if (this.idfacture != other.idfacture) {
            return false;
        }
        if (this.nofacturepro != other.nofacturepro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.FactureproformaPK[ idfacture=" + idfacture + ", nofacturepro=" + nofacturepro + " ]";
    }
    
}
