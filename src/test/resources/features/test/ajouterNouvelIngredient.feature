#language: fr

Fonctionnalité: Gérer les ingrédients disponibles pour tous les magasins

  Contexte:
    Etant donné une saveur "Vanille"

  Scénario: Ajouter un nouvel ingrédient disponibles pour tous les magasins
    Quand j'ajoute le nouvel ingrédient
    Alors l'ingrédient est ajouté à la liste des ingrédients disponibles

  Scénario: Retirer un ingrédient disponibles pour tous les magasins
    Etant donné l'ingrédient est présent dans la liste des ingrédients disponibles
    Quand je retire l'ingrédient
    Alors l'ingrédient est retiré à la liste des ingrédients disponibles
