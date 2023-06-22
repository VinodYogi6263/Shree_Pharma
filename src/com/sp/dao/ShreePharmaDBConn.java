package com.sp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShreePharmaDBConn {
	public Connection getConn()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shree_pharma","root","root");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception = "+e);
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return con;
	}

}
