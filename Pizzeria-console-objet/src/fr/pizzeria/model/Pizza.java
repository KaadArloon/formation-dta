package fr.pizzeria.model;

public class Pizza {
	public static int nbPizzas;
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	
	public Pizza(String pcode, String pnom, double pprix, CategoriePizza pcategorie){
		this.code = pcode;
		this.nom = pnom;
		this.prix = pprix;
		this.categorie = pcategorie;
		Pizza.nbPizzas++;
	}

	public Pizza() {
		super();
	}
	
	@Override
	public String toString() {
		return this.code + " -> " + this.nom + " (" + this.prix + "€) -- " + this.categorie;
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
	
	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
