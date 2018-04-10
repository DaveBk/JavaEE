package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.DateObject;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DateObject db = new DateObject();

        if(db.isAuthorizationCorrect(req.getParameter("login"),req.getParameter("password"))){
            session.setAttribute("zalogowany",true);
            session.setAttribute("user",db.getUserByName(req.getParameter("login")));
            resp.sendRedirect("/index");
        }else{
            session.setAttribute("showAuthError",true);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
