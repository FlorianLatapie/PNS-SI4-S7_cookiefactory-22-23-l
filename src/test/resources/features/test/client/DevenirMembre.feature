#language: fr

Fonctionnalité: Permet à un client de passer son compte Client en compte Membre

  Contexte:
    Etant donné un client qui veut passer son compte Client en compte Membre

  Scénario:
    Quand il veux passer son compte Client en compte Membre
    Alors le client devient un membre avec ses avantages

  Plan du Scénario:
    Quand un Membre passe une commande à <nombreCookies> cookies et qu'il a <avant> points de fidélité
    Alors il voit ses points de fidélité augmenter du nombre de cookie acheté: <après>

    Exemples:
      | nombreCookies | avant | après |
      | 0             | 0     | 0     |
      | 0             | 1     | 1     |
      | 1             | 0     | 1     |
      | -1            | 1     | 1     |
      | 1             | -1    | 1     |
      | -1            | -1    | 0     |
      | 2             | 1     | 3     |
