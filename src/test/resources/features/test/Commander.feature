#language: fr

Fonctionnalité: Passer une commande

  Contexte:
    Étant donné un invité nommé "Bernard" "Tapie" avec pour adresse mail "bernardtapie@gmail.com" et pour numéro du téléphone "06 08 56 78 65"
    Et un cookie nommé "Pop-Choco"

  Plan du scénario: ajouter un cookie au panier
    Quand l'invité ajoute <nbAjouter> cookie à son panier
    Alors il y a <nbTotal> cookie dans son panier

    Exemples:
      | nbAjouter | nbTotal |

      # Comportement correct
      | 1         | 1       |
      | 5         | 5       |
      | 0         | 0       |

      # Ajouter un nombre négatif de cookie
      | -1        | 0       |


  Plan du scénario: retirer un cookie au panier
    Étant donné que l'invité ajoute <nbAjouter> cookie à son panier
    Quand l'invité retire <nbRetirer> cookie à son panier
    Alors il y a <nbTotal> cookies dans son panier

    Exemples:
      | nbAjouter | nbRetirer | nbTotal |

      # Comportement correct
      | 0         | 0         | 0       |
      | 1         | 1         | 0       |
      | 5         | 3         | 2       |

      # Retirer un nombre négatif de cookie
      | 4         | 5         | 4       |

      # Ajouter et retirer un nombre négatif de cookie
      | -3        | -5        | 0       |


  Plan du scénario: consulter le prix du panier
    Étant donné que l'invité ajoute <nbAjouter> cookie à son panier
    Quand l'invité accède au prix de son panier
    Alors son panier possède un montant de <prix> €

    Exemples:
      | nbAjouter | prix |
      # Conditions classiques
      | 5         | 7,5  |

      # Conditions limites
      | 1         | 1,50 |
      | -1        | 0    |
      | 0         | 0    |







