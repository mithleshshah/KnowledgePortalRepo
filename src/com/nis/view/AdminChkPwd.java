package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nis.dao.AdminDAO;
import com.nis.model.Admin;

/**
 * Servlet implementation class AdminChkPwd
 */
@WebServlet("/AdminChkPwd")
public class AdminChkPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChkPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin A=AdminDAO.checkPassword(request.getParameter("aid"),request.getParameter("pwd"));
		if(A==null)
		{ PrintWriter out=response.getWriter();
        out.println("<html><font color=red size=10>Invalid Adminid/Password</font></html>");
	    out.flush();
		}
		else
		{
			HttpSession ses=request.getSession();
			ses.putValue("SAID",A.getAdminid());
			ses.putValue("SANAME", A.getAdminname());
			ses.putValue("LTIME",new java.util.Date());
		response.sendRedirect("AdminHome");	
		}
	
	
	}

}
