package fr.unice.polytech.cookiefactory.commandes.enums;

public enum Etat {

    ANNULEE,
    CONFIRMEE, // payée, mais pas encore préparée
    EN_COURS_DE_PAIEMENT, // choisi, mais pas payée
    EN_COURS_DE_PREPARATION, // en train d'être cuisinée
    EN_ATTENTE_DE_RETRAIT, // cuisinée
    RECEPTIONNEE // dernière étape
}
