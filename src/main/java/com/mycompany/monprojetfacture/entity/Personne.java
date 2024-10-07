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
@Table(name = "personne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
    @NamedQuery(name = "Personne.findByIdpers", query = "SELECT p FROM Personne p WHERE p.idpers = :idpers"),
    @NamedQuery(name = "Personne.findByIdcotation", query = "SELECT p FROM Personne p WHERE p.idcotation = :idcotation"),
    @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personne.findByAge", query = "SELECT p FROM Personne p WHERE p.age = :age")})
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpers")
    private Integer idpers;
    @Column(name = "idcotation")
    private Integer idcotation;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Column(name = "age")
    private Long age;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpers")
    private Collection<Cotation> cotationCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personne")
    private Morale morale;

    public Personne() {
    }

    public Personne(Integer idpers) {
        this.idpers = idpers;
    }

    public Integer getIdpers() {
        return idpers;
    }

    public void setIdpers(Integer idpers) {
        this.idpers = idpers;
    }

    public Integer getIdcotation() {
        return idcotation;
    }

    public void setIdcotation(Integer idcotation) {
        this.idcotation = idcotation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @XmlTransient
    public Collection<Cotation> getCotationCollection() {
        return cotationCollection;
    }

    public void setCotationCollection(Collection<Cotation> cotationCollection) {
        this.cotationCollection = cotationCollection;
    }

    public Morale getMorale() {
        return morale;
    }

    public void setMorale(Morale morale) {
        this.morale = morale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpers != null ? idpers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idpers == null && other.idpers != null) || (this.idpers != null && !this.idpers.equals(other.idpers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.monprojetfacture.entity.Personne[ idpers=" + idpers + " ]";
    }
    
}
