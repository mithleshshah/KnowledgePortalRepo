package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.HeadingDAO;

/**
 * Servlet implementation class HeadingDisplayAll
 */
@WebServlet("/HeadingDisplayAll")
public class HeadingDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=HeadingDAO.displayAll();
		try
		{			
		out.println("<html>");
		if(rs.next())
		{
			out.println("<a href=HeadingView>Add New Heading</a><br>");
			out.println("<center><table border=1 width=50%>");
			out.println("<caption><h3>List Of Headings</h3></caption>");
			out.println("<tr><th>Chapter<br>ID</th><th>Heading<br>ID</th><th>Description</th><th>Update</th></tr>");
			do
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><a href=HeadingViewById?hid="+rs.getString(2)+">Edit/Delete</a></td></tr>");
			}while(rs.next());
			out.println("</table></center>");
		}
		else
		{
			out.println("<h3><font color=red>Heading Not Found</font></h3>");
		}
		
		out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
