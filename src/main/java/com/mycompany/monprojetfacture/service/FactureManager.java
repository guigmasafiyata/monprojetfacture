/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.service;

import com.mycompany.monprojetfacture.entity.Connexion;
import com.mycompany.monprojetfacture.entity.Facture;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */

@RequestScoped
public class FactureManager {
    
     @PersistenceContext(unitName = "facturePU")
    private EntityManager em;

    public List<Facture> getAllFactures() {
        Query query = em.createNamedQuery("Facture.findAll");
        return query.getResultList();

    }
    
     @Transactional
    public Facture update(Facture facture) {
        return em.merge(facture);
    }

    @Transactional
    public void persist(Facture facture) {
        em.persist(facture);
    }

    public Facture findById(Integer idfacture){
          return em.find(Facture.class, idfacture);
        
    }
    
}
