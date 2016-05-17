package fr.pizzeria.dao.client;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Client;

public class ClientDaoJpa implements IClientDao {
	
	EntityManagerFactory entityManagFact;

	public ClientDaoJpa(EntityManagerFactory emf) {
		entityManagFact = emf;
	}
	
	@Override
	public List<Client> afficherTousClients() throws DaoException {
		List<Client> clients = new ArrayList<>();
		EntityManager em = entityManagFact.createEntityManager();
		TypedQuery<Client> q = em.createQuery("SELECT c FROM Client c", Client.class);

		clients.addAll(q.getResultList());
		em.close();
		return clients;
	}

	@Override
	public void nouveauClient(Client nvClient) throws DaoException {
		EntityManager em = entityManagFact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(nvClient);
			et.commit();
			em.close();
		} catch (EntityExistsException e) {
			et.rollback();
			em.close();
			System.err.println(e);
		}
	}

	@Override
	public void modifierClient(String idClient, Client modClient) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerClient(String idClient) throws DaoException {
		EntityManager em = entityManagFact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			//TODO Delete Client
			et.commit();
			em.close();
		} catch (EntityExistsException e) {
			et.rollback();
			em.close();
			System.err.println(e);
		}
	}

}
