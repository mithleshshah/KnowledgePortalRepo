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
import com.nis.dao.ChapterDAO;

/**
 * Servlet implementation class ListOfChapters
 */
@WebServlet("/ListOfChapters")
public class ListOfChapters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfChapters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("cid");
		String cna=request.getParameter("cna");
		
		try{
		ResultSet rs=ChapterDAO.displayChapterByCategoryId(cid);
		out.println("<html>");
		if(rs.next())
		{out.println("<center><table border=1 cellpadding=10 cellspacing=25 width=70%>");
		 out.println("<h2>List of "+cna+" Chapters</h2>");
		
		do
	      {   
	        out.println("<tr>");
	        cna=cna.replace(" ", "+");
	        String chna=rs.getString(3).replace(" ", "+");
	        out.println("<td><a href=ListOfHeadings?chid="+rs.getString(2)+"&chna="+chna+"&cna="+cna+"><h3>"+rs.getString(3)+"</h3><h3><i>"+rs.getString(4)+"</i></h3></a></td>");
	        out.println("</tr>");
	       }while(rs.next());
			
		 out.println("</table></center>");	
			
		}
		else{}
		}catch(Exception e){}
		
		
	}

}
