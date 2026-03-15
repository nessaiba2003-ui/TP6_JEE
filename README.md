🚀 TP 6 : Spring Boot et Thymeleaf
Ce projet est une application web de gestion d'utilisateurs réalisée avec Spring Boot, Spring Data JPA, Thymeleaf et une base de données MySQL.
📋 Fonctionnalités (CRUD)
Afficher la liste des utilisateurs.
Ajouter un nouvel utilisateur avec validation des données.
Modifier les informations d'un utilisateur existant.
Supprimer un utilisateur.
🛠️ Technologies Utilisées
Java 17+
Spring Boot 3.x (Starter Web, Data JPA, Thymeleaf, Validation)
MySQL (Serveur de base de données via XAMPP/WAMP)
Maven (Gestionnaire de dépendances)
IntelliJ IDEA (IDE)
📂 Structure du Projet
Le code est organisé selon une architecture MVC :
ma.example.demo.entities : Contient l'entité User avec annotations JPA et Validation.
ma.example.demo.repositories : Contient l'interface UserRepository (Spring Data JPA).
ma.example.demo.web : Contient UserController pour la logique de navigation.
src/main/resources/templates : Contient les vues HTML (index, add-user, update-user).
🏁 Conclusion Personnelle
Ce TP 6 m'a permis de mettre en pratique les concepts fondamentaux de l'écosystème Spring Boot et de comprendre comment structurer une application web moderne suivant l'architecture MVC (Modèle-Vue-Contrôleur).
Points clés retenus :
Gain de productivité : L'utilisation de Spring Data JPA avec les interfaces Repository simplifie énormément l'accès aux données. On n'a plus besoin d'écrire de requêtes SQL complexes pour les opérations de base (CRUD), ce qui réduit les risques d'erreurs.
Puissance de Thymeleaf : J'ai appris à lier dynamiquement le code Java avec des pages HTML. La syntaxe de Thymeleaf permet de manipuler facilement des listes d'objets et de gérer les formulaires de manière intuitive.
Rigueur du développement : Ce TP m'a montré l'importance d'une configuration précise (comme le fichier pom.xml ou application.properties). La gestion des erreurs de validation avec @Valid assure également la cohérence des données stockées en base MySQL.
