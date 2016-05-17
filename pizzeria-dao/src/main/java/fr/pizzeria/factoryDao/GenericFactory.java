package fr.pizzeria.factoryDao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.commande.ICommandeDao;
import fr.pizzeria.dao.livreur.ILivreurDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class GenericFactory implements IFactoryDao {
	
	private IPizzaDao pizzaDao;
	private IClientDao clientDao;


	public GenericFactory(IPizzaDao pizzaDao, IClientDao clientDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.clientDao = clientDao;
	}

	@Override
	public IPizzaDao createDAOPizza() {
		return null;
	}

	@Override
	public IClientDao createDAOClient() {
		return null;
	}

	@Override
	public ICommandeDao createDAOCommande() {
		return null;
	}

	@Override
	public ILivreurDao createDAOLivreur() {
		return null;
	}

}
