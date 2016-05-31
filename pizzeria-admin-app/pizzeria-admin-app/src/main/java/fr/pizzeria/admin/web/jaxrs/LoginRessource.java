package fr.pizzeria.admin.web.jaxrs;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/login")
public class LoginRessource {
	
	@Inject private TokenService tokenService;

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("email") String email, @FormParam("mdp") String mdp){
		Response resp = null;
		
		if("admin@pizzeria.fr".equals(email) && "admin".equals(mdp)){
			//cas OK
			
			//Génération de token
			String token = tokenService.generateToken();
			
			resp = Response.ok(token).build();
		}else{
			//Cas KO
			resp = Response.status(Status.FORBIDDEN).build();
		}
		
		return resp;
	}
}
