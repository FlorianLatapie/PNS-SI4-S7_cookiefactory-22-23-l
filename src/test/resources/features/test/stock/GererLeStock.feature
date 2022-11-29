##language: fr
#
#Fonctionnalité: Gérer le Stock
#
#  Contexte:
#    Étant donné un stock
#    Et un ingrédient "Chocolat"
#
#  Plan du scénario: Ajouter une quantité positive d'ingrédient au stock
#    Étant donné le stock ayant <nbInitial> ingrédients
#    Quand le responsable du stock ajoute <nbAjoute> ingrédients
#    Alors le stock comporte <nbFinal> ingrédients
#
#    Exemples:
#      | nbInitial | nbAjoute | nbFinal |
#
#      # Cas classiques
#      | 1         | 1        | 2       |
#      | 6         | 4        | 10      |
#
#      # Cas limites
#      | 0         | 0        | 0       |
#      | 0         | 1        | 1       |
#      | 1         | 0        | 1       |
#
#  Plan du scénario: Ajouter une quantité strictement négative d'ingrédient au stock
#    Étant donné le stock ayant <nbInitial> ingrédients
#    Et un problème est attendu
#    Quand le responsable du stock ajoute <nbAjoute> ingrédients
#    Alors le stock comporte <nbFinal> ingrédients
#    Et une exception IllegalArgumentException a été levée
#
#    Exemples:
#      | nbInitial | nbAjoute | nbFinal |
#
#      # Cas classiques
#      | 10        | -5       | 10      |
#
#      # Cas limites
#      | 0         | -1       | 0       |
#      | 1         | -1       | 1       |
#
#
#
#
#
#
#
#
#
#
