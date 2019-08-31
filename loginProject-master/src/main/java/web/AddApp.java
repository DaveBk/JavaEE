package web;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.x500.X500Principal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Domain;
import domain.DummyAplicationRepository;
/**
 * Servlet implementation class AddApp
 */
@WebServlet("/Add")
public class AddApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final Pattern email_Pattern = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
    private Domain getRequest(HttpServletRequest request)
    {
    	Domain result = new Domain();
  
        result.setUsername(request.getParameter("Username"));
    	result.setPassword(request.getParameter("Password"));
    	result.setCPassword(request.getParameter("CPassword"));
    	result.setEmail(request.getParameter("email"));
    	result.setPrivlage(request.getParameter("privlage"));
    	
    	
    	return result;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Domain app = getRequest(request);
		DummyAplicationRepository repo = new DummyAplicationRepository();
		List<Domain> db =repo.getAllRecords();
		
		if(app.getUsername().isEmpty() || app.getPassword().isEmpty() || app.getCPassword().isEmpty() || app.getEmail().isEmpty() || app.getPrivlage().isEmpty())
    	{
    		response.sendRedirect("fail.jsp");
    		return;
    	}
		if(!app.getPassword().equals(app.getCPassword()))
		{
			response.sendRedirect("fail.jsp");
			return;
		}
		Matcher matcher = email_Pattern.matcher(app.getEmail());
		if(!matcher.find())
		{
			response.sendRedirect("fail.jsp");
			return;
		}

		for(Domain x: db)
		{
			if(app.getUsername().equals(x.getUsername()) || app.getEmail().equals(x.getEmail()))
			{
				response.sendRedirect("fail.jsp");
				return;
			}
				
		}
		
		repo.add(app);
		response.sendRedirect("succes.jsp");
	}

}
