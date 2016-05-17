package fr.pizzeria.factoryDao;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.commande.ICommandeDao;
import fr.pizzeria.dao.livreur.ILivreurDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public interface IFactoryDao {
	
	public abstract IPizzaDao createDAOPizza();
	public abstract IClientDao createDAOClient();
	public abstract ICommandeDao createDAOCommande();
	public abstract ILivreurDao createDAOLivreur();
	
}
