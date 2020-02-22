TP1 - Tutoriel de technologies emergentes
======


# Spring - Spring Boot




## Plan 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**1. Présentation de la technologie**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**2. Objectifs du tutoriel - contexte, description et résultats/connaisses  attendus après  l’exécution**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
**3. Tutoriel**


## Présentation de la technologie 
 
### Spring 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spring est un framework open source, créée en 2003 par Rod Johnson en tant qu'alternative à J2EE. Spring peut est considéré comme conteneur léger car les classes n'ont pas besoin d'implémenter une interface pour être pris en charge par le framework. Au cours de mise à jour, Spring a ajouté de nombreuses fonctionnalités pour répondre aux besoins des applications modernes comme la sécurité, l'utilisation de bases de données NosQL, le bigData,...
Aujourd'hui, Spring n'est plus considéré comme un framework mais comme une plateforme viable pour créer des applications d'entreprises.
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spring a initialement été créé comme container pour l'injection de dépendance en faisant de l'inversion de contrôle mais il a maintenant d'autres concepts clés qui sont présents par exemple : 
  * la programmation orienté aspect
  * une couche d’abstraction qui permet de faciliter l'intégration d'autres frameworks Java ou de librairies
  * la programmation suivant le patron MVC
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Avec Spring, il y a des sous-projets qui permettent de rendre Spring modulaire. Ces modules permettent aux développeurs de créer une application plus rapidement et de n'utiliser que les modules dont ils ont besoin. Les plus utiles sont par exemple : 
  * Spring Data : permet de simplifier l'accès aux bases de données relationnelles et NoSQL, 
  * Spring Security : permet de sécuriser facilement une application.
  
#### Inversion of Control et Dependency Inversion 

##### Inversion of Control (IoC)
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  L'inversion de contrôle ou Inversion of Control (IoC) en anglais est un patron d'architecture commun à de nombreux framework dont Spring/Spring Boot. 
De façon grossière l'inversion de contrôle inverse le flow de du déroulement de l'application : ce n'est plus l'application qui déroule le code mais le code qui réagit à des événements lancés par le framework.

... Exemple ... 

##### Dependency Inversion (DI)
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  L'inversion de dépendance ou Dependency Inversion (DI) en anglais est un paradigme utilisé pour faire de l'inversion de contrôle. Dans ce cas ce n'est pas le programmeur qui crée les instances de classe importante, c'est le framework qui va en crée une ou en fournir une déja existante.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Exemple : 
Voici ce que donnerait un exemple en Java sans injection de dépendance : ici l'instance de la classe Item est directement créé par l'appelle du **new** dans le constructeur, cette instance sera forcément du type ItemImpl1.

```java
public class Store {
    private Item item;
  
    public Store() {
        item = new ItemImpl1();    
    }
}
```
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans le cas de l'inversion de dépendance, l'instanciation n'est pas faites directement dans le constructeur mais elle est passé en paramètre de ce dernier. Ainsi un objet store peut être créé avec différentes nouvelles implémentations de la classe Item  (ItemImpl1, ItemImpl2 etc...) ou avec une implémentation déja existante.

```java
public class Store {
    private Item item;
    public Store(Item item) {
        this.item = item;
    }
}
```

Les bénèfices de l'IoC sont nombreux : 

* Découplé l'exécution et l’implémentation des tâches.
* Plus simple de changer d’implémentation.
* Plus grande modularité du programme.
* Simplicité des tests par isolation des composants.





### Spring Boot
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Spring boot est initialement un module du framework Spring mais peut être considéré comme un framework à part entière.
Il permet de créer facilement des applications autonomes basées sur Spring grâce à ces fonctionnalités :
  
  * Création d'application autonome
  * Intégration de serveur Tomcat, jetty ou Undertow de façon native
  * Intégration de dépendance dite "starter" pour simplifier les configurations
  * Automatisation des configurations pour Spring et certaines librairies quand c'est possible
  * Management des dépendances pour éviter les problèmes de versionnages 
  
Spring Boot est donc un outil extrèmement intéressant pour créé des applications "production-ready" en peu de temps et facilement.

  


## Objectif du tutoriel
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Dans ce tutoriel nous allons créé une application utilisant une architecture microservice à l'aide de Spring/Spring Boot. 
  
  Ces technologies sont très intéréssantes pour ce genre de projet pour plusieurs raisons : 
  * Création rapide et facile de microservice près a l'emplois et deployable rapidement
  * Grande flexibilité
  * Configuration et monitoring simple des services (edge ou micro) grâce au grand nombre de module présent
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
A la fin de ce tutoriel il vous sera possible de créer une application de gestion de collection simple avec une architecture microservice et API REST. Vous apprendrez aussi comment configurer les edges microservices suivant : Eureka pour le registre, Ribbon pour le load balancing et Zuul comme point d'accée proxy de votre applicaiton.

 

## Tutoriel
### Mise en place du projet

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour ce tutoriel nous allons utiliser différent outils :

