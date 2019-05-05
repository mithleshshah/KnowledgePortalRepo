package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.ProgramDAO;

/**
 * Servlet implementation class ProgramDisplayAll
 */
@WebServlet("/ProgramDisplayAll")
public class ProgramDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=ProgramDAO.displayAll();
		try
		{			
		out.println("<html>");
		if(rs.next())
		{
			out.println("<a href=ProgramView>Add New Record</a><br>");
			out.println("<center><table border=1 width=50%>");
			out.println("<caption><h3>List Of Programs</h3></caption>");
			out.println("<tr><th>Heading<br>ID</th><th>Program<br>ID</th><th>Program<br>Description</th><th>Program</th><th>Program<br>Output</th><th>Download</th><th>Update</th></tr>");
			do
			{
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><img src=pic/"+rs.getString(4)+" width=35 height=35></td><td><img src=pic/"+rs.getString(5)+" width=35 height=35></td><td>"+rs.getString(6)+"</td><td><a href=ProgramViewById?pid="+rs.getString(2)+">Edit/Delete</a></td></tr>");
			}while(rs.next());
			out.println("</table></center>");
		}
		else
		{
			out.println("<h3><font color=red>Record Not Found</font></h3>");
		}
		
		out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
