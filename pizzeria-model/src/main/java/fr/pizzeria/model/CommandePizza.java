package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import fr.pizzeria.model.clefComposite.CleCommandePizza;

@Entity
public class CommandePizza {
	
	@EmbeddedId private CleCommandePizza id;
	
	@Column(name = "qte_Pizza")
	private Integer qtePizza;

	public CommandePizza(CleCommandePizza id, Integer qtePizza) {
		super();
		this.id = id;
		this.qtePizza = qtePizza;
	}

	public CleCommandePizza getId() {
		return id;
	}

	public Integer getQtePizza() {
		return qtePizza;
	}

	public void setQtePizza(Integer qtePizza) {
		this.qtePizza = qtePizza;
	}
	
}
