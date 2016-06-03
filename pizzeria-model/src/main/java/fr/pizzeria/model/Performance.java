package fr.pizzeria.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.pizzeria.model.annotation.ToString;

@Entity
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Service")
	private String service;
	@Column(name = "Date_Heure")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dateHeure;
	@Column(name = "Tps_Exec")
	//temps d'exécution en ms
	private Long tempsExecution;
	
	public Performance(String pservice, Calendar dateHeure) {
		this.service = pservice;
		this.dateHeure = dateHeure;
	}

	public Performance() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}

	public Calendar getDateHeure() {
		return dateHeure;
	}
	public void setDateHeure(Calendar dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Long getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
}
