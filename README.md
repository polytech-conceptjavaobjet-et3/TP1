Programmation Java @ Et3
<br>
Polytech Paris-Saclay | 2019-20

___

# TP1

Vous allez développer une gestion simple d’autotamponneuses. Celles-ci sont caractérisées par :
- le fait qu’elles soient placées ou non sur une piste d’autotamponneuses, leur position étant alors représentée par une paire de valeurs réelles (coordonnées dans un plan à deux dimensions)
- le fait qu’elles soient occupées ou non, et si oui par quelle personne (il faut qu’elles soient placées pour pouvoir être occupées)
- le fait qu’elle soient allumées ou non (il faut qu’elles soient occupées pour pouvoir être allumées)
- le fait qu’elle soient clignotantes ou non (il faut qu’elles soient allumées pour pouvoir être cignotantes)

1#1. Créez une nouvelle classe Autotamponneuse dans un package com.feteforraine. Ajoutez les données nécessaires à la classe en choisissant les niveaux de visibilité appropriés.

- 1#1.1 classe Autotamponneuse :

> La classe est `public`, ce qui veut dire qu'elle est accessible depuis n'importe quel endroit du projet.
> Les données ne sont visible que depuis la classe, elle sont donc `private`.
> Ici, on travaille avec des [types primitifs](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html) (boolean, double) et une classe des API standard ([String](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html)).
>
> ```Java
> package com.feteforraine;
> 
> public class Autotamponneuse 
> {
> 	private boolean placee = false;
> 	private double[] position = new double[2];
>   
> 	private boolean occupee = false;
> 	private String nomOccupant = "";
> 	
> 	private boolean allumee = false;
> 	
> 	private boolean clignotante = false;
> }
> ```

1#2. Ajoutez deux constructeurs à la classe : l’un sans paramètres, l’autre avec une coordonnée x et une coordonnée y. Faites en sorte de réutiliser ce qui peut l’être dans vos constructeurs.

- 1#2.1 constructeur sans paramètres : 

> ```Java
> public Autotamponneuse()
> {
> 		this.occupee = false;
> 		this.allumee = false;
> 		this.clignotante = false;
> 		this.placee = false;
> 		this.position[0] = 0.0d;
> 		this.position[1] = 0.0d;
> 		this.nomOccupant = "";
> }
> ```
> 
> Le `this` renvoie à l'instance de la classe, donc `this.occupee` renvoie, par exemple, à l'attribut `occupee` de l'autotamponneuse. On peut utiliser le `this` systématiquement mais il est surtout important de l'utiliser lorsqu'un des paramètres d'une méthode a le même nom qu'un attribut de la classe, cela permet de les différencier malgré un nom identique.

- 1#2.2 constructeur avec 2 paramètres :

> ```Java
> public Autotamponneuse(double positionX, double positionY)
> {
> 	this();
> 	this.placee = true;
> 	this.position[0] = positionX;
> 	this.position[1] = positionY;
> }
> ```
> 
> Ici, `this()` renvoie au constructeur sans paramètre

- 1#2.3 Pour quelles raisons aurait-on intérêt à réutiliser (invoquer) d'autres constructeurs lorsqu'on définit des constructeurs ?

