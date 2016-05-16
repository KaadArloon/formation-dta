package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements PizzaDao {

	EntityManagerFactory entityManagFact;

	public PizzaDaoJpa(EntityManagerFactory emf) throws DaoException {
		entityManagFact = emf;
	}

	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		List<Pizza> pizzas = new ArrayList<>();
		EntityManager em = entityManagFact.createEntityManager();
		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p", Pizza.class);

		pizzas.addAll(q.getResultList());
		em.close();
		return pizzas;
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) throws DaoException {
		EntityManager em = entityManagFact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(nvPizza);
			et.commit();
			em.close();
		} catch (EntityExistsException e) {
			et.rollback();
			em.close();
			System.err.println(e);
		}
	}

	@Override
	public void modifierPizza(String codePizza, Pizza updatePizza) throws DaoException {
		
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		EntityManager em = entityManagFact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();

			et.commit();
			em.close();
		} catch (EntityExistsException e) {
			et.rollback();
			em.close();
			System.err.println(e);
		}
	}

}