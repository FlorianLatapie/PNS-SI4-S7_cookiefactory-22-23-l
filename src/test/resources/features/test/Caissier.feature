#language: fr
Fonctionnalité: Caissier

  Contexte:
    Étant donné un Caissier
    Et une Commande

  Scénario: marquer une commande comme délivrée
    Étant donné un Caissier
    Quand je veux valider la commande de "Aurélia"
    Alors la commande est enlevée de la liste des commandes en attente de retrait