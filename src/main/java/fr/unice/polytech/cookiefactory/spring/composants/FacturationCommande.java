package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import fr.unice.polytech.cookiefactory.spring.interfaces.TraiterNouvelleCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.unice.polytech.cookiefactory.spring.interfaces.PayerComande;

@Component
public class FacturationCommande implements PayerComande {
    private Banque banque;
    private TraiterNouvelleCommande traiterNouvelleCommande;

    @Autowired
    public FacturationCommande(Banque banque) {
        this.banque = banque;
    }

    @Override
    public Commande payer(Invite invite) {
        Commande commande = new Commande(invite, invite.getPanier());
        banque.payer(commande.getPrixHorsTaxe()); // A changer plus tard avec le prix avec taxes
        return commande;
    }
}
