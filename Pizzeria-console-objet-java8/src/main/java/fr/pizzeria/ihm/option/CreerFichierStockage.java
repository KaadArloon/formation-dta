package fr.pizzeria.ihm.option;

import fr.pizzeria.dao.PizzaDao;

public class CreerFichierStockage extends OptionMenu{

	private static final String CREER_FICHIERS_STOCKAGE_LIBELLE_MENU = "Créer et mettre à jour les fichiers de pizza";
	
	private PizzaDao pizzaDao;

	public CreerFichierStockage(PizzaDao pizzaDao) {
		super(CREER_FICHIERS_STOCKAGE_LIBELLE_MENU);
		this.pizzaDao = pizzaDao;
	}

	@Override
	public boolean execute(){

		return true;	
	}

}
