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
> Ici, on travaille avec des types primitifs ([boolean, double](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)) et une classe des API standard ([String](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html)).
>
>```Java
>package com.feteforraine;
>
>public class Autotamponneuse 
>{
>	private boolean placee = false;
>	private double[] position = new double[2];
>  
>	private boolean occupee = false;
>	private String nomOccupant = "";
>	
>	private boolean allumee = false;
>	
>	private boolean clignotante = false;
>}
>```

1#2. Ajoutez deux constructeurs à la classe : l’un sans paramètres, l’autre avec une coordonnée x et une coordonnée y. Faites en sorte de réutiliser ce qui peut l’être dans vos constructeurs.

- 1#2.1 constructeur sans paramètres : 

```Java

```

- 1#2.2 constructeur avec 2 paramètres :

```Java

```

- 1#2.3 Pour quelles raisons aurait-on intérêt à réutiliser (invoquer) d'autres constructeurs lorsqu'on définit des constructeurs ?

```Java

```

1#3. Ajoutez des méthodes d’instance dans la classe Autotamponneuse pour consulter l’état d’une
autotamponneuse particulière : estOccupee, getNomOccupant, estAllumee, estClignotante.

- 1#3.1 méthodes demandées

```Java

```

- 1#3.2 Pourquoi parle-t-on de "méthodes d'instances" ?

```Java

```

- 1#3.3 Pourquoi ces méthodes ne contournent-elles pas le principe d'encapsulation des données ?

```Java

```

1#4. Ajoutez une méthode main dans la classe Autotamponneuse afin de pouvoir définir un programme principal de test. Testez-y sur des exemples le code précedemment défini, et utilisez-la pour tester le code des questions suivantes.

- 1#4.1 méthode  main

```Java

```

- 1#4.2 affichage produit par l'exécution de votre méthode  main

```Java

```

- 1#4.3 méthode main dans une nouvelle classe TestAutotamponneuse dans  le package com.feteforraine


```Java

```

- 1#4.4 Comment faire en sorte d'exécuter la méthode main de la classe com.feteforraine. TestAutotamponneuse ?

```Java

```

- 1#4.5 Pourquoi la méthode main est-elle static ? A quoi correspond son paramètre ?

```Java

```

- 1#4.6 Quelles critiques pourriez-vous faire à l'approche consistant à tester le fonctionnement d'une classe au travers d'un programme de test exécuté par sa méthode main ? Quelles autres approches pourrait-on imaginer pour faire cela ?

```Java

```

1#5. Ajoutez le code nécessaire pour qu’une autotamponneuse ait désormais un identifiant entier unique. Cette valeur ne devra pas être choisie par l’utilisateur, et devra commencer à la valeur 1 pour la première autotamponneuse.

- 1#5.1 code ajouté

```Java

```

- 1#5.2 test du fonctionnement dans la méthode main

```Java

```

1#6. Redéfinissez dans la classe Autotamponneuse la méthode particulière suivante de la classe java.lang.Object : String toString() qui retourne une représentation sous forme de chaı̂ne de caractères de l’état d’un objet. Des exemples de chaı̂nes pourraient être :

[1] (5.0,5.0) libre éteinte non clignotante
[2] (7.0,2.0) occupée (Charles Darwin) éteinte non clignotante
[2] (5.1,5.0) occupée (Charles Darwin) allumée clignotante

- 1#6.1 redéfinition de la méthode toString


```Java

```

- 1#6.2 test du fonctionnement dans la méthode main

```Java

```

1#7. Ajoutez à présent des méthodes d’instance dans la classe Autotamponneuse pour modifier l’état d’une autotamponneuse particulière, en respectant les règles énoncées ci-dessus : place, ajouteOccupant, enleveOccupant, allume, eteint, demarreClignotement, arreteClignotement. Afin d’informer le programme appelant sur la modification effective ou non de l’objet correspondant, faites retourner à vos méthodes une valeur booléenne. On décide que ces méthodes ne pourront être accessibles qu’aux autres classes du même package (com.feteforraine).

- 1#7.1 définition des méthodes

```Java

```

- 1#7.2 test du fonctionnement dans la méthode main et trace d'exécution

- 1#7.3 En créant une classe Test dans le package par défaut, invoquez la méthode ajouteOccupant. Que se passe-t-il, pourquoi ?

1#8. On souhaite détecter des collisions entre autotamponneuses. Pour simplifier, on dira que deux autotamponneuses sont en collision si la distance entre leurs positions (comprise ici comme un point dans le plan) est inférieure à une valeur constante définie au niveau de la classe, DISTANCE_MINIMALE. Ajoutez cette valeur de manière appropriée, puis ajoutez une méthode d’instance pour le calcul de distance entre deux autotamponneuses :

double calculeDistance(Autotamponneuse autreAuto)

ainsi qu’une méthode d’instance indiquant si une collision a lieu entre deux autotamponneuses :

boolean collision(Autotamponneuse autreAuto)

- 1#8.1 déclaration du champ  DISTANCE MINIMALE

