package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.dto.ASMTargetDto;

public class ASMTargetDaoImp implements ASMTargetDao {
	ShreePharmaDBConn sdb;
	Connection con;
	public ASMTargetDaoImp()
	{
		sdb=new ShreePharmaDBConn();
		con=sdb.getConn();
	}
	public int assignTargetToASM(ASMTargetDto a)
	{
		   int r=0;
			try {
				PreparedStatement ps=con.prepareStatement("insert into asm_target values(?,?,?,?,?)");
				ps.setInt(1, a.getTarget_id());
				ps.setString(2, a.getTarget_mode());
				ps.setString(3, a.getTarget_qtr_yr());
				ps.setString(4, a.getTarget());
				ps.setInt(5, a.getAsm_id());
				r=ps.executeUpdate();
     			}
			catch(SQLException e)
			{
				System.out.println("Exception = "+e);
			}
			return r;
		}
		public List<ASMTargetDto> viewASMTargetData()
		{
			ASMTargetDto a1;
			List<ASMTargetDto> l=new ArrayList<ASMTargetDto>();
			try {
				PreparedStatement ps=con.prepareStatement("select * from asm_target");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					a1=new ASMTargetDto();
					a1.setTarget_id(rs.getInt(1));
					a1.setTarget_mode(rs.getString(2));
					a1.setTarget_qtr_yr(rs.getString(3));
					a1.setTarget(rs.getString(4));
					a1.setAsm_id(rs.getInt(5));
					l.add(a1);
				}
	        }
			catch(SQLException e)
			{
				System.out.println("Exception = "+e);
			}
			return l;
		}
		public int deleteASMTarget(int id)
		{
			int r=0;
			try {
				PreparedStatement ps=con.prepareStatement("delete from asm_target where Target_id=?");
				ps.setInt(1, id);
				r=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				System.out.println("Exception = "+e);
			}
			return r;
		}
		public ASMTargetDto searchTargetByASMID(int id)
		{
			ASMTargetDto at=null;
			try {
				PreparedStatement ps=con.prepareStatement("select * from asm_target where asm_id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					at=new ASMTargetDto();
					at.setTarget_id(rs.getInt(1));
					at.setTarget_mode(rs.getString(2));
					at.setTarget_qtr_yr(rs.getString(3));
					at.setTarget(rs.getString(4));
					at.setAsm_id(rs.getInt(5));
				}
			}
			catch(SQLException e)
			{
				System.out.println("Exception = "+e);
			}
			return at;
		}
}