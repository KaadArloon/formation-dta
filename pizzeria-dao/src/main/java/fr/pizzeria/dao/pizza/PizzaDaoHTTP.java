package fr.pizzeria.dao.pizza;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoHTTP implements IPizzaDao {

	private Client client = ClientBuilder.newClient();
	WebTarget target = client.target("http://localhost:8080");

	public PizzaDaoHTTP(EntityManagerFactory emf) throws DaoException {
		
	}

	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		List<Pizza> pizzas = new ArrayList<>();
		return pizzas;
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) throws DaoException {
		
	}

	@Override
	public void modifierPizza(String codePizza, Pizza updatePizza) throws DaoException {
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		
	}

	@Override
	public void importPizza() throws DaoException {
		
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		return null;
	}

	@Override
	public void ajoutPizzaLot(List<Pizza> listePizzas, int tailleLot) {
		// TODO Auto-generated method stub
		
	}

}