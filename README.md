# CookieFactory-22-23-L

![The Cookie Factory logo](https://www.cookiefactory-germany.de/wp-content/uploads/2021/08/cookie_factory.png)

The Cookie Factory (TCF) est une grande enseigne de cookies.  
Le système Cookie on Demand (CoD) est un service innovant proposé par TCF à ses clients.  
Ils peuvent commander des cookies en ligne grâce à une application, et sélectionner le magasin de retrait, ainsi que du créneau de retrait de leur commande.  
Le système CoD garantit aux clients de TCF qu'ils récupéreront toujours leurs cookies prépayés et chauds.

## Documentation

Pour plus d'informations sur le projet, veuillez consulter
la [documentation](https://mireillebf.github.io/MyCourses/ForDistribution/SI4A-COO/TD/CookiesFactoryV0.html).

Vous pouvez également consulter le rapport du projet [ici](/doc/TeamL-rendu2.pdf)

## Pour Commencer

Ces instructions vous permettront d'obtenir une copie du projet sur votre propre machine.

### Prérequis

Vous devez avoir installé sur votre machine les logiciels suivants :

- [GIT](https://git-scm.com/)
- [Maven](https://maven.apache.org/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

### Installation

Cloner le projet

```sh
git clone https://github.com/PNS-Conception/cookiefactory-22-23-l.git
```

Se déplacer dans le répertoire de travail

```sh
cd cookiefactory-22-23-l
```

### Lancement de l'application

Compiler le projet

```sh
mvn clean install
```

Lancer l'application

```sh
mvn exec:java
```

## Fonctionnalités

### Réductions

 #### *User Story* : Bénéficier d’une réduction sur une commande [#12](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/12)

**En tant que** Client fidèle  
**Je veux** bénéficier de mon avantage client fidèle  
**Afin de** payer moins cher ma commande  

#### *User Story* : Obtenir une réduction quand le client atteint le quota de fidélité [#49](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/49)

**En tant que** Client qui a un compte Membre  
**Je veux** pouvoir bénéficier d'une réduction quand j'atteins le quota nécessaire  
**Afin de** payer moins cher  

### Cookie festif

#### *User Story* : Ajouter un cookie festif au panier [#39](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/39)

**En tant qu'** Invité  
**Je veux** ajouter un cookie festif au panier  
**Afin de** le commander ultérieurement  

#### *User Story* : Devenir Chef cookie festif [#40](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/40)

**En tant que** Chef cuisinier  
**Je veux** devenir chef cookies festifs  
**Afin de** créer des party cookies selon mes thèmes et mes occasions  

#### *User Story* : Commander des cookies festifs [#41](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/41)

**En tant qu'** Invité  
**Je veux** obtenir la liste des magasins proposant les cookies festifs  
**Afin de** commander des cookies festifs  

#### *User Story* : Les Cookies Festifs modifient la quantité d'ingrédients [#47](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/47)

**En tant que** Chef Cuisinier  
**Je veux** que les Cookies Festifs que je prépare modifient la quantité des ingrédients de la recette  
**Afin de** pouvoir prendre la quantité qu'il me faut à l'avance  

#### *User Story* : Assigner les chefs cookies festifs à une commande de cookies festifs [#48](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/48)

**En tant que** Chef cookie festif  
**Je veux** être assigné à une commande de Cookie Festif  
**Afin de** pouvoir préparer la commande  

### Too Good To Go

#### *User Story* : Too Good To Go [#43](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/43)

**En tant que** Client  
**Je veux** être notifié des nouvelles commandes TooGoodToGo  
**Afin d'** avoir des cookies aléatoires moins chers  

### Panier

#### *User Story* : Consulter le contenu du panier [#1](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/1)

**En tant qu'** Invité  
**Je veux** voir mon panier avant de payer  
**Afin de** m’assurer de ne pas avoir fait d’erreur dans ma sélection des cookies et des quantités  

### Commandes

#### *User Story* : Annuler sa commande  [#13](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/13)

**En tant que** Client ayant passé une commande  
**Je veux** annuler ma commande  
**Afin d'** être remboursé de mon achat  

### Consultation des commandes

#### *User Story* : Consulter les commandes à préparer [#2](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/2)

**En tant que** Cuisinier  
**Je veux** consulter les commandes à préparer  
**Afin de** savoir ce qu’il faut préparer  

#### *User Story* : Consulter les commandes en attente de retrait [#4](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/4)

**En tant que** Caissier  
**Je veux** consulter les commandes en attente de retrait  
**Afin de** les délivrer au bon client  

#### *User Story* : Une commande par cuisinier, plusieurs cuisiniers [#21](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/21)

**En tant que** Cuisinier  
**Je veux** consulter les commandes à préparer  
**Afin de** pouvoir cuisiner les cookies efficacement  

#### *User Story* : Plusieurs commandes par cuisinier, plusieurs cuisiniers [#33](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/33)

**En tant que** Cuisinier  
**Je veux** consulter les commandes à préparer  
**Afin de** pouvoir cuisiner les cookies  

### Gestion des commandes par le système

#### *User Story* : Marquer la commande en entrée et sortie de cuisine [#3](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/3)

**En tant que** Cuisinier  
**Je veux** marquer une commande comme préparée  
**Afin d'** avertir le gestionnaire de commande  

#### *User Story* : Valider une commande délivrée [#5](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/5)

**En tant que** Caissier  
**Je veux** donner la commande à la bonne personne et marquer la commande comme délivrée  
**Afin de** l’enlever de la liste des commandes en attente de retrait  

### Magasins

#### *User Story* : Consulter le catalogue d’un magasin [#6](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/6)

**En tant qu'** Invité  
**Je veux** consulter le catalogue des cookies disponibles auprès d’un magasin donné  
**Afin de** connaître toutes les recettes proposées  

#### *User Story* : Gérer les magasins présents dans la chaine de magasins [#35](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/35)

**En tant que** Dirigeant  
**Je veux** gérer (ajouter/supprimer) les magasins présents dans la chaine de magasins  
**Afin d'** avoir une cohérence entre le monde réel et le système  

### Clients

#### *User Story* : Créer un compte client [#7](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/7)

**En tant qu'** Invité  
**Je veux** créer un compte client  
**Afin de** bénéficier des avantages des clients enregistrés  

### Recettes

#### *User Story* : Sélectionner la quantité d’une recette [#9](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/9)

**En tant qu'** Invité  
**Je veux** sélectionner la quantité pour un certain cookie que je veux commander  
**Afin de** commander plusieurs cookies d’une même recette dans une seule commande  

#### *User Story* : Soumettre une nouvelle recette [#17](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/17)

**En tant que** Chef Cuisinier  
**Je veux** soumettre une nouvelle recette au dirigeant  
**Afin d'** ajouter une nouvelle recette au catalogue des recettes  

#### *User Story* : Accepter une nouvelle recette [#19](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/19)

**En tant que** Dirigeant  
**Je veux** valider ou refuser une nouvelle recette  
**Afin de** l’ajouter ou non au catalogue  

#### *User Story* : Les recettes ont une quantité [#46](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/46)

**En tant que** Chef Cuisinier  
**Je veux** que les Cookies que je prépare aient une quantité d'ingrédients différents selon la recette  
**Afin de** pouvoir prendre en stock la bonne quantité  

### Programme de fidélité

#### *User Story* : Souscription au programme de fidélité [#11](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/11)

**En tant que** Client  
**Je veux** souscrire au programme de fidélité  
**Afin d'** avoir des remises sur mes prochains achats  

### Stock des ingrédients

#### *User Story* : Gérer des ingrédients du stock d'un magasin [#20](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/20)

**En tant que** Responsable du stock  
**Je veux** ajouter des ingrédients aux stock  
**Afin de** modifier les quantités présentes dans le stock du magasin  

#### *User Story* : Passer une commande enlève du stock les ingrédients nécessaires [#24](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/24)

**En tant que** Cuisinier  
**Je veux** que les ingrédients nécessaires à la réalisation d'une commande soient disponibles  
**Afin de** pouvoir réaliser toutes les commandes qui me sont assignées  

#### *User Story* : Gérer les ingrédients disponibles pour tous les magasins [#32](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/32)

**En tant que** Dirigeant  
**Je veux** ajouter de nouveaux ingrédients dans les ingrédients disponibles pour tous les magasins  
**Afin de** créer des nouvelles recettes de cookie plus diversifiées  

### Paiement

#### *User Story* : Payer à la fin d'une commande [#22](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/22)

**En tant que** Client en cours de finalisation sa commande  
**Je veux** pouvoir payer  
**Afin de** valider ma commande  

#### *User Story* : Vendre ses cookies TTC [#30](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/30)

**En tant que** Responsable  
**Je veux** vendre mes cookies avec la taxe ajoutée  

### Notifications

#### *User Story* : Notifier le client une fois la commande en attente de retrait [#29](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/29)

**En tant qu'** Invité  
**Je veux** recevoir une notification quand ma commande est en attente de retrait  
**Afin de** pouvoir aller la chercher à coup sûr  

### Horaires de Magasin

#### *User Story* : Changer les horaires d'ouverture d'un magasin [#31](https://github.com/PNS-Conception/cookiefactory-22-23-l/issues/31)

**En tant que** Responsable  
**Je veux** changer les horaires d’ouverture de mon magasin  
**Afin de** prévoir l'emploi du temps des cuisiniers  

## Outils et technologies utilisés

- [**Github**](https://github.com) - Gestion de projet, gestion de version, gestion de tâches
- [**Java**](https://www.java.com/) - Langage de programmation
- [**Maven**](https://maven.apache.org/) - Gestionnaire de dépendances
- [**Spring**](https://spring.io/) - Framework Java
- [**Cucumber**](https://cucumber.io/) - Framework de test
- [**Junit**](https://junit.org/junit5/) - Framework de test
- [**Mockito**](https://site.mockito.org/) - Framework de test
- [**Gherkin**](https://cucumber.io/docs/guides/overview/) - Langage pour Behavior Driven Development

## Auteurs

- [**Ludovic Bailet**](https://github.com/Ludovic-BAILET)
- [**Aurélia Chabanier**](https://github.com/AureliaChabanier)
- [**Quentin Dubois**](https://github.com/QuentinDubois-Polytech)
- [**Matis Herrmann**](https://github.com/MatisPrograms)
- [**Florian Latapie**](https://github.com/FlorianLatapie)
