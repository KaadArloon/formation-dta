package fr.pizzeria.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.pizzeria.model.enumerer.StatutCommande;

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "Num_Commande")
	private Integer numCommande;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Statut")
	private StatutCommande statut;
	
	@Column(name = "DateCommande")
	private Date dateCommande;
	
	@Column(name = "ID_Livreur")
	@ManyToOne
	private Integer idLivreur;
	
	@Column(name = "ID_Client")
	@ManyToOne
	private Integer idClient;
	
	public Commande(Integer numCommande, StatutCommande statut, Date dateCommande, Integer idLivreur, Integer idClient) {
		super();
		this.numCommande = numCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.idLivreur = idLivreur;
		this.idClient = idClient;
	}

	public StatutCommande getStatut() {
		return statut;
	}

	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Integer getIdLivreur() {
		return idLivreur;
	}

	public void setIdLivreur(Integer idLivreur) {
		this.idLivreur = idLivreur;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumCommande() {
		return numCommande;
	}
	
}
