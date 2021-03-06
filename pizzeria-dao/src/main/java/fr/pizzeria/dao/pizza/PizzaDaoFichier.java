package fr.pizzeria.dao.pizza;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaDaoFichier implements IPizzaDao {
	
	private static final String REPERTOIRE_DATA = "data";

	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		
		try {
			return Files.list(Paths.get(REPERTOIRE_DATA))
				.map(path -> {
					Pizza p = new Pizza();
					p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
					try {
						String ligne = Files.readAllLines(path).get(0);
						String[] ligneTab = ligne.split(";");
						p.setNom(ligneTab[0]);
						p.setPrix(BigDecimal.valueOf(Double.valueOf(ligneTab[1])));
						p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return p;
				})
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}
	
	private String convertPizzaToString(Pizza p) {
		return p.getNom() + ";" + p.getPrix() + ";" + p.getCategorie().name();
	}
	

	@Override
	public void nouvellePizza(Pizza newPizza) throws DaoException {
		try {
			Path nouveauFichier = Paths.get(REPERTOIRE_DATA + "/" + newPizza.getCode() + ".txt");
			Files.write(nouveauFichier, Arrays.asList(convertPizzaToString(newPizza)), StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void modifierPizza(String codePizza, Pizza updatePizza) throws DaoException {
		//TODO implements
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		//TODO implements
	}

	@Override
	public void importPizza() throws DaoException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

}