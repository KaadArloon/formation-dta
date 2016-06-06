package fr.pizzeria.dao.performance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.dao.repository.IPerfRepository;
import fr.pizzeria.model.Performance;

@Transactional
public class PerformanceDaoDataJPA implements IPerfDao{
	
	@Autowired IPerfRepository perfRepository;

	@Override
	public List<Performance> afficherToutesPerformances() {
		return perfRepository.findAll();
	}

	@Override
	public void nouvellePerformance(Performance nvPerformance) {
		perfRepository.save(nvPerformance);
	}
	
}
