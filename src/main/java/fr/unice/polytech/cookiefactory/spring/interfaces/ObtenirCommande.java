package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.commandes.Commande;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ObtenirCommande {

    List<Commande> getCommandesEnAttenteDeRetrait();

    Optional<Commande> getCommandeDuCompte(String prenom, String nom);

    Optional<Commande> getCommandeDuCompte(UUID idCompte);
}
