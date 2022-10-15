# cookiefactory-22-23-l

_Template for classroom SI4-COO_

## doc

Contient le rapport final

## .github

1. Contient sous workflows/maven.yml, une version d'un fichier d'actions qui est déclenché dès que vous poussez du code.
   Sur cette version initiale seule un test Junit5 est déclenché pour vérifier que tout fonctionne.
    - GitHub Actions (See in .github/workflows) to simply make a maven+test compilation
2. Contient sous ISSUE_TEMPLATE, les modèles pour les issues user_story et bug. Vous pouvez le compléter à votre guise.

## src

- pom.xml :
    - Cucumber 7 et JUnit 5
    - Maven compatible
    - JDK 17

## User stories

La liste des fonctionnalités livrées par user story.

### Milestone X

Chaque user story doit être décrite par

- son identifiant en tant que issue github (#),
- sa forme classique (As a… I want to… In order to…) (pour faciliter la lecture)
- Le nom du fichier feature Cucumber et le nom des scénarios qui servent de tests d’acceptation pour la story.
  Les contenus détaillés sont dans l'issue elle-même.
   
   
