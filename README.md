jplc-init-java
==============

### 1. Objectif

Réaliser en Java le portage d’un programme simple écrit en FreeBASIC.

### 2. Fichiers de référence

Le programme original « FillCov » 
lit un fichier CSV comportant des données manquantes,
infère des valeurs pour ces données manquantes à partir des données présentes,
et émet deux fichiers CSV en sortie : le fichier complété avec les données
trouvées, et la matrice symétrique de covariance entre les colonnes de
données du fichier complété.

Fichiers CSV de référence :

  * UKOutput.csv : exemple de fichier en entrée
  * OupFillCov.csv : exemple de sortie, premier fichier
  * OupFillFile.csv : exemple de sortie, deuxième fichier

### 3. Utiliser git sur son poste

#### 3.1. Récupérer une première fois le repository git sur son poste

En ligne de commande :

    > git clone git@github.com:avantage-compris/jplc-init-java.git
    > cd jplc-init-java
    
#### 3.2. Enregistrer les modifications dans git sur son poste

Pour vérifier qu’il y a des modifications en cours :

    > git status

Pour enregistrer les modifications dans git :

    > git commit -a -m 'Nouvel essai'

#### 3.3. Voir les dernières modifications enregistrées sur son poste

    > git log    
    commit d2c5aef7b7c9a74ba5575a63fcd971d83bf69915
    Author: David Andrianavalontsalama <david.andriana@avantage-compris.com>
    Date:   Tue Jul 26 06:50:33 2016 +0200

        Initial import: README + CSV test files

#### 3.4. Voir le détail d’une modification (différences avant/après)

    > git show d2c5aef7b7c9a74ba5575a63fcd971d83bf69915

### 4. Utiliser java sur son poste

Rappel : placer les ficiers sources Java dans `src\main\java\fr\jplc`

#### 4.1. Compiler un programme Java

En ligne de commande :

    > md target\classes
    > javac -d target\classes src\main\java\fr\jplc\*.java    
    
#### 4.2. Exécuter un programme Java

En ligne de commande :

    > java -cp target\classes fr.jplc.MyHelloWorld
    
