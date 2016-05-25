package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

public class EditerPizzaController extends HttpServlet{
	
	private IPizzaDao pizzadao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			List<Pizza> list = pizzadao.afficherToutesPizzas();
			req.setAttribute("listpizzas", list);
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
		
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
