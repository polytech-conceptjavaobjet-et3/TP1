package com.feteforraine;

public class Autotamponneuse 
{
	
	/* 1. Créez une nouvelle classe Autotamponneuse dans un package com.feteforraine.
	 * Ajoutez les données nécessaires à la classe en choisissant les niveaux de
	 * visibilité appropriés. */
	
	
	// => le fait qu’elles soient placées ou non sur une piste d’autotamponneuses,
	// leur position étant alors représentée par une paire de valeurs réelles
	// (coordonnées dans un plan à deux dimensions)
	
	private boolean placee = false;
	private double[] position = new double[2];
	
	// => le fait qu’elles soient occupées ou non, et si oui par quelle personne
	// (il faut qu’elles soient placées pour pouvoir être occupées)
	
	private boolean occupee = false;
	private String nomOccupant = "";
	
	// => le fait qu’elle soient allumées ou non (il faut qu’elles soient occupées
	// pour pouvoir être allumées)
	
	private boolean allumee = false;
	
	// => le fait qu’elle soient clignotantes ou non (il faut qu’elles soient allumées
	// pour pouvoir être cignotantes)
	
	private boolean clignotante = false;
	
	
	/* 2. Ajoutez deux constructeurs à la classe : l’un sans paramètres, l’autre avec
	 * une coordonnée x et une coordonnée y. Faites en sorte de réutiliser ce qui peut
	 * l’être dans vos constructeurs. */
	
	
	// #1.2.1 constructeur sans paramètres
	
	public Autotamponneuse()
	{
		this.occupee = false;
		this.allumee = false;
		this.clignotante = false;
		this.placee = false;
		this.position[0] = 0.0d;
		this.position[1] = 0.0d;
		this.nomOccupant = "";
	}
	
	// #1.2.2 constructeur avec 2 paramètres
	
	public Autotamponneuse(double positionX, double positionY)
	{
		this();
		this.placee = true;
		this.position[0] = positionX;
		this.position[1] = positionY;
	}
	
	// #1.2.3 Pour quelles raisons aurait-on intérêt à réutiliser (invoquer) d'autres
	// constructeurs lorsqu'on définit des constructeurs ?
	
	/* Cela peut être utile si:
	 * - on veut donner des valeurs par défaut à notre Autotamponeuse (exemple : si
	 * l'autotamponeuse est occupée, elle est automatiquement clignotante)
	 * - on veut définir manuellement d'autres paramètre (exemple : l'utilisateur peut
	 * choisir si l'autotamponeuse est clignotante ou non à sa création) */
	
	
	/* 3. Ajoutez des méthodes d’instance dans la classe Autotamponneuse pour consulter
	 * l’état d’une autotamponneuse particulière : estOccupee, getNomOccupant, estAllumee,
	 * estClignotante. */
	
	
	// #1.3.1 méthodes demandées
	
	public boolean estOccupee()
	{
		return this.occupee;
	}
	
	public String getNomOccupant()
	{
		return this.nomOccupant;
	}
	
	public boolean estAllumee()
	{
		return this.allumee;
	}
	
	public boolean estClignotante()
	{
		return this.clignotante;
	}
	
	// #1.3.2 Pourquoi parle-t-on de "méthodes d'instances" ?
	
	/* Une méthode d'instance est appelée sur une instance de la classe. Ce n'est
	 * donc pas une méthode static. */
		
	// #1.3.3 Pourquoi ces méthodes ne contournent-elles pas le principe d'encapsulation
	// des données ?
	
	/* Elles ne contournent pas le principe d'encapsulation des données car elles
	 * retournent une copie de la donnée et non la donnée elle-même. Cela signifie
	 * qu'elles ne donnent pas l'accès à la donnée mais seulement sa valeur. */
	
	
	/* 4. Ajoutez une méthode main dans la classe Autotamponneuse afin de pouvoir
	 * définir un programme principal de test. Testez-y sur des exemples le code
	 * précedemment défini, et utilisez-la pour tester le code des questions suivantes. */
	
	
	// #1.4.1 méthode main
	
