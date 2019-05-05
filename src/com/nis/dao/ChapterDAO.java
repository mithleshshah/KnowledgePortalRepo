package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Category;
import com.nis.model.Chapter;

public class ChapterDAO {
	static String provider="jdbc:mysql://localhost:3306/kp";
	static String uid="root";
	static String pwd="monalisa";
public static boolean addNewRecord(Chapter C)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="insert into chapter values('"+C.getCategoryid()+"','"+C.getChapterid()+"','"+C.getChaptername()+"','"+C.getDescription()+"')";
		boolean st=DBHelper.executeUpdate(query, cn);
		return (st);
	}
	catch(Exception e){
		System.out.println(e);
		return false;
	}
}


public static ResultSet displayChapterByCategoryId(String cid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from chapter where categoryid='"+cid+"'";
	    System.out.println(query);
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return (rs);
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}
public static ResultSet displayChapterByCategoryName(String pat)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from chapter where categoryid in (select categoryid from category where categoryname like '%"+pat+"%')";
	    System.out.println(query);
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return (rs);
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}





public static ResultSet displayAll()
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from chapter";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		return (rs);
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}
public static Chapter displayById(String chid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="select * from chapter where chapterid='"+chid+"'";
		ResultSet rs=DBHelper.executeQuery(query, cn);
		if(rs.next())
		{
			Chapter C=new Chapter();
			C.setCategoryid(rs.getString(1));
			C.setChapterid(rs.getString(2));
			C.setChaptername(rs.getString(3));
			C.setDescription(rs.getString(4));
			return C;
		}
		return null;
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	}
}
public static boolean deleteById(String chid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="delete from chapter where chapterid='"+chid+"'";
		boolean st=DBHelper.executeUpdate(query, cn);
		return (st);
	}
	catch(Exception e){
		System.out.println(e);
		return false;
	}
}
public static boolean editRecord(Chapter C)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="update chapter set chaptername='"+C.getChaptername()+"',description='"+C.getDescription()+"' where chapterid='"+C.getChapterid()+"'";
		boolean st=DBHelper.executeUpdate(query, cn);
		return (st);
	}
	catch(Exception e){
		System.out.println(e);
		return false;
	}
}
}
