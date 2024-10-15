/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.monprojetfacture.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L; // Ajout d'un identifiant de version pour la sérialisation

    private String login = "safi";
    private String password = "002";

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        System.out.println("in setLogin with" + login);
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("in setpassword with" + password);
        this.password = password;
    }

    public String returnAction() {

        return "Listedesclients?faces-redirect=true"; // Redirection vers la liste des clients
    }
}
