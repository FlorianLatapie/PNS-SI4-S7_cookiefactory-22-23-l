##language: fr
#
#Fonctionnalité: Vendre ses cookies TTC
#
#  Plan du scénario: Faire payer les clients le prix avec taxe
#    Etant donné une commande de prix <prixCommande> centimes
#    Et un magasin de valeur ajoutée <taxe>%
#    Quand le client paye la commande
#    Alors le prix sera celui TTC
#
#    Exemples:
#      | taxe | prixCommande |
#      | 30   | 1500         |
#      | 10   | 1500         |
#      | 10   | 1000         |