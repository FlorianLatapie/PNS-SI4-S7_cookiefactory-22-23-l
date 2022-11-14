package fr.unice.polytech.cookiefactory.acteurs.employees;

import fr.unice.polytech.cookiefactory.acteurs.Personne;

public abstract class Employe extends Personne {

    protected Employe(String nom, String prenom, String email, String telephone, String motDePasse, double solde) {
        super(nom, prenom, email, telephone, motDePasse, solde);
    }
}
