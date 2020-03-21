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

```Java

```

1#2. Ajoutez deux constructeurs à la classe : l’un sans paramètres, l’autre avec une coordonnée x et une coordonnée y. Faites en sorte de réutiliser ce qui peut l’être dans vos constructeurs.

- 1#2.1 constructeur sans paramètres : 

```Java

```







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
