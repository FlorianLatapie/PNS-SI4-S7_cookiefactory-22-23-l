#language: fr

  Fonctionnalité: Notifier le client une fois la commande en attente de retrait
    Contexte:
      Etant donné un invité (notifier)
      Et une de ses commandes

    Scénario:
      Quand la commande passe à l'état en attente de retrait
      Alors le client reçoit un message (retrait)

    Scénario:
      Quand la commande passe à l'état est receptionnée
      Alors le client reçoit un message (reception)