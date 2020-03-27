package com.feteforraine;

public class PisteAutotamponneuses
{
	private Autotamponneuse[] autotamponneuses;
	
	public PisteAutotamponneuses(int numberOfAutotamponneuse)
	{
		this.autotamponneuses = new Autotamponneuse[numberOfAutotamponneuse];
	}
	
	public static void main(String[] args)
	{
		// 1#12.2
		System.out.println();
		System.out.println("Question 1#12.2");
		System.out.println();
		
		//On crée une piste avec 10 autotamponneuses
		PisteAutotamponneuses piste = new PisteAutotamponneuses(9);
		
		boolean collision = false;
		
		//Pour chaque autotamponneuse de la piste
		for(int i = 0; i < piste.autotamponneuses.length; i++)
		{
			//On fait l'hypothèse qu'elle n'est en collision avec aucune autre autotamponneuse déjà placée
			collision = false;
			
			//On définie une position aléatoire sur une piste de 20x20 unités
			double positionX = Math.random() * 20;
			double positionY = Math.random() * 20;
			
			//On instancie l'autotamponeuse à la position aléatoire
			Autotamponneuse auto = new Autotamponneuse(positionX, positionY);
			
			//Pour chaque autotamponneuse déjà placée sur la piste
			for(int j = 0; j < i; j++)
			{
				//Si l'autotamponneuse qui vient d'être instanciée est en collision avec l'autotamponneuse déjà placée
				if(auto.collision(piste.autotamponneuses[j]))
				{
					//Il y a une collision
					collision = true;
					System.out.println("Il y a une collision entre l'auto#" + i + " et l'auto#" + j);
					
					//On arrête la boucle
					break;
				}
			}
			
			//S'il y a une collision
			if(collision)
			{
				//On n'ajoute pas la nouvelle autotamponneuse à la piste 
				System.out.println("L'auto#" + i + " n'a pas été ajoutée à la piste à la position (" + positionX + ";" + positionY + ")");
				
				//On recommence cette itération de la boucle 'for'
				i--;
			}
			//S'il n'y a pas de collision
			else
			{
				//On ajoute la nouvelle autotamponneuse à la piste
				piste.autotamponneuses[i] = auto;
				System.out.println("L'auto#" + i + " a été ajoutée à la piste à la position (" + positionX + ";" + positionY + ")");
			}
		}
		
		// 1#13.2
		System.out.println();
		System.out.println("Question 1#13.2");
		System.out.println();
		System.out.println(piste.toString());
		
		// 1#14.1
		System.out.println();
		System.out.println("Question 1#14.1");
		System.out.println();
		piste.dereglementAleatoire();
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < autotamponneuses.length; i++)
		{
			stringBuilder.append(autotamponneuses[i] + "\n");
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Cette méthode permet de simuler un jeu d'autotamponneuses.
	 * Les autotamponneuses se déplacent aléatoirement sur la piste jusqu'à ce qu'il en reste au plus 1.
	 * Cette autotamponneuse est déclarée gagnante (s'il n'en reste aucune, il n'y a pas de gagnant)
	 */
	public void dereglementAleatoire()
	{
		//Pour chaque autotamponneuse de la piste
		for(int l = 0; l < this.autotamponneuses.length; l++)
		{
			//On ajoute un occupant
			this.autotamponneuses[l].ajouteOccupant("occupant#" + (l+1));
			
			//On allume l'autotamponneuse
			this.autotamponneuses[l].allume();
		}
		
		//Pour l'instant, toutes les autotamponneuses sont en jeu
		int nombreAutotamponneusesEnJeu = this.autotamponneuses.length;
		
		//Le jeu commence au tour#1
		int tour = 1;
		
		//Tant qu'il y a plusieurs autotamponneuses en jeu
		while (nombreAutotamponneusesEnJeu > 1)
		{
			//Pour chaque autotamponneuse de la piste
			for(int i = 0; i < this.autotamponneuses.length; i++)
			{
				//Si l'autotamponneuse i est allumée
				if(this.autotamponneuses[i].estAllumee())
				{
					//On change sa position
					double positionX = Math.random() * 20;
					double positionY = Math.random() * 20;
					this.autotamponneuses[i].place(positionX, positionY);
					
					//Pour chaque autotamponneuse de la piste
					for(int j = 0; j < this.autotamponneuses.length; j++)
					{
						//Si l'autotamponneuse j est allumée
						if(this.autotamponneuses[j].estAllumee())
						{
							//Si les autotamponneuses i et j sont en collision (et qu'il ne s'agit pas de la même autotamponneuse)
							if(this.autotamponneuses[i] != this.autotamponneuses[j] && this.autotamponneuses[i].collision(this.autotamponneuses[j]))
							{
								//Si l'autotamponneuse i est toujours allumée
								if(this.autotamponneuses[i].estAllumee())
								{
									//On éteint l'autotamponneuse i
									this.autotamponneuses[i].eteint();
									System.out.println("L'autotamponneuse " + this.autotamponneuses[i].toString() + " est éliminée au tour#" + tour);
									
									//On éteint l'autotamponneuse j
									this.autotamponneuses[j].eteint();
									System.out.println("L'autotamponneuse " + this.autotamponneuses[j].toString() + " est éliminée au tour#" + tour);
									
									//Les deux autotamponneuses sont retirées du jeu
									nombreAutotamponneusesEnJeu -= 2;
								}
								//Si l'autotamponneuse i a été éteinte entre temps, donc si elle a déjà été en collision avec une autre autotamponneuse durant ce tour
								else
								{
									//On éteint l'autotamponneuse j
									this.autotamponneuses[j].eteint();
									System.out.println("L'autotamponneuse " + this.autotamponneuses[j].toString() + " est éliminée au tour#" + tour);
								
									//L'autotamponneuse j est retirée du jeu
									nombreAutotamponneusesEnJeu -= 1;
								}
							}
						}
					}
				}
			}
			tour++;
		}
		
		//S'il reste exactement une autotamponneuse en jeu
		if(nombreAutotamponneusesEnJeu == 1)
		{
			//On parcours les autotamponneuses de la piste
			for(int k = 0; k < this.autotamponneuses.length; k++)
			{
				//Si l'autotamponneuse est allumée
				if(this.autotamponneuses[k].estAllumee())
				{
					//Il s'agit de l'autotamponneuse gagnante
					System.out.println("L'autotamponneuse gagnante est l'auto : " + this.autotamponneuses[k].toString());
				}
			}
		}
		//S'il n'y a plus d'autotamponneuses en jeu
		else
		{
			//Aucune autotamponneuse ne gagne
			System.out.println("Il n'y a pas d'autotamponneuse gagnante");
		}
	}
}
