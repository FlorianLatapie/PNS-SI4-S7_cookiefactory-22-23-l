package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.List;

public interface AjouterCommande {
    void ajouterCommande(Commande commande);

    void ajouterCommandes(List<Commande> commandes);
}
