package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichier implements PizzaDao {
	private Path repertoire = Paths.get("data");


@Override
public List<Pizza> afficherToutesPizzas() {
	try {
		return Files.list(repertoire)
			.map(path -> {
				Pizza p = new Pizza();

				p.setCode(path.getFileName().toString().replaceAll(".txt", ""));
				try {
					String ligne = Files.readAllLines(path).get(0);
					String[] ligneTab = ligne.split(":");
					p.setNom(ligneTab[0]);
					p.setPrix(Double.valueOf(ligneTab[1]));
					p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
				} catch (IOException e) {
					e.printStackTrace();
				}
									
				return p;
			}).collect(Collectors.toList());
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

@Override
public void nouvellePizza(Pizza nvPizza) throws DaoException {
	// TODO Auto-generated method stub
	
}

@Override
public void modifierPizza(String codePizza, Pizza modPizza) throws DaoException {
	// TODO Auto-generated method stub
	
}

@Override
public void supprimerPizza(String codePizza) throws DaoException {
	// TODO Auto-generated method stub
	
}
}
