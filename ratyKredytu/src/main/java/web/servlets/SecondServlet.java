package web.servlets;

import control.Calculator;
import javaObjects.InputData;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/harmonogram")
public class SecondServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String wKwota = req.getParameter("wKwota");
		if(wKwota==null || wKwota.equals("")) {
			resp.sendRedirect("/");
		}
		
		String oplataSt = req.getParameter("oplataSt");
		if(oplataSt==null || oplataSt.equals("")) {
			resp.sendRedirect("/");
		}
		
		HttpSession session = req.getSession();
		InputData inputData = new InputData();
		
		inputData.setwKwota(req.getParameter("wKwota"));
		inputData.setIloRat(req.getParameter("iloRat"));
		inputData.setOproc(req.getParameter("oproc"));
		inputData.setOplataSt(req.getParameter("oplataSt"));
		inputData.setRodzRat(req.getParameter("rodzRat"));
		
	    session.setAttribute("harmonogram",new Calculator().upHarmonogram(inputData));
        req.setAttribute("harmonogram",new Calculator().upHarmonogram(inputData));
        req.getRequestDispatcher("/harmonogram.jsp").forward(req,resp);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect("/");
			
	}

}
