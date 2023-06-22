package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.sp.dto.AreaTableDto;

public class AreaTableDaoImp implements AreaTableDao {
	ShreePharmaDBConn sdb;
	Connection con;
	public AreaTableDaoImp()
	{
		sdb=new ShreePharmaDBConn();
		con=sdb.getConn();
	}
	public List<AreaTableDto> viewAreaTable()
	{
		AreaTableDto a;
		List<AreaTableDto> l=new ArrayList<AreaTableDto>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from area_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				a=new AreaTableDto();
				a.setArea_id(rs.getInt(1));
				a.setArea_name(rs.getString(2));
				l.add(a);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	
	public int addNewArea(AreaTableDto a)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into area_table values(?,?)");
			ps.setInt(1, a.getArea_id());
			ps.setString(2, a.getArea_name());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int updateAreaByAreaID(AreaTableDto a)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update area_table set area_name=? where area_id=?");
			ps.setInt(2, a.getArea_id());
			ps.setString(1, a.getArea_name());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	
	public AreaTableDto getAreaByID(int id)
	{
		AreaTableDto a=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from area_table where area_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				a= new AreaTableDto();
				a.setArea_id(rs.getInt(1));
				a.setArea_name(rs.getString(2));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return a;
	}
	public int deleteAreaFromAreaTable(int id)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from area_table where area_id=?");
			ps.setInt(1, id);
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}

}
