package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.magasin.Magasin;
import fr.unice.polytech.cookiefactory.recette.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionnaireDeCuisiniers {
    private List<Cuisinier> cuisiniers;
    private Magasin magasin;
    private List<Commande> commandes;

    public GestionnaireDeCuisiniers(Magasin magasin) {
        this.magasin = magasin;
        cuisiniers = new ArrayList<>();
        commandes = new ArrayList<>();
    }

    public void soumettreUnNouveauCookie(Cookie cookie){
        magasin.soumettreUnNouveauCookie(cookie);
    }
    public void assignerCuisinier(Commande commande) {
        for (Cuisinier cuisinier : cuisiniers) {
            if (cuisinier.estDisponible()) {
                cuisinier.getEdtCuisinier().nouveauCreneau(commande);
                return;
            }
        }
    }

    public Optional<Cuisinier> getCuisinierAssigne(Commande commande) {
        for (Cuisinier cuisinier : cuisiniers) {
            if (cuisinier.getEdtCuisinier().getCreneauPreparationCommande().stream().anyMatch(creneau -> creneau.getCommande().equals(commande))) {
                return Optional.of(cuisinier);
            }
        }
        return Optional.empty();
    }

    public CreneauPreparationCommande getDisponibilites() {
        //TODO
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean ajouterCuisinier(Cuisinier cuisinier) {
        return cuisiniers.add(cuisinier);
    }

    public List<Cuisinier> getCuisiniers() {
        return cuisiniers;
    }
}
