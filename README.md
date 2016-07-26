jplc-init-java
==============

Objectif :
réaliser en Java le portage d’un programme simple écrit en FreeBASIC.

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
