package fr.pizzeria.dao;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.PizzaDaoSpringJPATestConfig;
import fr.pizzeria.dao.pizza.IPizzaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzaDaoSpringJPATestConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PizzaDaoSpringJPATest extends PizzaDaoTest {

	@Autowired
	public void setIPizzaDao(@Qualifier("pizzaDaoJPASpring") IPizzaDao ipd) {
		this.pizzaDao = ipd;
	}

}
