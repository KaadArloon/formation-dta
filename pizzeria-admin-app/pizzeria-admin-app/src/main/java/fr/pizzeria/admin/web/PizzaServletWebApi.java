package fr.pizzeria.admin.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaServletWebApi extends HttpServlet {

	@Inject
	private PizzaService pizzaService;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Pizza> pizzas = pizzaService.afficherToutesPizzas();
			PrintWriter out = resp.getWriter();
			out.println("<h1>" + pizzas.toString() + "</h1>");
		} catch (IOException e) {
			try {
				resp.sendError(501);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String categorie = req.getParameter("categorie");

		Pizza p = new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie), "");
		pizzaService.nouvellePizza(p);
	}
}