package fr.unice.polytech.cookiefactory.commandes.oubliees;

import fr.unice.polytech.cookiefactory.commandes.Commande;
import fr.unice.polytech.cookiefactory.commandes.oubliees.generation_panier_strategy.IGenerationPanierStrategy;
import fr.unice.polytech.cookiefactory.divers.IClasseTempsReel;
import fr.unice.polytech.cookiefactory.messageservices.MessageServices;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireDeCommandesOubliees implements IClasseTempsReel {
    private final List<Commande> commandesOubliees;
    private final List<Commande> paniersSurprise;
    private ZonedDateTime derniereCompositionPanierSurprise;

    private final IGenerationPanierStrategy generationPanierStrategy;

    /* --------------------------------------- Constructeurs --------------------------------------- */

    public GestionnaireDeCommandesOubliees(ZonedDateTime zonedDateTime, IGenerationPanierStrategy generationPanierStrategy) {
        this.commandesOubliees = new ArrayList<>();
        this.paniersSurprise = new ArrayList<>();
        this.derniereCompositionPanierSurprise = zonedDateTime;
        this.generationPanierStrategy = generationPanierStrategy;
    }

    /* ----------------------------------------- Méthodes  ----------------------------------------- */

    public void ajouterCommandesOubliees(List<Commande> commandesOubliees) {
        this.commandesOubliees.addAll(commandesOubliees);
    }

    private void genererPanierSurprise() {
        paniersSurprise.clear();
        paniersSurprise.addAll(generationPanierStrategy.generePanierSurprise(commandesOubliees));
        commandesOubliees.clear();
    }

    private void prevenir() {
        prevenirTooGoodToGo();
    }

    private void prevenirTooGoodToGo() {
        paniersSurprise.forEach(MessageServices.getInstance()::envoyerAvecTousLesServicesPartenaire);
    }

    @Override
    public void updateHeure(ZonedDateTime zonedDateTime) {
        if (derniereCompositionPanierSurprise == null) {
            derniereCompositionPanierSurprise = zonedDateTime;
        }
        if (zonedDateTime.isAfter(derniereCompositionPanierSurprise.plusHours(2).plusMinutes(59))) {
            derniereCompositionPanierSurprise = zonedDateTime;
            genererPanierSurprise();
            prevenir();
        }
    }
}
