# RAM-TAT-BACK
,
RAM TAT BackOffice Application :

L’implémentation de la solution RAM TAT consiste à la mise en place et l’implémentation des composants et des briques techniques suivants :
•	La mise en place de deux implémentations :
    ○	Web TAT (Système de gestion du Back-Office TAT)
    ○	Mobile TAT (Application Mobile Cross-Platform en modes Online et Offline)
•	La mise en place d’un système de synchronisation/rafraîchissement automatique pour le mode Online   
•	Intégration d’un système de Notification PUSH
•	Module de gestion du référentiel de base (Tâches, Tâches exceptionnels, Ressources, Types de vols, avions, …)
•	Module de gestion d’interfaçage avec les différents systèmes tiers, à savoir :
    ○	NETLINE : interfaçage bidirectionnel :
        -	Récupération des informations basiques des vols depuis Netline (Itinéraire/Départ/ Arrivée …)
        -	Envoi des infos des retards Vols depuis TAT vers Netline
    ○	ALTEA CM / BRS : Récupération des listes des passagers par Vol
    ○	ALTEA FM : Récupération de la charge de remplissage par Vol
    ○	SITATX : Récupération des Calculated Take Off Time (CTOT)
    ○	JEPPESEN/ROCADE : Récupération des listes des membres d'équipages par Vol
    ○	ONDA : Récupération des informations sur le Parking et le Gate depuis le SI d’ONDA
•	Implémentation d’un moteur de règles, pour la gestion du référentiel des tâches
•	Implémentation d’un système d'affectation automatique des tâches, et d'auto-affectation des TAT/Vols
•	Implémentation et la mise en place d’un moteur de Workflow pour la gestion du cycle de vie des tâches
•	Module de gestion de l’historique et de la traçabilité
•	Implémentation des trois principaux catalogues de services suivants (APIs REST) :
    ○	Implémentation et exposition de l'API-TAT-Details (gestion des détails des TATs)
    ○	Implémentation et exposition des de l'API-Monitoring (Monitoring management)
    ○	Implémentation et exposition de l'API-Reporting (reporting de base)
•	Gestion de sécurité, d’authentification (Online/Offline), des habilitations, et d’accès via un annuaire LDAP interne
•	Intégration d’un API Gateway
•	Module de gestion du Chat et Inbox
•	Intégration des Data-Martes spécifiques pour le reporting Avancé sur QlickSense
