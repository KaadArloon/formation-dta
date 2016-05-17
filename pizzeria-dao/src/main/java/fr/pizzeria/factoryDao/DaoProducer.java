package fr.pizzeria.factoryDao;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJpa;
import fr.pizzeria.dao.pizza.PizzaDaoJpa;
import fr.pizzeria.exception.DaoException;

public class DaoProducer {

	public  IFactoryDao getDaoFactoryJpa(EntityManagerFactory emf) throws DaoException{
		return new GenericFactory(new PizzaDaoJpa(emf), new ClientDaoJpa(emf));
	}

	public IFactoryDao getDaoFactoryJdbc(EntityManagerFactory emf){
		return null;
	}

	public IFactoryDao getDaoFactoryFichier(EntityManagerFactory emf){
		return null;
	}

	public IFactoryDao getDaoFactoryImpl(EntityManagerFactory emf){
		return null;
	}

}
