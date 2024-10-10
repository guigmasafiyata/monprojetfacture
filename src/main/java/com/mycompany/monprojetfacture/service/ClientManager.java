/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.service;

import com.mycompany.monprojetfacture.entity.Client;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */
@RequestScoped
public class ClientManager {

    @PersistenceContext(unitName = "clientPU")
    private EntityManager em;

    public List<Client> getAllClients() {
        Query query = em.createNamedQuery("Client.findAll");
        return query.getResultList();
    }

    @Transactional
    public Client update(Client client) {
        return em.merge(client);

    }

    /**
     *@param client
     */
    @Transactional
    public void persist(Client client) {
        em.persist(client);
    }

    public Client findById(int numcli) {
        return em.find(Client.class, numcli);
    }
    @Transactional
    public void delete(Client client) {
        if(client != null ){
            em.remove(em.merge(client));
        }
        
    }
     @Transactional
    public boolean isEmailExists(String email) {
       TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Client c WHERE c.email = :email", Long.class);
        query.setParameter("email", email);
        return query.getSingleResult() > 0; // Renvoie true si l'e-mail existe
    

}
    }
