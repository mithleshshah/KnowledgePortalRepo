package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.CategoryDAO;
import com.nis.model.Category;

/**
 * Servlet implementation class CategoryViewById
 */
@WebServlet("/CategoryViewById")
public class CategoryViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryViewById() {
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
		Category C=CategoryDAO.displayById(cid);
		if(C!=null)
		{
			out.println("<html>");
			out.println("<form action=CategoryEditDelete method=post enctype='multipart/form-data'>");
			out.println("<center><table>");
			out.println("<caption><h3>Category Details</h3></caption>");
			out.println("<tr><td><b><i>Category ID:</i></b></td><td><input type=text name=cid size=30 value='"+C.getCategoryid()+"' readonly=true></td></tr>");
		       out.println("<tr><td><b><i>Category Name:</i></b></td><td><input type=text name=cna size=30 value='"+C.getCategoryname()+"'></td></tr>");
		       out.println("<tr><td><b><i>Description:</i></b></td><td><textarea name=cd rows=3 cols=40>"+C.getCategorydescription()+"</textarea></td></tr>");
		       out.println("<tr><td><b><i>Icon:</i></b></td><td><input type=file name=ci> &nbsp;&nbsp;&nbsp;<img src='pic/"+C.getIcon()+"' width=35 height=35></td></tr>");
		       out.println("<tr><td><input name=btn type=submit value=Edit><td><input name=btn type=submit value=Delete></td></tr>");
		       out.println("</table></center></form></html>");		
					 
		}
		
		
		 

	}

}






