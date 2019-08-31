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

@WebServlet("/profil")
public class profil  extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DummyAplicationRepository repo = new DummyAplicationRepository();
		List<Domain> db =repo.getAllRecords();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
        String username= session.getAttribute("username").toString();
        PrintWriter out = response.getWriter();
		for(Domain x: db)
		{
			if(username.equals(x.getUsername()))
			{
				out.println("Username:"+x.getUsername()+"<br/>");
				out.println("Email:"+x.getEmail()+"<br/>");
				out.println("Privlage:"+x.getPrivlage()+"<br/>");
				 
			}
				
			
		}

		 out.print("<a href='/logsite.jsp'>Go back</a> <br/>"); 
	
	}

}