	public static void main(String[] args)
	{
		Autotamponneuse auto1 = new Autotamponneuse();
		Autotamponneuse auto2 = new Autotamponneuse();
		
		// #1.5.2
		System.out.println();
		System.out.println("Question#1.5.2");
		System.out.println();
		System.out.println("ID de auto1 : " + auto1.id);
		System.out.println("ID de auto2 : " + auto2.id);
		
		// #1.6.2
		System.out.println();
		System.out.println("Question#1.6.2");
		System.out.println();
		System.out.println("Etat de auto1 : " + auto1.toString());
		System.out.println("Etat de auto2 : " + auto2.toString());
		
		// #1.7.2
		System.out.println();
		System.out.println("Question#1.7.2");
		System.out.println();
		System.out.println("Je place l'auto1 en position (1.0,2.0) : " + auto1.place(1.0,2.0));
		System.out.println("Nouvel état de l'auto1 : " + auto1.toString());
		System.out.println("Nouvel état de l'auto2 : " + auto2.toString());
		System.out.println("J'allume l'auto1 : " + auto1.allume());
		System.out.println("J'allume l'auto2 : " + auto2.allume());
		System.out.println("état de auto1 : " + auto1.toString());
		System.out.println("état de auto2 : " + auto2.toString());
		System.out.println("Bob Marley entre dans l'auto1 : " + auto1.ajouteOccupant("Bob Marley"));
		System.out.println("John Lennon entre dans l'auto2 : " + auto2.ajouteOccupant("John Lennon"));
		System.out.println("état de auto1 : " + auto1.toString());
		System.out.println("état de auto2 : " + auto2.toString());
		System.out.println("Je démarre le clignotement de l'auto1 : " + auto1.demarreClignotement());
		System.out.println("Je démarre le clignotement de l'auto2 : " + auto2.demarreClignotement());
		System.out.println("état de auto1 : " + auto1.toString());
		System.out.println("état de auto2 : " + auto2.toString());
		System.out.println("J'allume l'auto1 : " + auto1.allume());
		System.out.println("J'allume l'auto2 : " + auto2.allume());
		System.out.println("état de auto1 : " + auto1.toString());
		System.out.println("état de auto2 : " + auto2.toString());
		System.out.println("Je démarre le clignotement de l'auto1 : " + auto1.demarreClignotement());
		System.out.println("Je démarre le clignotement de l'auto2 : " + auto2.demarreClignotement());
		System.out.println("état de auto1 : " + auto1.toString());
		System.out.println("état de auto2 : " + auto2.toString());
		
		// #1.8.4
		System.out.println();
		System.out.println("Question#1.8.4");
		System.out.println();
		System.out.println("Je place l'auto1 en position (1.0,2.0) : " + auto1.place(1.0,2.0));
		System.out.println("Nouvel état de l'auto1 : " + auto1.toString());
		System.out.println("Nouvel état de l'auto2 : " + auto2.toString());
		System.out.println("L'auto1 et l'auto2 sont-elles en collision ? : " + auto1.collision(auto2));
		System.out.println("Je place l'auto2 en position (3.0,3.0) : " + auto2.place(3.0,3.0));
		System.out.println("Nouvel état de l'auto1 : " + auto1.toString());
		System.out.println("Nouvel état de l'auto2 : " + auto2.toString());
		System.out.println("L'auto1 et l'auto2 sont-elles en collision ? : " + auto1.collision(auto2));
		System.out.println("Je place l'auto2 en position (2.0,2.0) : " + auto2.place(2.0,2.0));
		System.out.println("Nouvel état de l'auto1 : " + auto1.toString());
		System.out.println("Nouvel état de l'auto2 : " + auto2.toString());
		System.out.println("L'auto1 et l'auto2 sont-elles en collision ? : " + auto1.collision(auto2));
	}
	
	// #1.4.2 affichage produit par l'exécution de votre méthode main
	
	// #1.4.3 méthode main dans une nouvelle classe TestAutotamponneuse dans le package
	// com.feteforraine
	
	// #1.4.4 Comment faire en sorte d'exécuter la méthode main de la classe
	// com.feteforraine. TestAutotamponneuse ? 
	
	// #1.4.5 Pourquoi la méthode main est-elle static ? A quoi correspond son paramètre ? 
	
	// #1.4.6 Quelles critiques pourriez-vous faire à l'approche consistant à tester le
	// fonctionnement d'une classe au travers d'un programme de test exécuté par sa
	// méthode main ? Quelles autres approches pourrait-on imaginer pour faire cela ?
	
	
	/* 5. Ajoutez le code nécessaire pour qu’une autotamponneuse ait désormais un
	 * identifiant entier unique. Cette valeur ne devra pas être choisie par l’utilisateur,
	 * et devra commencer à la valeur 1 pour la première autotamponneuse. */
	
	
	// #1.5.1 code ajouté
	
	private static int DERNIER_ID_ATTRIBUE = 0;
	private int	id = ++DERNIER_ID_ATTRIBUE; 
	
	// #1.5.2 test du fonctionnement dans la méthode main
	
