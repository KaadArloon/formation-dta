package fr.pizzeria.dao.client;

import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public interface IClientDao {

	List<Client> afficherTousClients() throws DaoException;
	
	void nouveauClient(Client nvClient) throws DaoException;

	void modifierClient(String idClient, Client modClient) throws DaoException;

	void supprimerClient(String idClient) throws DaoException;
}
