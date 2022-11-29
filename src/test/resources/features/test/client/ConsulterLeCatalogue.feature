#language: fr

Fonctionnalité: Permet à un invité de consulter le catalogue d'un magasin

  Contexte:
    Etant donné un invité qui veut onsulter le catalogue d'un magasin

  Plan du scénario:
    Quand il veux consulter le catalogue du magasin <Numero du magasin>
    Alors l'invité peut voir <Nombre de cookies> cookies
    Exemples:
      | Numero du magasin | Nombre de cookies |
      | 1                 | 5                 |
      | 2                 | 2                 |
      | 3                 | 1                 |