package web.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javaObjects.OutputData;

@WebServlet("/pdf")
public class ServletPDF extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	        resp.sendRedirect("/");
	 }


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<OutputData> raty = (List<OutputData>) session.getAttribute("harmonogram");

        resp.setContentType("application/pdf");
        resp.setHeader("Content-Type","application/x-www-form-urlencoded");
        resp.setHeader("Content-disposition","attachment; filename='calculation.pdf'");
        createPdf(raty,resp);
	}


	private void createPdf(List<OutputData> raty, HttpServletResponse resp) {
		  Document document = new Document(PageSize.A4);
	        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
	            ServletOutputStream servletOutputStream = resp.getOutputStream();
	            PdfWriter writer = PdfWriter.getInstance(document, servletOutputStream);
	            document.open();
	            PdfPTable table = new PdfPTable(5);
	            table.addCell("Nr raty");
	            table.addCell("Kwota kapitalu");
	            table.addCell("Kwota odsetek");
	            table.addCell("Oplaty stale");
	            table.addCell("Calkowita kwota raty");
	            for(OutputData i: raty){
	                table.addCell(""+i.getNumer());
	                table.addCell(""+i.getKapital());
	                table.addCell(""+i.getOdsetki());
	                table.addCell(""+i.getOplata());
	                table.addCell(""+i.getCalkowitaKwota());
	            }
	            out.writeTo(servletOutputStream);
	            document.add(table);
	            document.close();

	        } catch (IOException | DocumentException e) {
	            e.printStackTrace();
	        }
	}
	 
	 
}