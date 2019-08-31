package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Domain;
import domain.DummyAplicationRepository;

@WebServlet("/login")
public class Login  extends HttpServlet{
	

		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DummyAplicationRepository repo = new DummyAplicationRepository();
		List<Domain> db =repo.getAllRecords();
		HttpSession session = request.getSession();
		response.setContentType("text/html");
    	String login=request.getParameter("Username");
    	String pass=request.getParameter("Password");
		
		for(Domain x: db)
		{
			if(pass.equals(x.getCPassword()) && login.equals(x.getUsername()))
			{
				session.setAttribute("log", "true");
				session.setAttribute("p", x.getPrivlage());
				session.setAttribute("username", x.getUsername());
				response.sendRedirect("logsite.jsp");
			}
				
			
		}

		response.getWriter().println("Wrong login or username");
		response.getWriter().println("<a href='/login.jsp'>try again</a>");
	
	}

}
