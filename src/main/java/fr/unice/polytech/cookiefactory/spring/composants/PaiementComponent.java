package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.unice.polytech.cookiefactory.spring.interfaces.Paiement;

@Component
public class PaiementComponent implements Paiement {
    private Banque banque;

    @Autowired
    public PaiementComponent(Banque banque) {
        this.banque = banque;
    }

    @Override
    public Commande payer(Invite invite) {
        Commande commande = new Commande(invite, invite.getPanier());
        banque.payer(commande.getPrixHorsTaxe()); // A changer plus tard avec le prix avec taxes
        return commande;
    }
}
