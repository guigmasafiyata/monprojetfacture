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
public class Association23PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numcomnde")
    private int numcomnde;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nopro")
    private int nopro;

    public Association23PK() {
    }

    public Association23PK(int numcomnde, int nopro) {
        this.numcomnde = numcomnde;
        this.nopro = nopro;
    }

    public int getNumcomnde() {
        return numcomnde;
    }

    public void setNumcomnde(int numcomnde) {
        this.numcomnde = numcomnde;
    }

    public int getNopro() {
        return nopro;
    }

    public void setNopro(int nopro) {
        this.nopro = nopro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numcomnde;
        hash += (int) nopro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Association23PK)) {
            return false;
        }
        Association23PK other = (Association23PK) object;
        if (this.numcomnde != other.numcomnde) {
            return false;
        }
        if (this.nopro != other.nopro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Association23PK[ numcomnde=" + numcomnde + ", nopro=" + nopro + " ]";
    }
    
}
