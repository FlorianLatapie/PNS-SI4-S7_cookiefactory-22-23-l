##language: fr
#
#Fonctionnalité: Ajouter des cookies festifs au panier
#
#  Contexte:
#    Etant donné un magasin avec une taxe de 0,20
#    Et un invité (cookieFestif)
#    Et un cookie festif se nommant "Cookie de Noël".
#
#  Plan du Scénario: Ajouter de cookies festifs au panier
#    Quand j'ajoute <nbCookies> cookies festifs au panier.
#    Alors le panier contient <nbCookies> cookies festifs.
#
#    Exemples:
#      | nbCookies |
#      | 1         |
#      | 10        |
#
#
#  Plan du Scénario: Ajouter des cookies festifs basés sur un cookie normal
#    Quand j'ajoute <nbCookies> cookies festifs de taille L au panier basés sur le cookie normal Pop-Choco.
#    Alors le panier contient <nbCookies> cookies festifs.
#    Et le prix du panier hors taxes est de <prixHT> euros.
#    Et le prix de la commande est de <prixTTC> euros.
#
#    Exemples:
#      | nbCookies | prixHT | prixTTC |
#      | 1         | 7,50   | 9,00    |
#      | 10        | 75,00  | 90,00   |