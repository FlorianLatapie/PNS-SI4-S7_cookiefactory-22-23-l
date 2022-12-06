##language: fr
#Fonctionnalité: Annuler sa commande
#
#  Contexte:
#    Etant donné un magasin avec des commandes
#    Et une commande à annuler
#    Et un cuisinier responsable de la commande à annuler
#
#  Scénario: Annuler sa commande (possible)
#    Etant donné un client ayant une commande n'étant pas encore préparée
#    Quand le client annule sa commande
#    Alors l'état de la commande devient ANNULEE
#
#  Scénario: Annuler sa commande (impossible)
#    Etant donné un client ayant une commande déja commencée
#    Quand le client annule sa commande
#    Alors une exception IllegalArgumentException est levée
#
#  Scénario: Désassigner un cuisinier
#    Etant donné un client ayant une commande n'étant pas encore préparée
#    Quand le client annule sa commande
#    Alors le créneau du cuisinier est libéré
#
#  Scénario: Remettre les ingrédients en stock
#    Etant donné un client ayant une commande n'étant pas encore préparée
#    Quand le client annule sa commande
#    Alors on rajoute dans le stock les ingrédients nécessaires à la commande
#
#  Scénario: Rembourser le client
#    Etant donné un client ayant une commande n'étant pas encore préparée
#    Quand le client annule sa commande
#    Alors le client est remboursé de la valeur de sa commande