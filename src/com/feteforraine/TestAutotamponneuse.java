package com.feteforraine;

public class TestAutotamponneuse 
{
	public static void main(String[] args) 
	{
		Autotamponneuse auto1 = new Autotamponneuse();
		Autotamponneuse auto2 = new Autotamponneuse();
		
		// 1#4.3
		System.out.println();
		System.out.println("Question 1#4.3");
		System.out.println();
		System.out.println("L'autotamponeuse#1 est-elle occupée ? " + auto1.estOccupee());
		System.out.println("L'autotamponeuse#1 est-elle allumée ? " + auto1.estAllumee());
		System.out.println("L'autotamponeuse#1 est-elle clignotante ? " + auto1.estClignotante());	
		
		// 1#8.4
		System.out.println();
		System.out.println("Question 1#8.4");
		System.out.println();
		System.out.println("Je place l'autotamponneuse#1 à la position (2.4,5.6)");
		auto1.place(2.4f, 5.6f);
		System.out.println("Je place l'autotamponneuse#2 à la position (2.3,4.1)");
		auto2.place(2.3f, 4.1f);
		System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + auto1.collision(auto2));
		System.out.println("Je place l'autotamponneuse#2 à la position (10.3,4.1)");
		auto2.place(10.3f, 4.1f);
		System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + auto1.collision(auto2));
		
		// 1#9.3
		System.out.println();
		System.out.println("Question 1#9.3");
		System.out.println();
		System.out.println("Je place l'autotamponneuse#1 à la position (2.4,5.6)");
		auto1.place(2.4f, 5.6f);
		System.out.println("Je place l'autotamponneuse#2 à la position (2.3,4.1)");
		auto2.place(2.3f, 4.1f);
		System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + Autotamponneuse.collision(auto1,auto2));
		System.out.println("Je place l'autotamponneuse#2 à la position (10.3,4.1)");
		auto2.place(10.3f, 4.1f);
		System.out.println("Les autotamponneuses 1 et 2 sont-elles en collision ? " + Autotamponneuse.collision(auto1,auto2));
	
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
}