#language: fr

Fonctionnalité: Soumettre un nouveau cookie

  Contexte:
    Étant donné un gestionnaire de cuisinier
    Et un cookie de Nom : "Nom"
    Et avec une Pate : "Pate"
    Et de Saveur : "Saveur"
    Et avec les garnitures "Garniture 1" et "Garniture 2"
    Et une Cuisson : "Cuisson"
    Et un Melange : "Melange"
    Et un temps de préparation <temps>)

  Plan du scénario: Soumettre un cookie
    Quand le gestionaire de cuisinier soumet un nouveau cookie
    Alors le cookie apparait dans la liste des cookies en attente de validation

    Exemples:
      | temps |

      # Comportement correct
      | 1   |
      | 5   |
