#  Backend - Devine le Mot

Ce dépôt contient le **backend** de l'application _Devine le Mot_, un petit jeu où les utilisateurs doivent deviner un mot à partir d'espaces vides représentant le nombre de lettres. Le jeu en lui-même est implémenté dans le dépôt frontend, tandis que ce backend gère l'authentification, la persistance des parties jouées, et l'interaction avec la base de données.

---

##  Description du projet

- Authentification sécurisée via **Spring Security** et **JWT** (JSON Web Tokens)
- Deux endpoints principaux pour les utilisateurs :
    - `/signup` : Inscription
    - `/login` : Connexion
- Un endpoint pour **sauvegarder** et **récupérer** les parties jouées par chaque utilisateur
- Le backend est indépendant de la logique du jeu, qui se trouve dans le **frontend**
- Les données des utilisateurs et leurs parties sont stockées dans une base PostgreSQL

---

##  Lancer le projet

###  Option 1 : Docker Compose

La manière la plus simple de lancer l'application est d’utiliser Docker Compose. Il suffit d’exécuter la commande suivante à la racine du projet :

```bash
docker-compose up
```

### Option 2 : Lancement en local

il est possible aussi de lancer l'application sans Docker Compose. Il te faudra alors :
 Avoir un conteneur PostgreSQL actif avec la configuration suivante :

    Nom de la base : devopsdb

    Nom d'utilisateur : username

    Mot de passe : password

    Port : 5432

Assure-toi que ces informations sont bien configurées dans application.properties.
▶ Ensuite :

Compile et exécute le projet via Maven ou ton IDE .

### Tester le backend

Pour tester les fonctionnalités de l'application, il est nécessaire de lancer également le frontend (présent dans le dépôt dédié).
Étapes de test :

    Lancer le frontend

    Créer un profil utilisateur via l'interface d'inscription

    Jouer une ou plusieurs parties (le jeu consiste à deviner un mot à partir d'espaces vides)

    Accéder à l’onglet Historique des parties pour consulter les parties précédemment jouées

### Interactions avec Docker

Ce projet tire pleinement parti de l’écosystème Docker :

- Utilisation d’un conteneur PostgreSQL pour la base de données

- Build de l’image Docker du backend avec un Dockerfile

- Orchestration avec Docker Compose (docker-compose.yml)
 
- Publication automatique de l’image sur Docker Hub via GitHub Actions

🛠️ Technologies utilisées

- Java 17

- Spring Boot

- Spring Security + JWT

- PostgreSQL

- Docker / Docker Compose

- GitHub Actions


### Déploiement & CI/CD
- L’image Docker de l’application est automatiquement buildée et publiée sur Docker Hub à chaque mise à jour grâce à GitHub Actions.