> Cela peut être utile si:
> - on veut donner des valeurs par défaut à notre Autotamponeuse (exemple : si l'autotamponeuse est occupée, elle est automatiquement clignotante)
> - on veut définir manuellement d'autres paramètre (exemple : l'utilisateur peut choisir si l'autotamponeuse est clignotante ou non à sa création)

1#3. Ajoutez des méthodes d’instance dans la classe Autotamponneuse pour consulter l’état d’une
autotamponneuse particulière : estOccupee, getNomOccupant, estAllumee, estClignotante.

- 1#3.1 méthodes demandées

> ```Java
> /**
>  * Cette méthode permet de savoir si l'autotamponneuse est occupée ou non.
>  * @return VRAI si l'autotamponneuse est occupée et FAUX sinon
>  */
> public boolean estOccupee()
> {
> 	return this.occupee;
> }
> 
> /**
>  * Cette méthode permet d'obtenir le nom de l'occupant de l'autotamponeuse.
>  * @return Le nom de l'occupant de l'autotamponneuse
>  */
> public String getNomOccupant()
> {
> 	return this.nomOccupant;
> }
> 
> /**
>  * Cette méthode permet de savoir si l'autotamponneuse est allumée ou non.
>  * @return VRAI si l'autotamponneuse est allumée et FAUX sinon
>  */
> public boolean estAllumee()
> {
> 	return this.allumee;
> }
> 
> /**
>  * Cette méthode permet de savoir si l'autotamponneuse est clignotante ou non.
>  * @return VRAI si l'autotamponneuse est clignotante et FAUX sinon
>  */
> public boolean estClignotante()
> {
> 	return this.clignotante;
> }
> ```

- 1#3.2 Pourquoi parle-t-on de "méthodes d'instances" ?

> Une méthode d'instance est appelée sur une instance de la classe. Ce n'est donc pas une méthode `static`.

- 1#3.3 Pourquoi ces méthodes ne contournent-elles pas le principe d'encapsulation des données ?

> Elles ne contournent pas le principe d'encapsulation des données car elles retournent une copie de la donnée et non la donnée elle-même. Cela signifie qu'elles ne donnent pas l'accès à la donnée mais seulement sa valeur.

1#4. Ajoutez une méthode main dans la classe Autotamponneuse afin de pouvoir définir un programme principal de test. Testez-y sur des exemples le code précedemment défini, et utilisez-la pour tester le code des questions suivantes.

- 1#4.1 méthode  main

> ```Java
> public static void main(String[] args)
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
> 	
> 	// 1#4.1
> 	System.out.println();
> 	System.out.println("Question 1#4.1");
> 	System.out.println();
> 	System.out.println("L'autotamponeuse#1 est-elle occupée ? " + auto1.estOccupee());
> 	System.out.println("L'autotamponeuse#1 est-elle allumée ? " + auto1.estAllumee());
> 	System.out.println("L'autotamponeuse#1 est-elle clignotante ? " + auto1.estClignotante());		
> }
> ```

- 1#4.2 affichage produit par l'exécution de votre méthode  main

> ```
> 
> Question 1#4.1
> 
> L'autotamponeuse#1 est-elle occupée ? false
> L'autotamponeuse#1 est-elle allumée ? false
> L'autotamponeuse#1 est-elle clignotante ? false
> ```

- 1#4.3 méthode main dans une nouvelle classe TestAutotamponneuse dans le package com.feteforraine

> ```Java
> package com.feteforraine;
> 
> public class TestAutotamponneuse 
> {
> 	public static void main(String[] args) 
> 	{
> 		Autotamponneuse auto1 = new Autotamponneuse();
> 		Autotamponneuse auto2 = new Autotamponneuse();
> 		
> 		// 1#4.3
> 		System.out.println();
> 		System.out.println("Question 1#4.3");
> 		System.out.println();
> 		System.out.println("L'autotamponeuse#1 est-elle occupée ? " + auto1.estOccupee());
> 		System.out.println("L'autotamponeuse#1 est-elle allumée ? " + auto1.estAllumee());
> 		System.out.println("L'autotamponeuse#1 est-elle clignotante ? " + auto1.estClignotante());		
> 	}
> }
> ```

- 1#4.4 Comment faire en sorte d'exécuter la méthode main de la classe com.feteforraine. TestAutotamponneuse ?

> Il faut transmettre la classe `TestAutotamponneuse` à la machine virtuelle Java plutôt que `Autotamponneuse`.
> 
> ```
> java TestAutotamponneuse
> ```

- 1#4.5 Pourquoi la méthode main est-elle static ? A quoi correspond son paramètre ?

> `main` est le nom de la méthode recherchée par la machine virtuelle Java. Cette méthode est `static` car elle ne doit pas avoir besoin d'un objet instancié pour être appelée. On peut tout à fait définir une méthode `main` dans d'autres classes. Son paramêtre correspond aux paramètres transmis lors de l'appel du programme qui se fait comme suit :
> 
> ```
> java MaClasse paramètre1 paramètre2 ... paramètreN
> ```

- 1#4.6 Quelles critiques pourriez-vous faire à l'approche consistant à tester le fonctionnement d'une classe au travers d'un programme de test exécuté par sa méthode main ? Quelles autres approches pourrait-on imaginer pour faire cela ?

> Lorsqu'on effectue des tests au sein même de la méthode `main` d'une classe, il peut être fastidieux de trouver la source des erreurs rencontrées. Une alternative consisterait à utiliser des tests unitaires qui permettent notemment de cibler une partie du code pour savoir si celle-ci fonctionne ou pas. Le debogage du programme sera donc plus efficace.

1#5. Ajoutez le code nécessaire pour qu’une autotamponneuse ait désormais un identifiant entier unique. Cette valeur ne devra pas être choisie par l’utilisateur, et devra commencer à la valeur 1 pour la première autotamponneuse.

- 1#5.1 code ajouté

> ```Java
> private static int DERNIER_ID_ATTRIBUE = 0;
> private int id = ++DERNIER_ID_ATTRIBUE; 
> ```
> `++DERNIER_ID_ATTRIBUE` va incrémenter la valeur de `DERNIER_ID_ATTRIBUE` de 1.

- 1#5.2 test du fonctionnement dans la méthode main

> ```Java
> public static void main(String[] args)
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
>    
> 	// #1.5.2
> 	System.out.println();
> 	System.out.println("Question 1#5.2");
> 	System.out.println();
> 	System.out.println("ID de auto1 : " + auto1.id);
> 	System.out.println("ID de auto2 : " + auto2.id);
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#5.2
> 
> ID de auto1 : 1
> ID de auto2 : 2
> ```

1#6. Redéfinissez dans la classe Autotamponneuse la méthode particulière suivante de la classe java.lang.Object : String toString() qui retourne une représentation sous forme de chaı̂ne de caractères de l’état d’un objet. Des exemples de chaı̂nes pourraient être :

[1] (5.0,5.0) libre éteinte non clignotante
[2] (7.0,2.0) occupée (Charles Darwin) éteinte non clignotante
[2] (5.1,5.0) occupée (Charles Darwin) allumée clignotante

- 1#6.1 redéfinition de la méthode toString

> Pour explicitement redéfinir une méthode, on utilise la balise `@Override`.
> 
> ```Java
> @Override
> public String toString()
> {
> 	String etatAutotamponeuse = "";
> 	
> 	//On ajoute l'ID de l'autotamponeuse
> 	etatAutotamponeuse += "[" + this.id + "]";
> 	
> 	//On ajoute un espace
> 	etatAutotamponeuse += " ";
> 			
> 	//On ajoute la position de l'autotamponeuse
> 	etatAutotamponeuse += "(" + this.position[0] + ";" + this.position[1] + ")";
> 	
> 	//On ajoute un espace
> 	etatAutotamponeuse += " ";
> 	
> 	//L'autotamponeuse est-elle occupée ?
> 	if(this.occupee)
> 	{
> 		etatAutotamponeuse += "occupée (" + this.nomOccupant + ")";
> 	}
> 	else
> 	{
> 		etatAutotamponeuse += "libre";
> 	}
> 	
> 	//On ajoute un séparateur
> 	etatAutotamponeuse += " / ";
> 	
> 	//L'autotamponeuse est-elle allumée ?
> 	if(this.allumee)
> 	{
> 		etatAutotamponeuse += "allumée";
> 	}
> 	else
> 	{
> 		etatAutotamponeuse += "eteinte";
> 	}
> 	
> 	//On ajoute un séparateur
> 	etatAutotamponeuse += " / ";
> 	
> 	//L'autotamponeuse est-elle clignotante ?
> 	if(this.clignotante)
> 	{
> 		etatAutotamponeuse += "clignotante";
> 	}
> 	else
> 	{
> 		etatAutotamponeuse += "non clignotante";
> 	}
> 			
> 	return etatAutotamponeuse;	
> }
> ```

- 1#6.2 test du fonctionnement dans la méthode main

> ```Java
> public static void main(String[] args)
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
> 	
> 	// 1#6.2
> 	System.out.println();
> 	System.out.println("Question 1#6.2");
> 	System.out.println();
> 	System.out.println("Etat de auto1 : " + auto1.toString());
> 	System.out.println("Etat de auto2 : " + auto2.toString());
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#6.2
> 
> Etat de auto1 : [1] (0.0;0.0) libre / eteinte / non clignotante
> Etat de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> ```

1#7. Ajoutez à présent des méthodes d’instance dans la classe Autotamponneuse pour modifier l’état d’une autotamponneuse particulière, en respectant les règles énoncées ci-dessus : place, ajouteOccupant, enleveOccupant, allume, eteint, demarreClignotement, arreteClignotement. Afin d’informer le programme appelant sur la modification effective ou non de l’objet correspondant, faites retourner à vos méthodes une valeur booléenne. On décide que ces méthodes ne pourront être accessibles qu’aux autres classes du même package (com.feteforraine).

- 1#7.1 définition des méthodes

> ```Java
> /**
>  * Cette méthode permet de placer l'autotamponneuse sur le circuit.
>  * @param positionX La position de l'autotamponneuse sur l'abscisse du circuit
>  * @param positionY La position de l'autotamponneuse sur l'ordonnée du circuit
>  * @return VRAI si l'autotamponneuse a pu être placée et FAUX sinon
>  */
> protected boolean place(double positionX, double positionY)
> {
> 	//On change les coordonnées de l'autotamponneuse
> 	this.position[0] = positionX;
> 	this.position[1] = positionY;
> 	
> 	//L'autotamponneuse est désormais placée
> 	this.placee = true;
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet de définir qui occupe l'autotamponneuse.
>  * @param nomOccupant Le nom de l'occupant de l'autotamponneuse
>  * @return VRAI si l'occupant a pu rentrer dans l'autotamponneuse et FAUX sinon
>  */
> protected boolean ajouteOccupant(String nomOccupant)
> {
> 	//Si l'autotamponneuse n'est pas déja placée ou si elle est déjà occupée
> 	if(!this.placee || this.occupee)
> 	{
> 		//On ne peut pas rajouter de participant
> 		return false;
> 	}
> 	
> 	//On change le nom de l'occupant
> 	this.nomOccupant = nomOccupant;
> 	
> 	//L'autotamponneuse est désormais occupée
> 	this.occupee = true;
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet de retirer l'occupant de l'autotamponeuse.
>  * @return VRAI si un occupant a pu être retiré de l'autotamponneuse et FAUX sinon
>  */
> protected boolean enleveOccupant()
> {
> 	//Si l'autotamponneuse n'est pas déjà occupée
> 	if(!this.occupee)
> 	{
> 		//On ne peut pas enlever de participant
> 		return false;
> 	}
> 	
> 	//On enlève le nom de l'occupant
> 	this.nomOccupant = "";
> 	
> 	//L'autotamponneuse est désormais vide
> 	this.occupee = false;
> 	
> 	//Si l'autotamponneuse est allumée, on doit l'éteindre
> 	if(this.allumee)
> 	{
> 		//On éteint l'autotamponneuse
> 		this.eteint();
> 	}
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet d'allumer l'autotamponneuse.
>  * @return VRAI si l'autotamponneuse a pu être allumée et FAUX sinon
>  */
> protected boolean allume()
> {
> 	//Si l'autotamponneuse est déjà allumée ou si l'autotamponneuse n'est pas déjà occupée
> 	if(this.allumee || !this.occupee)
> 	{
> 		//On ne peut pas allumer l'autotamponneuse
> 		return false;
> 	}
> 	
> 	//L'autotamponneuse est désormais allumée
> 	this.allumee = true;
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet d'éteindre l'autotamponneuse.
>  * @return VRAI si l'autotamponneuse a pu être éteinte et FAUX sinon
>  */
> protected boolean eteint()
> {
> 	//Si l'autotamponneuse n'est pas déjà allumée
> 	if(!this.allumee)
> 	{
> 		//On ne peut pas éteindre l'autotamponneuse
> 		return false;
> 	}
> 	
> 	//L'autotamponneuse est désormais éteinte
> 	this.allumee = false;
> 	
> 	//Si l'autotamponneuse est clignotante
> 	if(this.clignotante)
> 	{
> 		//On arrête son clignotement
> 		this.arreteClignotement();
> 	}
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet de démarrer le clignotement de l'autotamponneuse.
>  * @return VRAI si le clignotement a pu être allumé et FAUX sinon
>  */
> protected boolean demarreClignotement()
> {
> 	//Si l'autotamponneuse est déjà clignotante ou si elle n'est pas déjà allumée
> 	if(this.clignotante || !this.allumee)
> 	{
> 		//On ne peut pas démarrer le clignotement
> 		return false;
> 	}
> 	
> 	//L'autotamponneuse est désormais clignotante
> 	this.clignotante = true;
> 	
> 	return true;
> }
> 
> /**
>  * Cette méthode permet d'arrêter le clignotement de l'autotamponneuse.
>  * @return VRAI si le clignotement a pu être arrêté et FAUX sinon
>  */
> protected boolean arreteClignotement()
> {
> 	//Si l'autotamponneuse n'est pas déjà clignotante
> 	if(!this.clignotante)
> 	{
> 		//On ne peut pas éteindre le clignotement
> 		return false;
> 	}
> 	
> 	//Le clignotement de l'autotamponneuse est désormais éteint
> 	this.clignotante = false;
> 	
> 	return true;
> }
> ```

- 1#7.2 test du fonctionnement dans la méthode main et trace d'exécution

> ```Java
> public static void main(String[] args)
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
> 	
> 	// 1#7.2
> 	System.out.println();
> 	System.out.println("Question#1.7.2");
> 	System.out.println();
> 	System.out.println("Je place l'auto1 en position (1.0,2.0) : " + auto1.place(1.0,2.0));
> 	System.out.println("Nouvel état de l'auto1 : " + auto1.toString());
> 	System.out.println("Nouvel état de l'auto2 : " + auto2.toString());
> 	System.out.println("J'allume l'auto1 : " + auto1.allume());
> 	System.out.println("J'allume l'auto2 : " + auto2.allume());
> 	System.out.println("état de auto1 : " + auto1.toString());
> 	System.out.println("état de auto2 : " + auto2.toString());
> 	System.out.println("Bob Marley entre dans l'auto1 : " + auto1.ajouteOccupant("Bob Marley"));
> 	System.out.println("John Lennon entre dans l'auto2 : " + auto2.ajouteOccupant("John Lennon"));
> 	System.out.println("état de auto1 : " + auto1.toString());
> 	System.out.println("état de auto2 : " + auto2.toString());
> 	System.out.println("Je démarre le clignotement de l'auto1 : " + auto1.demarreClignotement());
> 	System.out.println("Je démarre le clignotement de l'auto2 : " + auto2.demarreClignotement());
> 	System.out.println("état de auto1 : " + auto1.toString());
> 	System.out.println("état de auto2 : " + auto2.toString());
> 	System.out.println("J'allume l'auto1 : " + auto1.allume());
> 	System.out.println("J'allume l'auto2 : " + auto2.allume());
> 	System.out.println("état de auto1 : " + auto1.toString());
> 	System.out.println("état de auto2 : " + auto2.toString());
> 	System.out.println("Je démarre le clignotement de l'auto1 : " + auto1.demarreClignotement());
> 	System.out.println("Je démarre le clignotement de l'auto2 : " + auto2.demarreClignotement());
> 	System.out.println("état de auto1 : " + auto1.toString());
> 	System.out.println("état de auto2 : " + auto2.toString());
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#7.2
> 
> Je place l'auto1 en position (1.0,2.0) : true
> Nouvel état de l'auto1 : [1] (1.0;2.0) libre / eteinte / non clignotante
> Nouvel état de l'auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> J'allume l'auto1 : false
> J'allume l'auto2 : false
> état de auto1 : [1] (1.0;2.0) libre / eteinte / non clignotante
> état de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> Bob Marley entre dans l'auto1 : true
> John Lennon entre dans l'auto2 : false
> état de auto1 : [1] (1.0;2.0) occupée (Bob Marley) / eteinte / non clignotante
> état de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> Je démarre le clignotement de l'auto1 : false
> Je démarre le clignotement de l'auto2 : false
> état de auto1 : [1] (1.0;2.0) occupée (Bob Marley) / eteinte / non clignotante
> état de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> J'allume l'auto1 : true
> J'allume l'auto2 : false
> état de auto1 : [1] (1.0;2.0) occupée (Bob Marley) / allumée / non clignotante
> état de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> Je démarre le clignotement de l'auto1 : true
> Je démarre le clignotement de l'auto2 : false
> état de auto1 : [1] (1.0;2.0) occupée (Bob Marley) / allumée / clignotante
> état de auto2 : [2] (0.0;0.0) libre / eteinte / non clignotante
> ```

- 1#7.3 En créant une classe Test dans le package par défaut, invoquez la méthode ajouteOccupant. Que se passe-t-il, pourquoi ?

> On obtient l'erreur suivante :
> Exception in thread "main" java.lang.Error: Unresolved compilation problem:
> The method ajouteOccupant(String) from the type Autotamponneuse is not visible at tp1/test.Test.main(Test.java:10)
> 
> La visibilité de la méthode ajouteOccupant étant `protected`, on ne peut y accéder que depuis le même package ou les classes filles.

1#8. On souhaite détecter des collisions entre autotamponneuses. Pour simplifier, on dira que deux autotamponneuses sont en collision si la distance entre leurs positions (comprise ici comme un point dans le plan) est inférieure à une valeur constante définie au niveau de la classe, DISTANCE_MINIMALE. Ajoutez cette valeur de manière appropriée, puis ajoutez une méthode d’instance pour le calcul de distance entre deux autotamponneuses :

double calculeDistance(Autotamponneuse autreAuto)

ainsi qu’une méthode d’instance indiquant si une collision a lieu entre deux autotamponneuses :

boolean collision(Autotamponneuse autreAuto)

- 1#8.1 déclaration du champ  DISTANCE MINIMALE

> ```Java
> public static final double DISTANCE_MINIMALE = 2.0d;
> ```

- 1#8.2 méthode  calculeDistance

> ```Java
> /**
>  * Cette méthode permet de calculer la distance entre l'autotamponneuse et une autre.
>  * @param autreAuto L'autre autotamponneuse
>  * @return La distance entre les deux autotamponneuses
>  */
> public double calculeDistance(Autotamponneuse autreAuto)
> {
> 	double distance = Math.sqrt((this.position[0] - autreAuto.position[0])
> 			* (this.position[0] - autreAuto.position[0])
> 			+ (this.position[1] - autreAuto.position[1])
> 			* (this.position[1] - autreAuto.position[1]));
> 	return distance;
> }
> ```

- 1#8.3 méthode  collision

> ```Java
> /**
>  * Cette méthode permet de vérifier si l'autotamponneuse est en collision avec une autre.
>  * @param autreAuto L'autre autotamponneuse
>  * @return VRAI s'il y a une collision entre les autotamponneuses et FAUX sinon
>  */
> public boolean collision(Autotamponneuse autreAuto)
> {
> 	/* Si la distance entre les autotamponneuses est inférieure à la distance minimale
> 	if(this.calculeDistance(autreAuto) < DISTANCE_MINIMALE)
> 	{
> 		return true;
> 	}
> 	return false;
> }
> ```

- 1#8.4 exemples de tests de collisions dans la classe TestAutotamponneuse

```Java
> public static void main(String[] args) 
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
> 	
> 	// 1#8.4
> 	System.out.println();
> 	System.out.println("Question 1#8.4");
> 	System.out.println();
> 	System.out.println("Je place l'autotamponneuse#1 à la position (2.4,5.6)");
> 	auto1.place(2.4f, 5.6f);
> 	System.out.println("Je place l'autotamponneuse#2 à la position (2.3,4.1)");
> 	auto2.place(2.3f, 4.1f);
> 	System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + auto1.collision(auto2));
> 	System.out.println("Je place l'autotamponneuse#2 à la position (10.3,4.1)");
> 	auto2.place(10.3f, 4.1f);
> 	System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + auto1.collision(auto2));
> 	
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#8.4
> 
> Je place l'autotamponneuse#1 à la position (2.4,5.6)
> Je place l'autotamponneuse#2 à la position (2.3,4.1)
> Les autotamponneuses 1 et 2 sont-elles en collision ? true
> Je place l'autotamponneuse#2 à la position (10.3,4.1)
> Les autotamponneuses 1 et 2 sont-elles en collision ? false
> ```

1#9. Afin d’autoriser d’autres types d'utilisation, proposez des équivalents sous forme de méthodes de classes pour les deux méthodes d’instance précédentes :

static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)

