#language: fr

Fonctionnalité: Soumettre un nouveau cookie

  Contexte:
    Étant donné un cuisinier


  Plan du scénario: Soumettre un cookie
    Etant donné un cookie de Nom : "<Nom>"
    Et avec une Pate : "<Pate>"
    Et de Saveur : "<Saveur>"
    Et avec les garnitures "<Garniture 1>" et "<Garniture 2>"
    Et une Cuisson : "<Cuisson>"
    Et un Melange : "<Melange>"
    Et un temps de préparation <temps> s
    Quand le gestionaire de cuisinier soumet un nouveau cookie
    Alors le cookie apparait dans la liste des cookies en attente de validation

    Exemples:
      | Nom      | Pate     | Saveur        | Garniture 1        | Garniture 2      | Cuisson  | Melange | temps |

      # Comportement correct
      | Amandine | Nature   | Amande        | Chouchou           | Caramel          | CROQUANT | MIXTE   | 5     |
      | Pepito   | Chocolat | Chocolat noir | Pépite de chocolat | Fraise           | MOELLEUX | GARNI   | 3     |


