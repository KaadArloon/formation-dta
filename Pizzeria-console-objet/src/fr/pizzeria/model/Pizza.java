package fr.pizzeria.model;

public class Pizza {
	public static int nbPizzas;
	private int id;
	private String code;
	private String nom;
	private double prix;
	
	public Pizza(String pcode, String pnom, double pprix){
		this.code = pcode;
		this.nom = pnom;
		this.prix = pprix;
		Pizza.nbPizzas++;
	}

	public Pizza() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

	public double getPrix() {
		return prix;
	}
}
