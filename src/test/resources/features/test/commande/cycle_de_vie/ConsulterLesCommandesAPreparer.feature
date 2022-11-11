#language: fr
Fonctionnalité: Consulter les commandes à préparer

  Contexte:
    Étant donné un cuisinier "Daniel"

  Scénario: 1 commande à préparer
    Etant donné une commande "C1" à préparer
    Quand le cuisinier consulte les commandes à préparer
    Alors le cuisinier voit la commande à préparer

  Scénario: 0 commande à préparer
    Etant donné que le cuisinier n’a pas de commande à préparer
    Quand le cuisinier consulte les commandes à préparer
    Alors le cuisinier voit aucune commande à préparer
