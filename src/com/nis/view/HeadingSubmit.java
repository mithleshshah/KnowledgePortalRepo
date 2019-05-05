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
 * Servlet implementation class HeadingSubmit
 */
@WebServlet("/HeadingSubmit")
public class HeadingSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Heading H=new Heading();
		H.setChapterid(request.getParameter("chid"));
		H.setHeadingid(request.getParameter("hid"));
		H.setHeadingname(request.getParameter("hn"));
		H.setDescription(request.getParameter("hd"));
		boolean st=HeadingDAO.addNewRecord(H);
		out.println("<html>");
		if(st)
		{
			out.println("<h4><font color=green>Heading Submitted...</font><br><a href=HeadingView>Click Here To Add More Headings</a></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed To Submit...</font></h4>");
		}
		out.println("</html>");
	}

}
