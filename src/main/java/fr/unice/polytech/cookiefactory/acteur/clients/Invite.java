package fr.unice.polytech.cookiefactory.acteur.clients;

import fr.unice.polytech.cookiefactory.acteur.Compte;
import fr.unice.polytech.cookiefactory.commandes.Panier;

import java.util.UUID;

public class Invite extends Compte {

    private final UUID id = UUID.randomUUID();
    private Panier panier = new Panier();

    public Invite(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Invite(String nom, String prenom) {
        super(nom, prenom);
    }

    public Invite() {
    }

    public UUID getId() {
        return id;
    }

    public Panier getPanier() {
        return panier;
    }
}