et :

static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)

Bien prendre en compte le fait que les paramètres peuvent tous les deux avoir une valeur null à l’exécution.


- 1#9.1 méthode  de classes calculeDistance

> Dans une méthode de classe, on ne peut pas faire appel à `this`. Il faut donc nécessairement passer deux autotamponeuses en paramètre.
> 
> ```Java
> /**
>  * Cette méthode permet de calculer la distance entre deux autotamponneuses.
>  * @param auto1 La première autotamponneuse
>  * @param auto2 La seconde autotamponneuse
>  * @return La distance entre les deux autotamponneuses
>  */
> public static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)
> {
> 	double distance = Math.sqrt((auto1.position[0] - auto2.position[0])
> 			* (auto1.position[0] - auto2.position[0])
> 			+ (auto1.position[1] - auto2.position[1])
> 			* (auto1.position[1] - auto2.position[1]));
> 	return distance;
> }
> ```

- 1#9.2 méthode de classes collision

> ```Java
> /**
>  * Cette méthode permet de vérifier si deux autotamponneuses sont en collision.
>  * @param auto1 La première autotamponneuse
>  * @param auto2 La seconde autotamponneuse
>  * @return VRAI s'il y a une collision entre les autotamponneuses et FAUX sinon
>  */
> public static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)
> {
> 	/* Si la distance entre les autotamponneuses est inférieure à la distance minimale */
> 	if(Autotamponneuse.calculeDistance(auto1, auto2) < DISTANCE_MINIMALE)
> 	{
> 		return true;
> 	}
> 	return false;
> }
> ```

