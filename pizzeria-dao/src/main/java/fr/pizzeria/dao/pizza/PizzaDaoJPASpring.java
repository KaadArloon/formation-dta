package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoJPASpring implements IPizzaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired BatchAjoutPizza bap;

	

	@Override
	@Transactional
	public List<Pizza> afficherToutesPizzas() {
		return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
	}

	@Override
	@Transactional
	public void nouvellePizza(Pizza nvPizza){
		em.persist(nvPizza);
	}

	@Override
	@Transactional
	public void modifierPizza(String codePizza, Pizza updatePizza) {
		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza WHERE Ref=" + codePizza, Pizza.class);
		q.setParameter("codePizza", codePizza);
		Pizza p = q.getSingleResult();
		p.setCode(updatePizza.getCode());
		p.setNom(updatePizza.getNom());
		p.setPrix(updatePizza.getPrix());
		p.setCategorie(updatePizza.getCategorie());
	}

	@Override
	@Transactional
	public void supprimerPizza(String codePizza) {
		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza WHERE Ref=" + codePizza, Pizza.class);
		Pizza p = q.getSingleResult();
		if (p != null) {
			em.remove(p);
		}
	}

	@Override
	@Transactional
	public void importPizza() {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional
	public Pizza trouverPizza(String codePizza) {
		TypedQuery<Pizza> q = em.createQuery("SELECT p FROM Pizza p WHERE Ref=:code", Pizza.class).setParameter("code", codePizza);
		return q.getSingleResult();
	}

	@Override
	@Transactional
	public void ajoutPizzaLot(List<Pizza> listePizzas, int tailleLot) {
		List<List<Pizza>> partition = ListUtils.partition(listePizzas, tailleLot);
        partition.forEach(bap::ajoutPizza);
	}

}
