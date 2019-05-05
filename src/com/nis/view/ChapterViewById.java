package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.CategoryDAO;
import com.nis.dao.ChapterDAO;
import com.nis.model.Category;
import com.nis.model.Chapter;

/**
 * Servlet implementation class ChapterViewById
 */
@WebServlet("/ChapterViewById")
public class ChapterViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterViewById() {
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
		Chapter C=ChapterDAO.displayById(chid);
		if(C!=null)
		{
			out.println("<html>");
			out.println("<form action=ChapterEditDelete>");
			out.println("<center><table width=50%>");
			out.println("<caption><h3>Category Details</h3></caption>");
			out.println("<tr><td><b><i>Category ID:</b></i></td><td><input type='text' name=cid size=30 value='"+C.getCategoryid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Chapter ID:</b></i></td><td><input type='text' name=chid size=30 value='"+C.getChapterid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Chapter Name:</b></i></td><td><input type='text' name=cna size=30 value='"+C.getChaptername()+"'></td></tr>");
			out.println("<tr><td><b><i>Chapter Description:</b></i></td><td><textarea name=cd rows=3 cols=40>"+C.getDescription()+"</textarea></td></tr>");
			out.println("<tr><td><input name=btn type='submit' value=Edit></td><td><input name=btn type='submit' value=Delete></td></tr>");
			out.println("</table>");
			out.println("</center>");
			out.println("</html>");
		}
	}

}
