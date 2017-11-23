
ACLMiniRPG

Groupe composé de :

    Jean-Charles LIONNET
    Louis NAVONE
    Lucas SCHNABEL
    Thomas JANOWSKYJ

But du projet :

    Création d'un mini jeu style zelda, RPG
        
gitignore : 

    .gitignore
    .classpath
    .project
    bin/

Fonctionnalités :

    Sprint 1 : 
        Version texte.
        Le labyrinthe est généré par défaut - le héros et les monstres ne peuvent pas traverser les murs.
        Le héros est placé sur le plateau de jeu et peu s’y déplacer à l’intérieur. 
    
    Sprint 2 : 
        Version graphique avec des sprites.
        Des monstres sont placés de manière aléatoire dans le labyrinthe.
        Les monstres se déplacent de manière aléatoire.
        Les fantômes sont des monstres qui peuvent traverser les murs.
        Le héros a des points de vie.
        Le héros prend des dégats au contact d'un monstre.
        Le héros peut attaquer les montres avec lequel il est en contact - les deux perdent
        des points de vie.
        
        
    Suite :
    
    Le labyrinthe est généré à partir d’un fichier.
    Ajout d'une clé et une porte de sortie pour chaque labyrinthe.
    Le héros doit récupérer la clé pour dévérouiller la porte de sortie.  
    Le labyrinthe est généré en fonction du niveau sélectionné.
    Certains cases du labyrinthe sont spéciales : 
        • trésor : si le héros arrive sur la case il a gagné le jeu 
        • pièges : quand un personnage arrive sur la case il subit des dégâts  
        • magiques : si un personnage arrive sur la case un effet est déclenché  
     
    
    Les monstres se déplacent de manière intelligente en essayant d’attraper le héros.
    
     
    
    Le héros peut récupérer des points de vie en trouvant une potion.
    
    
    Le héros peut attaquer les montres sur la case adjacente.
    Le joueur appuie sur une touche pour que le héros attaque (coup par coup)
    Plusieurs labyrinthes à terminer pour terminer le jeu.
    Écran victoire,défaite.
    Menu du jeu et menu sélection des niveaux.
    Tableau des scores.
    Sauvegarde de parties.
    Charger une partie.
    
    
Utilisation de la première version : 
    
    Il suffit de lancer le main présent sur le projet ou exécuter la commande "ant".
    L'application ne fait pas grand chose mais permet de déplacer le personnage (ici représenté par "o/") dans un labyrinthe de taille 10*10. Le personnage ne peut pas franchir les limites de ce labyrinthe. 
    Pour le déplacement, il suffit d'appuyer dans le terminal sur une des touches de déplacements puis de confirmer son choix. Les touches de déplacements sont :
        - z : haut
        - q : droite 
        - s : bas
        - d : gauche
    ATTENTION : Il n'est pas possible d'utiliser plusieurs touches en même temps, il faut utiliser une touche, confirmer avec entrée puis refaire la manip pour un autre déplacement. 
        
        
Utilisation de la deuxième version :
    Sur Linux si erreur du type : Failed to open device (/dev/input/event9): Failed to open device /dev/input/event9 (13)
    alors faire les commandes dans le terminal :    - cd /
                                                    - sudo chmod o+r /dev/input/*
                                                    
    Installation native en fonctino de votre OS sur eclipse : https://docs.adacore.com/gnatbench-docs/src/using_ajis/java_path_config.html
    Pensez à ajouter toutes les librairies présentes dans le dossier lib.

