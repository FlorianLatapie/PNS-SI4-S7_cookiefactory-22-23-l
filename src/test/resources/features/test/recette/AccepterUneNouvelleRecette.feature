# language: fr

Fonctionnalité: Accepter un nouveau cookie

  Contexte:
    Etant donné un cookie "Chocokid"

  Scénario: Accepter un cookie
    Étant donné un cuisinier qui soumet un cookie
    Alors le cookie est en attente de validation
    Quand un dirigeant valide le cookie "Chocokid"
    Alors le cookie est accepté
