package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import fr.pizzeria.dao.mapper.PizzaMapper;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.model.Pizza;

@Transactional
@Repository
public class PizzaDaoJDBCTemplate implements IPizzaDao {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate txTemplate;

	@Autowired
	public PizzaDaoJDBCTemplate(DataSource dataSource, PlatformTransactionManager txManager) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		txTemplate = new TransactionTemplate(txManager);
	}

	@Override
	public List<Pizza> afficherToutesPizzas() throws DaoException {
		String sql = "SELECT * FROM pizza";
		return jdbcTemplate.query(sql, new PizzaMapper());
	}

	@Override
	public void nouvellePizza(Pizza nvPizza) {
		String sql = "INSERT INTO pizza (Ref, Nom, Prix, Categorie) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, nvPizza.getCode(), nvPizza.getNom(), nvPizza.getPrix().toString(),
				nvPizza.getCategorie().toString().toUpperCase());
	}

	@Override
	public void modifierPizza(String codePizza, Pizza modPizza) throws DaoException {
		String sql = "UPDATE pizza SET Ref = ?, Nom = ?, Prix = ?, Categorie = ? WHERE Ref = ?";
		jdbcTemplate.update(sql, modPizza.getCode(), modPizza.getNom(), modPizza.getPrix().toString(),
				modPizza.getCategorie().toString().toUpperCase(), codePizza);
	}

	@Override
	public void supprimerPizza(String codePizza) throws DaoException {
		String sql = "DELETE FROM pizza WHERE Ref = ?";
		jdbcTemplate.update(sql, codePizza);
	}

	@Override
	public void importPizza() throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		String sql = "SELECT * FROM pizza WHERE Ref = ?";
		return jdbcTemplate.queryForObject(sql, new PizzaMapper(), codePizza);
	}

	@Transactional
	public void ajoutPizzaLot(List<Pizza> listePizzas, int tailleLot)  {
		ListUtils.partition(listePizzas, tailleLot).forEach(list -> {
			this.txTemplate.execute(status -> {
				list.forEach(this::nouvellePizza);
				return null;
			});
		});
	}
}
