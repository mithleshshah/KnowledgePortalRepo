package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.HeadingDAO;
import com.nis.model.Heading;


/**
 * Servlet implementation class HeadingViewById
 */
@WebServlet("/HeadingViewById")
public class HeadingViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String hid=request.getParameter("hid");
		Heading H=HeadingDAO.displayById(hid);
		if(H!=null)
		{
			out.println("<html>");
			out.println("<form action=HeadingEditDelete>");
			out.println("<center><table width=50%>");
			out.println("<caption><h3>Heading Details</h3></caption>");
			out.println("<tr><td><b><i>Chapter ID:</b></i></td><td><input type='text' name=chid size=30 value='"+H.getChapterid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Heading ID:</b></i></td><td><input type='text' name=hid size=30 value='"+H.getHeadingid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Heading Description:</b></i></td><td><textarea name=hd rows=3 cols=40>"+H.getDescription()+"</textarea></td></tr>");
			out.println("<tr><td><input name=btn type='submit' value=Edit></td><td><input name=btn type='submit' value=Delete></td></tr>");
			out.println("</table>");
			out.println("</center>");
			out.println("</html>");
		}
	}

}
