package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.enums.Etat;
import fr.unice.polytech.cookiefactory.spring.depots.CommandeDepot;
import fr.unice.polytech.cookiefactory.spring.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class RegistreCommandes implements AjouterCommande, ObtenirCommande, ModifierEtatCommande {
    private CommandeDepot commandeDepot;

    private Notifier notifier;

    @Autowired
    public RegistreCommandes(CommandeDepot commandeDepot, Notifier notifier) {
        this.commandeDepot = commandeDepot;
        this.notifier = notifier;
    }

    /* ----------------- AjouterCommande ----------------- */

    @Override
    public void ajouterCommande(Commande commande) {
        commandeDepot.sauvegarder(commande, commande.getId());
    }

    @Override
    public void ajouterCommandes(List<Commande> commandes) {
        commandes.forEach(this::ajouterCommande);
    }

    /* ----------------- ObtenirCommande ----------------- */

    @Override
    public List<Commande> getCommandesEnAttenteDeRetrait() {
        return commandeDepot.getTout().stream().filter(c -> c.getEtat() == Etat.EN_ATTENTE_DE_RETRAIT).toList();
    }

    @Override
    public Optional<Commande> getCommandeDuCompte(String prenom, String nom) {
        return this.getCommandesEnAttenteDeRetrait()
                .stream()
                .filter(c -> c.getCompte().getNom().equals(nom) && c.getCompte().getPrenom().equals(prenom))
                .findFirst();
    }

    @Override
    public Optional<Commande> getCommandeDuCompte(UUID idCompte) {
        return this.getCommandesEnAttenteDeRetrait()
                .stream()
                .filter(c -> Objects.equals(c.getCompte().getId(), idCompte))
                .findFirst();
    }

    /* ----------------- ModifierEtatCommande ----------------- */

    @Override
    public void annulerCommande(Commande commande){
        if (commande.getEtat() != Etat.CONFIRMEE) {
            throw new IllegalArgumentException("Vous ne pouvez pas annuler votre commande maintenant.");
        }
        commande.setEtat(Etat.ANNULEE);
        // TODO rembourser client
        // TODO remettre en stock les ingrédients
    }

    @Override
    public void commandeEnAttenteDeRetrait(Commande commande){
        commande.setEtat(Etat.EN_ATTENTE_DE_RETRAIT);
        notifier.envoyerAvecTousLesServicesClientelle(commande);
    }

    @Override
    public void commandeReceptionnee(Commande commande){
        commande.setEtat(Etat.RECEPTIONNEE);
        notifier.envoyerAvecTousLesServicesClientelle(commande);
    }
}