- 1#9.3 exemples de tests de collisions dans la classe TestAutotamponneuse

> ```Java
> public static void main(String[] args) 
> {
> 	Autotamponneuse auto1 = new Autotamponneuse();
> 	Autotamponneuse auto2 = new Autotamponneuse();
> 	
> 	// 1#9.3
> 	System.out.println();
> 	System.out.println("Question 1#9.3");
> 	System.out.println();
> 	System.out.println("Je place l'autotamponneuse#1 à la position (2.4,5.6)");
> 	auto1.place(2.4f, 5.6f);
> 	System.out.println("Je place l'autotamponneuse#2 à la position (2.3,4.1)");
> 	auto2.place(2.3f, 4.1f);
> 	System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + Autotamponneuse.collision(auto1,auto2));
> 	System.out.println("Je place l'autotamponneuse#2 à la position (10.3,4.1)");
> 	auto2.place(10.3f, 4.1f);
> 	System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + Autotamponneuse.collision(auto1,auto2));
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#9.3
> 
> Je place l'autotamponneuse#1 à la position (2.4,5.6)
> Je place l'autotamponneuse#2 à la position (2.3,4.1)
> Les autotamponneuses 1 et 2 sont-elles en collision ? true
> Je place l'autotamponneuse#2 à la position (10.3,4.1)
> Les autotamponneuses 1 et 2 sont-elles en collision ? false
> ```

