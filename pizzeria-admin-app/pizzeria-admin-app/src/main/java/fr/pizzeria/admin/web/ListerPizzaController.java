package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private IPizzaDao pizzaDao = IPizzaDao.DEFAULT_IMPLEMENTATION;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {
				List<Pizza> listePizza = pizzaDao.afficherToutesPizzas();
				req.setAttribute("listePizza", listePizza);
				RequestDispatcher rqd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
				rqd.forward(req, resp);
			} catch (DaoException e) {
				e.printStackTrace();
			}
	}

}
