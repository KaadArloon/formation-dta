package fr.pizzeria.aspects;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;

@Aspect
@Component
public class TpsExecEnBdd {

	@Around("execution(* fr.pizzeria.dao.pizza.IPizzaDao.*(..))")
	public Object toutesMethodeDaoPizza(ProceedingJoinPoint pjp) throws Throwable {
		Performance perf = new Performance("", Calendar.getInstance());
		Long start = System.nanoTime();

		Object resultat = pjp.proceed();
		
		Long end = System.nanoTime();
		perf.setTempsExecution((end - start) / 1000000);
		return resultat;
	}

}
