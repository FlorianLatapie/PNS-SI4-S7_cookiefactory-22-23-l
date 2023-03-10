#language:fr

Fonctionnalité: Retirer les ingrédients du stock nécessaires à la réalisation d'une commande

  Contexte:
    Étant donné un cookie nommé "Pop-Choco" composé de Chocolat
    Et un stock contenant 8 pâte "Nature", 7 "Amande", 5 "Chocolat", 6 "Chocolat blanc"


  Plan du Scénario: retirer les ingrédient nécessaire à une commande
    Étant donné une commande contenant <nbCookie> cookies
    Quand la commande est validé par le système
    Alors le stock comporte <nbChocolat> chocolats

    Exemples:
      | nbCookie | nbChocolat |
      | 1        | 4          |
      | 2        | 3          |
      | 5        | 0          |

