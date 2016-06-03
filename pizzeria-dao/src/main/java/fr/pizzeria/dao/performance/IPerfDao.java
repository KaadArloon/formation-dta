package fr.pizzeria.dao.performance;

import java.util.List;

import fr.pizzeria.model.Performance;

public interface IPerfDao {
	List<Performance> afficherToutesPerformances();
	void nouvellePerformance(Performance nvPerformance);
}
