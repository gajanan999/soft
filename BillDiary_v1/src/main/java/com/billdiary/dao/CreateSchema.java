package com.billdiary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateSchema {
	
	public static boolean CreateDatabase() throws ClassNotFoundException, SQLException
	{
		boolean dbCreated=false;
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		Connection connection = DriverManager.getConnection("jdbc:hsqldb:billdiarydb;create=true", "gajanan", "gajanan");
		connection.createStatement().executeQuery("create table if not exists user(id int, username varchar(20),password varchar(20),role varchar(20))");
		//connection.createStatement().executeQuery("insert into user values(1,'gajanan','gajanan','admin')");
		 PreparedStatement st = connection.prepareStatement("select * from user");
		    ResultSet r1=st.executeQuery();
		   while(r1.next())
		   {
			   System.out.println(r1.getInt(1)+" "+r1.getString(2));
		   }
		
		r1.close();
		st.close();
		connection.close();
		System.out.println("Tables created successfully.. and record inserted successfully");
		
		return dbCreated;
		
	}

}
