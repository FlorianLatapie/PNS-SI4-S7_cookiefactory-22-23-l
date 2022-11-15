package fr.unice.polytech.cookiefactory.acteur.clients;

import fr.unice.polytech.cookiefactory.acteur.Compte;

public class Client extends Compte {

    public Client(String nom, String prenom, String email, String telephone, String motDePasse) {
        super(nom, prenom, email, telephone, motDePasse);
    }

    public Client(Invite invite) {
        super(invite.getNom(), invite.getPrenom(), invite.getEmail(), invite.getTelephone(), invite.getMotDePasse());
    }

    public Client(String nom, String prenom) {
        super(nom, prenom);
    }
}
