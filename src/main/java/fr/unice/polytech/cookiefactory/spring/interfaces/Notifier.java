package fr.unice.polytech.cookiefactory.spring.interfaces;

import fr.unice.polytech.cookiefactory.commandes.Commande;

public interface Notifier {
    void envoyerAvecTousLesServicesClientelle(Commande commande);

    void envoyerAvecTousLesServicesPartenaire(Commande commande);
}
