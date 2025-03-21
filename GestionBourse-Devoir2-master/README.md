
# Gestion Bourse - Application Web

Ce projet est une application web de gestion de portefeuille d’actions pour les traders. Elle permet aux utilisateurs de consulter les traders, de visualiser les actions qu’ils possèdent, d’acheter et de vendre des actions, tout en respectant certaines règles métier.

## Fonctionnalités

1. **Affichage des traders** :
   - Liste les traders enregistrés dans le système.
   - Lien vers les actions qu'ils possèdent.

2. **Gestion des actions** :
   - Affiche les actions possédées par un trader.
   - Permet de vendre une partie ou la totalité d'une action selon les règles suivantes :
     - Si la quantité à vendre dépasse la quantité possédée : erreur affichée.
     - Si la quantité à vendre est inférieure : mise à jour de la quantité.
     - Si la quantité à vendre est égale : suppression de l'action.
   - Affiche les actions non possédées par un trader pour les acheter.

3. **Achat d’actions** :
   - Permet d'acheter une nouvelle action.
   - L'utilisateur peut saisir la quantité et le prix d'achat.

## Technologies utilisées

- **Backend** :
  - Spring Boot (version utilisée : 3.x)
  - Spring Data JPA
  - MySQL Driver
- **Frontend** :
  - Thymeleaf pour les templates HTML.
  - Bootstrap (version 4.5.2) pour le design.
- **Autres** :
  - Spring Boot DevTools pour le rechargement rapide.

## Architecture du projet

Le projet suit une architecture MVC claire :

```
src/main/
├── java/com/gestionbourse/
│   ├── controllers/
│   │   ├── AcheterController.java
│   │   ├── ActionController.java
│   │   ├── TraderController.java
│   ├── dto/
│   │   └── ActionDto.java
│   ├── entities/
│   │   ├── Acheter.java
│   │   ├── AcheterId.java
│   │   ├── Action.java
│   │   ├── Trader.java
│   ├── repositories/
│   │   ├── AcheterRepository.java
│   │   ├── ActionRepository.java
│   │   ├── TraderRepository.java
├── resources/
│   ├── templates/
│   │   ├── acheterAction.html
│   │   ├── actions.html
│   │   ├── actionsNotIn.html
│   │   ├── traders.html
│   │   ├── vendreAction.html
│   ├── static/
│   │   ├── css/ (pour les fichiers CSS personnalisés)
│   │   ├── js/  (pour les fichiers JavaScript personnalisés)
│   ├── application.properties
```

## Configuration de la base de données

Assurez-vous de configurer votre base de données MySQL dans le fichier `application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestionbourse
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Installation et exécution

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/your-repo/gestionbourse.git
   cd gestionbourse
   ```

2. **Configurer la base de données** :
   - Créez une base de données MySQL nommée `gestionbourse`.
   - Mettez à jour le fichier `application.properties` avec vos identifiants MySQL.

3. **Lancer l'application** :
   ```bash
   mvn spring-boot:run
   ```

4. **Accéder à l'application** :
   - Ouvrez votre navigateur et rendez-vous sur : `http://localhost:8080`.

## Points importants de l'interrogation

1. L'application respecte les règles métier :
   - Gestion des erreurs lors de la vente d'actions.
   - Affichage dynamique des actions possédées et non possédées.
2. Utilisation de **Thymeleaf** et **Bootstrap** pour un rendu dynamique et professionnel.
3. Organisation claire du code source et des templates.

---

**Aperçu des pages** :

- **Page des traders** :
  Affiche tous les traders avec un bouton pour voir leurs actions.

- **Page des actions possédées** :
  Liste les actions avec des boutons pour vendre.

- **Page des actions non possédées** :
  Liste les actions disponibles à l'achat.

- **Formulaires dynamiques** :
  - Vendre une action : mise à jour ou suppression selon la quantité saisie.
  - Acheter une action : saisie du prix et de la quantité.

---

## Auteur

Ce projet a été réalisé dans le cadre d'une interrogation en développement Java/Spring.
