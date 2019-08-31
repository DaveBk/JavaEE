package web.filtr;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.DummyAplicationRepository;

@WebFilter({"/","/Add"})
public class RegisterFilter implements Filter{
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)
	throws IOException,ServletException{
		if(new DummyAplicationRepository().count()>10)
		{
			response.getWriter().print("Utworzy³eœ za du¿o u¿ytkowników");
			return;
		}
		chain.doFilter(request, response);
	}
	@Override
	public void destroy(){
	
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException{
		
	}



}
