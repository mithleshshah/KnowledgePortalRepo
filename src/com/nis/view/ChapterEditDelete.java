package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.dao.CategoryDAO;
import com.nis.dao.ChapterDAO;
import com.nis.model.Category;
import com.nis.model.Chapter;

/**
 * Servlet implementation class ChapterEditDelete
 */
@WebServlet("/ChapterEditDelete")
public class ChapterEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChapterEditDelete() {
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
			String chid=request.getParameter("chid");
			boolean st=ChapterDAO.deleteById(chid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Chapter C=new Chapter();
			C.setCategoryid(request.getParameter("cid"));
			C.setChapterid(request.getParameter("chid"));
			C.setChaptername(request.getParameter("cna"));
			C.setDescription(request.getParameter("cd"));
			ChapterDAO.editRecord(C);
		}
		response.sendRedirect("ChapterDisplayAll");
	}

}
