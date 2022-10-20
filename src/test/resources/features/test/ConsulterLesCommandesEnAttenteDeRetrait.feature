#language: fr
Fonctionnalité: Consulter les commandes en attente de retrait
  # User story :
  # En tant que Caissier
  # Je veux consulter les commandes en attente de retrait
  # Afin de les délivrer au bon client

  Contexte:
    Étant donné qu'une Commande "Commande1" en état "EN_ATTENTE_DE_RECEPTION" existe

  Scénario: Consulter les commandes en attente de retrait
    Quand un caissier consulte les commandes en attente de retrait
    Alors il voit la commande "Commande1"
