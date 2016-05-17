package fr.pizzeria.model.clefComposite;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CleCommandePizza {
	
	@Column(name = "ID_Commande")
	@ManyToOne
	Integer commandeId;
	
	@Column(name = "ID_Pizza")
	@ManyToOne
	Integer pizzaId;
}
