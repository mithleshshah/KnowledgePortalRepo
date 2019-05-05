package com.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.nis.dao.ChapterDAO;
import com.nis.dao.DBHelper;

/**
 * Servlet implementation class SearchResultJSON
 */
@WebServlet("/SearchResultJSON")
public class SearchResultJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String pat=request.getParameter("pat");
		 
		
		try{
		ResultSet rs=ChapterDAO.displayChapterByCategoryName(pat);
		 ArrayList<JSONObject> json=DBHelper.getFormattedResult(rs);
		   out.println(json);	 
	}catch(Exception e){}

}}
