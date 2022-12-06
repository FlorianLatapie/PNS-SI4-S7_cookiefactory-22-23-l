##language: fr
#
#Fonctionnalité: Permet à un client de passer son compte Client en compte Membre
#
#  Contexte:
#    Etant donné un client qui veut passer son compte Client en compte Membre
#
#  Scénario:
#    Quand il veux passer son compte Client en compte Membre
#    Alors le client devient un membre avec ses avantages
#
#  Plan du Scénario:
#    Quand un Membre passe une commande à <nombreCookies> cookies et qu'il a <avant> points de fidélité
#    Alors il voit ses points de fidélité augmenter du nombre de cookie acheté: <après>
#
#    Exemples:
#      | nombreCookies | avant | après |
#      | 0             | 0     | 0     |
#      | 0             | 1     | 1     |
#      | 1             | 0     | 1     |
#      | -1            | 1     | 1     |
#      | 1             | -1    | 1     |
#      | -1            | -1    | 0     |
#      | 2             | 1     | 3     |
#
#
#  Plan du Scénario:
#    Quand un Membre passe une commande et qu'il a <avant> points de fidélité pour un panier d'un montant de <montant> euros
#    Alors il voit le prix de sa commande diminuer de <pourcent>% pour payer <réduction> euros
#    Et il voit ses points de fidélité remis à <après> points
#
#    # Réduction a 20% taxe en plus
#    Exemples:
#      | avant | montant | pourcent | réduction | après |
#      | -1    | -10     | -7       | 0         | 1     |
#      | 0     | 0       | 0        | 0         | 1     |
#      | 5     | 0       | 0        | 0         | 6     |
#      | 0     | 50      | 0        | 60        | 1     |
#      | 10    | 100     | 1        | 120       | 11    |
#      | 29    | 200     | 2        | 237       | 0     |
#      | 35    | 800     | 5        | 940       | 6     |
