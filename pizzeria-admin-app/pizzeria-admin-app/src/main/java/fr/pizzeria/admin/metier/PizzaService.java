package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

public class PizzaService {

	@PersistenceContext(unitName = "pizzeria-admin-web")
	private EntityManager em;

	public List<Pizza> afficherToutesPizzas(){
		return em.createQuery("SELECT * FROM Pizza p", Pizza.class).getResultList();
	}

	public void nouvellePizza(Pizza nvPizza) {
		em.persist(nvPizza);
	}

	public void modifierPizza(String codePizza, Pizza modPizza) {
		if(trouverPizza(codePizza) != null){
			em.merge(modPizza);
		} else {
			nouvellePizza(modPizza);
		}
	}

	public void supprimerPizza(String codePizza) {
		em.remove(trouverPizza(codePizza));
	}
	
	@Deprecated
	public void importPizza() {
	}

	public Pizza trouverPizza(String codePizza) {
		return em.createQuery("SELECT * FROM Pizza p WHERE code=:code", Pizza.class).getSingleResult();
	}
}
