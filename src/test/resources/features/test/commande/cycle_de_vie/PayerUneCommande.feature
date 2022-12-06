##language: fr
#Fonctionnalité: Payer lors d'une commande
#
#  En tant que Client en cours de finalisation sa commande
#  Je veux pouvoir payer
#  afin de valider ma commande
#
#  Contexte:
#    Étant donné un client qui passe une commande
#
#  Plan du Scénario: Payer une commande
#    Quand le client paye la commande et qu'il arrive au bout du "<payment>"
#    Alors l'état de la commande passe à "<etat>"
#
#    Exemples:
#      | payment | etat                    |
#      | True    | EN_COURS_DE_PREPARATION |
#      | False   | ANNULEE                 |