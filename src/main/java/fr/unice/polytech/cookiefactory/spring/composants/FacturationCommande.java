package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.acteur.clients.Invite;
import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.exceptions.PayementException;
import fr.unice.polytech.cookiefactory.spring.interfaces.Banque;
import fr.unice.polytech.cookiefactory.spring.interfaces.PayerComande;
import fr.unice.polytech.cookiefactory.spring.interfaces.TraiterNouvelleCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacturationCommande implements PayerComande {
    private Banque banque;

    private TraiterNouvelleCommande traiterNouvelleCommande;

    @Autowired
    public FacturationCommande(Banque banque) {
        this.banque = banque;
    }

    @Override
    public void payer(Invite invite) {
        Commande commande = new Commande(invite, invite.getPanier());
        try {
            banque.payer(commande.getPrixHorsTaxe()); // À changer plus tard avec le prix avec taxes
            traiterNouvelleCommande.traiterNouvelleCommande(commande);
        } catch (PayementException e) {
            // il y a un problème lors du paiement, faire le traitement
            System.out.println("Un problème est survenu lors du paiement");
        }
    }
}