	/* (voir la méthode main) */
	
	
	/* 6. Redéfinissez dans la classe Autotamponneuse la méthode particulière suivante
	 * de la classe java.lang.Object : 
	 * - String toString() qui retourne une représentation sous forme de chaı̂ne de
	 * caractères de l’état d’un objet.
	 * 
	 * Des exemples de chaı̂nes pourraient être : 
	 * - [1] (5.0,5.0) libre éteinte non clignotante
	 * - [2] (7.0,2.0) occupée (Charles Darwin) éteinte non clignotante
	 * - [2] (5.1,5.0) occupée (Charles Darwin) allumée clignotante */
	
	
	// #1.6.1 redéfinition de la méthode toString
	
	public String toString()
	{
		String etatAutotamponeuse = "";
		
		//On ajoute l'ID de l'autotamponeuse
		etatAutotamponeuse += "[" + this.id + "]";
		
		//On ajoute un espace
		etatAutotamponeuse += " ";
				
		//On ajoute la position de l'autotamponeuse
		etatAutotamponeuse += "(" + this.position[0] + ";" + this.position[1] + ")";
		
		//On ajoute un espace
		etatAutotamponeuse += " ";
		
		//L'autotamponeuse est-elle occupée ?
		if(this.occupee)
		{
			etatAutotamponeuse += "occupée (" + this.nomOccupant + ")";
		}
		else
		{
			etatAutotamponeuse += "libre";
		}
		
		//On ajoute un séparateur
		etatAutotamponeuse += " / ";
		
		//L'autotamponeuse est-elle allumée ?
		if(this.allumee)
		{
			etatAutotamponeuse += "allumée";
		}
		else
		{
			etatAutotamponeuse += "eteinte";
		}
		
		//On ajoute un séparateur
		etatAutotamponeuse += " / ";
		
		//L'autotamponeuse est-elle clignotante ?
		if(this.clignotante)
		{
			etatAutotamponeuse += "clignotante";
		}
		else
		{
			etatAutotamponeuse += "non clignotante";
		}
				
		return etatAutotamponeuse;	
	}
	
	// #1.6.2 test du fonctionnement dans la méthode main
	
	/* (voir la méthode main) */
	
	
	/* 7. Ajoutez à présent des méthodes d’instance dans la classe Autotamponneuse
	 * pour modifier l’état d’une autotamponneuse particulière, en respectant les
	 * règles énoncées ci-dessus : place, ajouteOccupant, enleveOccupant, allume,
	 * eteint, demarreClignotement, arreteClignotement.
	 * Afin d’informer le programme appelant sur la modification effective ou non de
	 * l’objet correspondant, faites retourner à vos méthodes une valeur booléenne.
	 * On décide que ces méthodes ne pourront être accessibles qu’aux autres classes
	 * du même package ( com.feteforraine ). */
	
	
	// #1.7.1 définition des méthodes
	
	protected boolean place(double positionX, double positionY)
	{
		this.position[0] = positionX;
		this.position[1] = positionY;
		this.placee = true;
		return true;
	}
	
	protected boolean ajouteOccupant(String nomOccupant)
	{
		if(!this.placee || this.occupee)
		{
			return false;
		}
		this.nomOccupant = nomOccupant;
		this.occupee = true;
		return true;
	}
	
	protected boolean enleveOccupant()
	{
		if(!this.occupee)
		{
			return false;
		}
		this.nomOccupant = "";
		if(this.allumee)
		{
			this.eteint();
		}
		this.occupee = false;
		return true;
	}
	
	protected boolean allume()
	{
		if(this.allumee || !this.occupee)
		{
			return false;
		}
		this.allumee = true;
		return true;
	}
	
	protected boolean eteint()
	{
		if(!this.allumee)
		{
			return false;
		}
		this.allumee = false;
		if(this.clignotante)
		{
			this.arreteClignotement();
		}
		return true;
	}
	
	protected boolean demarreClignotement()
	{
		if(this.clignotante || !this.allumee)
		{
			return false;
		}
		this.clignotante = true;
		return true;
	}
	
	protected boolean arreteClignotement()
	{
		if(!this.clignotante)
		{
			return false;
		}
		this.clignotante = false;
		return true;
	}
	
	// #1.7.2 test du fonctionnement dans la méthode main et trace d'exécution
	
	/* (voir la méthode main) */
	
	// #1.7.3 En créant une classe Test dans le package par défaut, invoquez la
	// méthode ajouteOccupant. Que se passe-t-il, pourquoi ?
	