* L'IDE [Eclipse](https://www.eclipse.org/eclipseide/)
* Maven	3.6.1 qui est directement intégré à Eclipse 
* [PostgreSQL](https://www.postgresql.org/download/) pour windows
* [postman](https://www.postman.com/downloads/) qui est un outil extrèmement utile lors de l'utilisation d'API REST

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Comme définis précédemment nous allons nous intérésser à la création d'une application de gestion de collection très simple. L'utilisateur de l'application pourra s'inscrire et se connecter, emprunter un livre (c'est à dire l'ajouter à sa collection), rendre un livre (ce qui revient à l'enlever de sa collection) et consulter sa collection de livre.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici l'architecture de l'application, nous l'étofferons plus tard dans le projet : 


![Architecture](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/archi.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Comme montrer sur la photo, le client va pouvoir communiquer avec le ms utilisateur et le ms collection, de plus les microservices pourront communiquer entre eux au besoin.


**Le client :**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ce peut être un client tel qu'un naviguateur ou une API externe, dans notre cas nous simulerons l'utilisation du naviguateur par des requètes postman.

**MS Utilisateur :**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ce microservice va gérer les utilisateurs en général, leur inscription, leur connexion et les demandes d'informations relatives aux utilisateurs (tel que leur id unique dans notre base de données par rapport à leur identifiant par exemple).

**MS Collection :**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ce microservice va gérer les collections, l'ajout de livre dans une collection pour un utilisateur, le retrait et la consultation d'une collection. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Comme les microservices sont des applications indépendantes et autonomes, chacun aura sa propre base de données ou il enregistrera les informations qu'il gère. Ce point sera développé plus tard lors de la création de nos micros services.

#### Création du projet 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour une meilleure visibilité nous allons décomposer le projet en différent sous projet, cette méthode de construction permet de même une meilleure modularité propice au changement.
Voici l'arbre qui décrit l'architecture de notre projet : 

![ArchitectureFichier](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/archifichier.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Nous allons commencé par créer un la racine : ARCHITP1 qui sera un projet maven. 
Pour cela il faut se rendre sur eclipse puis dans la barre d'outil File > New > Project...

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
Séléctionner un projet Maven : 

![Maven](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven1.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Séléctionner Maven Project
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cocher la case "Create a simple project" puis cliquer sur suivant.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Puis entrer le configuration tel ci dessous : 

![Maven2](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven2.PNG)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Vous avez créer votre projet racine ! 

Maintenant créons les sous projets MS et EMS : 

Pour MS, faites un clique droit sur le projet ARCHITP1 New > Project...

Cette fois séléctionner Maven Module

![Maven](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven1.png)

Cocher la case "Create a simple project" et entrer le nom MS puis cliquer sur suivant. 
Changer le Packaging en pom et mettez le nom MS. 
Cliquer sur Finish et faites de même pour le sous projet EMS.

Il est enfin temps de créer nos microservices ! 

La création de microservices peut se faire automatiquement grâce à l'outil [Spring Initializr](https://start.spring.io/), dans ce tutoriel nous ferons tout à la main pour comprendre les rouages du framework :).

Pour le microservice Utilisateur appelé ms_user : 

faites un clique droit sur le projet MS New > Project...
Séléctionner Maven Module
Cocher la case "Create a simple project" et entrer le nom ms_user puis cliquer sur suivant. 
Changer le Packaging en jar et mettez le nom ms_user. 
Cliquer sur Finish et faites de même pour le sous projet ms_collection.

Faites de même pour les edges microservices ems_eureka et ems_zuul ! 
Ribbon n'est pas présent car il est directement intégré à nos microservices. 

Voici ce que devrait donner le résultat final : 

![Projet](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/projet.PNG)
 
### Implémentation

Il est enfin temps de coder nos microservices ! 

Pour cela nous allons commencé par le microservices ms_collection : 

Dans un premier temps nous allons créer différent package toujours dans un soucis de modularité. 
Il y en aura 5 : 

Le package **fr.tse.myapp** sera le package racine, il contiendra la classe App.java qui sera le point d'entrée de notre microservice

Le package **fr.tse.myapp.api** sera le package qui contiendra l'ensemble de nos classe de routing

Le package **fr.tse.myapp.domain** sera le package qui contiendra l'ensemble de nos classes d'objet tel que des POJO ou encore les classes représentant les instances a transmettre sur le réseau

Le package **fr.tse.myapp.repository** sera le package qui contiendra l'ensemble des classes utilisés pour communiquer avec nos bases de données 

Le package **fr.tse.myapp.service** sera le package qui contiendra l'ensemble des classes contenant le code métier


On peut remarquer une similitude entre nos packages et le modele MVC. 

Il est important que l'ensemble des packages ai la même racine, ici **fr.tse.myapp**. Cela permet a Spring Boot de repérer l'ensemble des classes dans notre projet avec une configuration minimale de notre part.

Pour créer un package c'est simple : cliquer droit sur src/main/java dans le sous projet ms_collection, puis sur new > package
Entrer le nom de votre package puis finish. 

Voici à quoi devrait ressembler le résultat final : 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/package.PNG)

Une fois cela fait nous pouvons créer la classe App.java dans le package racine fr.tse.myapp. 
Pour cela cliquer droit sur le package , puis sur new > class et configurer la classe comme l'image ci-dessous (ne pas oubliez de cocher **public static void main** 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/App.PNG)

Voici le code a placer dans cette classe : 

```java
package fr.tse.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ms_collection")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


}
```

Lorsqu'on copie colle ce code directement dans eclipse, l'IDE nous renvois une erreure car il ne sait pas d'ou viennent ces annotations et comment elles marchent il faut donc lui dire ou les chercher. 
Pour cela nous allons ajouter au pom.xml des dépendances sur les quels Spring / Spring Boot iront se basé pour configurer notre application automatiquement ! 

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-autoconfigure</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>2.2.4.RELEASE</version>
   </dependency>
```

De façon surprenant nous n'allons pas rajouter ces dépendances dans le pom.xml de notre microservice mais dans celui du projet n-1 c'est à dire MS. Les projets fils héritant des dépendances de leurs parents il est plus facile de placé ces dépendances au niveau n-1 et de ne pas les copier coller pour chaque microservice.



3. Exécution 
