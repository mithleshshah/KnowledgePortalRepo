package com.nis.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nis.dao.HeadingDAO;
import com.nis.dao.ProgramDAO;
import com.nis.model.Program;

/**
 * Servlet implementation class DisplayProgram
 */
@WebServlet("/DisplayProgram")
public class DisplayProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProgram() {
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
		 
		try{
			Program P=ProgramDAO.displayById(pid);
            out.println("<html>");
            out.println("<table border=1>");
            
            out.println("<tr><td><h3>"+P.getDescription()+"</h3></td></tr>");
            String savepath="F:/Eclipse Mars/eclipse/KP/WebContent/pic";
            File F=new File(savepath+"/"+P.getProgram());
            FileInputStream FF=new FileInputStream(F);
            byte b[]=new byte[FF.available()];  
            FF.read(b, 0, b.length);
            String content=new String(b);
            content=content.trim();
            FF.close();
            
             
            out.println("<tr><td><textarea rows=20 cols=100>"+content+"</textarea></td></tr>");
            out.println("<tr><td><b>Output:</b><br><img src=pic/"+P.getProgramoutput()+" width=250 height=170></td></tr>");
            out.println("<tr><td><a href=pic/"+P.getDownload()+">Download</a></td></tr>");
            out.println("</table></html>");            
            	out.flush();	
		}
		catch(Exception e){}
		
	}

}
