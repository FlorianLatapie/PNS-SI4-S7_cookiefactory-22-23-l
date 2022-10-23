package fr.unice.polytech.cookiefactory.commandes;

import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.services.ServiceDEnvoi;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireDeCommandes {
    private ServiceDEnvoi MailService;
    private ServiceDEnvoi SMSService;
    private final List<Commande> commandes = new ArrayList<>();

    public List<Commande> voirCommandesEnAttenteDeReception() {
        return this.commandes.stream().filter(c -> c.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT).toList();
    }

    public void commandeReceptionnee(Commande commande) {
        commande.setEtat(Etat.RECEPTIONNEE);
    }

    public void ajouterCommande(Commande commande) {
        this.commandes.add(commande);
    }

    public void ajouterCommande(List<Commande> commandes) {
        this.commandes.addAll(commandes);
    }
}
