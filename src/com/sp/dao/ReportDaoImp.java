package com.sp.dao;

import java.sql.*;
import java.util.*;

import com.sp.dto.ReportDto;

public class ReportDaoImp implements ReportDao {
	ShreePharmaDBConn sdb=null;
	Connection con=null;
	public ReportDaoImp()
	{
		sdb=new ShreePharmaDBConn();
		con=sdb.getConn();
	}
	public List<ReportDto> viewReports()
	{
		List<ReportDto> ar=new ArrayList<ReportDto>();
		ReportDto r;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_reporting");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setReport_id(rs.getInt(1));
				r.setDate(rs.getString(2));
				r.setCity_id(rs.getInt(3));
				r.setMr_id(rs.getInt(4));
				r.setArea_visited(rs.getString(5));
				r.setDr_visited(rs.getInt(6));
				r.setChemist_visited(rs.getInt(7));
				r.setMedicine_promoted(rs.getString(8));
				r.setOrder(rs.getInt(9));
				r.setDaily_income(rs.getInt(10));
				r.setAchievement(rs.getInt(11));
				r.setStatus(rs.getString(12));
				r.setRemark(rs.getString(13));
				r.setComment(rs.getInt(14));
				ar.add(r);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return ar;
	}
	public List<ReportDto> viewReportByCity(int id)
	{
		List<ReportDto> l=new ArrayList<ReportDto>();
		ReportDto r;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_reporting where city_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setReport_id(rs.getInt(1));
				r.setDate(rs.getString(2));
				r.setCity_id(rs.getInt(3));
				r.setMr_id(rs.getInt(4));
				r.setArea_visited(rs.getString(5));
				r.setDr_visited(rs.getInt(6));
				r.setChemist_visited(rs.getInt(7));
				r.setMedicine_promoted(rs.getString(8));
				r.setOrder(rs.getInt(9));
				r.setDaily_income(rs.getInt(10));
				r.setAchievement(rs.getInt(11));
				r.setStatus(rs.getString(12));
				r.setRemark(rs.getString(13));
				r.setComment(rs.getInt(14));
				l.add(r);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public ReportDto viewReportByReportID(int id)
	{
		ReportDto r = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_reporting where report_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setReport_id(rs.getInt(1));
				r.setDate(rs.getString(2));
				r.setCity_id(rs.getInt(3));
				r.setMr_id(rs.getInt(4));
				r.setArea_visited(rs.getString(5));
				r.setDr_visited(rs.getInt(6));
				r.setChemist_visited(rs.getInt(7));
				r.setMedicine_promoted(rs.getString(8));
				r.setOrder(rs.getInt(9));
				r.setDaily_income(rs.getInt(10));
				r.setAchievement(rs.getInt(11));
				r.setStatus(rs.getString(12));
				r.setRemark(rs.getString(13));
				r.setComment(rs.getInt(14));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int checkMrReport(ReportDto r)
	{
		int n=0;
		try {
			PreparedStatement ps=con.prepareStatement("update mr_reporting set status=?,remark=?,comment=? where report_id=?");
			ps.setInt(4, r.getReport_id());
			ps.setString(1, r.getStatus());
			ps.setString(2, r.getRemark());
			ps.setInt(3, r.getComment());
			n=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return n;
	}
	public int deleteMrReport(int id)
	{
		int r=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from mr_reporting where report_id=?");
			ps.setInt(1, id);
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public List<ReportDto> checkLimitedReport(String from, String to)
	{
		List<ReportDto> l=new ArrayList<ReportDto>();
		ReportDto r;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_reporting where date between ? and ?");
			ps.setString(1, from);
			ps.setString(2, to);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setReport_id(rs.getInt(1));
				r.setDate(rs.getString(2));
				r.setCity_id(rs.getInt(3));
				r.setMr_id(rs.getInt(4));
				r.setArea_visited(rs.getString(5));
				r.setDr_visited(rs.getInt(6));
				r.setChemist_visited(rs.getInt(7));
				r.setMedicine_promoted(rs.getString(8));
				r.setOrder(rs.getInt(9));
				r.setDaily_income(rs.getInt(10));
				r.setAchievement(rs.getInt(11));
				r.setStatus(rs.getString(12));
				r.setRemark(rs.getString(13));
				r.setComment(rs.getInt(14));
				l.add(r);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public ReportDto getReportByCityID(int id)
	{
		ReportDto r = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from mr_reporting where city_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setReport_id(rs.getInt(1));
				r.setDate(rs.getString(2));
				r.setCity_id(rs.getInt(3));
				r.setMr_id(rs.getInt(4));
				r.setArea_visited(rs.getString(5));
				r.setDr_visited(rs.getInt(6));
				r.setChemist_visited(rs.getInt(7));
				r.setMedicine_promoted(rs.getString(8));
				r.setOrder(rs.getInt(9));
				r.setDaily_income(rs.getInt(10));
				r.setAchievement(rs.getInt(11));
				r.setStatus(rs.getString(12));
				r.setRemark(rs.getString(13));
				r.setComment(rs.getInt(14));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public ReportDto getMaxMRAchReport(int id)
	{
		ReportDto r=null;
		try {
			PreparedStatement ps=con.prepareStatement("select max(achievement) from mr_reporting where mr_id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				r=new ReportDto();
				r.setAchievement(rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	
	
}
