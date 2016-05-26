package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

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
		//TODO modifier
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		EntityManager em = entityManagFact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza WHERE Ref=" + codePizza, Pizza.class);
			Pizza p = q.getSingleResult();
			if (p != null){
				em.remove(p);
			}
			et.commit();
			em.close();
		} catch (EntityExistsException e) {
			et.rollback();
			em.close();
			System.err.println(e);
		}
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