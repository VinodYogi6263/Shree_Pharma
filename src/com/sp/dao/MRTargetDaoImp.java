package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sp.dto.MRTargetDto;

public class MRTargetDaoImp implements MRTargetDao {
	ShreePharmaDBConn scon;
	Connection con;
	public MRTargetDaoImp()
	{
		scon=new ShreePharmaDBConn();
		con=scon.getConn();
	}
	public MRTargetDto getMrTargetByMRid(int id)
	{
		MRTargetDto m=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_target_table where mr_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				m=new MRTargetDto();
				m.setMonth(rs.getString(1));
				m.setTarget(rs.getInt(2));
				m.setMr_id(rs.getInt(3));
				m.setAsm_id(rs.getInt(4));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return m;
	}

}
