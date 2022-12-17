package fr.unice.polytech.cookiefactory.spring.composants;

import fr.unice.polytech.cookiefactory.spring.depots.CommandeDepot;
import fr.unice.polytech.cookiefactory.spring.interfaces.ModifierEtatCommande;
import fr.unice.polytech.cookiefactory.spring.interfaces.Notifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestionCommandes implements ModifierEtatCommande//, ObtenirCommande{
{
    private CommandeDepot commandeDepot;

    private Notifier notifier;

    @Autowired
    public GestionCommandes(CommandeDepot commandeDepot, Notifier notifier) {
        this.commandeDepot = commandeDepot;
        this.notifier = notifier;
    }
}