	/* On obtient l'erreur suivante :
	 * 
	 * (voir la classe Test)
	 * 
	 * Exception in thread "main" java.lang.Error: Unresolved compilation problem:
	 * The method ajouteOccupant(String) from the type Autotamponneuse is not visible
	 * at tp1/test.Test.main(Test.java:10)
	 * 
	 * La visibilité de la méthode ajouteOccupant étant "protected", on ne peut y accéder
	 * que depuis le même package ou les classes filles.
	 * */
	
	
	/* 8. On souhaite détecter des collisions entre autotamponneuses. Pour simplifier,
	 * on dira que deux autotamponneuses sont en collision si la distance entre leurs
	 * positions (comprise ici comme un point dans le plan) est inférieure à une valeur
	 * constante définie au niveau de la classe, DISTANCE_MINIMALE. Ajoutez cette valeur
	 * de manière appropriée, puis ajoutez une méthode d’instance pour le calcul de
	 * distance entre deux autotamponneuses : 
	 * - double calculeDistance(Autotamponneuse autreAuto)
	 * ainsi qu’une méthode d’instance indiquant si une collision a lieu entre deux
	 * autotamponneuses :
	 * - boolean collision(Autotamponneuse autreAuto) */
	
	// #1.8.1 déclaration du champ DISTANCE MINIMALE
	
	public static final double DISTANCE_MINIMALE = 2.0d; 
	
	// #1.8.2 méthode calculeDistance
	
	public double calculeDistance(Autotamponneuse autreAuto)
	{
		double distance = Math.sqrt((this.position[0] - autreAuto.position[0])
				* (this.position[0] - autreAuto.position[0])
				+ (this.position[1] - autreAuto.position[1])
				* (this.position[1] - autreAuto.position[1]));
		return distance;
	}
	
	// #1.8.3 méthode collision
	
	public boolean collision(Autotamponneuse autreAuto)
	{
		if(this.calculeDistance(autreAuto) < DISTANCE_MINIMALE)
		{
			return true;
		}
		return false;
	}
	
	// #1.8.4 exemples de tests de collisions dans la classe TestAutotamponneuse
	
	/* (voir la méthode main) */
	
	
	/* 9. Afin d’autoriser d’autres types d'utilisation, proposez des équivalents
	 * sous forme de méthodes de classes pour les deux méthodes d’instance précédentes :
	 * - static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)
	 * et :
	 * - static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)
	 * Bien prendre en compte le fait que les paramètres peuvent tous les deux avoir
	 * une valeur null à l’exécution. */

	
	// #1.9.1 méthode de classes calculeDistance
	
