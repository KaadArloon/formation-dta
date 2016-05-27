package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {

	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			RequestDispatcher rqd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
			String code = (String) req.getParameter("code");
			Pizza pizza = pizzaService.trouverPizza(code);
			req.setAttribute("pizza", pizza);
			
			rqd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		Pizza pizza = new Pizza(code, nom, prix, null, "");
		pizza.setId(id);
		pizzaService.modifierPizza(code, pizza);
		resp.setStatus(201);
		resp.sendRedirect(req.getContextPath()+"/pizzas/list");
	}
	
	

}
