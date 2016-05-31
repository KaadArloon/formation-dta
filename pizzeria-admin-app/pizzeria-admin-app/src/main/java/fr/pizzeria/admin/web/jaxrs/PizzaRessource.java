package fr.pizzeria.admin.web.jaxrs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaRessource {
	
	@Inject PizzaService pizzaService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> listePizzas() {
		return pizzaService.afficherToutesPizzas();
		
	}
	
	@GET
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pizza pizzaByCode(@PathParam("code") String code){
		return pizzaService.trouverPizza(code);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void nouvellePizza(@FormParam("code") String code, @FormParam("nom") String nom, @FormParam("prix") String prix){
		Pizza nvPizza = new Pizza(code, nom, prix, null, "");
		pizzaService.nouvellePizza(nvPizza);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void nouvellePizza2(Pizza nvPizza){
		pizzaService.nouvellePizza(nvPizza);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void modifPizza(@FormParam("code") String code, @FormParam("nom") String nom, @FormParam("prix") String prix){
		Pizza modPizza = new Pizza(code, nom, prix, null, "");
		pizzaService.modifierPizza(code, modPizza);
	}
	
	@DELETE
	@Path("/{code}")
	@Produces(MediaType.APPLICATION_FORM_URLENCODED)
	@Consumes(MediaType.APPLICATION_JSON)
	public void supprPizza(@FormParam("code") String code) {
		pizzaService.supprimerPizza(code);
	}
	
}
