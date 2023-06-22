package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.dto.CityTableDto;

public class CityTableDaoImp implements CityTableDao {
	ShreePharmaDBConn scon;
	Connection con;
	public CityTableDaoImp()
	{
		scon=new ShreePharmaDBConn();
		con=scon.getConn();
	}
	public List<CityTableDto> viewCitiesById(int id) 
	{
		List<CityTableDto> l=new ArrayList<CityTableDto>();
		CityTableDto c;
		try {
			PreparedStatement ps=con.prepareStatement("select * from city_table where AreaId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new CityTableDto();
				c.setCity_id(rs.getInt(1));
				c.setCity_name(rs.getString(2));
				l.add(c);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	
	public CityTableDto getCityById(int id) 
	{
		CityTableDto c = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from city_table where city_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new CityTableDto();
				c.setCity_id(rs.getInt(1));
				c.setCity_name(rs.getString(2));
				c.setAreaid(rs.getInt(3));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return c;
	}
	
	public int updateCityNameById(CityTableDto c) 
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update city_table set city_name=? where city_id=?");
			ps.setInt(2, c.getCity_id());
			ps.setString(1, c.getCity_name());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	
	public int deleteCityFromCityTable(int id) 
	{
		int r=0;
				try {
					PreparedStatement ps=con.prepareStatement("delete from city_table where city_id=?");
					ps.setInt(1, id);
					r=ps.executeUpdate();
				}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
				return r;
	}
	
	public int addNewCity(CityTableDto c) 
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into city_table values(?,?,?)");
			ps.setInt(1, c.getCity_id());
			ps.setString(2, c.getCity_name());
			ps.setInt(3, c.getAreaid());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public List<CityTableDto> viewCityList()
	{
		List<CityTableDto> l=new ArrayList<CityTableDto>();
		CityTableDto c;
		try {
			PreparedStatement ps=con.prepareStatement("select * from city_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new CityTableDto();
				c.setCity_id(rs.getInt(1));
				c.setCity_name(rs.getString(2));
				l.add(c);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}

}