- 1#9.4 La définition des méthodes de classes pourrait-elle réutiliser celle de la méthode d'instances correspondante ? Si oui, pourquoi ?

> Non car elles ne sont pas `static` et font donc potentiellement appel à des données de l'instance de la classe.

1#10. Redéfinissez dans la classe Autotamponneuse la méthode de la classe java.lang.Object :

boolean equals(Object autreObjet)

qui indique si deux objets sont égaux (même état complet ici). Attention, la méthode étant déclarée au niveau de la classe java.lang.Object, il faudra vérifier puis transtyper le type du paramètre de la méthode.

- 1#10.1 redéfinition de la méthode  equals

> ```Java
> @Override
> public boolean equals(Object autreObjet)
> {
> 	//Si l'objet de comparaison n'est pas instancié
> 	if(autreObjet == null)
> 	{
> 		//On peut affirmer que les deux objets ne sont pas égaux
> 		return false;
> 	}
> 	
> 	//Si l'autotamponneuse et l'objet de comparaison sont deux références pour le même objet
> 	if(this == autreObjet)
> 	{
> 		//On peut affirmer que les deux objets sont égaux
> 		return true;
> 	}
> 	
> 	//Si l'autotamponneuse et l'objet de comparaison n'ont pas la même classe
> 	if(this.getClass() != autreObjet.getClass())
> 	{
> 		//On peut affirmer que les deux objets ne sont pas égaux
> 		return false;
> 	}
> 	
> 	//On caste l'objet en autotamponneuse pour pouvoir comparer ses valeurs avec celles de l'autotamponneuse
> 	Autotamponneuse autreAuto = (Autotamponneuse) autreObjet;
> 	
> 	//Si les deux autotamponneuses n'ont pas le même placement
> 	if(this.position[0] != autreAuto.position[0]
> 			|| this.position[1] != autreAuto.position[1])
> 	{
> 		//On peut affirmer que les deux objets ne sont pas égaux
> 		return false;
> 	}
> 	
> 	//Si les attributs 'placee', 'occupee', 'allumee' et 'clignotante' des deux autotamponneuses ne sont pas identiques
> 	if(this.placee != autreAuto.placee
> 			|| this.occupee != autreAuto.occupee
> 			|| this.allumee != autreAuto.allumee
> 			|| this.clignotante != autreAuto.clignotante)
> 	{
> 		//On peut affirmer que les deux objets ne sont pas égaux
> 		return false;
> 	}
> 	
> 	//Si les deux autotamponneuses n'ont pas le même occupant
> 	if(this.nomOccupant != autreAuto.nomOccupant)
> 	{
> 		//On peut affirmer que les deux objets ne sont pas égaux
> 		return false;
> 	}
> 	
> 	//On peut affirmer que les deux objets sont égaux
> 	return true;
> }
> ```

