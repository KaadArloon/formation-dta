package fr.pizzeria.ihm.option;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class CreerFichierStockage extends OptionMenu{

	private static final String CREER_FICHIERS_STOCKAGE_LIBELLE_MENU = "Cr�er et mettre � jour les fichiers de pizza";
	
	private IPizzaDao pizzaDao;

	public CreerFichierStockage(IPizzaDao pizzaDao) {
		super(CREER_FICHIERS_STOCKAGE_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute(){

		return true;	
	}

}
