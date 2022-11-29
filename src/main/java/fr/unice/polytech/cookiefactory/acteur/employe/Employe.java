package fr.unice.polytech.cookiefactory.acteur.employe;

import fr.unice.polytech.cookiefactory.acteur.Compte;

public abstract class Employe extends Compte {

    /* --------------------------------------- Constructeurs --------------------------------------- */

    protected Employe(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }
}
