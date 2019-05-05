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
 * Servlet implementation class CategoryDisplayAll
 */
@WebServlet("/CategoryDisplayAll")
public class CategoryDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryDisplayAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=CategoryDAO.displayAll();
		try{
			out.println("<html>");
		if(rs.next())
		{  out.println("<a href=CategoryView>Add New Record</a><br><br>");
		
			out.println("<center><table border=1 width=50%>");
		  out.println("<caption><h3>List of Subject Category</h3></Caption>");
          out.println("<tr><th>CategoryID</th><th>Category Name</th><th>Category<br>Description</th><th>Category Icon</th><th>Update</th></tr>");			
		  do
		  {
		 out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td><img src=pic/"+rs.getString(4)+" width=35 height=35></td><td><a href=CategoryViewById?cid="+rs.getString(1)+">Edit/Delete</a></tr>");	  
			  
		  }while(rs.next());
			out.println("</table></center>");
		}
		else
		{
		out.println("<h3><font color=red>Record Not Found</font></h3>");	
			
		}
		
		out.println("</html>");
		}catch(Exception e)
		{
		 out.println(e);	
			
		}
		
	}

}







