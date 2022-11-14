#language: fr

Fonctionnalité: Accepter un nouveau cookie

  Contexte:
    Étant donné un Dirigent
    Et  un cookie "Chocokid"
    Et avec une "Nature"
    Et de "Chocolat"
    Et avec les garnitures : "Pépite de chocolat"
    Et une "MOELLEUX"
    Et un "GARNI"
    Et un 60 s de préparation

  Scénario: Accepter un cookie
    Étant donné un cuisinier qui a soumis un cookie
    Quand le Dirigent regarde les cookies en attente de validation
    Alors le Dirigent valide le cookie "Chocokid"
