package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import fr.pizzeria.model.annotation.ToString;
import fr.pizzeria.model.enumerer.CategoriePizza;

@Entity
public class Pizza {

	private static int nbPizzas;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@ToString
	@Column(name = "Ref", unique = true)
	private String code;
	@ToString(uppercase = true)
	@Column(name = "Nom")
	private String nom;
	@ToString
	@Column(name = "Prix")
	private BigDecimal prix;
	
	@Column(name = "Image")
	private String urlImage;

	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "Categorie")
	private CategoriePizza categorie;

	private static final Map<String, String> FORMAT = new HashMap<>();
	private static final String AUTRE_FORMAT = "(%s)";

	static {
		FORMAT.put("code", "%s ->");
		FORMAT.put("nom", "%s ***");
	}

	public Pizza(String pcode, String pnom, String pprix, CategoriePizza pcategorie, String purlImage) {
		this.code = pcode;
		this.nom = pnom;
		this.prix = new BigDecimal(pprix);
		this.categorie = pcategorie;
		this.urlImage = purlImage;
		nbPizzas++;
	}

	public Pizza() {
		super();
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
		return new EqualsBuilder().append(code, other.code).append(nom, other.nom).isEquals();
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

	public BigDecimal getPrix() {
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

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
