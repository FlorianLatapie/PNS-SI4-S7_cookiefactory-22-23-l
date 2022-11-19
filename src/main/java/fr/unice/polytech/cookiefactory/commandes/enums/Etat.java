package fr.unice.polytech.cookiefactory.commandes.enums;

@SuppressWarnings("ALL")
public enum Etat {

    ANNULEE,
    OUBLIEE, // La commande est cuisinée depuis plus de 2h et n'a pas été récupérée
    CONFIRMEE, // payée, mais pas encore préparée
    EN_COURS_DE_PAIEMENT, // choisi, mais pas payée
    EN_COURS_DE_PREPARATION, // en train d'être cuisinée
    EN_ATTENTE_DE_RETRAIT, // cuisinée
    RECEPTIONNEE // dernière étape
}
