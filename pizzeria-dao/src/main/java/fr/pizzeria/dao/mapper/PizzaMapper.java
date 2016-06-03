package fr.pizzeria.dao.mapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.enumerer.CategoriePizza;

public class PizzaMapper implements RowMapper<Pizza>{
	
	@Override
	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException{
		Pizza p = new Pizza();
		p.setId(rs.getInt("ID"));
		p.setCode(rs.getString("ref"));
		p.setNom(rs.getString("nom"));
		p.setPrix(BigDecimal.valueOf(rs.getDouble("prix")));
		p.setCategorie(CategoriePizza.valueOf(rs.getString("categorie")));
		return p;
	}

}
