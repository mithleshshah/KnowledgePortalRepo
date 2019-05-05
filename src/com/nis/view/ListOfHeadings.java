package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.ChapterDAO;
import com.nis.dao.HeadingDAO;

/**
 * Servlet implementation class ListOfHeadings
 */
@WebServlet("/ListOfHeadings")
public class ListOfHeadings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfHeadings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String chid=request.getParameter("chid");
		String chna=request.getParameter("chna");
		String cna=request.getParameter("cna");
		cna=cna.replace("+"," ");
			
		try{
		ResultSet rs=HeadingDAO.displayHeadingByChapterId(chid);
		out.println("<html>");
		if(rs.next())
		{out.println("<center><table border=1 cellpadding=10 cellspacing=25 width=70%>");
		 out.println("<h2>Language:"+cna+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chapter:"+chna+"</h2>"); 
		 
	      do
	      {   
	        out.println("<tr>"); 
	        cna=cna.replace(" ", "+");
	        chna=chna.replace(" ", "+");
	        String hna=rs.getString(3).replace(" ","+");
	        out.println("<td><a href=ListOfPrograms?hid="+rs.getString(2)+"&hna="+hna+"&cna="+cna+"&chna="+chna+"><h3>"+rs.getString(3)+"</h3><h3><i>"+rs.getString(4)+"</i></h3></a></td>");
	        out.println("</tr>");
	       }while(rs.next());
			
		 out.println("</table></center>");	
			
		}
		else{}
		}catch(Exception e){}
		
		
	}

}
