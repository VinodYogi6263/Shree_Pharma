package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.dto.CityAllotmentDto;

public class CityAllotmentDaoImp implements CityAllotmentDao {
	ShreePharmaDBConn scon;
	Connection con;
	public CityAllotmentDaoImp()
	{
		scon=new ShreePharmaDBConn();
		con=scon.getConn();
	}
	public List<CityAllotmentDto> ShowMRListByAreaID(int id) 
	{
		List<CityAllotmentDto> l=new ArrayList<CityAllotmentDto>();
		CityAllotmentDto c;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_city_allotment_table where AreaId=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new CityAllotmentDto();
				c.setMr_id(rs.getInt(1));
				c.setCity_id(rs.getInt(2));
				c.setAreaid(rs.getInt(3));
				l.add(c);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public int CityAllotToMR(CityAllotmentDto c) 
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into mr_city_allotment_table values (?,?,?)");
			ps.setInt(1, c.getMr_id());
			ps.setInt(2, c.getCity_id());
			ps.setInt(3, c.getAreaid());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int transferOfMR(CityAllotmentDto c)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update mr_city_allotment_table set mr_id=? where city_id=?");
			ps.setInt(2, c.getCity_id());
			ps.setInt(1, c.getMr_id());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int removeMRFromCityByMrID(int id)
	{
	   int r=0;
	   try {
		     PreparedStatement ps=con.prepareStatement("delete from mr_city_allotment_table where mr_id=?");
		     ps.setInt(1, id);
		     r=ps.executeUpdate();
	       } 
	   catch(SQLException e)
	   {
		   System.out.println("Exception = "+e);
	   }
	   return r;
	}
	public CityAllotmentDto getCityDetailByCityID(int cid)
	{
		CityAllotmentDto c=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_city_allotment_table where city_id=?");
			ps.setInt(1, cid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				c=new CityAllotmentDto();
				c.setMr_id(rs.getInt(1));
				c.setCity_id(rs.getInt(2));
				c.setAreaid(rs.getInt(3));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return c;
	}
	

}
