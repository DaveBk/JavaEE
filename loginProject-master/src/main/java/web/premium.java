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

@WebServlet("/premium")
public class premium  extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DummyAplicationRepository repo = new DummyAplicationRepository();
		List<Domain> db =repo.getAllRecords();
		  PrintWriter out = response.getWriter();         
		  out.print("<table width=25% border=1>");
		  out.print("<center><h1>Users:</h1>");
		for(Domain x: db)
		{
			 out.print("<tr>");
			 out.print("<td> Username </td> ");
			 out.print("<td>"+x.getUsername()+"</td> </tr>");
			 out.print("<tr><td> Email </td> ");
			 out.print("<td>"+x.getEmail()+"</td> </tr>");
			 out.print("<tr><td> Privlage</td> ");
			 out.print("<td>"+x.getPrivlage()+"</td> </tr>");
			 out.print("<td>"+"----------"+"</td> </tr>");
				
		}
		HttpSession session = request.getSession();
		String privlage=session.getAttribute("p").toString();
		
		
		
		if(privlage.equals("admin"))
		{
			 out.print("<a href='/privlage.jsp'>Add privlage</a> <br/>"); 
			

		}
		out.print("</center>");
		 out.print("<a href='/logsite.jsp'>Go back</a> <br/>"); 


	
	}

}
