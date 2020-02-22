TP1 - Tutoriel de technologies emergentes
======


# Spring - Spring Boot




## Plan 


**1. Présentation de la technologie**


**2. Objectifs du tutoriel - contexte, description et résultats/connaisses  attendus après  l’exécution**

**3. Tutoriel**


## Présentation de la technologie 
 
### Spring 

Spring est un framework open source, créée en 2003 par Rod Johnson en tant qu'alternative à J2EE. Spring peut est considéré comme conteneur léger car les classes n'ont pas besoin d'implémenter une interface pour être pris en charge par le framework. Au cours de mise à jour, Spring a ajouté de nombreuses fonctionnalités pour répondre aux besoins des applications modernes comme la sécurité, l'utilisation de bases de données NosQL, le bigData,...
Aujourd'hui, Spring n'est plus considéré comme un framework mais comme une plateforme viable pour créer des applications d'entreprises.

Spring a initialement été créé comme container pour l'injection de dépendance en faisant de l'inversion de contrôle mais il a maintenant d'autres concepts clés qui sont présents par exemple : 
  * la programmation orienté aspect
  * une couche d’abstraction qui permet de faciliter l'intégration d'autres frameworks Java ou de librairies
  * la programmation suivant le patron MVC
  

Avec Spring, il y a des sous-projets qui permettent de rendre Spring modulaire. Ces modules permettent aux développeurs de créer une application plus rapidement et de n'utiliser que les modules dont ils ont besoin. Les plus utiles sont par exemple : 
  * Spring Data : permet de simplifier l'accès aux bases de données relationnelles et NoSQL, 
  * Spring Security : permet de sécuriser facilement une application.
  

  Nous allons maintenant présenter des concepts clés de Spring, certains modules et quelques outils.
  
##### Inversion of Control et Dependency Inversion 

###### Inversion of Control (IoC)

  L'inversion de contrôle ou Inversion of Control (IoC) en anglais est un patron d'architecture commun à de nombreux framework dont Spring/Spring Boot. 
De façon grossière l'inversion de contrôle inverse le flow de du déroulement de l'application : ce n'est plus l'application qui déroule le code mais le code qui réagit à des événements lancés par le framework.

... Exemple ... 

###### Dependency Inversion (DI)

  L'inversion de dépendance ou Dependency Inversion (DI) en anglais est un paradigme utilisé pour faire de l'inversion de contrôle. Dans ce cas ce n'est pas le programmeur qui crée les instances de classe importante, c'est le framework qui va en crée une ou en fournir une déja existante.


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


##### Spring Initilizr 


Spring Initilizr est un site qui permet, permet en remplissant un formulaire de générer, en appuyant sur le bouton generate, une archive qui permet d'amorcer le projet. Il y a le fichier pom.xml qui a déjà les dépendances de bases dont on aura besoin en fonction de ce que l'on aura rempli dans le formulaire, l’arborescence du projet est déjà créée automatiquement le dossier pour le main, le dossier pour les tests, etc. Dans le dossier src il y a déjà le squelette d'une classe pour une application qui utilise Spring Boot. Si on ne souhaite pas générer tous ces fichiers on peut seulement les consulter en appuyant sur le bouton Explore.


##### Spring Testig 


Spring Test est un module qui, comme son nom l'indique,  permet de tester son application. C'est un module qui contient beaucoup de façons de faire des tests pour plusieurs situations possibles. Il est possible de faire à la fois des tests unitaires mais aussi de l'intégration.
Pour les tests unitaires, ce module offre des mocks objets avec des paquets dédiés :
  * pour une application qui dépend d'un environnement spécifique en dehors du container 
  * pour les environnements Java Naming and Directory Interface (JNDI), qui permettent de faire des suites de tests ou des applications autonome sans avoir besoin de modifier l'application
  * pour les environnements web, controllers et filtre
  * pour les applications avec du WebFLux, on peut faire les tests sans avoir de serveur http


