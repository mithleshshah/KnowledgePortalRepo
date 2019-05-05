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
 * Servlet implementation class ProgramEditDelete
 */
@WebServlet("/ProgramEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class ProgramEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String pid=request.getParameter("pid");
			boolean st=ProgramDAO.deleteById(pid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			Program P=new Program();
			P.setHeadingid(request.getParameter("hid"));
			P.setProgramid(request.getParameter("pid"));
			P.setDescription(request.getParameter("pd"));
			P.setProgram("");
			P.setProgramoutput("");
			P.setDownload("");
			if(request.getPart("p").getSize()>0)
			{
			try
			{
				Part part=request.getPart("p");
				String savepath="C:/Users/abhay/workspace/KP/WebContent/pic";
				FileUpload F=new FileUpload(part,savepath);
				P.setProgram(F.filename);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
			if(request.getPart("po").getSize()>0)
			{
			try
			{
				Part part=request.getPart("po");
				String savepath="C:/Users/abhay/workspace/KP/WebContent/pic";
				FileUpload F=new FileUpload(part,savepath);
				P.setProgramoutput(F.filename);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
			if(request.getPart("d").getSize()>0)
			{
			try
			{
				Part part=request.getPart("d");
				String savepath="C:/Users/abhay/workspace/KP/WebContent/pic";
				FileUpload F=new FileUpload(part,savepath);
				P.setDownload(F.filename);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			}
			ProgramDAO.editRecord(P);
		}
		response.sendRedirect("ProgramDisplayAll");
	}

}
