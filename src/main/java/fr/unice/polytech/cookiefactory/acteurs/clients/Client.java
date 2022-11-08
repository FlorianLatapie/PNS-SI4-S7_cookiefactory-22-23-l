package fr.unice.polytech.cookiefactory.acteurs.clients;

import fr.unice.polytech.cookiefactory.acteurs.Personne;

public class Client extends Personne {

    public Client(String nom, String prenom, String email, String telephone, String motDePasse, double solde) {
        super(nom, prenom, email, telephone, motDePasse, solde);
    }
}
