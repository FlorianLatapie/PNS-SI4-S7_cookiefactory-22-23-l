#language: fr

Fonctionnalité: Gérer les magasins de la chaine de magasins

  Contexte:
    Etant donné un magasin s'appelant "CookieNice-18"

  Scénario: Supprimer un magasin de chaine de magasin
    Etant donné le magasin appartenant à la chaine de magasins
    Quand je supprime le magasin de la chaine de magasins
    Alors le magasin est absent de la chaine de magasins

  Scénario: Ajouter un nouveau magasin à la chaine de magasin
    Quand j'ajoute le nouveau magasin
    Alors le magasin est présent dans la chaine de magasins