Spring offre aussi des classes pour faire des tests unitaires, 
  * ReflectionTestUtils : permet, par exemple, de changer les valeurs des constantes, modifier un champ qui est privé , invoquer des méthodes privées qui modifie champs (setter method) dans certains types d'application.
  * AopTestUtils :  permet de connaître des configurations qui sont faites automatiquement par Spring avec les annotations.
  * ModelAndViewAssert : avec la combinaison d'autres frameworks pour les tests unitaires permet de faire des tests plus facilement pour le module Spring MVC.

Ce module permet aussi de faire des tests d'intégrations.


### Spring Boot

  Spring boot est initialement un module du framework Spring mais peut être considéré comme un framework à part entière.
Il permet de créer facilement des applications autonomes basées sur Spring grâce à ces fonctionnalités :
  
  * Création d'application autonome
  * Intégration de serveur Tomcat, jetty ou Undertow de façon native
  * Intégration de dépendance dite "starter" pour simplifier les configurations
  * Automatisation des configurations pour Spring et certaines librairies quand c'est possible
  * Management des dépendances pour éviter les problèmes de versionnages 
  
Spring Boot est donc un outil extrèmement intéressant pour créé des applications "production-ready" en peu de temps et facilement.

  


## Objectif du tutoriel

  Dans ce tutoriel nous allons créé une application utilisant une architecture microservice à l'aide de Spring/Spring Boot. 
  
  Ces technologies sont très intéréssantes pour ce genre de projet pour plusieurs raisons : 
  * Création rapide et facile de microservice près a l'emplois et deployable rapidement
  * Grande flexibilité
  * Configuration et monitoring simple des services (edge ou micro) grâce au grand nombre de module présent


A la fin de ce tutoriel il vous sera possible de créer une application de gestion de collection simple avec une architecture microservice et API REST. Vous apprendrez aussi comment configurer les edges microservices suivant : Eureka pour le registre, Ribbon pour le load balancing et Zuul comme point d'accée proxy de votre applicaiton.

 

## Tutoriel
### Mise en place du projet


Pour ce tutoriel nous allons utiliser différent outils :

