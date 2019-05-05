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
 * Servlet implementation class ChapterDisplayAll
 */
@WebServlet("/ChapterDisplayAll")
public class ChapterDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		ResultSet rs=ChapterDAO.displayAll();
		try
		{			
		out.println("<html>");
		if(rs.next())
		{
			out.println("<a href=ChapterView>Add New Chapter</a><br>");
			out.println("<center><table border=1 width=50%>");
			out.println("<caption><h3>List Of Chapters</h3></caption>");
			out.println("<tr><th>Category<br>ID</th><th>Chapter<br>ID</th><th>Chapter<br>Name</th><th>Description</th><th>Update</th></tr>");
			do
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td><a href=ChapterViewById?chid="+rs.getString(2)+">Edit/Delete</a></td></tr>");
			}while(rs.next());
			out.println("</table></center>");
		}
		else
		{
			out.println("<h3><font color=red>Chapter Not Found</font></h3>");
		}
		
		out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
