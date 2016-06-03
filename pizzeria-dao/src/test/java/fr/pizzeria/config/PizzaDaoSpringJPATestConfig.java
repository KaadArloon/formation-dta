package fr.pizzeria.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("fr.pizzeria.dao")
public class PizzaDaoSpringJPATestConfig {

	
	
	@Bean
	public EntityManagerFactory emf(){
		return Persistence.createEntityManagerFactory("pizzeria-console");
	}
	
	@Bean
	public PlatformTransactionManager txManager (){
		return new JpaTransactionManager();
	}
	
	@Bean
	PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
