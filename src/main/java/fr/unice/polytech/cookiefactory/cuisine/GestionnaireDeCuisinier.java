package fr.unice.polytech.cookiefactory.cuisine;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.magasin.Magasin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionnaireDeCuisinier {
    private List<Cuisinier> cuisiniers;
    private Magasin magasin;
    private List<Commande> commandes;

    public GestionnaireDeCuisinier() {
        cuisiniers = new ArrayList<>();
        commandes = new ArrayList<>();
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
