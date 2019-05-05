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
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
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
        //Navigation bar
        HttpSession ses=request.getSession();
        try{
        String n="<h4><b><i>Admin Id:"+ses.getValue("SAID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=red>"+ses.getValue("SANAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></b></i></h4><hr color=green>";
        out.println(n);		
        	
        }
        catch(Exception e)
        {
        	response.sendRedirect("AdminLogin");
        }
        out.println("<table>");
        out.println("<tr>");
        out.println("<td valign=top>");
        out.println("<a href=CategoryView target=mw>Category Register</a><br>");
        out.println("<a href=ChapterView target=mw>Chapter Register</a><br>");
        out.println("<a href=HeadingView target=mw>Heading Register</a><br>");
        out.println("<a href=ProgramView target=mw>Program Register</a><br>");
        out.println("<a href=AdminLogout>Logout</a><br>");
        out.println("</td>");
        out.println("<td><iframe width=800 height=800 frameborder=0 name=mw></iframe></td></tr></table></html>"); 
        out.flush();
        
	

	
	}
	
	

}




