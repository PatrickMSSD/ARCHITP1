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
  Spring est un framework open source créée en 2003 par Rod Johnson en tant qu'alternative à J2EE.

  ... ENCORE DU BLA BLA ...
  
  ... Petite historique...
  
  ... Point faible de J2EE... 
  
  ... Point fort de Spring ...
  
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
  Spring boot est initialement un modul du framework Spring mais peut être considéré comme un framework à part entière. 
Il permet de créer facilement des applications autonomes basées sur Spring grâce à ces fonctionnalités :
  
  * Création d'application autonome
  * Intégration de serveur Tomcat, jetty ou Undertow de façon native
  * Intégration de dépendance dite "starter" pour simplifier les configurations
  * Automatisation des configurations pour Spring et certaines librairies quand c'est possible
  * Management des dépendances pour éviter les problèmes de versionnages 
  
Spring Boot est donc un outil extrèmement intéressant pour créé des applications "production-ready" en peu de temps et facilement.

  


## Objectif du tutoriel

  Dans ce tutoriel nous allons créé une application utilisant une architecture micro service à l'aide de Spring/Spring Boot. 
  
  Ces technologies sont très intéréssantes pour ce genre de projet pour plusieurs raisons : 
  * Création rapide et facile de micro service près a l'emplois et deployable rapidement
  * Grande flexibilité
  * Configuration et monitoring simple des services ( edge ou micro ) grâce au grand nombre de module présent
  
A la fin de ce tutoriel il vous sera possible de créer une application de gestion de collection simple avec une architecture micro service et API REST. Vous apprendrez aussi comment configurer les edges micro services suivant : Eureka pour le registre, Ribbon pour le load balancing et Zuul comme point d'accée proxy de votre applicaiton.

 

## Tutoriel
### Mise en place du projet

Pour ce tutoriel nous allons utiliser différent outils :

* L'IDE [Eclipse] (https://www.eclipse.org/eclipseide/)
* Maven	3.6.1 qui est directement intégré à Eclipse 
* [PostgreSQL] (https://www.postgresql.org/download/) pour windows
* [postman] (https://www.postman.com/downloads/) qui est un outil extrèmement utile lors de l'utilisation d'API REST



2. Implémentation
3. Exécution
