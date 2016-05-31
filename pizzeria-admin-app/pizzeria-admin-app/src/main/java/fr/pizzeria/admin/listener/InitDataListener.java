package fr.pizzeria.admin.listener;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.admin.metier.PizzaService;

@WebListener
public class InitDataListener implements ServletContextListener {
	
	@Inject private PizzaService pizzaService;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0){
		pizzaService.importPizza();
	}
}
