/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.service.ClientManager;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 * Backing bean pour la page clientrDetails.xhtml.
 */
@Named(value = "clientDetailsBean")
@ViewScoped
public class ClientDetailsBean implements Serializable{
    
    private int numcli;
    private Client client;

    @Inject
    private ClientManager clientManager;

    public int getNumcli() {
        return numcli;
    }
    
    @PostConstruct
    public void init() {
        if (clientManager == null) {
            throw new IllegalStateException("Injection de ClientManager a échoué !");
        }
    }

    public void setNumcli(int numcli) {
        this.numcli = numcli;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

   

   public String update() {
        client = clientManager.update(client);
        return "Listedesclients?faces-redirect=true";
    }
   
    public void loadClient() {
        this.client = clientManager.findById(numcli);
    }
    
     // Méthode pour supprimer un client
    public String deleteClient(Client client) {
        try {
            clientManager.delete(client);
            FacesMessage msg = new FacesMessage("Client supprimé avec succès.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "Listedesclients?faces-redirect=true"; // Rediriger après la suppression
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Erreur lors de la suppression du client : " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null; // Rester sur la même page en cas d'erreur
        }
    }
}
