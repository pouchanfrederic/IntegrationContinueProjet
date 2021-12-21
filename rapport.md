# Cas pratique N°1 : Intégration continue d'un serveur de chat grâce à l'IDE Intellij

Nom Prénom : Damien Mollimard, Pouchan Frédéric

## Scénarios de tests :

Information supplémentaire : (Chaque fois qu'il y a la mention "Cliquer", cela s'opère à l'aide de la touche ENTREE sur clavier)

### Scénario 1 : Créer une nouvelle Chatroom

- Etape 1 : Entrer un pseudo et cliquer sur le bouton "Login"
- Etape 2 : Cliquer sur le bouton "New Chatroom"
- Etape 3 : Entrer le nom de la chatroom et cliquer sur le bouton create
- **Résultat : La nouvelle chatroom est crée et l'utilisateur peut maintenant envoyer un message**

### Scénario 2 : Envoyer un message dans une chatroom existante

- Etape 1 : Entrer un pseudo et cliquer sur le bouton "Login"
- Etape 2 : Cliquer sur le bouton avec l'icone de la flèche vers le bas
- Etape 3 : Sélectionner la chatroom voulue
- Etape 4 : Ecrire le texte souhaité et cliquer sur le bouton "Send"
- **Résultat : L'utilisateur se trouve dans la chatroom désirée et le message a bien été envoyé**
  
### Scénario 3 : Vérifier l'état de connexion d'un utilisateur - nécéssite 2 utilisateurs (vérifie également que les messages sont actualisés en temps réel)

- Etape 1 : Les 2 utilisateurs entrent un pseudo et cliquent sur le bouton "Login"
- Etape 2 : Un des 2 utilisateurs crée une nouvelle chatroom (à l'aide du bouton "New Chatroom") en indiquant le nom souhaité
- Etape 3 : L'utilisateur qui n'a pas créé la chatroom l'a rejoint 
- Etape 4 : Un des deux utilisateurs envoie un message (avec le bouton "Send") puis l'autre le fait à son tour 10 secondes plus tard
- **Résultat : Le status de l'utilisateur présent devant son pseudo est actualité, passant de "active" à "idle"**
  
### Scénario 4 : Vérifier l'information "Current user" présente dans l'écran principal

- Etape 1 : Entrer un pseudo, le mémoriser et cliquer sur le bouton "Login"
- Etape 2 : Vérifier en haut de l'écran si à côté de la mention "Current user :" se trouve le pseudo entré précédemment
- **Résultat : Le pseudo est bien présent à cet endroit**

### Scénario 5 : Vérifier que l'on ne puisse pas créer deux chatroom du même nom 

- Etape 1 : Entrer un pseudo et cliquer sur le bouton "Login"
- Etape 2 : Cliquer sur le bouton "New Chatroom"
- Etape 3 : Entrer le nom de la chatroom et cliquer sur le bouton create
- Etape 4 : Répéter les étapes 2 et 3 en indiquant le même nom 
- **Résultat : La seconde chatroom n'a pas été créée** 

### Scénario 6 : Vérifier que la liste des chatroom est actualisée en temps réel (néséssite 2 utilisateurs)
- Etape 1 : Les 2 utilisateurs entrent un pseudo et cliquent sur le bouton "Login"
- Etape 2 : Un des deux utilisateurs créé une nouvelle chatroom à l'aide du bouton "New Chatroom"
- Etape 3 : L'autre utilisateur ouvre la liste des chatroom et vérifie la présence de la chatroom qui vient d'être créée
- **Résultat : La nouvelle chatroom est bien présente dans la liste**
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