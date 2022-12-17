package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.spring.interfaces.ModifierEtatCommande;
import fr.unice.polytech.cookiefactory.spring.interfaces.TraiterNouvelleCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TraiterCommandePayee implements TraiterNouvelleCommande{

    //private GestionStock gestionStock;
    //private GestionEDTCuisiniers gestionEDTCuisiniers;
    private ModifierEtatCommande modifierEtatCommande;

    @Autowired
    public TraiterCommandePayee(ModifierEtatCommande modifierEtatCommande){
        this.modifierEtatCommande = modifierEtatCommande;
    }
}
