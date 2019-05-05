package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.nis.dao.ProgramDAO;
import com.nis.model.Program;

/**
 * Servlet implementation class ProgramSubmit
 */
@WebServlet("/ProgramSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class ProgramSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Program P=new Program();
		P.setHeadingid(request.getParameter("hid"));
		P.setProgramid(request.getParameter("pid"));
		P.setDescription(request.getParameter("pd"));
		//P.setProgram(request.getParameter("p"));
		//P.setProgramoutput(request.getParameter("po"));
		//P.setDownload(request.getParameter("d"));
		try
		{
			Part part=request.getPart("p");
			String savepath="F:/Eclipse Mars/eclipse/KP/WebContent/pic";
			FileUpload F=new FileUpload(part,savepath);
			P.setProgram(F.filename);
			part=request.getPart("po");
			F=new FileUpload(part,savepath);
			P.setProgramoutput(F.filename);
			part=request.getPart("d");
			F=new FileUpload(part,savepath);
			P.setDownload(F.filename);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		boolean st=ProgramDAO.addNewRecord(P);
		out.println("<html>");
		if(st)
		{
			out.println("<h4><font color=green>Program Submitted...</font><br><a href=ProgramView>Click Here To Add More Programs</a></h4>");
		}
		else
		{
			out.println("<h4><font color=red>Failed To Submit...</font></h4>");
		}
		out.println("</html>");
	}

}
