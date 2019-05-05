package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.CategoryDAO;

/**
 * Servlet implementation class UserHome
 */
@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	try{
	ResultSet rs=CategoryDAO.displayAll();
	out.println("<html>");
	if(rs.next())
		
	{out.println("<center><table border=1 cellpadding=10 cellspacing=25>");
	 out.println("<h2>List of Programming Languages</h2>"); 
	  int i=1;
      do
      {  if(i==1){
    	  out.println("<tr>");}
       String cna=rs.getString(2).replace(" ","+");
       out.println("<td><center><a href=ListOfChapters?cid="+rs.getString(1)+"&cna="+cna+"><img src='pic/"+rs.getString(4)+"' width=150 height=150><br><h3>"+rs.getString(2)+"</h3></a></center></td>");
       i=i+1;
       if(i==4){
       out.println("</tr>");
       i=1;
       }
    	  
      }while(rs.next());
		
	 out.println("</table></center>");	
		
	}
	else{}
	}catch(Exception e){}
	
	
	}

}







