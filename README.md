TP1 - Tutoriel de technologies emergentes
======


# Spring - Spring Boot




## Plan 


**1. Présentation de la technologie**


**2. Objectifs du tutoriel - contexte, description et résultats/connaisses  attendus après  l’exécution**

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
  
 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Nous allons maintenant présenter des concepts clés de Spring, certains modules et quelques outils.
  
##### Inversion of Control et Dependency Inversion 

###### Inversion of Control (IoC)


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  L'inversion de contrôle ou Inversion of Control (IoC) en anglais est un patron d'architecture commun à de nombreux framework dont Spring/Spring Boot. 
De façon grossière l'inversion de contrôle inverse le flow de du déroulement de l'application : ce n'est plus l'application qui déroule le code mais le code qui réagit à des événements lancés par le framework.
 

###### Dependency Inversion (DI)


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
L'inversion de dépendance ou Dependency Inversion (DI) en anglais est un paradigme utilisé pour faire de l'inversion de contrôle. Dans ce cas ce n'est pas le programmeur qui crée les instances de classe importante, c'est le framework qui va en créer une ou en fournir une déjà existante.	


Exemple : 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici ce que donnerait un exemple en Java sans injection de dépendance : ici l'instance de la classe Item est directement créée par l'appel du **new** dans le constructeur, cette instance sera forcément du type ItemImpl1.

```java
public class Store {
    private Item item;
  
    public Store() {
        item = new ItemImpl1();    
    }
}
```


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans le cas de l'inversion de dépendance, l'instanciation n'est pas faites directement dans le constructeur mais elle est passé en paramètre de ce dernier. Ainsi un objet store peut être créé avec différentes nouvelles implémentations de la classe Item (ItemImpl1, ItemImpl2 etc.) ou avec une implémentation déjà existante.

```java
public class Store {
    private Item item;
    public Store(Item item) {
        this.item = item;
    }
}
```

Les bénéfices de l'IoC sont nombreux : 

* Découpler l'exécution et l’implémentation des tâches.
* Plus simple de changer d’implémentation.
* Plus grande modularité du programme.
* Simplicité des tests par isolation des composants.


