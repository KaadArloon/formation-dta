package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/pizzas/*" })
public class FiltreLogin implements Filter {
	private FilterConfig config = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest srvRequest = (HttpServletRequest) request;
		HttpServletResponse srvResponse = (HttpServletResponse) response;
		HttpSession session = srvRequest.getSession();
		
		Boolean testLogin = false;
		testLogin = (Boolean) session.getAttribute("identifie");
		if(testLogin!= null && testLogin){
			chain.doFilter(request, response);
		} else {
			srvResponse.sendRedirect(srvRequest.getContextPath()+"/login");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
