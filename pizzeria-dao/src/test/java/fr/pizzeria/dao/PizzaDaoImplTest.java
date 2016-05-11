package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	private PizzaDaoImpl pDAOI;
	private List<Pizza> listePizza;

	@Before
	public void testPizzaDaoImpl() {
		pDAOI = new PizzaDaoImpl();
		listePizza = new ArrayList<Pizza>();
		listePizza.add(new Pizza("PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listePizza.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("ORI", "L�orientale", 13.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("IND", "L�indienne", 14.00, CategoriePizza.VIANDE));
		listePizza.sort(Comparator.comparing(Pizza::getCode));
	}

	@Test
	public void testAfficherToutesPizzas() {
		List<Pizza> resultat = pDAOI.afficherToutesPizzas();
		resultat.sort(Comparator.comparing(Pizza::getCode));
		Pizza[] tabPizzaInit = listePizza.<Pizza>toArray(new Pizza[0]);
		Pizza[] tabPizzaRes = resultat.<Pizza>toArray(new Pizza[0]);
				
		assertArrayEquals(tabPizzaInit, tabPizzaRes);
	}

	@Test
	public void testNouvellePizzaCodeInexistant() throws DaoException {
		Pizza p = new Pizza("CODE_INEXISTANT", "Service apr�s vente", 5.00, CategoriePizza.POISSON);
		pDAOI.nouvellePizza(p);
		List<Pizza> lP = pDAOI.afficherToutesPizzas();
		assertTrue(lP.contains(p));
	}
	
	@Test(expected = SavePizzaException.class)
	public void testNouvellePizzaCodeExistant() throws DaoException {
		Pizza p = new Pizza("PEP", "Nouveau nom", 15, CategoriePizza.VIANDE);
		pDAOI.nouvellePizza(p);	
	}
	
	@Test
	public void testUpdatePizzaCodeExistant() throws DaoException {
		Pizza updatePizza = new Pizza("PEP", "PEP2", 15, CategoriePizza.VIANDE);
		pDAOI.modifierPizza("PEP", updatePizza);
		List<Pizza> listPizzas = pDAOI.afficherToutesPizzas();
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertTrue(pizzaOpt.isPresent());
		Pizza pizzaTrouve = pizzaOpt.get();
		assertEquals("PEP", pizzaTrouve.getCode());
		assertEquals("PEP2", pizzaTrouve.getNom());
		assertTrue(pizzaTrouve.getPrix() == 15.0);
		assertEquals(CategoriePizza.VIANDE, pizzaTrouve.getCategorie());
	}

	@Test
	public void testDeletePizza() throws DaoException {
		List<Pizza> listPizzas = pDAOI.afficherToutesPizzas();
		assertEquals(8, listPizzas.size());
		pDAOI.supprimerPizza("PEP");
		listPizzas = pDAOI.afficherToutesPizzas();
		assertEquals(7, listPizzas.size());
		Optional<Pizza> pizzaOpt = listPizzas.stream().filter(p -> "PEP".equals(p.getCode())).findFirst();
		assertFalse(pizzaOpt.isPresent());
	}
	
	@Test(expected = DeletePizzaException.class)
	public void testDeletePizzaCodeInexistant() throws DaoException {
		pDAOI.supprimerPizza("PEP1");
	}

}