- 1#10.2 tests d'égalité entre objets dans la classe TestAutotamponneuse

```Java
public static void main(String[] args) 
{
	Autotamponneuse auto1 = new Autotamponneuse();
	Autotamponneuse auto2 = new Autotamponneuse();

	// 1#10.2
	System.out.println();
	System.out.println("Question 1#10.2");
	System.out.println();
	System.out.println("Je place l'autotamponneuse#1 à la position (2.4,5.6)");
	auto1.place(2.4f, 5.6f);
	System.out.println("Je place l'autotamponneuse#2 à la position (2.3,4.1)");
	auto2.place(2.3f, 4.1f);
	System.out.println("Les autotamponneuses 1 et 2 sont-elles identiques ? " + auto1.equals(auto2));
	System.out.println("Je place l'autotamponneuse#1 à la position (1.0,1.0)");
	auto1.place(1.0f, 1.0f);
	System.out.println("Je place l'autotamponneuse#2 à la position (1.0,1.0)");
	auto2.place(1.0f, 1.0f);
	System.out.println("Les autotamponneuses 1 et 2 sont-elles identiques ? " + auto1.equals(auto2));
	System.out.println("L'autotamponneuse#1 prend la valeur de l'autotamponneuse#2");
	auto1 = auto2;
	System.out.println("Les autotamponneuses 1 et 2 sont-elles identiques ? " + auto1.equals(auto2));
}
```

Voici la sortie que l'on obtient :

```

Question 1#10.2

Je place l'autotamponneuse#1 à la position (2.4,5.6)
Je place l'autotamponneuse#2 à la position (2.3,4.1)
Les autotamponneuses 1 et 2 sont-elles identiques ? false
Je place l'autotamponneuse#1 à la position (1.0,1.0)
Je place l'autotamponneuse#2 à la position (1.0,1.0)
Les autotamponneuses 1 et 2 sont-elles identiques ? true
L'autotamponneuse#1 prend la valeur de l'autotamponneuse#2
Les autotamponneuses 1 et 2 sont-elles identiques ? true
```

1#11. Ajoutez une nouvelle classe PisteAutotamponneuses dans le package com.feteforraine. Une telle classe comporte une collection d’autotamponneuses représentée par un tableau. Ajoutez-y un constructeur prenant pour paramètre la taille de cette collection.

- 1#11.1 définition de la classe PisteAutotamponneuses

> ```Java
> package com.feteforraine;
> 
> public class PisteAutotamponneuses
> {
> 	private Autotamponneuse[] autotamponneuses;
> 	
> 	public PisteAutotamponneuses(int numberOfAutotamponneuse)
> 	{
> 		this.autotamponneuses = new Autotamponneuse[numberOfAutotamponneuse];
> 	}
> }
> ```

1#12. Ajoutez une nouvelle méthode statique main dans la classe PisteAutotamponneuses pour définir un programme de test qui crée le nombre d’autotamponneuses requis et les place de façon aléatoire sur la piste (cf. Math.random()). Faites en sorte qu’aucune autotamponneuse nouvellement placée ne soit en collision avec une autre autotamponneuse.

- 1#12.1 méthode main

