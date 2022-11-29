package fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.List;

public class ConcatenantionGenerationPanierStrategy implements IGenerationPanierStrategy {
    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    @Override
    public List<Commande> generePanierSurprise(List<Commande> commandesOubliees) {
        var commandeRetour = new Commande(commandesOubliees.get(0).getGestionnaireDeCommandes().getMagasin());

        for (Commande commande : commandesOubliees) {
            commandeRetour
                    .getPanier()
                    .getLignesCommande()
                    .addAll(commande
                            .getPanier()
                            .getLignesCommande()
                    );
        }

        return List.of(commandeRetour);
    }
}
