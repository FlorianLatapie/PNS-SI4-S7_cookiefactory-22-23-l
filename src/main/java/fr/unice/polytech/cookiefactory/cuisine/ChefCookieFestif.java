package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.GestionnaireDeCommandes;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Occasions;
import fr.unice.polytech.cookiefactory.cuisine.specialites.Themes;

import java.util.ArrayList;

public class ChefCookieFestif extends Cuisinier {
    private ArrayList<Themes> themes;
    private ArrayList<Occasions> occasions;

    public ChefCookieFestif(GestionnaireDeCommandes gestionnaireDeCommandes) {
        super(gestionnaireDeCommandes);
        this.themes = new ArrayList<>();
        this.occasions = new ArrayList<>();
    }

    public ChefCookieFestif(GestionnaireDeCommandes gestionnaireDeCommandes, ArrayList<Themes> themes, ArrayList<Occasions> occasions) {
        super(gestionnaireDeCommandes);
        this.themes = themes;
        this.occasions = occasions;
    }

    public ChefCookieFestif devenirChefCookieFestif(Cuisinier cuisinier, ArrayList<Themes> themes, ArrayList<Occasions> occasions){
       return new ChefCookieFestif(cuisinier.getGestionnaireDeCommandes(), themes, occasions);
    }
}
