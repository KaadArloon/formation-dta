package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	public static int nbPizzas;
	private int id;
	@ToString
	private String code;
	@ToString(uppercase = true)
	private String nom;
	@ToString
	private double prix;
	@ToString
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
		String resultat = "";
		for (Field f : Pizza.class.getDeclaredFields()){
			ToString annotation = f.getAnnotation(ToString.class);
			if( annotation != null ){
				try {
					boolean uppercase = annotation.uppercase();
					
					Object valeurDuChamp = f.get(this);
					
					resultat += (uppercase ? valeurDuChamp.toString().toUpperCase() : valeurDuChamp) + " ";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		return resultat;
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
