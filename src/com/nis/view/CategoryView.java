package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CategoryView
 */
@WebServlet("/CategoryView")
public class CategoryView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CategoryView() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       PrintWriter out=response.getWriter();
     //Navigation bar
       HttpSession ses=request.getSession();
       try{
       String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
      	
       	
       }
       catch(Exception e)
       {
       	response.sendRedirect("AdminLogin");
       }
       
       
       out.println("<html>");
       out.println("<a href=CategoryDisplayAll>List of Categories</a><br>");
       out.print("<form action=CategorySubmit method=post enctype='multipart/form-data'>");
       out.println("<table>");
       out.println("<caption><h3><i>Category Register</i></h3></caption>");
       out.println("<tr><td><b><i>Category ID:</i></b></td><td><input type=text name=cid size=30></td></tr>");
       out.println("<tr><td><b><i>Category Name:</i></b></td><td><input type=text name=cna size=30></td></tr>");
       out.println("<tr><td><b><i>Description:</i></b></td><td><textarea name=cd rows=3 cols=40></textarea></td></tr>");
       out.println("<tr><td><b><i>Icon:</i></b></td><td><input type=file name=ci size=30></td></tr>");
       out.println("<tr><td><input type=submit><td><input type=reset></td></tr>");
       out.println("</table></form></html>");
       out.flush();
        	}

}












