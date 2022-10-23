#language: fr
Fonctionnalité: Valider une commande délivrée

  Contexte:
    Étant donné une Commande pour "Aurélia" "Chabanier" en état "EN_ATTENTE_DE_RETRAIT"

  Scénario: marquer une commande comme délivrée
    Quand je veux valider la commande de "Aurélia"
    Alors la commande est enlevée de la liste des commandes en attente de retrait et la commande est marquée comme "RECEPTIONNEE"