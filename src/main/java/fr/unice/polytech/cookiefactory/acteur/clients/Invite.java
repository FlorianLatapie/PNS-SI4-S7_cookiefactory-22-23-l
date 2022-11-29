package fr.unice.polytech.cookiefactory.acteur.clients;

import fr.unice.polytech.cookiefactory.acteur.Compte;

public class Invite extends Compte {

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public Invite(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Invite(String nom, String prenom) {
        super(nom, prenom);
    }

    public Invite() {
    }
}
