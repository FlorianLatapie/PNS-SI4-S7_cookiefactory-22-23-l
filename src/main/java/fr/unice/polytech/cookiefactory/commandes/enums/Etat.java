package fr.unice.polytech.cookiefactory.commandes.enums;

public enum Etat {
    EN_ATTENTE_DE_RECEPTION, // cuisinée
    RECEPTIONNEE, // dernière étape
    ANNULEE,
    EN_COURS_DE_PREPARATION,
    CONFIRME // payée, mais pas encore préparée
}
