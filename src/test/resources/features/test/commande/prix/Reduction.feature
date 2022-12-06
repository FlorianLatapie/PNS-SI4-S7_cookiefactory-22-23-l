##language:fr
#
#Fonctionnalité: Bénéficier d’une réduction de 10% sur une commande
#
#  Contexte:
#    Etant donné un cookie nommé "Pop-Choco" (reduction)
#
#  Plan du Scénario: Bénéficier d’une réduction de 10% sur une commande
#    Etant donné une commande composée de <nbCookie> cookies
#    Lorsque le système calcule le montant total de la commande
#    Alors le prix est égal à <prixTotal> €
#
#    Exemples:
#      | nbCookie | prixTotal |
#      | 1        | 1,35      |
#      | 5        | 6,75      |
#      | 10       | 13,50     |