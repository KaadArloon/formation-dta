package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.mysql.jdbc.log.Log;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaServletWebApi extends HttpServlet{

	private static final Logger LOG = Logger.getLogger(PizzaServletWebApi.class.toString());
	private IPizzaDao pizzadao = new PizzaDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		try {
			List<Pizza> listPizzas = pizzadao.afficherToutesPizzas();
			resp.getWriter().write(listPizzas.toString());
		} catch (DaoException e) {
			resp.sendError(500,"Déolé :'(");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prix = req.getParameter("prix");
		String categorie = req.getParameter("categorie");
		
		if(StringUtils.isBlank(code) || StringUtils.isBlank(nom) || StringUtils.isBlank(prix) || StringUtils.isBlank(categorie)){
			Pizza nvPizza = new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie.toString()), "");
				
			LOG.info("POST bien reçu");			
		}
	}
}
