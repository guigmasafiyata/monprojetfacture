package com.mycompany.monprojetfacture;

import com.mycompany.monprojetfacture.entity.Facture;
import com.mycompany.monprojetfacture.service.FactureManager;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author GUIGMA Safiyata
 */
@FacesConverter(value = "factureConverter", managed = true)
public class FactureConverter implements Converter<Facture> {
    
    private FactureManager factureManager;

    // Constructeur pour initialiser factureManager via CDI
    public FactureConverter() {
        // Utilisation de CDI pour obtenir une instance de FactureManager
        this.factureManager = CDI.current().select(FactureManager.class).get();
    }

    @Override
    public Facture getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            Integer idfacture = Integer.valueOf(value);
            return factureManager.findById(idfacture);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Conversion de facture échouée, valeur incorrecte : " + value, e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Facture facture) {
        if (facture == null) {
            return "";
        }
        return String.valueOf(facture.getIdfacture());
    }
    
    // Accesseurs pour factureManager (si nécessaire)
    public FactureManager getFactureManager() {
        return factureManager;
    }

    public void setFactureManager(FactureManager factureManager) {
        this.factureManager = factureManager;
    }
}
