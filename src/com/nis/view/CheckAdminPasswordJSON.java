package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.nis.dao.AdminDAO;
import com.nis.model.Admin;

/**
 * Servlet implementation class CheckAdminPasswordJSON
 */
@WebServlet("/CheckAdminPasswordJSON")
public class CheckAdminPasswordJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminPasswordJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin A=AdminDAO.checkPassword(request.getParameter("aid"),request.getParameter("pwd"));
		PrintWriter out=response.getWriter();
		if(A==null)
		{  JSONObject J=new  JSONObject();
		   try {
			J.put("message","Invalid Userid/Password");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
        out.println(J);
	    out.flush();
		}
		else
		{
			HttpSession ses=request.getSession();
			ses.putValue("SAID",A.getAdminid());
			ses.putValue("SANAME", A.getAdminname());
			ses.putValue("LTIME",new java.util.Date());
			JSONObject J=new  JSONObject();
			   try {
				J.put("message","1");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   out.println(J);
			    out.flush();
		}
	
	
	}

	}

 