* L'IDE [Eclipse](https://www.eclipse.org/eclipseide/)
* Maven	3.6.1 qui est directement intégré à Eclipse 
* [PostgreSQL](https://www.postgresql.org/download/) pour windows
* [postman](https://www.postman.com/downloads/) qui est un outil extrèmement utile lors de l'utilisation d'API REST


Comme définis précédemment nous allons nous intérésser à la création d'une application de gestion de collection très simple. L'utilisateur de l'application pourra s'inscrire et se connecter, emprunter un livre (c'est à dire l'ajouter à sa collection), rendre un livre (ce qui revient à l'enlever de sa collection) et consulter sa collection de livre.


Voici l'architecture de l'application, nous l'étofferons plus tard dans le projet : 


![Architecture](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/archi.png)

Comme montrer sur la photo, le client va pouvoir communiquer avec le ms utilisateur et le ms collection, de plus les microservices pourront communiquer entre eux au besoin.


**Le client :**


Ce peut être un client tel qu'un naviguateur ou une API externe, dans notre cas nous simulerons l'utilisation du naviguateur par des requètes postman.

**MS Utilisateur :**

Ce microservice va gérer les utilisateurs en général, leur inscription, leur connexion et les demandes d'informations relatives aux utilisateurs (tel que leur id unique dans notre base de données par rapport à leur identifiant par exemple).

**MS Collection :**


Ce microservice va gérer les collections, l'ajout de livre dans une collection pour un utilisateur, le retrait et la consultation d'une collection. 

Comme les microservices sont des applications indépendantes et autonomes, chacun aura sa propre base de données ou il enregistrera les informations qu'il gère. Ce point sera développé plus tard lors de la création de nos micros services.

#### Création du projet 

Pour une meilleure visibilité nous allons décomposer le projet en différent sous projet, cette méthode de construction permet de même une meilleure modularité propice au changement.
Voici l'arbre qui décrit l'architecture de notre projet : 

![ArchitectureFichier](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/archifichier.png)

Nous allons commencé par créer un la racine : ARCHITP1 qui sera un projet maven. 
Pour cela il faut se rendre sur eclipse puis dans la barre d'outil File > New > Project...

Séléctionner un projet Maven : 

![Maven](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven1.png)

Séléctionner Maven Project

Cocher la case "Create a simple project" puis cliquer sur suivant.

Puis entrer le configuration tel ci dessous : 

![Maven2](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven2.PNG)

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

* Le package **fr.tse.myapp** sera le package racine, il contiendra la classe App.java qui sera le point d'entrée de notre microservice

* Le package **fr.tse.myapp.api** sera le package qui contiendra l'ensemble de nos classe de routing

* Le package **fr.tse.myapp.domain** sera le package qui contiendra l'ensemble de nos classes d'objet tel que des POJO ou encore les classes représentant les instances a transmettre sur le réseau

* Le package **fr.tse.myapp.repository** sera le package qui contiendra l'ensemble des classes utilisés pour communiquer avec nos bases de données 

* Le package **fr.tse.myapp.service** sera le package qui contiendra l'ensemble des classes contenant le code métier


On peut remarquer une similitude entre nos packages et le modele MVC. 

Il est important que l'ensemble des packages ai la même racine, ici **fr.tse.myapp**. Cela permet a Spring Boot de repérer l'ensemble des classes dans notre projet avec une configuration minimale de notre part.

Pour créer un package c'est simple : cliquer droit sur src/main/java dans le sous projet ms_collection, puis sur new > package
Entrer le nom de votre package puis finish. 

Voici à quoi devrait ressembler le résultat final : 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/package.PNG)

**La classe principale**

Une fois cela fait nous pouvons créer la classe App.java dans le package racine fr.tse.myapp. 
Pour cela cliquer droit sur le package , puis sur new > class et configurer la classe comme l'image ci-dessous (ne pas oubliez de cocher **public static void main** 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/App.PNG)

Voici le code a placer dans cette classe : 

```java
package fr.tse.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


}
```

Lorsqu'on copie colle ce code directement dans eclipse, l'IDE nous renvois une erreure car il ne sait pas d'ou viennent ces annotations et comment elles marchent il faut donc lui dire ou les chercher. 

Pour cela nous allons ajouter au pom.xml des dépendances sur les quels  Spring Boot ira se basé pour configurer notre application automatiquement ! 

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

On peut alors remarquer que l'erreur n'apparait plus ! 

Au niveau du code nous avons deux différences par rapport à un main normal : 

1. **@SpringBootApplication** 

Est une annotation de Spring Boot  qui regroupe les annotations suivantes : 

* @EnableAutoConfiguration qui permet le méchanisme d'auto configuration de Spring Boot. Ce dernier va configurer notre appliaction Spring automatiquement selon les dépendences que nous avons ajouté à notre projet !
	
* @ComponentScan permet de scanner le package ( ou l'ensemble de sous package dans notre cas) ou l'application se trouve et ainsi localiser l'ensemble des éléments (classe, interface ...)
	
* @Configuration qui permet d'enregistrer et d'importer nos propres classes de configuration

2. **SpringApplication.run(App.class, args)**
	
```java
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
```

Permet de définir le point d'entrée de notre application Spring ! 


Nous pouvons maintenant lancer l'application avec clique droit sur la classe Run As > 1 Java Application
et ainsi avec ces quelques lignes de code nous avons une application Spring déja fonctionelle sur serveur Tomcat. 


**Application.properties**

Ce fichier, que vous devez créer dans le dossier src/main/resources (clique droit > new > file et application.properties comme nom) permet de faire certaine configuration soit même.
Par exemple il permet de définir le nom de notre application et le port du serveur Tomcat sur le quel il écoute. Ainsi nous allons ajouter ces lignes : 

```xml
spring.application.name=ms_collection
server.port = 8083
```

Il nous sera assez utile pour le configuration de connexion à la base de données et aux différents edge microservices.


**Repository**

Le package repository est le package qui gère les questions de données. Avec Spring / Spring boot cela ce fait très facilement.

Pour les microservices il faut tenter de faire des bases de données au plus simple, ainsi pour notre microservice collection nous aurons une unique base avec une unique table et des entrées du type :


| idBDD | idLivre | idUser | Date de Retour |

Avec idBDD l'id unique de l'entrée en base

idLivre l'id unique du livre

idUser l'id unique de l'utilisateur 

Date de Retour étant la date de retour du livre

Pour créer cette base de données c'est très simple à faire avec Spring / Spring Boot : il n'y a pas besoin d'écrire soit même un schéma de base ou faire la création à la main faire à la main. Il suffit de faire une classe avec les bonnes annotations et Spring Boot se chargera du reste pour nous. 

Voici la classe Collection créée dans le package domain : 


```java
package fr.tse.myapp.domain;

import javax.persistence.*;;

@Entity
@Table(name = "Collections")
public class Collection {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBDD")
	private long idBDD;
	
	@Column(name = "idLivre")
	private long idLivre;
	
	@Column(name = "idUser")
	private long idUser;
	
	@Column(name = "dateRetour")
	private String dateRetour;

	

	public Collection(long idLivre, long idUser, String dateRetour) {
		super();
		this.idLivre = idLivre;
		this.idUser = idUser;
		this.dateRetour = dateRetour;
	}

	public Collection() {
		
	}

	
	
	public long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(long idLivre) {
		this.idLivre = idLivre;
	}

	public long getIdBDD() {
		return idBDD;
	}

	public void setIdBDD(long idBDD) {
		this.idBDD = idBDD;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(String dateRetour) {
		this.dateRetour = dateRetour;
	}

	@Override
	public String toString() {
		return "Collection [idBDD=" + idBDD + ", idLivre=" + idLivre + ", idUser=" + idUser + ", dateRetour="
				+ dateRetour + "]";
	}

	

}
```

Pour pouvoir utiliser l'ensemble de ces annotations il est nécéssaire de rajouter la dépendance suivante à notre microservice : 

```xml
<!-- https://mvnrepository.com/artifact/org.eclipse.persistence/javax.persistence -->
    <dependency>
        <groupId>org.eclipse.persistence</groupId>
        <artifactId>javax.persistence</artifactId>
        <version>2.2.1</version>
    </dependency>
```


Voici une courte explication des différentes annotations : 

@Entity défini la classe comme une entité, elle sera donc trouvé par @ComponentScan

@Table permet de donner un nom à la table, donner un schéma de construction particulier etc

@Id définis la clef primaire de notre table 

@GeneratedValue permet de définir une stratégie de génération pour cette attribut, ici c'est une génération de type identitaire donc unique et incrémentale

@Column permet de définir et donner des noms au colone de notre table

Les setteurs et getteurs sont importants, ainsi que le toString() car il permette l'échange d'instance de cette classe autonome.

Ainsi avec ces simples annotations dans cette classe Spring Boot peut de lui même créer une table dans la base de données que nous lui fournirons !


Maintenant intéréssons nous à la classe CollectionRepository du package repository qui va justement utiliser cette classe Collection : 

**CollectionRepository** 

Cette classe gère l'ensemble des intéractions avec la base de données du microservice.

Voici son code : 

```java
package fr.tse.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.tse.myapp.domain.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,String> {
	

	
	@SuppressWarnings("unchecked")
	public Collection save(Collection col);
	
	
	
	public void deleteByidBDD(long idLivre);
	
	
	
	@Query(nativeQuery=true,value = "SELECT * FROM Collections a WHERE a.id_user = :id_user")
	public List<Collection> getUserCollection(@Param("id_user") long idUser);
	
	
	
}

```

et voici les dépendances dont elle a besoin : 


```xml
<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
<dependency>
    <groupId>org.springframeworkta</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>2.2.4.RELEASE</version>
</dependency>



<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
<dependency>
    <groupId>javax.xml.bind</groupId>
    <artifactId>jaxb-api</artifactId>
    <version>2.3.1</version>
</dependency>
```


Celle-ci seront placée dans le pom.xml de MS car elles peuvent être utile pour l'ensemble des microservices.

Dans notre cas nous utilisons une base de données PostgreSQL pour le microservice collection ainsi nous rajoutons la dépendance suivante dans son pom.xml : 

```xml
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.10</version>
</dependency>
```



3. Exécution 
