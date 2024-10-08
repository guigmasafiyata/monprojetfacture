/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.service.ClientManager;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */
@Named(value = "clientBean")
@RequestScoped
public class ClientBean implements Serializable {
    private List<Client> clientList;
    private Client client = new Client();
    private String nom;
    private String prenom;
    private String email;
    
    
    
    @Inject
    private ClientManager clientManager;

    public List<Client> getClientList() {
        clientList = clientManager.getAllClients();
        return clientList;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
   
    
   

    public void addClient() {
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        clientManager.persist(client);  // Appel de la méthode persist pour ajouter un client
        
    }
}
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
   */  
    
    
  

    
    

