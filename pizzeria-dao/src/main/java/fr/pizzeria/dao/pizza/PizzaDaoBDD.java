package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaDaoBDD implements IPizzaDao {

	private String url;
	private String user;
	private String pass;
	
	private Connection connection;
	private Statement statement;

	public PizzaDaoBDD(String driver, String url2, String user2, String pass2) throws DaoException {
		try {
			Class.forName(driver);
			this.url = url2;
			this.user = user2;
			this.pass = pass2;
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		List<Pizza> pizzas = new ArrayList<>();
		try (Connection connection = getConnection();
				Statement st = connection.createStatement();
				ResultSet result = st.executeQuery("select * from pizza");) {
			while (result.next()) {
				Pizza pizza = new Pizza();
				pizza.setCode(result.getString("code"));
				pizza.setId(result.getInt("id"));
				pizza.setNom(result.getString("nom"));
				pizza.setPrix(BigDecimal.valueOf(result.getDouble("prix")));
				pizza.setCategorie(CategoriePizza.valueOf(result.getString("categorie")));
				pizzas.add(pizza);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return pizzas;
	}

	@Override
	public void nouvellePizza(Pizza newPizza) throws DaoException {
		try (Connection connection = getConnection(); Statement st = connection.createStatement();) {
			int nbLignesAffectes = st
					.executeUpdate(String.format("insert into pizza(code,nom,prix,categorie) VALUES('%s','%s',%s,'%s')",
							newPizza.getCode(), newPizza.getNom(), newPizza.getPrix(), newPizza.getCategorie().name()));

			if (nbLignesAffectes == 0) {
				throw new SavePizzaException("Aucune ligne insérée en base de données");
			}

		} catch (SQLException e) {
			throw new SavePizzaException(e);
		}
	}

	@Override
	public void modifierPizza(String codePizza, Pizza updatePizza) throws DaoException {
		try (Connection connection = getConnection(); Statement st = connection.createStatement();) {
			int nbLignesAffectes = st.executeUpdate(String.format(
					"update pizza set code='%s',nom='%s',prix=%s,categorie='%s' where code='%s'", updatePizza.getCode(),
					updatePizza.getNom(), updatePizza.getPrix(), updatePizza.getCategorie().name(), codePizza));

			if (nbLignesAffectes == 0) {
				throw new UpdatePizzaException("Aucune ligne mise à jour en base de données");
			}

		} catch (SQLException e) {
			throw new UpdatePizzaException(e);
		}
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		try (Connection connection = getConnection(); Statement st = connection.createStatement();) {
			int nbLignesAffectes = st.executeUpdate(String.format("delete from pizza where code='%s'", codePizza));

			if (nbLignesAffectes == 0) {
				throw new DeletePizzaException("Aucune ligne supprimée en base de données");
			}

		} catch (SQLException e) {
			throw new DeletePizzaException(e);
		}
	}
	
	
	
	private void connectionAutoCommit() throws DeletePizzaException{
		try (Connection connect = getConnection(); Statement st = connection.createStatement();) {
			connection = connect;
			statement = st;
		} catch (SQLException e) {
			throw new DeletePizzaException(e);
		}
		
	}

	@Override
	public void importPizza() throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

}