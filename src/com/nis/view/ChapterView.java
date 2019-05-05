package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.dao.CategoryDAO;


/**
 * Servlet implementation class ChapterView
 */
@WebServlet("/ChapterView")
public class ChapterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterView() {
        super();
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
		out.println("<a href=ChapterDisplayAll>List Of Chapters</a><br>");
		out.println("<form action=ChapterSubmit>");
		out.println("<table>");
		out.println("<caption><h3><i>Chapter Register</i></h3></caption>");
		out.println("<tr><td><b><i>Category ID:</b></i></td><td>");
         try{
          ResultSet rs=CategoryDAO.displayAll();
          out.println("<select name=cid>");
          out.println("<option>Category</option>");
          while(rs.next())
          {
           out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");	  
          }
        	 
          out.println("</select>"); 	 
         }catch(Exception e){}

		
		out.println("</td></tr>");
		out.println("<tr><td><b><i>Chapter ID:</b></i></td><td><input type='text' name=chid size=30></td></tr>");
		out.println("<tr><td><b><i>Chapter Name:</b></i></td><td><input type='text' name=cna size=30></td></tr>");
		out.println("<tr><td><b><i>Chapter Description:</b></i></td><td><textarea name=cd rows=3 cols=40></textarea></td></tr>");
		out.println("<tr><td><input type='submit'></td><td><input type=reset></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</html>");
	}

}
