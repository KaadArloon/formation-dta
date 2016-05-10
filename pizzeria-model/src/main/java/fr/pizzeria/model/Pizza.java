package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	public Pizza(String pcode, String pnom, double pprix, CategoriePizza pcategorie) {
		this.code = pcode;
		this.nom = pnom;
		this.prix = pprix;
		this.categorie = pcategorie;
		Pizza.nbPizzas++;
	}

	public Pizza() {
		super();
	}

	private final static Map<String, String> FORMAT = new HashMap<String, String>();
	private final static String AUTRE_FORMAT = "(%s)";

	static {
		FORMAT.put("code", "%s ->");
		FORMAT.put("nom", "%s ***");
	}

	@Override
	public String toString() {
		return Arrays.asList(this.getClass().getDeclaredFields()).stream()
				.filter(field -> field.getAnnotation(ToString.class) != null).map(getValeurDuChamp())
				.collect(Collectors.joining(" "));
	}

	private Function<? super Field, ? extends String> getValeurDuChamp() {
		return field -> {

			String resultat = "";
			try {
				resultat = field.getAnnotation(ToString.class).uppercase() ? field.get(this).toString().toUpperCase()
						: field.get(this).toString();
			} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
				e1.printStackTrace();
			}

			String formatResultat = FORMAT.get(field.getName()) == null ? AUTRE_FORMAT : FORMAT.get(field.getName());

			return String.format(formatResultat, resultat);
		};
	}

	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(code).append(nom).append(prix).append(categorie).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		return new EqualsBuilder().append(code, other.code).append(nom, other.nom)
				.append(prix, other.prix).isEquals();
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
