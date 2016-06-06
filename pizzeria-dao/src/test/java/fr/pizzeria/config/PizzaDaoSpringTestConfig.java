package fr.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJDBCTemplate;

@Configuration
@EnableTransactionManagement
public class PizzaDaoSpringTestConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db-schema.sql").addScript("db-data.sql").build();
	}
	
	@Bean
	public IPizzaDao pizzaDao() {
		return new PizzaDaoJDBCTemplate(dataSource(), txManager());
	}

	
	@Bean
	public PlatformTransactionManager txManager (){
		return new DataSourceTransactionManager(dataSource());
	}
}