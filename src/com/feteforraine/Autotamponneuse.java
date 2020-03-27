package com.feteforraine;

public class Autotamponneuse 
{
	private static int DERNIER_ID_ATTRIBUE = 0;
	private int	id = ++DERNIER_ID_ATTRIBUE; 
	
	public static final double DISTANCE_MINIMALE = 2.0d;
	
	private boolean placee = false;
	private double[] position = new double[2];
	
	private boolean occupee = false;
	private String nomOccupant = "";
	
	private boolean allumee = false;
	
	private boolean clignotante = false;
	
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
	
	public Autotamponneuse(double positionX, double positionY)
	{
		this();
		this.placee = true;
		this.position[0] = positionX;
		this.position[1] = positionY;
	}
	
	/**
	 * Cette méthode permet de placer l'autotamponneuse sur le circuit.
	 * @param positionX La position de l'autotamponneuse sur l'abscisse du circuit
	 * @param positionY La position de l'autotamponneuse sur l'ordonnée du circuit
	 * @return VRAI si l'autotamponneuse a pu être placée et FAUX sinon
	 */
	protected boolean place(double positionX, double positionY)
	{
		
		//On change les coordonnées de l'autotamponneuse
		this.position[0] = positionX;
		this.position[1] = positionY;
		
		//L'autotamponneuse est désormais placée
		this.placee = true;
		
		return true;
	}
	
	/**
	 * Cette méthode permet de savoir si l'autotamponneuse est occupée ou non.
	 * @return VRAI si l'autotamponneuse est occupée et FAUX sinon
	 */
	public boolean estOccupee()
	{
		return this.occupee;
	}
	
	/**
	 * Cette méthode permet d'obtenir le nom de l'occupant de l'autotamponeuse.
	 * @return Le nom de l'occupant de l'autotamponneuse
	 */
	public String getNomOccupant()
	{
		return this.nomOccupant;
	}
	
	/**
	 * Cette méthode permet de définir qui occupe l'autotamponneuse.
	 * @param nomOccupant Le nom de l'occupant de l'autotamponneuse
	 * @return VRAI si l'occupant a pu rentrer dans l'autotamponneuse et FAUX sinon
	 */
	protected boolean ajouteOccupant(String nomOccupant)
	{
		//Si l'autotamponneuse n'est pas déja placée ou si elle est déjà occupée
		if(!this.placee || this.occupee)
		{
			//On ne peut pas rajouter de participant
			return false;
		}
		
		//On change le nom de l'occupant
		this.nomOccupant = nomOccupant;
		
		//L'autotamponneuse est désormais occupée
		this.occupee = true;
		
		return true;
	}
	
	/**
	 * Cette méthode permet de retirer l'occupant de l'autotamponeuse.
	 * @return VRAI si un occupant a pu être retiré de l'autotamponneuse et FAUX sinon
	 */
	protected boolean enleveOccupant()
	{
		//Si l'autotamponneuse n'est pas déjà occupée
		if(!this.occupee)
		{
			//On ne peut pas enlever de participant
			return false;
		}
		
		//On enlève le nom de l'occupant
		this.nomOccupant = "";
		
		//L'autotamponneuse est désormais vide
		this.occupee = false;
		
		//Si l'autotamponneuse est allumée, on doit l'éteindre
		if(this.allumee)
		{
			//On éteint l'autotamponneuse
			this.eteint();
		}
		
		return true;
	}
	
	/**
	 * Cette méthode permet de savoir si l'autotamponneuse est allumée ou non.
	 * @return VRAI si l'autotamponneuse est allumée et FAUX sinon
	 */
	public boolean estAllumee()
	{
		return this.allumee;
	}
	
