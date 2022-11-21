package fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.List;

public interface IGenerationPanierStrategy {
    List<Commande> generePanierSurprise(List<Commande> commandesOubliees);
}