```Java
> public static void main(String[] args)
> {
> 	System.out.println();
> 	System.out.println("Question#1.12.2");
> 	System.out.println();
> 	
> 	//On crée une piste avec 10 autotamponneuses
> 	PisteAutotamponneuses piste = new PisteAutotamponneuses(9);
> 	
> 	boolean collision = false;
> 	
> 	//Pour chaque autotamponneuse de la piste
> 	for(int i = 0; i < piste.autotamponneuses.length; i++)
> 	{
> 		//On fait l'hypothèse qu'elle n'est en collision avec aucune autre autotamponneuse déjà placée
> 		collision = false;
> 		
> 		//On définie une position aléatoire sur une piste de 20x20 unités
> 		double positionX = Math.random() * 20;
> 		double positionY = Math.random() * 20;
> 		
> 		//On instancie l'autotamponeuse à la position aléatoire
> 		Autotamponneuse auto = new Autotamponneuse(positionX, positionY);
> 		
> 		//Pour chaque autotamponneuse déjà placée sur la piste
> 		for(int j = 0; j < i; j++)
> 		{
> 			//Si l'autotamponneuse qui vient d'être instanciée est en collision avec l'autotamponneuse déjà placée
> 			if(auto.collision(piste.autotamponneuses[j]))
> 			{
> 				//Il y a une collision
> 				collision = true;
> 				System.out.println("Il y a une collision entre l'auto#" + i + " et l'auto#" + j);
> 				
> 				//On arrête la boucle
> 				break;
> 			}
> 		}
> 		
> 		//S'il y a une collision
> 		if(collision)
> 		{
> 			//On n'ajoute pas la nouvelle autotamponneuse à la piste 
> 			System.out.println("L'auto#" + i + " n'a pas été ajoutée à la piste à la position (" + positionX + ";" + positionY + ")");
> 			
> 			//On recommence cette itération de la boucle 'for'
> 			i--;
> 		}
> 		//S'il n'y a pas de collision
> 		else
> 		{
> 			//On ajoute la nouvelle autotamponneuse à la piste
> 			piste.autotamponneuses[i] = auto;
> 			System.out.println("L'auto#" + i + " a été ajoutée à la piste à la position (" + positionX + ";" + positionY + ")");
> 		}
> 	}
> }
```

- 1#12.2 trace d'exécution de tests de création de piste

```

> Question 1#12.2
> 
> L'auto#0 a été ajoutée à la piste à la position (14.253948678453835;5.638108439966789)
> L'auto#1 a été ajoutée à la piste à la position (5.532463134240819;10.77125723855886)
> L'auto#2 a été ajoutée à la piste à la position (8.727751484599313;5.7809816514409835)
> L'auto#3 a été ajoutée à la piste à la position (3.988327559674132;5.41802986978886)
> L'auto#4 a été ajoutée à la piste à la position (18.07983166687325;19.242628162516596)
> L'auto#5 a été ajoutée à la piste à la position (0.9520956961896165;3.58811300805999)
> L'auto#6 a été ajoutée à la piste à la position (6.751223519465044;1.3753784406810388)
> L'auto#7 a été ajoutée à la piste à la position (14.1200639980671;17.36797146667028)
> Il y a une collision entre l'auto#8 et l'auto#3
> L'auto#8 n'a pas été ajoutée à la piste à la position (2.7130478051470086;6.5755577993613334)
> L'auto#8 a été ajoutée à la piste à la position (6.985950129674232;12.216550384314216)
> ```

1#13. Redéfinissez la méthode String toString() de la classe PisteAutotamponneuses afin qu’elle affiche l’état de la collection complète (l’ordre des autotamponneuses sera par ordre d’ajout). Utilisez pour cela la classe java.lang.StringBuilder.

- 1#13.1 méthode toString

> ```Java
> @Override
> public String toString()
> {
> 	StringBuilder stringBuilder = new StringBuilder();
> 	for(int i = 0; i < autotamponneuses.length; i++)
> 	{
> 		stringBuilder.append(autotamponneuses[i] + "\n");
> 	}
> 	return stringBuilder.toString();
> }
> ```

- 1#13.2 test d'utilisation de la méthode toString

> ```Java
> public static void main(String[] args)
> {
> 	[...]
> 	
> 	System.out.println();
> 	System.out.println("Question 1#13.2");
> 	System.out.println();
> 	System.out.println(piste.toString());
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#13.2
> 
> [1] (14.253948678453835;5.638108439966789) libre / eteinte / non clignotante
> [2] (5.532463134240819;10.77125723855886) libre / eteinte / non clignotante
> [3] (8.727751484599313;5.7809816514409835) libre / eteinte / non clignotante
> [4] (3.988327559674132;5.41802986978886) libre / eteinte / non clignotante
> [5] (18.07983166687325;19.242628162516596) libre / eteinte / non clignotante
> [6] (0.9520956961896165;3.58811300805999) libre / eteinte / non clignotante
> [7] (6.751223519465044;1.3753784406810388) libre / eteinte / non clignotante
> [8] (14.1200639980671;17.36797146667028) libre / eteinte / non clignotante
> [10] (6.985950129674232;12.216550384314216) libre / eteinte / non clignotante
> ```

1#14. Ajoutez une méthode dereglementAleatoire à la classe PisteAutotamponneuses qui déplace de façon aléatoire et continue chaque autotamponneuse encore pilotée tour à tour, et élimine les autotamponneuses entrées en collision. Cette méthode affichera l’historique des autotamponneuses éliminées, et le vainqueur (autotamponneuse survivante si elle existe).

- 1#14.1 méthode dereglementAleatoire

