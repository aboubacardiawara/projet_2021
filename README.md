# l2s4-projet-2021 - Groupe 3

# Equipe

- Niloufar BAYAT
- Nbemba KASSAMA
- Aboubacar DIAWARA
- Abdoulkader MOUSSA MOHAMED

# Sujet

[Le sujet 2021](https://www.fil.univ-lille1.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)

# Livrables

## Livrable 1
**Modelisation des personnages**

### Atteinte des objectifs
- Modelisation:

        - ✅ debutee
        - ✅ terminée
        - ✅ validee par l'encadreur.
- Ecriture de code.

        - ✅ debutée
        - ✅ terminée
### Difficultés restant à résoudre


## Livrable 2
**Modelisation du plateau**

### Atteinte des objectifs
- Modelisation:

        - ✅ debutée
        - ✅ terminée
        - ✅ validee par l'encadreur.
- Ecriture de code.

        - ✅ debutée
        - ✅ terminée
### Difficultés restant à résoudre



## Livrable 3
**Modélisation des actions**

### Atteinte des objectifs
- Modelisation:

        - ✅ debutée
        - ✅ terminée
        - ✅ validee par l'encadreur.
- Ecriture de code.

        - ✅ debutée
        - ✅ terminée

### Difficultés restant à résoudre

## Livrable 4
**Modelisation complète**

### Atteinte des objectifs
- Modelisation:

        - ✅ debutée
        - ✅ terminée
        - ✅ validee par l'encadreur.
- Ecriture de code.

        - ✅ debutée
        - ✅ terminée

### Difficultés restant à résoudre

# Journal de bord

## Semaine 1
**Du 01/02/2021 au 06/02/2021**
Après une discussion intense avec les membres de l'equipe, on est tombé d'accoord sur le choix des elements à retenir pour la modelisation.
Ces éléments sont:
- La class Army: l'armée dans le jeu de guerre
- La class Worker: l'ouvrier dans le jeu agricole
- La class Player: le joueur dans chacun des deux jeux (bien qu'il suicitait un peu de confusion quant à son caractère de 'personnage' ou pas)

## Semaine 2
**Du 08/02/2021 au 13/02/2021**
Après une rencontre avec le prof, suivant ses recommandations nous avons decidé de retirer pour le moment la class Player de la modelisation, n'etant pas un personnage.
Aussi, nous avons améliorer la precedente modelisation, en usant du principe d'heritage du mieux qu'on pouvait. Notre modelisation contient les éléments suivant:
- la class Character: (abstrait) de la quelle herite les 2 class suivantes
- La class Army: l'armée dans le jeu de guerre
- La class Worker: l'ouvrier dans le jeu agricole

## Semaine 3
**Du 15/02/2021 au 20/02/2021**
Nous avons entamé la modélisation du plateau. Les classes suivantes ont été modelisées à moitiée:
- La class Ressource (qui est un enumeration): represente les sources que peuvent produire les tuiles.
- La class Tuile
- La class Board: represente le plateau du jeu (terrain de jeu)

On a rencontré un problème sur la modélisation des ressources et avons jugé nécessaire de prendre un recul sur le problème. Chaque membre de l'équipe aura 3 jours pour refléchir sur un moyen de pallier au problème.

## Semaine 4
**Du22/02/2021 au 28/02/2021**
- Nous avons rediscuter sur le meilleur moyen de modeliser les plateaux et tuiles. C'est pourquoi une deuxieme modelisation "plateauV2.png" a eté proposé.

- (modification) Nous avons finalement réussi à mettre en plce une modélisation qui respecte les contraintes qu'on s'etait imposé. Aussi la modelisation du personnage a subit une petite modification.

## Semaine 5
**Du28/02/2021 au 07/03/2021**
- Nous avons commencer à coder.

## Semaine 6
**Du 08/02/2021 au 15/03/2021**
-  Nous avons continuer le codage.
## Semaine 7
**Du 15/02/2021 au 22/03/2021**
- Nous avons fais une premiére modélisation des actions.
## Semaine 8
**Du 22/02/2021 au 28/03/2021**
- Semaine du DS
## Semaine 9
**Du 29/02/2021 au 05/04/2021**
- Nous cherchons le meilleur moyen pour coder la methode initBoard qui contruit le plateau
## Semaine 10
**Du 06/04/2021 au 12/04/2021**
- On a continuer le codage des actions puis on a chercher à ameliorer l'implement de la methode init. Rien de très exhaustif.  
## Semaine 11
**DU 13/04/2021 au 19/04/2021**
Modelisation complète. Reflexion sur le deroulement du jeu.
## Semaine 12
**du 20/04/2021 au 21/05/2021**
finalisation du projet

# ORGANISATION DU PROJET
## Strucutre des repertoires
~~~
jeu
   ├── action
   │   ├── Action.java
   │   ├── Convert.java
   │   ├── DeployeArmy.java
   │   ├── DeployeWorker.java
   │   ├── Distribute.java
   │   ├── NothingFarm.java
   │   ├── NothingWar.java
   │   └── Reap.java
   ├── board
   │   ├── BoardFarmGame.java
   │   ├── Board.java
   │   ├── BoardWarGame.java
   │   ├── ClassicBoard.java
   │   └── tile
   │       ├── Desert.java
   │       ├── Mountain.java
   │       ├── Ocean.java
   │       ├── Plain.java
   │       ├── resource
   │       │   ├── Corn.java
   │       │   ├── Resource.java
   │       │   ├── Rock.java
   │       │   ├── Sand.java
   │       │   └── Wood.java
   │       ├── Tile.java
   │       ├── UnusableTile.java
   │       ├── UsableTile.java
   │       └── Woods.java
   ├── character
   │   ├── Army.java
   │   ├── Character.java
   │   └── Worker.java
   ├── exception
   │   ├── NoSuchResourceException.java
   │   └── TileException.java
   ├── game
   │   ├── GameFarm.java
   │   ├── Game.java
   │   └── GameWar.java
   ├── MainGame.java
   ├── player
   │   ├── PlayerFarm.java
   │   ├── Player.java
   │   └── PlayerWar.java
   ├── strategy
   │   ├── InteractiveStrat.java
   │   ├── RandomStratFarm.java
   │   ├── RandomStrat.java
   │   ├── RandomStratWar.java
   │   ├── Strategy.java
   └── util
       ├── Aleatoire.java
       └── io
           ├── Input.java
           └── InputMain.java

~~~
# UTILISATION DU MAKEFILE:
## EXECUTABLES
**Pour generer les fichiers executables**
~~~bash
make compile
~~~
Ceci a pour effet de generer tous les fichiers executables et les placer dans le repertoire `classes`.
## TESTS
~~~bash
make testCompile
~~~
Ceci a pour effet de generer tous les fichiers executables liés aux tests et les placer dans le repertoire `test`.
## DOCUMENTATION
~~~bash
make testCompile
~~~
Vous aurez un repertoire docs qui contiendra la documentation complète du projet.
Pour l'ouvrir, placer vous dans le repertoire docs, puis ouvrir dans votre navigateur le fichier html `index.html`.
## NETTOYER LES FICHIERS GENERABLES
pour supprimer tous les fichiers qui peuvent facilement être généré par un utilisateur, en l'occurence les ficheirs executables, la documentation, commencez par vous placer à la racine du projet puis executer la commande suivante:
~~~bash
make clean # supprime tous les fichiers generables.
~~~

# Lancer le jeu:

~~~bash
/l2s4-projet-2021$ make compile # pour compiler
~~~
~~~bash
cd classes/
/l2s4-projet-2021/classes$ java jeu.MainGame x player1 player2 ...playerN # pour lancer le jeu
~~~
x ----> 1 pour le jeu de guerre ou 2 pour le jeu agricole

player1 player2 ...playerN ---->  les noms des joueurs

Par exemple:
~~~bash
/l2s4-projet-2021/classes$ java jeu.MainGame 1 Raymond Odette
~~~
~~~bash
/l2s4-projet-2021/classes$ java jeu.MainGame 2 Vigneron Eleveur Maraicher
~~~

# Creer et lancer le jar:

~~~bash
/l2s4-projet-2021/classes$ jar cvf ../game.jar jeu
/l2s4-projet-2021/classes$ cd ..
/l2s4-projet-2021$ java -classpath game.jar jeu.MainGame 1 Raymond Odette
/l2s4-projet-2021$ java -classpath game.jar jeu.MainGame 2 Raymond Odette
~~~
