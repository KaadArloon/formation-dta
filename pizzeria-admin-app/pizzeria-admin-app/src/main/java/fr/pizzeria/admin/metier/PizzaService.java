package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

@Stateless
@TransactionManagement
public class PizzaService {

	@PersistenceContext(unitName = "pizzeriabdd")
	private EntityManager em;

	public List<Pizza> afficherToutesPizzas() {
		return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
	}

	public void nouvellePizza(Pizza nvPizza) {
		em.persist(nvPizza);
	}

	public void modifierPizza(String codePizza, Pizza modPizza) {
		if (trouverPizza(codePizza) != null) {
			em.merge(modPizza);
		} else {
			nouvellePizza(modPizza);
		}
	}

	public void supprimerPizza(String codePizza) {
		em.remove(trouverPizza(codePizza));
	}

	public void importPizza() {
		List<Pizza> lp = new ArrayList<>();
		lp.add(new Pizza("PEP", "Pépéroni", "12.5", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("MAR", "Margherita", "14", CategoriePizza.SANS_VIANDE, ""));
		lp.add(new Pizza("REI", "La Reine", "11.5", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("FRO", "La 4 fromages", "12", CategoriePizza.SANS_VIANDE, ""));
		lp.add(new Pizza("CAN", "La cannibale", "12.5", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("SAV", "La savoyarde", "13", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("ORI", "L'orientale", "13.5", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("IND", "L''indienne", "14", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("ILE", "Ilienne", "16", CategoriePizza.POISSON, ""));
		lp.add(new Pizza("SAU", "Sauvage", "25", CategoriePizza.VIANDE, ""));
		lp.add(new Pizza("POL", "Polonaise", "16", CategoriePizza.SANS_VIANDE, ""));
		lp.add(new Pizza("TWM", "Total War Medieval", "50", CategoriePizza.VIANDE, ""));
		
		for(Pizza p : lp){
			em.persist(p);
		}
	}

	public Pizza trouverPizza(String codePizza) {
		return em.createQuery("SELECT p FROM Pizza p WHERE p.code = '" + codePizza + "'", Pizza.class).getSingleResult();
	}
}
