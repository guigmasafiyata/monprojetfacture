/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.service;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.entity.Connexion;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */
@RequestScoped
public class MapageManager {

    @PersistenceContext(unitName = "connexionPU")
    private EntityManager em;

    public List<Connexion> getAllMapages() {
        Query query = em.createNamedQuery("Mapage.findAll");
        return query.getResultList();

    }

}
