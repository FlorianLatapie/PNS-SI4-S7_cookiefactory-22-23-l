#language: fr
Fonctionnalité: Consulter les commandes en attente de retrait

  Contexte:
    Étant donné un caissier nommé "Cassandre" qui est connecté

  Plan du scénario: Consulter les commandes en attente de retrait
    Lorsque le système contient <commandes> dont <retrait> commandes en attente de retrait
    Quand le caissier consulte les commandes en attente de retrait
    Alors il voit <voit> commandes en attente de retrait

    Exemples:

      | commandes | retrait | voit |

      # Conditions Limites
      | 0         | 1       | 0    |
      | 1         | 1       | 1    |
      | 2         | 1       | 1    |
      | 2         | 3       | 2    |
      | 4         | 1       | 1    |
      | 5         | 2       | 2    |
      | 6         | 6       | 6    |
      | 10        | 0       | 0    |
      | 10        | -1      | 0    |
      | -1        | 1       | 0    |
      | -1        | -1      | 0    |
