package com.feteforraine;

public class Autotamponneuse 
{
	/* 1. Cr�ez une nouvelle classe Autotamponneuse dans un package com.feteforraine.
	 * Ajoutez les donn�es n�cessaires � la classe en choisissant les niveaux de visibilit� appropri�s. */
	
	// => le fait qu�elles soient plac�es ou non sur une piste d�autotamponneuses, leur position �tant alors repr�sent�e par une paire de valeurs r�elles (coordonn�es dans un plan � deux dimensions)
	private boolean placee = false;
	private double[] position = new double[2];
	
	// => le fait qu�elles soient occup�es ou non, et si oui par quelle personne (il faut qu�elles soient plac�es pour pouvoir �tre occup�es)
	private boolean occupee = false;
	private String nomOccupant = "";
	
	// => le fait qu�elle soient allum�es ou non (il faut qu�elles soient occup�es pour pouvoir �tre allum�es)
	private boolean allumee = false;
	
	// => le fait qu�elle soient clignotantes ou non (il faut qu�elles soient allum�es pour pouvoir �tre cignotantes)
	private boolean clignotante = false;
	
	/* 2. Ajoutez deux constructeurs � la classe : l�un sans param�tres, l�autre avec une coordonn�e x et une coordonn�e y.
	 * Faites en sorte de r�utiliser ce qui peut l��tre dans vos constructeurs. */
	
	// #1.2.1 constructeur sans param�tres
	public Autotamponneuse()
	{
		
	}
	
	// #1.2.2 constructeur avec 2 param�tres
	public Autotamponneuse(double positionX, double positionY)
	{
		
	}
	
	// #1.2.3 Pour quelles raisons aurait-on int�r�t � r�utiliser (invoquer) d'autres constructeurs lorsqu'on d�finit des constructeurs ?
	/**/
	

}
