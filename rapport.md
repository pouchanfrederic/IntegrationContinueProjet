# Cas pratique N°1 : Intégration continue d'un serveur de chat grâce à l'IDE Intellij

Nom Prénom : Damien Mollimard, Pouchan Frédéric

## Plugins utilisés :

- JUnit : Pour créer les classes ainsi que les méthodes de tests
- Build-Dashboard : Pour générer un rapport donnant des informations sur les builds ainsi que sur les éventuelles erreurs rencontrées 

## Code coverage :

- Intellij : Pour déterminer le code coverage de l'application, nous avons utilisé le module du même nom de l'IDE, celui-ci nous a permis de trouver 
les parties du code qui n'étaient pas testés pour remédier au problème.

## Méthodologie de création de test :

  Lors de la création des tests, nous avons utilisés les bonnes pratiques que nous connaissions pour qu'ils soient les plus pertinents possibles, 
  à savoir : 

  - Un test doit être le plus simple possible et ne tester qu'une petite portion de code (ce qui correspond à une méthode en règle général)
  - Un test ne doit pas utiliser trop d'éléments extérieurs pour éviter qu'il devienne obsolète en cas de changements dans le code
  - Tester plusieurs fois la même méthode pour tester tous les comportements possibles 