package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoSpringTestConfig;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzaDaoSpringTestConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class PizzaDaoTest {

	private static final int NB_PIZZAS_INIT = 13;
	
	protected IPizzaDao pizzaDao;
	
	@Test
	public void testAfficherToutesPizzas()  throws DaoException{
		List<Pizza> pizzas = pizzaDao.afficherToutesPizzas();
		assertEquals(NB_PIZZAS_INIT, pizzas.size());
	}
	
	@Test
	public void testNouvellePizza() throws DaoException{
		Pizza p = new Pizza("WOL", "Wololo", "10", CategoriePizza.POISSON, null);
		pizzaDao.nouvellePizza(p);
		List<Pizza> pizzas = pizzaDao.afficherToutesPizzas();
		assertEquals(NB_PIZZAS_INIT + 1, pizzas.size());
		Pizza pRes = pizzaDao.trouverPizza("WOL");
		assertEquals("Wololo", pRes.getNom());
	}
	
	@Test
	public void testModifierPizza() throws DaoException{
		assertFalse(true);
	}
	
	@Test
	public void testSupprimerPizza() throws DaoException{
		assertFalse(true);
	}
	
	@Test
	public void testImportPizza() throws DaoException{
		assertTrue(true);
	}
	
	@Test
	public void testTrouverPizza(){
		assertFalse(true);
	}
	
	@Test
	public void testAjoutPizzaLot() throws DaoException{
		List<Pizza> listePizzas = new ArrayList<>();
		listePizzas.add(new Pizza("aaa", "a", "1", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("bbb", "b", "2", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("ccc", "c", "3", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("ddd", "d", "1", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("eee", "e", "2", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("fff", "f", "3", CategoriePizza.VIANDE, ""));
		int tailleLot = 3;
		
		pizzaDao.ajoutPizzaLot(listePizzas, tailleLot);
		List<Pizza> pizzas = pizzaDao.afficherToutesPizzas();
		Assert.assertEquals(NB_PIZZAS_INIT + 6, pizzas.size());
	}
	
	@Test
	public void testAjoutPizzaLotFailed() throws DaoException{
		List<Pizza> listePizzas = new ArrayList<>();
		listePizzas.add(new Pizza("aaa", "a", "1", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("bbb", "b", "2", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("ccc", "c", "3", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("ddd", "d", "1", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("PEP", "e", "2", CategoriePizza.VIANDE, ""));
		listePizzas.add(new Pizza("fff", "f", "3", CategoriePizza.VIANDE, ""));
		int tailleLot = 3;
		try {
			pizzaDao.ajoutPizzaLot(listePizzas, tailleLot);
			Assert.fail("une exception aurait du être lancée");
		} catch (PersistenceException | DataAccessException e) {
			List<Pizza> pizzas = pizzaDao.afficherToutesPizzas();
			Assert.assertEquals(NB_PIZZAS_INIT + 3, pizzas.size());
		}
	}
}
