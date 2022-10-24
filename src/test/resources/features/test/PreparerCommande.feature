#language:fr

Fonctionnalité: Préparer une commande

  Contexte:
    Étant donné une Commande en état "CONFIRME"

  Scénario: Démarrer preparation d'une commande
    Quand le cuisinier commence la préparation de la commande
    Alors la commande est en état "EN_COURS_DE_PREPARATION"

  Scénario: Terminer preparation d'une commande
    Quand le cuisinier termine la préparation de la commande
    Alors la commande est en état "EN_ATTENTE_DE_RETRAIT"