	/**
	 * Cette méthode permet d'allumer l'autotamponneuse.
	 * @return VRAI si l'autotamponneuse a pu être allumée et FAUX sinon
	 */
	protected boolean allume()
	{
		//Si l'autotamponneuse est déjà allumée ou si l'autotamponneuse n'est pas déjà occupée
		if(this.allumee || !this.occupee)
		{
			//On ne peut pas allumer l'autotamponneuse
			return false;
		}
		
		//L'autotamponneuse est désormais allumée
		this.allumee = true;
		
		return true;
	}
	
	/**
	 * Cette méthode permet d'éteindre l'autotamponneuse.
	 * @return VRAI si l'autotamponneuse a pu être éteinte et FAUX sinon
	 */
	protected boolean eteint()
	{
		//Si l'autotamponneuse n'est pas déjà allumée
		if(!this.allumee)
		{
			//On ne peut pas éteindre l'autotamponneuse
			return false;
		}
		
		//L'autotamponneuse est désormais éteinte
		this.allumee = false;
		
		//Si l'autotamponneuse est clignotante
		if(this.clignotante)
		{
			//On arrête son clignotement
			this.arreteClignotement();
		}
		
		return true;
	}
	
	/**
	 * Cette méthode permet de savoir si l'autotamponneuse est clignotante ou non.
	 * @return VRAI si l'autotamponneuse est clignotante et FAUX sinon
	 */
	public boolean estClignotante()
	{
		return this.clignotante;
	}
	
	/**
	 * Cette méthode permet de démarrer le clignotement de l'autotamponneuse.
	 * @return VRAI si le clignotement a pu être allumé et FAUX sinon
	 */
	protected boolean demarreClignotement()
	{
		//Si l'autotamponneuse est déjà clignotante ou si elle n'est pas déjà allumée
		if(this.clignotante || !this.allumee)
		{
			//On ne peut pas démarrer le clignotement
			return false;
		}
		
		//L'autotamponneuse est désormais clignotante
		this.clignotante = true;
		
		return true;
	}
	
	/**
	 * Cette méthode permet d'arrêter le clignotement de l'autotamponneuse.
	 * @return VRAI si le clignotement a pu être arrêté et FAUX sinon
	 */
	protected boolean arreteClignotement()
	{
		//Si l'autotamponneuse n'est pas déjà clignotante
		if(!this.clignotante)
		{
			//On ne peut pas éteindre le clignotement
			return false;
		}
		
		//Le clignotement de l'autotamponneuse est désormais éteint
		this.clignotante = false;
		
		return true;
	} 
	
	/**
	 * Cette méthode permet de calculer la distance entre l'autotamponneuse et une autre.
	 * @param autreAuto L'autre autotamponneuse
	 * @return La distance entre les deux autotamponneuses
	 */
	public double calculeDistance(Autotamponneuse autreAuto)
	{
		double distance = Math.sqrt((this.position[0] - autreAuto.position[0])
				* (this.position[0] - autreAuto.position[0])
				+ (this.position[1] - autreAuto.position[1])
				* (this.position[1] - autreAuto.position[1]));
		return distance;
	}
	