	public static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)
	{
		double distance = Math.sqrt((auto1.position[0] - auto2.position[0])
				* (auto1.position[0] - auto2.position[0])
				+ (auto1.position[1] - auto2.position[1])
				* (auto1.position[1] - auto2.position[1]));
		return distance;
	}
	
	// #1.9.2 méthode de classes collision
	
	public static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)
	{
		if(Autotamponneuse.calculeDistance(auto1, auto2) < DISTANCE_MINIMALE)
		{
			return true;
		}
		return false;
	}
	
	// #1.9.3 exemples de tests de collisions dans la classe Test
	
	/* (voir la classe Test) */
	
	// #1.9.4 La définition des méthodes de classes pourrait-elle réutiliser celle de
	//la méthode d'instances correspondante ? Si oui, pourquoi ?
	
	/* Non car elles ne sont pas statiques et font donc potentiellement appel à des
	 * données de l'instance de la classe. */
	
	
	/* 10. Redéfinissez dans la classe Autotamponneuse la méthode de la classe
	 * java.lang.Object :
	 * - boolean equals(Object autreObjet)
	 * qui indique si deux objets sont égaux (même état complet ici). Attention,
	 * la méthode étant déclarée au niveau de la classe java.lang.Object , il faudra
	 * vérifier puis transtyper le type du paramètre de la méthode. */
	
	
	// #1.10.1 redéfinition de la méthode equals
	
	@Override
	public boolean equals(Object autreObjet)
	{
		if(autreObjet == null)
		{
			return false;
		}
		if(this == autreObjet)
		{
			return true;
		}
		if(this.getClass() != autreObjet.getClass())
		{
			return false;
		}
		Autotamponneuse autreAuto = (Autotamponneuse) autreObjet;
		if(this.position[0] != autreAuto.position[0]
				|| this.position[1] != autreAuto.position[1])
		{
			return false;
		}
		if(this.placee != autreAuto.placee
				|| this.occupee != autreAuto.occupee
				|| this.allumee != autreAuto.allumee
				|| this.clignotante != autreAuto.clignotante)
		{
			return false;
		}
		if(this.nomOccupant != autreAuto.nomOccupant)
		{
			return false;
		}
			return true;
	}
	
	// #1.10.2 tests d'égalité entre objets dans la classe TestAutotamponneuse
	
	/* (voir la classe Test) */
	
	
	/* 11. Ajoutez une nouvelle classe PisteAutotamponneuses dans le package
	 * com.feteforraine. Une telle classe comporte une collection d’autotamponneuses
	 * représentée par un tableau. Ajoutez-y un constructeur prenant pour paramètre
	 * la taille de cette collection. */
	
	
	// #1.11.1 définition de la classe PisteAutotamponneuses
	
	/* (voir la classe PisteAutotamponeuses) */
	
	
	/* 12. Ajoutez une nouvelle méthode statique main dans la classe
	 * PisteAutotamponneuses pour définir un programme de test qui crée le
	 * nombre d’autotamponneuses requis et les place de façon aléatoire sur la
	 * piste (cf. Math.random()). Faites en sorte qu’aucune autotamponneuse
	 * nouvellement placée ne soit en collision avec une autre autotamponneuse. */
	
	
	// #1.12.1 méthode main
	
	/* (voir la classe PisteAutotamponeuses) */
	
	// #1.12.2 trace d'exécution de tests de création de piste
	
	/* (voir la classe PisteAutotamponeuses)
	 * 
	 * L'auto#0 a été ajoutée à la piste à la position (7.075965983441446;0.18777071254584055)
	 * L'auto#1 a été ajoutée à la piste à la position (16.292292445070533;19.01305654595785)
	 * L'auto#2 a été ajoutée à la piste à la position (2.2648264345048275;16.482561679822325)
	 * L'auto#3 a été ajoutée à la piste à la position (5.119108606713207;16.159119640151307)
	 * L'auto#4 a été ajoutée à la piste à la position (16.9197253095219;11.121848768213296)
	 * Il y a une collision entre l'auto#5 et l'auto#0
	 * L'auto#5 n'a pas été ajoutée à la piste à la position (5.222489098244476;0.021876973864454197)
	 * L'auto#5 a été ajoutée à la piste à la position (18.27101302469375;7.318583992632277)
	 * L'auto#6 a été ajoutée à la piste à la position (8.128346414004149;12.330410418583167)
	 * L'auto#7 a été ajoutée à la piste à la position (11.51586340831395;9.989380784928665)
	 * L'auto#8 a été ajoutée à la piste à la position (17.922929844518983;0.09908124019937237)
	 * L'auto#9 a été ajoutée à la piste à la position (6.296561548173425;4.137730059549951)*/
	
	
	/* 13. Redéfinissez la méthode String toString() de la classe
	 * PisteAutotamponneuses afin qu’elle affiche l’état de la collection
	 * complète (l’ordre des autotamponneuses sera par ordre d’ajout). Utilisez
	 * pour cela la classe java.lang.StringBuilder. */
	
	
	// #1.13.1 méthode toString
	
	/* (voir la classe PisteAutotamponeuses) */
	
	// #1.13.2 test d'utilisation de la méthode toString
	
	/* (voir la classe PisteAutotamponeuses)
	 * 
	 * [1] (11.525433527779265;2.4383797042140443) libre / eteinte / non clignotante
	 * [2] (13.523387177939544;19.940829272706853) libre / eteinte / non clignotante
	 * [3] (15.70578405907482;18.72602897936526) libre / eteinte / non clignotante
	 * [4] (18.040862640866028;10.594938484840227) libre / eteinte / non clignotante
	 * [5] (18.0636220910922;7.031975505256016) libre / eteinte / non clignotante
	 * [7] (2.7162909911908506;12.904550209615518) libre / eteinte / non clignotante
	 * [9] (1.3681812725836817;18.359600454452814) libre / eteinte / non clignotante
	 * [10] (13.836852044187467;8.289263479114076) libre / eteinte / non clignotante
	 * [11] (3.7389128719596187;6.7463378349555825) libre / eteinte / non clignotante
	 * [12] (9.452102060736117;4.253764133739157) libre / eteinte / non clignotante */
	
	
	/* 14. Ajoutez une méthode dereglementAleatoire à la classe
	 * PisteAutotamponneuses qui déplace de façon aléatoire et continue
	 * chaque autotamponneuse encore pilotée tour à tour, et élimine les
	 * autotamponneuses entrées en collision. Cette méthode affichera l’historique
	 * des autotamponneuses éliminées, et le vainqueur (autotamponneuse survivante
	 * si elle existe).*/
	
	
	// #1.14.1 méthode dereglementAleatoire
	
	/* (voir la classe PisteAutotamponeuses) */
}
