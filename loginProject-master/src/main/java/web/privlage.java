package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Domain;
import domain.DummyAplicationRepository;

@WebServlet("/privlage")
public class privlage  extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DummyAplicationRepository repo = new DummyAplicationRepository();
		List<Domain> db =repo.getAllRecords();
		HttpSession session = request.getSession();
		 PrintWriter out = response.getWriter();  
		String username=request.getParameter("Username");
		String privlage=request.getParameter("privlage");
		
		for(Domain x: db)
		{
			if(username.equals(x.getUsername()))
			{
				x.setPrivlage(privlage);
				response.sendRedirect("/premium");
			}
		}
		
			
		
				
		
	}
}
