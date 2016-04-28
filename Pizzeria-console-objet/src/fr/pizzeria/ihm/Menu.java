package fr.pizzeria.ihm;

import java.util.Scanner;

public class Menu {
	
	public String titre;
	public OptionMenu [] listeOptions;
	public Scanner sc = new Scanner(System.in);
	
	public void afficher(){
		System.out.println("**** " + titre +" ****");
		int i = 1;
		for(OptionMenu opt : listeOptions){
			System.out.println(i + " -> " + opt.getLibelle());
			i++;
		}
	}
	public Menu(){
		
	}
	
}
