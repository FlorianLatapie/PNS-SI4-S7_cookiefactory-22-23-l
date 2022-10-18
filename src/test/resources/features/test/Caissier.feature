#language: fr
Fonctionnalité: Caissier

  Contexte:
    Etant donné un Caissier
    Et une Commande

  Scénario: marquer une commande comme délivrée
    Etant donné un Caissier
    Quand je veux valider la commande
    Alors la commande est enlevée de la liste des commandes en attente de retrait