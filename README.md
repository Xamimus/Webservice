# Rendu Webservice (Eliott CLAVIER / Maxime MARTIN / Florent CHABIN / Nathan PIGNON)

# Mise en place de l'environnement

### Importer le projet

Ouvrir un terminal dans le dossier où le projet sera importé

Écrire la commande suivante :

`git clone https://github.com/Xamimus/Webservice.git`

Ouvrir le projet dans un IDE


### Mettre à jour les dépendances du projet (varie en fonction de l'IDE utilisé)

Clic droit sur 'pom.xml' :

    -> "Update Project" (sous Visual Studio)

    -> "Synchronize 'pom.xml'" (sous IntelliJ IDEA)


### Base de données

Lancer Xampp ou Wampp ("Apache" et "MySQL")

Se rendre sur l'adresse suivante :

    http://localhost/phpmyadmin/

Créer une nouvelle base de données se nommant :

    webservice


### Lancer le projet

Se mettre sur le fichier "ForumApplication.java" :

    forum\src\main\java\com\b2dev\forum\ForumApplication.java

Lancer le projet

# Tester le projet

## Dump SQL / Gestion des données

Les tables ainsi que leur descriptions sont automatiquement importées dans la base de données "webservice"

Un jeu de fausses données est également importé

## Comptes mis à disposition

Des comptes pour les 4 niveaux de permissions sont mis à disposition, afin de tester facilement la gestion de ces dernières.

 	| ANONYMOUS | USER | MODERATOR | ADMIN | |:----------:|:----------:|:----------:| | anonymous@test | user@test | moderator@test | admin@test |

### Importer un fichier JSON sur Postman

Cliquer sur "Import" (en haut à gauche)

Mettre le fichier JSON souhaité
