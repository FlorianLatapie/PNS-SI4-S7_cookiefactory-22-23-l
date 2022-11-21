package fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.List;

public class AucuneGenerationPanierStrategy implements IGenerationPanierStrategy {
    @Override
    public List<Commande> generePanierSurprise(List<Commande> commandesOubliees) {
        return commandesOubliees;
    }
}
