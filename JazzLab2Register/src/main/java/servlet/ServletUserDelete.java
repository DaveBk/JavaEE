package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.DateObject;
import object.User;

@WebServlet("/delete")
public class ServletUserDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if(user.getRights().equals("administrator")) {
            new DateObject().deleteUserFromDb(req.getParameter("user"));
            resp.sendRedirect("/rights");
        }else {
            resp.sendRedirect("/");
        }
	
    }
}