##### Spring Initilizr 



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spring Initilizr est un [site](https://start.spring.io/) qui permet, permet en remplissant un formulaire de générer, en appuyant sur le bouton generate, une archive qui permet d'amorcer le projet. Il y a le fichier pom.xml qui a déjà les dépendances de bases dont on aura besoin en fonction de ce que l'on aura rempli dans le formulaire, l’arborescence du projet est déjà créée automatiquement le dossier pour le main, le dossier pour les tests, etc. Dans le dossier src il y a déjà le squelette d'une classe pour une application qui utilise Spring Boot. Si on ne souhaite pas générer tous ces fichiers on peut seulement les consulter en appuyant sur le bouton Explore.


##### Spring Testing 



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spring Test est un module qui, comme son nom l'indique,  permet de tester son application. C'est un module qui contient beaucoup de façons de faire des tests pour plusieurs situations possibles. Il est possible de faire à la fois des tests unitaires mais aussi de l'intégration.
Pour les tests unitaires, ce module offre des mocks objets avec des paquets dédiés :
  * pour une application qui dépend d'un environnement spécifique en dehors du container 
  * pour les environnements Java Naming and Directory Interface (JNDI), qui permettent de faire des suites de tests ou des applications autonome sans avoir besoin de modifier l'application
  * pour les environnements web, controllers et filtre
  * pour les applications avec du WebFLux, on peut faire les tests sans avoir de serveur http



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Spring offre aussi des classes pour faire des tests unitaires, 
  * ReflectionTestUtils : permet, par exemple, de changer les valeurs des constantes, modifier un champ qui est privé , invoquer des méthodes privées qui modifie champs (setter method) dans certains types d'application.
  * AopTestUtils :  permet de connaître des configurations qui sont faites automatiquement par Spring avec les annotations.
  * ModelAndViewAssert : avec la combinaison d'autres frameworks pour les tests unitaires permet de faire des tests plus facilement pour le module Spring MVC.

Ce module permet aussi de faire des tests d'intégrations.


### Spring Boot


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  Spring boot est initialement un module du framework Spring mais peut être considéré comme un framework à part entière.
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il permet de créer facilement des applications autonomes basées sur Spring grâce à ces fonctionnalités :
  
  * Création d'application autonome
  * Intégration de serveur Tomcat, jetty ou Undertow ainsi qu'une base de données h2 de façon native 
  * Intégration de dépendance dite "starter" pour simplifier les configurations
  * Automatisation des configurations pour Spring et certaines librairies quand c'est possible
  * Management des dépendances pour éviter les problèmes de versionnages 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
Spring Boot est donc un outil extrêmement intéressant pour créer des applications "production-ready" en peu de temps et facilement.

  


## Objectif du tutoriel



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans ce tutoriel nous allons créer une application utilisant une architecture microservice à l'aide de Spring/Spring Boot.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ces techniques sont très intéressants pour ce genre de projet pour plusieurs raisons :
* création rapide et facile de microservice prêt à l’emploi et déployable rapidement
* Grande flexibilité
* Configuration et monitoring simple des services (edge ou micro) grâce au grand nombre de module présent



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
À la fin de ce tutoriel il vous sera possible de créer une application de gestion de collection simple avec une architecture microservice et API REST. Vous apprendrez aussi comment configurer les edges microservices suivants : Eureka pour le registre, Ribbon pour le loadbalancing et Zuul comme point d'accès proxy de votre application.

 

## Tutoriel
### Mise en place du projet



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour ce tutoriel nous allons utiliser différent outils :

* L'IDE [Eclipse](https://www.eclipse.org/eclipseide/)
* Maven	3.6.1 qui est directement intégré à Eclipse 
* [PostgreSQL](https://www.postgresql.org/download/) pour windows
* [postman](https://www.postman.com/downloads/) qui est un outil extrèmement utile lors de l'utilisation d'API REST



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Comme définis précédemment nous allons nous intéresser à la création d'une application de gestion de collection très simple. L'utilisateur de l'application pourra s'inscrire et se connecter, emprunter un livre (c'est-à-dire l'ajouter à sa collection), rendre un livre (ce qui revient à l'enlever de sa collection) et consulter sa collection de livres.

Voici l'architecture de l'application, nous l'étofferons plus tard dans le projet ; 


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
Vous avez créer votre projet racine ! Maintenant créons les sous projets MS et EMS. 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour MS, faites un clique droit sur le projet ARCHITP1 New > Project...


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cette fois séléctionner Maven Module

![Maven](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/maven1.png)


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cocher la case "Create a simple project" et entrer le nom MS puis cliquer sur suivant. 
Changer le Packaging en pom et mettez le nom MS. 
Cliquer sur Finish et faites de même pour le sous projet EMS.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il est enfin temps de créer nos microservices ! 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
La création de microservices peut se faire automatiquement grâce à l'outil [Spring Initializr](https://start.spring.io/), dans ce tutoriel nous ferons tout à la main pour comprendre les rouages du framework :).


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour le microservice Utilisateur appelé ms_user : 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Faites un clique droit sur le projet MS New > Project...
Séléctionner Maven Module
Cocher la case "Create a simple project" et entrer le nom ms_user puis cliquer sur suivant. 
Changer le Packaging en jar et mettez le nom ms_user. 
Cliquer sur Finish et faites de même pour le sous projet ms_collection.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Faites de même pour les edges microservices ems_eureka et ems_zuul ! 
Ribbon n'est pas présent car il est directement intégré à nos microservices. 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici ce que devrait donner le résultat final : 

![Projet](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/projet.PNG)
 
### Implémentation


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il est enfin temps de coder nos microservices ! 
Pour cela nous allons commencé par le microservices ms_collection : 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans un premier temps nous allons créer différent package toujours dans un soucis de modularité. 
Il y en aura 5 : 

* Le package **fr.tse.myapp** sera le package racine, il contiendra la classe App.java qui sera le point d'entrée de notre microservice

* Le package **fr.tse.myapp.api** sera le package qui contiendra l'ensemble de nos classe de routing

* Le package **fr.tse.myapp.domain** sera le package qui contiendra l'ensemble de nos classes d'objet tel que des POJO ou encore les classes représentant les instances a transmettre sur le réseau

* Le package **fr.tse.myapp.repository** sera le package qui contiendra l'ensemble des classes utilisés pour communiquer avec nos bases de données 

* Le package **fr.tse.myapp.service** sera le package qui contiendra l'ensemble des classes contenant le code métier



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
On peut remarquer une similitude entre nos packages et le modele MVC. 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il est important que l'ensemble des packages aient la même racine, ici **fr.tse.myapp**. Cela permet a Spring Boot de repérer l'ensemble des classes dans notre projet avec une configuration minimale de notre part.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour créer un package c'est simple : cliquer droit sur src/main/java dans le sous projet ms_collection, puis sur new > package
Entrer le nom de votre package puis finish. 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici à quoi devrait ressembler le résultat final : 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/package.PNG)

**La classe principale**


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Une fois cela fait nous pouvons créer la classe App.java dans le package racine fr.tse.myapp. 
Pour cela cliquer droit sur le package , puis sur new > class et configurer la classe comme l'image ci-dessous (ne pas oubliez de cocher **public static void main** 

![Package](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/App.PNG)


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Lorsqu'on copie colle ce code directement dans eclipse, l'IDE nous renvoie une erreure car il ne sait pas d'où viennent ces annotations et comment elles marchent, il faut donc lui dire où les chercher. Pour cela nous allons ajouter au pom.xml des dépendances sur lesquelles Spring Boot ira se baser pour configurer notre application automatiquement ! 

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

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
De façon surprenante nous n'allons pas rajouter ces dépendances dans le pom.xml de notre microservice mais dans celui du projet n-1 c'est-à-dire MS. Les projets fils héritant des dépendances de leurs parents il est plus facile de placer ces dépendances au niveau n-1 et de ne pas les copier coller pour chaque microservice.

On peut alors remarquer que l'erreur n'apparait plus ! 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Au niveau du code nous avons deux différences par rapport à un main normal : 

1. **@SpringBootApplication** est une annotation de Spring Boot  qui regroupe les annotations suivantes : 

* @EnableAutoConfiguration qui permet le méchanisme d'auto configuration de Spring Boot. Ce dernier va configurer notre appliaction Spring automatiquement selon les dépendances que nous avons ajouté à notre projet !
	
* @ComponentScan permet de scanner le package ( ou l'ensemble de sous package dans notre cas) ou l'application se trouve et ainsi localiser l'ensemble des éléments (classe, interface ...)
	
* @Configuration qui permet d'enregistrer et d'importer nos propres classes de configuration

2. **SpringApplication.run(App.class, args)** qui permet de définir le point d'entrée de notre application Spring ! 
	
```java
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
```





&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Nous pouvons maintenant lancer l'application avec clique droit sur la classe Run As > 1 Java Application. 
Ainsi avec ces quelques lignes de code nous avons une application Spring déja fonctionelle sur un serveur Tomcat. 


**Application.properties**


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ce fichier, que vous devez créer dans le dossier src/main/resources (clique droit > new > file et application.properties comme nom) permet de faire certaines configurations soi-même.
Par exemple il permet de définir le nom de notre application et le port du serveur Tomcat sur lequel il écoute. Ainsi nous allons ajouter ces lignes : 

```xml
spring.application.name=ms_collection
server.port = 8083
```

Il nous sera assez utile pour le configuration de connexion à la base de données et aux différents edge microservices.


**Repository**


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Le package repository est le package qui gère les questions de données. Avec Spring / Spring boot cela ce fait très facilement.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour les microservices il faut tenter de faire des bases de données au plus simple, ainsi pour notre microservice collection nous aurons une unique base avec une unique table et des entrées du type :


| idBDD | idLivre | idUser | Date de Retour |
--- | --- | --- | ---

Avec idBDD l'id unique de l'entrée en base

idLivre l'id unique du livre

idUser l'id unique de l'utilisateur 

Date de Retour étant la date de retour du livre


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour créer cette base de données c'est très simple à faire avec Spring / Spring Boot : il n'y a pas besoin d'écrire soit même un schéma de base ou faire la création à la main faire à la main. Il suffit de faire une classe avec les bonnes annotations et Spring Boot se chargera du reste pour nous. 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Pour pouvoir utiliser l'ensemble de ces annotations il est nécéssaire de rajouter la dépendance suivante à notre microservice : 

```xml
<!-- https://mvnrepository.com/artifact/org.eclipse.persistence/javax.persistence -->
    <dependency>
        <groupId>org.eclipse.persistence</groupId>
        <artifactId>javax.persistence</artifactId>
        <version>2.2.1</version>
    </dependency>
```



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici une courte explication des différentes annotations : 

* @Entity défini la classe comme une entité, elle sera donc trouvé par @ComponentScan

* @Table permet de donner un nom à la table, donner un schéma de construction particulier etc

* @Id définis la clef primaire de notre table 

* @GeneratedValue permet de définir une stratégie de génération pour cette attribut, ici c'est une génération de type identitaire donc unique et incrémentale

* @Column permet de définir et donner des noms au colone de notre table


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Les setteurs et getteurs sont importants, ainsi que le toString() car il permette l'échange d'instance de cette classe autonome.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ainsi avec ces simples annotations dans cette classe Spring Boot peut de lui même créer une table dans la base de données que nous lui fournirons !



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Maintenant intéréssons nous à la classe CollectionRepository du package repository qui va justement utiliser cette classe Collection : 

**CollectionRepository** 



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cette classe gère l'ensemble des intéractions avec la base de données du microservice, nous allons la créer dans le package fr.tse.myapp.repository.

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


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici les dépendances dont elle a besoin : 


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



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Celle-ci seront placée dans le pom.xml de MS car elles peuvent être utile pour l'ensemble des microservices.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans notre cas nous utilisons une base de données PostgreSQL pour le microservice collection ainsi nous rajoutons la dépendance suivante dans son pom.xml : 

```xml
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.2.10</version>
</dependency>
```



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Si vous avez l'oeil fin vous aurez remarqué que je parle de la classe CollectionRepository alors que dans le code elle est définis comme une intérface. Ainsi c'est bien une intérface mais grâce à Spring Boot et les dépendances que nous lui avons fournis nous n'avons pas à coder ses méthodes !


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
@Repository annote cette classe comme un repository et joue le même rôle que le @Entity précédemment expliqué !


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cette interface extend JpaRepository. Cette dernière est un module du framework Spring qui permet de facilement de manipuler des données. 



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ainsi la méthode save() de notre classe CollectionRepository est une méthode de ce module qui permet de sauvegarder une entrée dans la base de données par rapport au information contenue dans un objet. Par exemple pour sauvegarder l'emprunt d'un livre par un utilisateur x nous allons créer un objet Collection avec les différentes informations nécessaires et le passer en paramètre de la fonction save().  


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Il en est de même pour la méthode deleteByidBDD(), la méthode deleteBy"Attribut"() est une méthode du module JpaRepository.
Il existe bien d'autre méthode de ce type.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ces deux méthodes vont servir à "emprunter" et "rendre" un livre. 



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
La méthode getUserColletion() permet de consulter la collection d'un utilisateur selon son identifiant unique. Cette méthode n'existe pas dans les modules il faut donc l'écrire. Ici encore Spring va nous faire gagner du temps ! 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
@Query permet d'écrire des queries, soit en JPQL par défaut soit dans le langage de votre base de données ( grâce au paramètre "nativeQuery=true"). Ainsi nous écrivons une query pour récupérer l'ensemble des entrées qui correspondent à l'id fournis. Cette méthode va retourner le résultat dans le return de la signature donc une Liste d'instance de Collection. Rien de plus simple !


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Les @Param font le lien entre le nom des paramètres de la méthode et leur appélation en base.


**Base de données** 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans l'ensemble de cette partie nous avons parlé de base de données, mais comment peut on configuré nos entrées vers la base de données ? 
Cela ce fait dans le fichier application.properties de notre microservice en rajoutant ces lignes : 

```xml
## PostgreSQL
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql: l'adresse de votre base
spring.datasource.username= votre nom d'utilisateur
spring.datasource.password= votre mot de passe

#drop n create table again, good for testing, comment this in production
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=create

```


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Les trois dernières lignes sont très intéréssantes en production car elles permettent de recréer la table pour test à chaque lancement de l'application.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
De cette façon se conclue la partie Repository, nous allons donc passer à la partie Service ! 


**Service**


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Le package service est le package qui gère l'ensemble du code métier. la classe CollectionService est un lien entre l'API et le repository, c'est dans celle-ci que nous devrons faire les transformations de données, le tri, etc. Ainsi elle aura pour attribut un objet de type CollectionRepository pour pouvoir appeler les méthodes save(), deleteByIDBB(), et getUserCollection().

Voici le code de la classe : 
```java
package fr.tse.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.tse.myapp.domain.Collection;
import fr.tse.myapp.domain.UserDTO;
import fr.tse.myapp.repository.CollectionRepository;

@Service
public class CollectionService {

	@Autowired
	CollectionRepository collectionRepository;

	public void emprunterUnLivre(long idLivre, String email, String mdp) {

		RestTemplate restTemplate = new RestTemplate();

		UserDTO userReq = new UserDTO(email, mdp);
		UserDTO userRep = new UserDTO();

		userRep = restTemplate.postForObject("http://localhost:8082/Connexion", userReq, UserDTO.class);

		Collection maCol = new Collection(idLivre, userRep.getIdBDD(), "oui");
		collectionRepository.save(maCol);

	}

	public void rendreUnLivre(long idLivre) {
		

		collectionRepository.deleteByidBDD(idLivre);
		
	}

	public String getCollection(String email, String mdp) {
		List<Collection> maCollection = new ArrayList<Collection>();
		
		RestTemplate restTemplate = new RestTemplate();

		UserDTO userReq = new UserDTO(email, mdp);
		UserDTO userRep = new UserDTO();

		userRep = restTemplate.postForObject("http://localhost:8082/Connexion", userReq, UserDTO.class);

		maCollection = collectionRepository.getUserCollection(userRep.getIdBDD());
		
		return maCollection.toString();
		
	}
		
}

```


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Dans cette classe nous pouvons retrouver plusieurs points intéréssant : 

* L'annotation @Service ayant les mêmes fonctions que les annotations @Repository et @Entity précédente.
* L'annotation @Autowired qui permet de faire de l'inversion de dépendance, la classe CollectionService devant appeler une instance de la classe CollectionRepository. De cette manière le couplage entre les deux classes est réduit et une instance de CollectionRepository est passé dès que celle-ci est disponible.
* L'utilisation du RestTemplate pour récupérer des informations du microservice ms_user : On peut remarquer que l'on envoie et reçois des objets userReq et userRep de la classe UserDTO du package domain. Ces objets correspondent au body d'une requête REST envoyé au microservice et au body de sa réponse. Spring Boot permet encore une fois de lui-même de sérialiser des objets et les désérialiser de façon simple et facile. Pour ce faire les classes doivent comporter des constructeurs, setteur, getteur et toString(). Ces classes peuvent être assez général car Spring permet d'ignorer les champs vides facilement.



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Cette classe permet d'emprunter un livre, en faisant appel au microservice Utilisateur pour avoir certaines informations (tel que son id), de retourner un livre en faisant appel à la méthode deleteByIdBDD() ou de consulter la collection d'un utilisateur grâce à l'objet CollectionRepository.

**API**


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Le package API gère le routage vers le microservice. La classe CollectionApi gère les routes vers le microservice Collection et les actions à faire lors d'une requête vers une des routes. Ainsi cette classe doit avoir accès à une instance de la classe CollectionService pour pouvoir faire appel à ses méthodes.

Voici le code de la classe : 

```java
package fr.tse.myapp.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.tse.myapp.domain.ReqEmprunt;
import fr.tse.myapp.domain.UserDTO;
import fr.tse.myapp.service.CollectionService;

@RestController
public class CollectionApi {

	@Autowired
	CollectionService collectionService;
	
	@RequestMapping(path = "ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
	
	@RequestMapping(path = "Emprunter", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String emprunter(@RequestBody ReqEmprunt req) throws IOException {
		this.collectionService.emprunterUnLivre(req.getIdLivre(), req.getEmail(), req.getMdp());
		return("Livre emprunter");
	}
	
	@RequestMapping(path = "Rendre", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String rendre(@RequestBody ReqEmprunt req) throws IOException {
		this.collectionService.rendreUnLivre(req.getIdLivre());
		return("Livre rendu");
	}
	
	@RequestMapping(path = "Consulter", method = RequestMethod.POST, consumes = {"application/json"},produces = {"application/json"})
	public String consulter(@RequestBody UserDTO user) throws IOException {
		
		return this.collectionService.getCollection(user.getEmail(), user.getMdp());
	}

}
```


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Les points intéréssant de classe sont les suivants : 

* @RestController qui permet d'enregistrer cette classe en tant que Rest Controller
* @Autowired pour l'inversion de dépendance
* @RequestMapping qui permet de définir la route vers notre application :
	1. path : permet de définir le chemin 
	2. method : permet de choisir à quel verbe http correspond la méthode
	3. consumes : permet de définir quel type d'objet la méthode consomme en entré (json, xml ...) de même pour produce qui définis ce que la méthode produit en sortie


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
A cette route définie par @RequestMapping va s'appliquer la méthode définis en dessous et retourner l'objet suivant le "return".


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Par exemple le chemin http://localhost:8082/ping appelle la fonction ping qui va retourner un objet de type String = "pong". Celui ci va être sérialiser et envoyer sur le réseau.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Ainsi lorsqu'on veut consulter la collection d'un utilisateur, nous allons taper l'adresse http://localhost:8082/Consulter avec dans le body de la requète un json qui sera désérialiser en objet userDTO. Cette objet va être passé en tant que paramètre de la méthode consulter qui va appelé la méthode getCollection de l'instance CollectionService. A la fin de cette fonction la méthode va retourner une réponse de type json contenant dans son body un String correspondant à la collection de l'utilisateur.





&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Et c'est finalement ainsi que nous pouvons contruire une application compléte avec Spring / Spring Boot.
Vous pouvez faire de même avec ms_user ou importer le code fournis dans ce projet.

### Exécution 


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
L'execution est assez simple :
* Lancer la base de données de chaque microservice.
* Sur Eclipse, il suffit de lancer nos deux microservices en tant que Java application comme précédement 
* Tester avec postman.


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Voici ce que devrait être le résultat : 


![json](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/json.PNG)


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Et avec pgAdmin nous pouvons vérifier que l'utilisateur à bien été créé dans la base de données avec une query du type : 

```SQL
SELECT * FROM Utilisateurs
```
Nous avons construit une application sous forme d’architecture assez simple mais Spring / Spring boot nous de permet de l’étoffer facilement grâce a des dépendances tel que Spring Cloud !

**Eureka**


Eureka est un edge microservice qui sert de registre des microservice mais aussi des instances de chaque microservices. Il est ainsi possible de monitorer notre application lors de monter en charge par exemple.

L’installation de ce registre est assez simple, grâce à Spring Boot. La première étape est la configuration du serveur Eureka pour cela nous allons créer un nouveau sous module maven dans le projet EMS de la même façon que nous avons créé nos microservices. Nous l’appellerons ems_eureka. Il faudra ensuite créer sa classe principale appelée EurekaServerApplication.

Nous allons ensuite créer son fichier application.properties et y placer ce code :

```xml
server.port:9102

spring.application.name=eureka-server
eureka.client.serviceUrl.defaultZone:http://localhost:9102/eureka/
eureka.client.registerWithEureka:false
eureka.client.fetchRegistry:false
```
Pour définir le port du serveur, son nom. 
La troisième ligne permet de configurer l’adresse d’Eureka, c’est utile lorsque plusieurs instances de notre registre sont allumées.
Les deux dernières sont à false car nous n’utilisons pas Eureka en mode cluster.

Voici le code de la classe principale de notre application :
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main(String[] args) {
      SpringApplication.run(EurekaServerApplication.class, args);
  }
}
```
et voici les dépendances à ajouter :

```xml
<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-server -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>


		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.3.0.1</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.1</version>
		</dependency>



	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-starter-parent</artifactId>
				<version>Greenwich.RELEASE</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

Et nous avons tout simplement créer notre registre que vous pouvez lancer comme une application java et le retrouver à l'adresse http://localhost:9102

Maintenant pour chacun de nos microservices à monitorer il faudra faire les modifications suivantes : 

* Ajouter la dépendance suivante : 

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
			<version>2.2.1.RELEASE</version>
		</dependency>

<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.6</version>
		</dependency>

```

* Ajouter cette ligne de configuration dans le fichier application.properties :

```xml
#Eureka
eureka.client.serviceUrl.defaultZone: http://localhost:9102/eureka/
```

* Ajouter l'annotation @EnableDiscoveryClient dans la classe principale 



Ainsi en lançant Eureka puis vos microservices vous les verrez apparaitres sur la page d'Eureka : 

![eureka](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/eureka.PNG)


**Ribbon** 

Ribbon est un load balancer coté client, comme son nom l'indique il permet de répartir la charge entre les différentes instances des différents microservices.
Pour notre application, postman faisant office de client il n'est pas possible de l'implémenter, mais vous pouvez toujours essayer d'implémenter un FeignClient pour utiliser Ribbon :).

Pour l'ajouter c'est assez simple : 

* Au client il faut ajouter la dépendance suivante : 

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-ribbon -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
			<version>2.2.1.RELEASE</version>
		</dependency>
```

* Il faut aussi ajouter l'annotation @RibbonClient(name = "nom du microservice") dans la classe principale


Et c'est tout ! 

Il est possible de donner à Ribbon les adresses des différentes instances des microservices mais grâce à Eureka, c'est fait automatiquement !


**Zuul** 

Pour finir nous allons mettre en place Zuul, Zuul est un edge microservice qui va permettre d'avoir un point d'entrée unique à notre application. Il offre de nombreux avantages tel que la possibilité de filtrer les requétes, les rediriger, les modifier etc ...

De même que pour Eureka il faut créer un nouveau sous projet au projet EMS et créer sa classe principale ZuulServerApplication.

Voici le code de sa classe principale : 

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServerApplication {

  public static void main(String[] args) {
      SpringApplication.run(ZuulServerApplication.class, args);
  }
}
```
 et voici les dépendances à ajouter au pom.xml de ems_zuul :
 
```xml
<dependencies>
		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-server -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-zuul -->
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>

		</dependency>



		<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.3.0.1</version>
		</dependency>
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.1</version>
		</dependency>



	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-starter-parent</artifactId>
				<version>Greenwich.RELEASE</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>
```

Nous allons ensuites modifier le fichier application.properties de Zuul avec ces lignes :
```xml
spring.application.name=zuul-server
server.port 9004

#Eureka
eureka.client.serviceUrl.defaultZone: http://localhost:9102/eureka/
```

Ainsi Zuul sera reconnu et enregistrer par Eureka.

Et c'est tout pour la mise en place de Zuul !

Maintenant pour se connecter à un microservice depuis un client extérieur il faudra passer par Zuul. Par exemple on ne tapera plus http://localhost:8082/Consulter mais http://localhost:9004/ms_collection/Consulter et c'est Zuul qui redirigera la requète au service concerné.

Comme vous avez pu le constater l'architecture finale est un peu différente de celle présenté au début et ressemble plutôt à cela maintenant : 



![ems](https://github.com/PatrickMSSD/ARCHITP1/blob/master/RMRessources/ems.png)




Maintenant pour l'exécution il faudra lancer, Eureka, Zuul puis nos microservice. Pour de plus grosses applications, cela peut paraître lourd ainsi les containers comme Dockers et les solutions d'orchestrations tel que Kubernetes sont toujours les bienvenues pour nous faciliter la vie.


**Conclusion**

Spring est un framework complet et puissant pour créer des applications autonomes et prêtes à déployer. Spring Boot n'est qu'une petite partie du framework mais facilite grandement la vie pour la construction de nos applications. Ces deux technologies sont extrêmement intéressantes pour la construction d'application en architecture microservice, car elles permettent le déploiement d'application autonome, modulable facilement et les modules fournis sont nombreux pour étoffer nos applications.

