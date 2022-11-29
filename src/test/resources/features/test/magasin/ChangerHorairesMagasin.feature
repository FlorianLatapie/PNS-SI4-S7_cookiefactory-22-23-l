##language: fr
#Fonctionnalité: Changer les horaires d'ouvertures d'un magasin
#
#  Contexte:
#    Étant donné un magasin ouvert de 9 h à 18 h
#
#  Plan du Scénario: Changer les horaires d'ouvertures d'un magasin
#    Quand je change les horaires d ouvertures du magasin pour <heure d ouverture> à <heure de fermeture>
#    Alors le magasin est ouvert de <heure d ouverture> à <heure de fermeture>
#    Exemples:
#      | heure d ouverture | heure de fermeture |
#      | 9                 | 18                 |
#      | 10                | 19                 |
#
#  Plan du Scénario: Horaires incorrects
#    Quand je change les horaires d ouvertures du magasin pour <heure d ouverture> à <heure de fermeture>
#    Alors une erreur est levée
#    Exemples:
#      | heure d ouverture | heure de fermeture |
#      | 18                | 9                  |
#      | 8                 | 8                  |
