#language: fr

Fonctionnalité: Passer une commande

  Contexte:
    Etant donné un invité nommé "Bernard" "Tapie" avec pour adresse mail "bernardtapie@gmail.com" et pour numéro du téléphone "06 08 56 78 65"
    Et un cookie nommé "Pop-Choco"

  Scénario: ajouter un cookie au panier
    Quand l'invité ajoute 1 cookie à son panier
    Alors il y a 1 cookie dans son panier

  Scénario: retirer un cookie au panier
    Etant donné que l'invité ajoute 1 cookie à son panier
    Quand l'invité retire 1 cookie à son panier
    Alors il y a 0 cookies dans son panier

  Scénario: consulter le prix du panier
    Etant donné que l'invité ajoute 1 cookie à son panier
    Quand l'invité accède au prix de son panier
    Alors son panier possède un montant de 1,50 €






