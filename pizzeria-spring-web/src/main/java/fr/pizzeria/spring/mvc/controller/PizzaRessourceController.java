package fr.pizzeria.spring.mvc.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaRessourceController {
	
	@Autowired IPizzaDao pizzaDao;
	private static final Logger LOGGER = Logger.getLogger(PizzaRessourceController.class.getName());

	private static ObjectMapper sMapper = new ObjectMapper();  
	static {
	    sMapper.configure(Feature.IGNORE_UNKNOWN, false);  
	}
	
	public PizzaRessourceController() {
		LOGGER.log(Level.INFO, "Création du bean " + PizzaRessourceController.class);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> list() {
        return pizzaDao.afficherToutesPizzas();
    }
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Pizza post(@RequestBody Pizza pizza) {
        pizzaDao.nouvellePizza(pizza);
        return pizza;
    }

}
