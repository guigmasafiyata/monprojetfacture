/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.service.ClientManager;
import jakarta.enterprise.context.RequestScoped;
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
@RequestScoped
public class ClientBean implements Serializable {
    private List<Client> clientList;
    
    @Inject
    private ClientManager clientManager;

    public List<Client> getClientList() {
        clientList = clientManager.getAllClients();
        return clientList;
    }
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
   */  
    
    
  
}
    
    

