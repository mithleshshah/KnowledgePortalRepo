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
 * Servlet implementation class ChapterSubmit
 */
@WebServlet("/ChapterSubmit")
public class ChapterSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		Chapter C=new Chapter();
		C.setCategoryid(request.getParameter("cid"));
		C.setChapterid(request.getParameter("chid"));
		C.setChaptername(request.getParameter("cna"));
		C.setDescription(request.getParameter("cd"));
		boolean st=ChapterDAO.addNewRecord(C);
		out.println("<html>");
		if(st)
		{
			out.println("<h4><font color=green>Chapter Submitted...</font><br><a href=ChapterView>Click Here To Add More Chapters</a></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed To Submit...</font></h4>");
		}
		out.println("</html>");
	}

}
