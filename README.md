TP1 - Tutoriel de technologies emergentes
======


# Spring - Spring Boot




## Plan 

1. Présentation de la technologie

2. Objectifs du tutoriel - contexte, description et résultats/connaisses  attendus après  l’exécution

3. Tutoriel

## Présentation de la technologie 
### Spring 

  Spring est un framework open source créée en 2003 par Rod Johnson en tant qu'alternative à J2EE.

  ... ENCORE DU BLA BLA ...
  
  ... Petite historique...
  
  ... Point faible de J2EE... 
  
  ... Point fort de Spring ...
  
#### Inversion of Control et Dependency Inversion 
  
##### Inversion of Control (IoC)
  
  L'inversion de contrôle ou Inversion of Control (IoC) en anglais est un patron d'architecture commun à de nombreux framework dont Spring/Spring Boot. 
De façon grossière l'inversion de contrôle inverse le flow de du déroulement de l'application : ce n'est plus l'application qui déroule le code mais le code qui réagit à des événements lancés par le framework.

... Exemple ... 

##### Dependency Inversion (DI)
  
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




  
### Spring Boot
  
  Spring boot est initialement un modul du framework Spring mais peut être considéré comme un framework à part entière. 
Il permet de créer facilement des applications autonomes basées sur Spring grâce à ces fonctionnalités :
  
  * Création d'application autonome
  * Intégration de serveur Tomcat, jetty ou Undertow de façon native
  * Intégration de dépendance dite "starter" pour simplifier les configurations
  * Automatisation des configurations pour Spring et certaines librairies quand c'est possible
  * Management des dépendances pour éviter les problèmes de versionnages 

Spring Boot est donc un outil extrèmement intéressant pour créé des applications "production-ready" en peu de temps et facilement.

  
 
## Objectif du tutoriel

... Application micro service... 
... Rapide def de micro service ...
... Pourquoi spring est utile ici...
  