	/**
	 * Cette méthode permet de calculer la distance entre deux autotamponneuses.
	 * @param auto1 La première autotamponneuse
	 * @param auto2 La seconde autotamponneuse
	 * @return La distance entre les deux autotamponneuses
	 */
	public static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2)
	{
		double distance = Math.sqrt((auto1.position[0] - auto2.position[0])
				* (auto1.position[0] - auto2.position[0])
				+ (auto1.position[1] - auto2.position[1])
				* (auto1.position[1] - auto2.position[1]));
		return distance;
	}
	
	/**
	 * Cette méthode permet de vérifier si l'autotamponneuse est en collision avec une autre.
	 * @param autreAuto L'autre autotamponneuse
	 * @return VRAI s'il y a une collision entre les autotamponneuses et FAUX sinon
	 */
	public boolean collision(Autotamponneuse autreAuto)
	{
		/* Si la distance entre les autotamponneuses est inférieure à la distance minimale */
		if(this.calculeDistance(autreAuto) < DISTANCE_MINIMALE)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Cette méthode permet de vérifier si deux autotamponneuses sont en collision.
	 * @param auto1 La première autotamponneuse
	 * @param auto2 La seconde autotamponneuse
	 * @return VRAI s'il y a une collision entre les autotamponneuses et FAUX sinon
	 */
	public static boolean collision(Autotamponneuse auto1, Autotamponneuse auto2)
	{
		/* Si la distance entre les autotamponneuses est inférieure à la distance minimale */
		if(Autotamponneuse.calculeDistance(auto1, auto2) < DISTANCE_MINIMALE)
		{
			return true;
		}
		return false;
	}
	
	@Override
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
	
	@Override
	public boolean equals(Object autreObjet)
	{
		//Si l'objet de comparaison n'est pas instancié
		if(autreObjet == null)
		{
			//On peut affirmer que les deux objets ne sont pas égaux
			return false;
		}
		
		//Si l'autotamponneuse et l'objet de comparaison sont deux références pour le même objet
		if(this == autreObjet)
		{
			//On peut affirmer que les deux objets sont égaux
			return true;
		}
		
		//Si l'autotamponneuse et l'objet de comparaison n'ont pas la même classe
		if(this.getClass() != autreObjet.getClass())
		{
			//On peut affirmer que les deux objets ne sont pas égaux
			return false;
		}
		
		//On caste l'objet en autotamponneuse pour pouvoir comparer ses valeurs avec celles de l'autotamponneuse
		Autotamponneuse autreAuto = (Autotamponneuse) autreObjet;
		
		//Si les deux autotamponneuses n'ont pas le même placement
		if(this.position[0] != autreAuto.position[0]
				|| this.position[1] != autreAuto.position[1])
		{
			//On peut affirmer que les deux objets ne sont pas égaux
			return false;
		}
		
		//Si les attributs 'placee', 'occupee', 'allumee' et 'clignotante' des deux autotamponneuses ne sont pas identiques
		if(this.placee != autreAuto.placee
				|| this.occupee != autreAuto.occupee
				|| this.allumee != autreAuto.allumee
				|| this.clignotante != autreAuto.clignotante)
		{
			//On peut affirmer que les deux objets ne sont pas égaux
			return false;
		}
		
		//Si les deux autotamponneuses n'ont pas le même occupant
		if(this.nomOccupant != autreAuto.nomOccupant)
		{
			//On peut affirmer que les deux objets ne sont pas égaux
			return false;
		}
		
		//On peut affirmer que les deux objets sont égaux
		return true;
	}
	
	public static void main(String[] args)
	{
		Autotamponneuse auto1 = new Autotamponneuse();
		Autotamponneuse auto2 = new Autotamponneuse();
		
		// 1#4.1
		System.out.println();
		System.out.println("Question 1#4.1");
		System.out.println();
		System.out.println("L'autotamponeuse#1 est-elle occupée ? " + auto1.estOccupee());
		System.out.println("L'autotamponeuse#1 est-elle allumée ? " + auto1.estAllumee());
		System.out.println("L'autotamponeuse#1 est-elle clignotante ? " + auto1.estClignotante());
		
		// 1#5.2
		System.out.println();
		System.out.println("Question 1#5.2");
		System.out.println();
		System.out.println("ID de auto1 : " + auto1.id);
		System.out.println("ID de auto2 : " + auto2.id);
		
		// 1#6.2
		System.out.println();
		System.out.println("Question 1#6.2");
		System.out.println();
		System.out.println("Etat de auto1 : " + auto1.toString());
		System.out.println("Etat de auto2 : " + auto2.toString());
		
		// 1#7.2
		System.out.println();
		System.out.println("Question 1#7.2");
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
		
		// 1#8.4
		System.out.println();
		System.out.println("Question 1#8.4");
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
}
