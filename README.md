# AndroidKt4a

## Présentation
Projet de programmation mobile Android de 4e année (cf Consignes pour plus de détails). L'API Rest choisie est celle de StackExchange. Elle permet d'afficher une liste de questions posées sur le site StackOverflow, contenant le tag "android".

## Prérequis
* Installer AndroidStudio (et un émulateur si besoin).
* Récuperer la branche master.

## Consignes
* Langage Kotlin
* Architecture MVVM
* Clean Architecture
* Utilisation d'une réelle BDD
* Utilisation d'une API Rest
* Affichage d'une liste
* Design

## Ajouts personnels
* Page de connexion
* Splash Screen animé au début
* Quelques tests unitaires


## Fonctionnalités
### Splash
* Splash qui est censé afficher une image. Pour des raisons obscures, celle-ci ne s'affiche pas :/
![Splash Screen](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Splash.jpeg)

### Ecran de connexion
* Un écran classique de connexion.
![Ecran de connexion](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Connexion%20blank.jpeg)

* Un message d'erreur apparait si l'adresse e-mail n'est pas dans la base de données.
![Erreur de connexion](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Connexion%20error.jpeg)

* Un toast apparaît quand le compte est créé.
![Création de compte](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Création20%compte.jpeg)

* Un toast apparaît lorsque la connexion est réussie.
![Toast connexion](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Toast%20Connexion.jpeg)

### Ecran de liste
* Affichage de la liste contennant les informations délivrées par l'API.
![Liste](https://github.com/Laartem/AndroidKt4a/blob/master/Images%20Readme/Liste.jpeg)


## Pistes d'amélioration de l'application.
* Ajouter un mot de passe pour l'authentification.
* Faire une vraie page de création de compte.
* Faire un meilleur design pour la page d'API, et globalement pour toute l'application.
* Stockage des données de l'API en cache.
