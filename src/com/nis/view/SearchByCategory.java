package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchByCategory
 */
@WebServlet("/SearchByCategory")
public class SearchByCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html>");
		 out.println("<script src='asset/js/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/js/search.js'></script>");
		out.println("<center>");
	 	out.println("<input type=text name=pat id=pat size=100><br><br>");
 
		out.println("<span id=result></span>");
		out.println("</center></html>");
		out.flush();
	
	
	}

}
