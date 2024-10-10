/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.service.ClientManager;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */
@Named(value = "clientBean")
@ViewScoped
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
        
        // Vérifiez si l'email existe déjà
    if (clientManager.isEmailExists(email)) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email déjà utilisé", "L'email que vous avez saisi est déjà associé à un autre client.");
        context.addMessage(null, msg);
        return; // Sortir de la méthode si l'email existe déjà
    }
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        clientManager.persist(client);  // Appel de la méthode persist pour ajouter un client
        
         // Message de confirmation
    FacesContext context = FacesContext.getCurrentInstance();
    FacesMessage successMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Client ajouté", "Le client a été ajouté avec succès !");
    context.addMessage(null, successMsg);
    
    
    // Réinitialiser les valeurs après ajout
    this.nom = null;
    this.prenom = null;
    this.email = null;
    }
    
    
    
    /**
     * Supprime un client sélectionné.
     *
     * @param client Client à supprimer.
     */
    public void deleteClient(Client client) {
    if (client != null) {
        clientManager.delete(client); // Appel de la méthode delete du service
        // Mettre à jour la liste des clients après suppression
        clientList = clientManager.getAllClients(); // Cela peut être nécessaire pour actualiser la liste dans le bean
        // Ajouter un message de succès
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Client supprimé avec succès."));
    }
    }


}
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
   */  
    
    
  

    
    

