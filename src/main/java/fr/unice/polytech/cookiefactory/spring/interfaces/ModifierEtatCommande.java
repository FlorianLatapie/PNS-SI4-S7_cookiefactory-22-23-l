package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public interface ModifierEtatCommande {
    void commandeReceptionnee(Commande commande);

    void annulerCommande(Commande commande);

    void commandeEnAttenteDeRetrait(Commande commande);

    void commandeConfirmee(Commande commande);

    void commandeOubliee(Commande commande);

    void commandeEnCoursDePreparation(Commande commande);
}