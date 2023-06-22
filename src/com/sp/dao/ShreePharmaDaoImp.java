package com.sp.dao;

import java.sql.*;
import java.util.*;
import com.sp.dto.ShreePharmaDto;

public class ShreePharmaDaoImp implements ShreePharmaDao{
	ShreePharmaDBConn scon=null;
	Connection con=null;
	public ShreePharmaDaoImp() 
	{
		scon=new ShreePharmaDBConn();
		con=scon.getConn();
	}
	public int employeeRegistration(ShreePharmaDto s)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into emp_details(user_id,first_name,last_name,password,role,status,address,contact_number,email_id,qualification,experience) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, s.getUser_id());
			ps.setString(2, s.getFirst_name());
			ps.setString(3, s.getLast_name());
			ps.setString(4, s.getPassword());
			ps.setString(5, s.getRole());
			ps.setString(6, s.getStatus());
			ps.setString(7, s.getAddress());
			ps.setString(8, s.getContact_number());
			ps.setString(9, s.getEmail_id());
			ps.setString(10, s.getQualification());
			ps.setString(11, s.getExperience());
			r=ps.executeUpdate();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public ShreePharmaDto checkLogin(int id,String Password)
	{
		ShreePharmaDto s=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from emp_details where User_Id=? and Password=?");
			ps.setInt(1, id);
			ps.setString(2, Password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new ShreePharmaDto();
				s.setUser_id(rs.getInt(1));
				s.setFirst_name(rs.getString(2));
				s.setLast_name(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setRole(rs.getString(5));
				s.setStatus(rs.getString(6));
				s.setAddress(rs.getString(7));
				s.setContact_number(rs.getString(8));
				s.setEmail_id(rs.getString(9));
				s.setQualification(rs.getString(10));
				s.setExperience(rs.getString(11));
			}
			
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return s;
	}
	public int forgetEmployeePassword(ShreePharmaDto s )
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update emp_details set Password=? where User_Id=?");
			ps.setInt(2, s.getUser_id());
			ps.setString(1, s.getPassword());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public ShreePharmaDto searchEmployeeData(int id)
	{
		ShreePharmaDto s = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from emp_details where User_Id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new ShreePharmaDto();
				s.setUser_id(rs.getInt(1));
				s.setFirst_name(rs.getString(2));
				s.setLast_name(rs.getString(3));
				s.setPassword(rs.getString(4));
				s.setRole(rs.getString(5));
				s.setStatus(rs.getString(6));
				s.setAddress(rs.getString(7));
				s.setContact_number(rs.getString(8));
				s.setEmail_id(rs.getString(9));
				s.setQualification(rs.getString(10));
				s.setExperience(rs.getString(11));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return s;
	}
	public List<ShreePharmaDto> searchNewRegistrationByStatus(String s)
	{
		ShreePharmaDto s1;
		List<ShreePharmaDto> l=new ArrayList<ShreePharmaDto>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from emp_details where Status=?");
			ps.setString(1, s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s1=new ShreePharmaDto();
				s1.setUser_id(rs.getInt(1));
				s1.setFirst_name(rs.getString(2));
				s1.setLast_name(rs.getString(3));
				s1.setRole(rs.getString(5));
				s1.setStatus(rs.getString(6));
				s1.setAddress(rs.getString(7));
				s1.setContact_number(rs.getString(8));
				s1.setEmail_id(rs.getString(9));
				s1.setQualification(rs.getString(10));
				s1.setExperience(rs.getString(11));
				l.add(s1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public int approveEmployeeRegistrationByID(ShreePharmaDto s)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update emp_details set Password=?,Role=?,Status=? where User_Id=?");
			ps.setInt(4, s.getUser_id());
			ps.setString(1, s.getPassword());
			ps.setString(2, s.getRole());
			ps.setString(3, s.getStatus());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int deleteNewRegistration(int id)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from emp_details where User_Id=?");
			ps.setInt(1, id);
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int editEmployeeProfile(ShreePharmaDto s)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update emp_details set First_Name=?,Last_Name=?,Role=?,Status=?,Address=?,Contact_Number=?,Email_Id=?,Qualification=?,Experience=? where User_Id=?");
			ps.setInt(10, s.getUser_id());
			ps.setString(1, s.getFirst_name());
			ps.setString(2, s.getLast_name());
			ps.setString(3, s.getRole());
			ps.setString(4, s.getStatus());
			ps.setString(5, s.getAddress());
			ps.setString(6, s.getContact_number());
			ps.setString(7, s.getEmail_id());
			ps.setString(8, s.getQualification());
			ps.setString(9, s.getExperience());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public List<ShreePharmaDto> searchASMByRole(String s)
	{
		ShreePharmaDto s1;
		List<ShreePharmaDto> l=new ArrayList<ShreePharmaDto>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from emp_details where Role=?");
			ps.setString(1, s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s1=new ShreePharmaDto();
				s1.setUser_id(rs.getInt(1));
				s1.setFirst_name(rs.getString(2));
				s1.setLast_name(rs.getString(3));
				s1.setEmail_id(rs.getString(9));
				l.add(s1);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
}
