package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class PizzaServletWebApi extends HttpServlet{

	private IPizzaDao pizzadao = new PizzaDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			List<Pizza> listPizzas = pizzadao.afficherToutesPizzas();
			resp.getWriter().write(listPizzas.toString());
		} catch (DaoException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
