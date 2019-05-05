package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.ProgramDAO;
import com.nis.model.Program;


/**
 * Servlet implementation class ProgramViewById
 */
@WebServlet("/ProgramViewById")
public class ProgramViewById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramViewById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String pid=request.getParameter("pid");
		Program P=ProgramDAO.displayById(pid);
		if(P!=null)
		{
			out.println("<html>");
			out.println("<form action=ProgramEditDelete  method=post enctype='multipart/form-data'>");
			out.println("<center><table width=50%>");
			out.println("<caption><h3>Program Details</h3></caption>");
			out.println("<tr><td><b><i>Heading ID:</b></i></td><td><input type='text' name=hid size=30 value='"+P.getHeadingid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Program ID:</b></i></td><td><input type='text' name=pid size=30 value='"+P.getProgramid()+"' readonly=true></td></tr>");
			out.println("<tr><td><b><i>Program Description:</b></i></td><td><textarea name=pd rows=3 cols=40>"+P.getDescription()+"</textarea></td></tr>");
			out.println("<tr><td><b><i>Program:</b></i></td><td><input type='file' name=p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src='pic/"+P.getProgram()+"' width=35 height=35></td></tr>");
			out.println("<tr><td><b><i>Program Output:</b></i></td><td><input type='file' name=po>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src='pic/"+P.getProgramoutput()+"' width=35 height=35></td></tr>");
			out.println("<tr><td><b><i>Download:</b></i></td><td><input type='file' name=d>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; '"+P.getDownload()+"'</td></tr>");
			out.println("<tr><td><input name=btn type='submit' value=Edit></td><td><input name=btn type='submit' value=Delete></td></tr>");
			out.println("</table>");
			out.println("</center>");
			out.println("</html>");
		}
	}

}
