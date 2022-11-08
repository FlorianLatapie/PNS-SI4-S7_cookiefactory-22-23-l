package fr.unice.polytech.cookiefactory.acteurs.employees.management;

import fr.unice.polytech.cookiefactory.acteurs.employees.Employe;

public class Responsable extends Employe {

    public Responsable(String nom, String prenom, String email, String telephone, String motDePasse, double solde) {
        super(nom, prenom, email, telephone, motDePasse, solde);
    }
}
