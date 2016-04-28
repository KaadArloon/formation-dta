package fr.pizzeria.model;

public class Pizza {
	public static int nbPizzas;
	public int id;
	public String code;
	public String nom;
	public double prix;
	
	public Pizza(String pcode, String pnom, double pprix){
		this.code = pcode;
		this.nom = pnom;
		this.prix = pprix;
		Pizza.nbPizzas++;
	}

	public Pizza() {
		super();
	}
}
