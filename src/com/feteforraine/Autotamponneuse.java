package com.feteforraine;

public class Autotamponneuse 
{
	/* 1. Créez une nouvelle classe Autotamponneuse dans un package com.feteforraine.
	 * Ajoutez les données nécessaires à la classe en choisissant les niveaux de visibilité appropriés. */
	
	// => le fait qu’elles soient placées ou non sur une piste d’autotamponneuses, leur position étant alors représentée par une paire de valeurs réelles (coordonnées dans un plan à deux dimensions)
	private boolean placee = false;
	private double[] position = new double[2];
	
	// => le fait qu’elles soient occupées ou non, et si oui par quelle personne (il faut qu’elles soient placées pour pouvoir être occupées)
	private boolean occupee = false;
	private String nomOccupant = "";
	
	// => le fait qu’elle soient allumées ou non (il faut qu’elles soient occupées pour pouvoir être allumées)
	private boolean allumee = false;
	
	// => le fait qu’elle soient clignotantes ou non (il faut qu’elles soient allumées pour pouvoir être cignotantes)
	private boolean clignotante = false;
	
	/* 2. Ajoutez deux constructeurs à la classe : l’un sans paramètres, l’autre avec une coordonnée x et une coordonnée y.
	 * Faites en sorte de réutiliser ce qui peut l’être dans vos constructeurs. */
	
	// #1.2.1 constructeur sans paramètres
	public Autotamponneuse()
	{
		
	}
	
	// #1.2.2 constructeur avec 2 paramètres
	public Autotamponneuse(double positionX, double positionY)
	{
		
	}
	
	// #1.2.3 Pour quelles raisons aurait-on intérêt à réutiliser (invoquer) d'autres constructeurs lorsqu'on définit des constructeurs ?
	/**/
	

}
