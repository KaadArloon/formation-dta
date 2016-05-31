package fr.pizzeria.admin.web.jaxrs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenService {
	private List<String> tokensValides = new ArrayList<>();
	
	public String generateToken(){
		String token = UUID.randomUUID().toString();
		tokensValides.add(token);
		return token;
	}
	
	public boolean isTokenValid(String token){
		return tokensValides.contains(token);
	}
}
