package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			resp.getWriter().write("Hello depuis la servlet");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