> ```Java
> /**
>  * Cette méthode permet de simuler un jeu d'autotamponneuses.
>  * Les autotamponneuses se déplacent aléatoirement sur la piste jusqu'à ce qu'il en reste au plus 1.
>  * Cette autotamponneuse est déclarée gagnante (s'il n'en reste aucune, il n'y a pas de gagnant)
>  */
> public void dereglementAleatoire()
> {
> 	//Pour chaque autotamponneuse de la piste
> 	for(int l = 0; l < this.autotamponneuses.length; l++)
> 	{
> 		//On ajoute un occupant
> 		this.autotamponneuses[l].ajouteOccupant("occupant#" + (l+1));
> 		
> 		//On allume l'autotamponneuse
> 		this.autotamponneuses[l].allume();
> 	}
> 	
> 	//Pour l'instant, toutes les autotamponneuses sont en jeu
> 	int nombreAutotamponneusesEnJeu = this.autotamponneuses.length;
> 	
> 	//Le jeu commence au tour#1
> 	int tour = 1;
> 	
> 	//Tant qu'il y a plusieurs autotamponneuses en jeu
> 	while (nombreAutotamponneusesEnJeu > 1)
> 	{
> 		//Pour chaque autotamponneuse de la piste
> 		for(int i = 0; i < this.autotamponneuses.length; i++)
> 		{
> 			//Si l'autotamponneuse i est allumée
> 			if(this.autotamponneuses[i].estAllumee())
> 			{
> 				//On change sa position
> 				double positionX = Math.random() * 20;
> 				double positionY = Math.random() * 20;
> 				this.autotamponneuses[i].place(positionX, positionY);
> 				
> 				//Pour chaque autotamponneuse de la piste
> 				for(int j = 0; j < this.autotamponneuses.length; j++)
> 				{
> 					//Si l'autotamponneuse j est allumée
> 					if(this.autotamponneuses[j].estAllumee())
> 					{
> 						//Si les autotamponneuses i et j sont en collision (et qu'il ne s'agit pas de la même autotamponneuse)
> 						if(this.autotamponneuses[i] != this.autotamponneuses[j] && this.autotamponneuses[i].collision(this.autotamponneuses[j]))
> 						{
> 							//Si l'autotamponneuse i est toujours allumée
> 							if(this.autotamponneuses[i].estAllumee())
> 							{
> 								//On éteint l'autotamponneuse i
> 								this.autotamponneuses[i].eteint();
> 								System.out.println("L'autotamponneuse " + this.autotamponneuses[i].toString() + " est éliminée au tour#" + tour);
> 								
> 								//On éteint l'autotamponneuse j
> 								this.autotamponneuses[j].eteint();
> 								System.out.println("L'autotamponneuse " + this.autotamponneuses[j].toString() + " est éliminée au tour#" + tour);
> 								
> 								//Les deux autotamponneuses sont retirées du jeu
> 								nombreAutotamponneusesEnJeu -= 2;
> 							}
> 							//Si l'autotamponneuse i a été éteinte entre temps, donc si elle a déjà été en collision avec une autre autotamponneuse durant ce tour
> 							else
> 							{
> 								//On éteint l'autotamponneuse j
> 								this.autotamponneuses[j].eteint();
> 								System.out.println("L'autotamponneuse " + this.autotamponneuses[j].toString() + " est éliminée au tour#" + tour);
> 							
> 								//L'autotamponneuse j est retirée du jeu
> 								nombreAutotamponneusesEnJeu -= 1;
> 							}
> 						}
> 					}
> 				}
> 			}
> 		}
> 		tour++;
> 	}
> 	
> 	//S'il reste exactement une autotamponneuse en jeu
> 	if(nombreAutotamponneusesEnJeu == 1)
> 	{
> 		//On parcours les autotamponneuses de la piste
> 		for(int k = 0; k < this.autotamponneuses.length; k++)
> 		{
> 			//Si l'autotamponneuse est allumée
> 			if(this.autotamponneuses[k].estAllumee())
> 			{
> 				//Il s'agit de l'autotamponneuse gagnante
> 				System.out.println("L'autotamponneuse gagnante est l'auto : " + this.autotamponneuses[k].toString());
> 			}
> 		}
> 	}
> 	//S'il n'y a plus d'autotamponneuses en jeu
> 	else
> 	{
> 		//Aucune autotamponneuse ne gagne
> 		System.out.println("Il n'y a pas d'autotamponneuse gagnante");
> 	}
> }
> ```
> 
> Voici la sortie que l'on obtient :
> 
> ```
> 
> Question 1#14.1
> 
> L'autotamponneuse [10] (12.780341297705293;7.4329766239287505) occupée (occupant#9) / eteinte / non clignotante est éliminée au tour#1
> L'autotamponneuse [1] (12.027280967874198;6.489756646222549) occupée (occupant#1) / eteinte / non clignotante est éliminée au tour#1
> L'autotamponneuse [2] (4.1273012061068375;8.551272293948314) occupée (occupant#2) / eteinte / non clignotante est éliminée au tour#3
> L'autotamponneuse [6] (5.359961847771602;9.346857854459865) occupée (occupant#6) / eteinte / non clignotante est éliminée au tour#3
> L'autotamponneuse [8] (17.375143063977205;1.2112415420268197) occupée (occupant#8) / eteinte / non clignotante est éliminée au tour#4
> L'autotamponneuse [3] (15.735012246760396;2.143585910485737) occupée (occupant#3) / eteinte / non clignotante est éliminée au tour#4
> L'autotamponneuse [5] (17.888018874817423;1.4937833171980452) occupée (occupant#5) / eteinte / non clignotante est éliminée au tour#12
> L'autotamponneuse [7] (19.54399982576055;2.0131951361495593) occupée (occupant#7) / eteinte / non clignotante est éliminée au tour#12
> L'autotamponneuse gagnante est l'auto : [4] (11.478979040587236;8.178855701299659) occupée (occupant#4) / allumée / non clignotante
> ```
