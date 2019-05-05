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
 * Servlet implementation class HeadingEditDelete
 */
@WebServlet("/HeadingEditDelete")
public class HeadingEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeadingEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String hid=request.getParameter("hid");
			boolean st=HeadingDAO.deleteById(hid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Heading H=new Heading();
			H.setChapterid(request.getParameter("chid"));
			H.setHeadingid(request.getParameter("hid"));
			H.setDescription(request.getParameter("hd"));
			HeadingDAO.editRecord(H);
		}
		response.sendRedirect("HeadingDisplayAll");
	}

}
