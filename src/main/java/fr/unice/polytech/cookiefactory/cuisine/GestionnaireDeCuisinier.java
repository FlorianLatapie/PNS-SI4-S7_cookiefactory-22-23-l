package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.List;

public class GestionnaireDeCuisinier {
    private List<Cuisinier> cuisiniers;
    private Magasin magasin;
    private List<Commande> commandes;

    public GestionnaireDeCuisinier(Magasin magasin){
        this.magasin = magasin;
    }

    public void ajouterUnCuisinier(Cuisinier cuisinier){
        cuisiniers.add(cuisinier);
    }

    public void soumettreUnNouveauCookie(Cookie cookie){
        magasin.soumettreUnNouveauCookie(cookie);
    }

    public void assignCuisinier(CreneauPreparationCommande cpc, Commande c) {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");

    }

    public CreneauPreparationCommande getDisponibilites() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
