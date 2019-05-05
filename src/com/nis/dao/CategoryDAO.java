package com.nis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.nis.model.Category;

public class CategoryDAO {
static String provider="jdbc:mysql://localhost:3306/kp";
static String uid="root";
static String pwd="monalisa";
public static boolean addNewRecord(Category C)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="insert into category values('"+C.getCategoryid()+"','"+C.getCategoryname()+"','"+C.getCategorydescription()+"','"+C.getIcon()+"')";
   boolean st=DBHelper.executeUpdate(query, cn);
   return(st);
}catch(Exception e){
	System.out.println(e);
	return false;
 }
	
}

public static ResultSet displayAll()
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="select * from category";
  ResultSet rs=DBHelper.executeQuery(query, cn);
  return(rs);
  
}catch(Exception e){
	System.out.println(e);
	return null;
 }
	
}

public static Category displayById(String cid)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="select * from category where categoryid='"+cid+"'";
  ResultSet rs=DBHelper.executeQuery(query, cn);
  if(rs.next())
  {Category C=new Category();
  C.setCategoryid(rs.getString(1));
  C.setCategoryname(rs.getString(2));
  C.setCategorydescription(rs.getString(3));
  C.setIcon(rs.getString(4));
  return(C);
	  
  }
  return(null);
  
}catch(Exception e){
	System.out.println(e);
	return null;
 }
}

public static boolean deleteById(String cid)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="delete from category where categoryid='"+cid+"'";
  boolean st=DBHelper.executeUpdate(query, cn);
  
   
  return(st);
  
}catch(Exception e){
	System.out.println(e);
	return false;
 }

}

public static boolean editRecord(Category C)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="update category set categoryname='"+C.getCategoryname()+"',categorydescription='"+C.getCategorydescription()+"' where categoryid='"+C.getCategoryid()+"'";
  System.out.println(query); 
  boolean st=DBHelper.executeUpdate(query, cn);
  
   if( C.getIcon().length()>0)
   {
	query="update category set icon='"+C.getIcon()+"' where categoryid='"+C.getCategoryid()+"'";
    st=DBHelper.executeUpdate(query, cn); 
   }
   return(st);
}catch(Exception e){
	System.out.println(e);
	return false;
 }
	
}




}

	