- 1#8.2 méthode  calculeDistance

- 1#8.3 méthode  collision

- 1#8.4 exemples de tests de collisions dans la classe TestAutotamponneuse

1#9. Afin d’autoriser d’autres types d'utilisation, proposez des équivalents sous forme de méthodes de classes pour les deux méthodes d’instance précédentes :

static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)

et :

static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)

Bien prendre en compte le fait que les paramètres peuvent tous les deux avoir une valeur null à l’exécution.


- 1#9.1 méthode  de classes calculeDistance

- 1#9.2 méthode de classes collision

- 1#9.3 exemples de tests de collisions dans la classe TestAutotamponneuse

- 1#9.4 La définition des méthodes de classes pourrait-elle réutiliser celle de la méthode d'instances correspondante ? Si oui, pourquoi ?

1#10. Redéfinissez dans la classe Autotamponneuse la méthode de la classe java.lang.Object :

boolean equals(Object autreObjet)

qui indique si deux objets sont égaux (même état complet ici). Attention, la méthode étant déclarée au niveau de la classe java.lang.Object, il faudra vérifier puis transtyper le type du paramètre de la méthode.

- 1#10.1 redéfinition de la méthode  equals

- 1#10.2 tests d'égalité entre objets dans la classe TestAutotamponneuse

1#11. Ajoutez une nouvelle classe PisteAutotamponneuses dans le package com.feteforraine. Une telle classe comporte une collection d’autotamponneuses représentée par un tableau. Ajoutez-y un constructeur prenant pour paramètre la taille de cette collection.

- 1#11.1 définition de la classe PisteAutotamponneuses

1#12. Ajoutez une nouvelle méthode statique main dans la classe PisteAutotamponneuses pour définir un programme de test qui crée le nombre d’autotamponneuses requis et les place de façon aléatoire sur la piste (cf. Math.random()). Faites en sorte qu’aucune autotamponneuse nouvellement placée ne soit en collision avec une autre autotamponneuse.

- 1#12.1 méthode main

- 1#12.2 trace d'exécution de tests de création de piste

1#13. Redéfinissez la méthode String toString() de la classe PisteAutotamponneuses afin qu’elle affiche l’état de la collection complète (l’ordre des autotamponneuses sera par ordre d’ajout). Utilisez pour cela la classe java.lang.StringBuilder.

- 1#13.1 méthode toString

- 1#13.2 test d'utilisation de la méthode toString

1#14. Ajoutez une méthode dereglementAleatoire à la classe PisteAutotamponneuses qui déplace de façon aléatoire et continue chaque autotamponneuse encore pilotée tour à tour, et élimine les autotamponneuses entrées en collision. Cette méthode affichera l’historique des autotamponneuses éliminées, et le vainqueur (autotamponneuse survivante si elle existe).

- 1#14.1 méthode dereglementAleatoire









Vous allez développer une classe utilitaire en Java permettant de réaliser divers traitements sur des tableaux d’entiers.

2#1. Créez une classe au nom approprié dans un package pertinent. Ajoutez une méthode statique à votre classe permettant de créer un tableau d’entiers (int[]) à partir d’un tableau de chaı̂nes de caractères (String[]).

- 2#1.1 code de la classe

> ```Java
> package et3.java;
> 
> public class TableauEntiers
> {
> 	/**
> 	 * Cette méthode permet de transformer un tableau de chaînes de caractères en tableau d'entiers
> 	 * 
> 	 * @param tabString Le tableau de chaînes de caractères à transformer
> 	 * @return Le tableau d'entiers créé à partir du tableau de chaînes de caractères
> 	 */
> 	public static int[] creerTableauEntiers ( String [] tabString )
> 	{
> 		//On crée un tableau d'entiers ayant la même taille que le tableau de chaînes de caractères
> 		int [] tabInt = new int [tabString.length];
> 		
> 		//On parcours le tableau de chaînes de caractères
> 		for(int indice = 0; indice < tabString.length; indice++)
> 		{
> 			//On tente d'éxécuter le code ci-dessous
> 			try
> 			{
> 				//On parse l'élément i du tableau de chaînes de caractère en entier
> 				//On associe cet entier à l'élément i du tableau d'entiers
> 				tabInt[indice] = Integer.parseInt(tabString[indice]);
> 			}
> 			//Si le code du "try" renvoie une erreur "NumberFormatException", on execute le code ci-dessous
> 			catch(NumberFormatException exception)
> 			{
> 				//On informe l'utilisateur que tabString[indice] ne peut pas être transformé en entier
> 				System.out.println("La valeur " + tabString[indice] + " d'indice " 
> 						+ indice + " ne peut pas être transformée en entier");
> 				System.out.println("Cette valeur sera donc remplacée par 0 dans le tableau");
> 				
> 				//On donne la valeur 0 à l'indice i du tableau d'entier
> 				tabInt[indice] = 0;
> 			}
> 		}
> 		
> 		//On retourne le tableau d'entiers
> 		return tabInt;
> 	}
> }
> ```
