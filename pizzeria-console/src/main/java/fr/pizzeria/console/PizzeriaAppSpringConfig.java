package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoDataJPA;
import fr.pizzeria.dao.pizza.PizzaDaoJDBCTemplate;

@Configuration
@ComponentScan({"fr.pizzeria.ihm", "fr.pizzeria.aspects"})
@EnableJpaRepositories("fr.pizzeria.dao.repository")
@EnableAspectJAutoProxy
public class PizzeriaAppSpringConfig {
	
	@Bean
	public PropertyPlaceholderConfigurer props(){
		PropertyPlaceholderConfigurer co = new PropertyPlaceholderConfigurer();
		co.setLocation(new ClassPathResource("jdbc.properties"));
		return co;
	}
	
	@Bean
	public DataSource dataSource(@Value("${jdbc.url}") String url, @Value("${jdbc.user}") String username, @Value("${jdbc.pass}") String password){
		return new DriverManagerDataSource(url, username, password);
	}
	
	@Bean
	public IPizzaDao pizzaDao() {
		return new PizzaDaoDataJPA();
	}
	
	/*@Bean
	public IPizzaDao pizzaDaoJDBC(@Value("${jdbc.url}") String url, @Value("${jdbc.user}") String username, @Value("${jdbc.pass}") String password) {
		return new PizzaDaoJDBCTemplate(dataSource(url, username, password), txManager(url, username, password));
	}*/
	
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	/*
	@Bean
	public PlatformTransactionManager transactionManager (@Value("${jdbc.url}") String url, @Value("${jdbc.user}") String username, @Value("${jdbc.pass}") String password){
		return new DataSourceTransactionManager(dataSource(url, username, password));
	}
	*/
	
	@Bean
	public PlatformTransactionManager transactionManager (){
		return new JpaTransactionManager();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		return Persistence.createEntityManagerFactory("pizzeria-console");
	}

}
