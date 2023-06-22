package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.dto.AreaAllotmentDto;
import com.sp.dto.AreaTableDto;
import com.sp.dto.ShreePharmaDto;

public class AreaAllotmentDaoImp implements AreaAllotmentDao {
	ShreePharmaDBConn scon;
	Connection con;
	public AreaAllotmentDaoImp()
	{
		scon=new ShreePharmaDBConn();
		con=scon.getConn();
	}
	public int assignAreaToASM(AreaAllotmentDto a) 
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into asm_area_allotment_table values(?,?)");
			ps.setInt(1, a.getAsm_id());
			ps.setInt(2, a.getArea_id());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	
	public List<AreaAllotmentDto> getAllAreaAndASMId()
	{
		List<AreaAllotmentDto> l=new ArrayList<AreaAllotmentDto>();
		AreaAllotmentDto a;
		try {
			PreparedStatement ps=con.prepareStatement("select * from asm_area_allotment_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				a=new AreaAllotmentDto();
				a.setAsm_id(rs.getInt(1));
				a.setArea_id(rs.getInt(2));
				l.add(a);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public int TransferOfASM(AreaAllotmentDto a)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update asm_area_allotment_table set asm_id=? where area_id=?");
			ps.setInt(2, a.getArea_id());
			ps.setInt(1, a.getAsm_id());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int removeASMFromArea(AreaAllotmentDto a) {
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("update asm_area_allotment_table set asm_id=? where area_id=?");
			ps.setInt(2, a.getArea_id());
			ps.setInt(1, a.getAsm_id());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public AreaAllotmentDto searchEmpByAreaID(int id)
	{
		AreaAllotmentDto a = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from asm_area_allotment_table where area_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			a=new AreaAllotmentDto();
			a.setAsm_id(rs.getInt(1));
			a.setArea_id(rs.getInt(2));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return a;
	}
	
}
