/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import com.mycompany.monprojetfacture.entity.Client;
import com.mycompany.monprojetfacture.service.MapageManager;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author GUIGMA Safiyata
 */
@Named(value = "ClientBean")
@ViewScoped
public class ClientBean implements Serializable {
    private List<Client> pagesuivante;
    
    /** 
   * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
   */  
  public List<Client> getClients() {
    if (pagesuivante == null) {
      pagesuivante = MapageManager.getAllClients();
    }
    return pagesuivante;
  }  
}
    
    

