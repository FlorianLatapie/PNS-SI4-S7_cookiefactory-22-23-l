#language: fr
Fonctionnalité: Consulter les commandes à préparer

  Contexte:
    Étant donné un cuisinier "Daniel"

  Scénario: 1 commande à préparer
    Etant donné que le cuisinier "Daniel" a une commande "C1" à préparer
    Quand le cuisinier "Daniel" consulte les commandes à préparer
    Alors le cuisinier "Daniel" voit la commande "C1" à préparer

  Scénario: 0 commande à préparer
    Etant donné que le cuisinier "Daniel" n’a pas de commande à préparer
    Quand le cuisinier "Daniel" consulte les commandes à préparer
    Alors le cuisinier "Daniel" voit aucune commande à préparer
