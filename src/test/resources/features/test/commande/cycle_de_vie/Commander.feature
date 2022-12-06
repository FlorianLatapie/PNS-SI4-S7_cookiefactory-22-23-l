##language: fr
#
#Fonctionnalité: Passer une commande
#
#  Contexte:
#    Étant donné un invité
#    Et un cookie nommé "Pop-Choco"
#
#  Plan du scénario: Ajouter une quantité strictement positive de cookie au panier
#    Quand l'invité ajoute <nbAjouter> cookies à son panier
#    Alors il y a <nbTotal> cookie dans son panier
#
#    Exemples:
#      | nbAjouter | nbTotal |
#
#      # Cas classiques
#      | 5         | 5       |
#
#      #Cas limites
#      | 1         | 1       |
#
#
#  Plan du scénario: Ajouter une quantité négative de cookie au panier
#    Etant donné un problème est attendu (Commander)
#    Quand l'invité ajoute <nbAjouter> cookies à son panier
#    Alors il y a <nbTotal> cookie dans son panier
#    Et une exception IllegalArgumentException a été levée (Commander)
#
#    Exemples:
#      | nbAjouter | nbTotal |
#
#      # Cas classiques
#      | -5        | 0       |
#
#      # Cas limites
#      | 0         | 0       |
#      | -1        | 0       |
#
#
#  Plan du scénario: retirer une quantité strictement positive de cookie au panier
#    Étant donné que l'invité ajoute 10 cookies à son panier
#    Quand l'invité retire <nbRetirer> cookie à son panier
#    Alors il y a <nbTotal> cookies dans son panier
#
#    Exemples:
#      | nbRetirer | nbTotal |
#
#      # Cas classiques
#      | 2         | 8       |
#      | 9         | 1       |
#
#      # Cas limites
#      | 1         | 9       |
#      | 10        | 0       |
#
#
#  Plan du scénario: retirer une quantité négative de cookie au panier
#    Étant donné que l'invité ajoute 10 cookies à son panier
#    Et un problème est attendu (Commander)
#    Quand l'invité retire <nbRetirer> cookie à son panier
#    Alors il y a <nbTotal> cookies dans son panier
#    Et une exception IllegalArgumentException a été levée (Commander)
#
#    Exemples:
#      | nbRetirer | nbTotal |
#
#      # Cas classiques
#      | -2        | 10      |
#
#      # Cas limites
#      | 0         | 10      |
#      | -1        | 10      |
#
#
#  Plan du scénario: retirer une quantité trop importante de cookie au panier
#    Étant donné que l'invité ajoute 10 cookies à son panier
#    Et un problème est attendu (Commander)
#    Quand l'invité retire <nbRetirer> cookie à son panier
#    Alors il y a <nbTotal> cookies dans son panier
#    Et une exception PasAssezCookies a été levée (Commander)
#
#
#    Exemples:
#      | nbRetirer | nbTotal |
#
#      # Cas classiques
#      | 12        | 10      |
#      | 15        | 10      |
#
#      # Cas limites
#      | 11        | 10      |
#
#
#  Plan du scénario: consulter le prix du panier
#    Étant donné que l'invité ajoute <nbAjouter> cookies à son panier
#    Quand l'invité accède au prix de son panier
#    Alors son panier possède un montant de <prix> €
#
#    Exemples:
#      | nbAjouter | prix |
#      # Conditions classiques
#      | 5         | 7,5  |
#
#      # Conditions limites
#      | 1         | 1,50 |
#
#
#  Scénario: consulter le prix d'un panier vide
#    Quand l'invité accède au prix de son panier
#    Alors son panier possède un montant de 0 €
#
#
#
#
#
#
#
#
