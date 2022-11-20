#language: fr

Fonctionnalité: Ajouter des cookies festifs au panier

  Contexte:
    Etant donné un invité (cookieFestif)
    Et un cookie festif se nommant "Cookie de Noël".

  Plan du Scénario: Scénario: Ajouter un cookie festif au panier
    Quand j'ajoute <nbCookies> cookies festifs au panier.
    Alors le panier contient <nbCookies> cookies festifs.

    Exemples:
      | nbCookies |
      | 1         |
      | 10        |