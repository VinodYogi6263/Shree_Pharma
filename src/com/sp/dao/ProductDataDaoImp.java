package com.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.sp.dto.ProductDataDto;
import com.sp.dto.ShreePharmaDto;

public class ProductDataDaoImp implements ProductDataDao {
	ShreePharmaDBConn sdb;
	Connection con;
	public ProductDataDaoImp()
	{
		sdb=new ShreePharmaDBConn();
		con=sdb.getConn();
	}
	public List<ProductDataDto> viewProductData()
	{
		ProductDataDto p;
		List<ProductDataDto> l=new ArrayList<ProductDataDto>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from product_data");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new ProductDataDto();
				p.setProduct_id(rs.getString(1));
				p.setProduct_name(rs.getString(2));
				p.setBrand_name(rs.getString(3));
				p.setFormula(rs.getString(4));
				p.setProduct_form(rs.getString(5));
				p.setCategory(rs.getString(6));
				p.setPrice(rs.getDouble(7));
				p.setQuantity(rs.getInt(8));
				l.add(p);
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return l;
	}
	public ProductDataDto getProductData(String Product_id)
	{
		ProductDataDto p = null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from product_data where Product_id=?");
			ps.setString(1, Product_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new ProductDataDto();
				p.setProduct_id(rs.getString(1));
				p.setProduct_name(rs.getString(2));
				p.setBrand_name(rs.getString(3));
				p.setFormula(rs.getString(4));
				p.setProduct_form(rs.getString(5));
				p.setCategory(rs.getString(6));
				p.setPrice(rs.getDouble(7));
				p.setQuantity(rs.getInt(8));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return p;
	}
	
	public int updateProductData(ProductDataDto p)
	{
		int r = 0;
		try {
			PreparedStatement ps=con.prepareStatement("update product_data set Product_name=?,Brand_name=?,Formula=?,Product_form=?,Category=?,Price=?,Quantity=? where Product_id=?");
			ps.setString(8, p.getProduct_id());
			ps.setString(1, p.getProduct_name());
			ps.setString(2, p.getBrand_name());
			ps.setString(3, p.getFormula());
			ps.setString(4, p.getProduct_form());
			ps.setString(5, p.getCategory());
			ps.setDouble(6, p.getPrice());
			ps.setInt(7, p.getQuantity());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int deleteProductData(ProductDataDto p)
	{
		int r=0;
	 try {
		PreparedStatement ps=con.prepareStatement("delete from product_data where Product_id=?");
		ps.setString(1, p.getProduct_id());
		r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}
	public int addProductData(ProductDataDto p)
	{
		int r = 0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
			ps.setString(1, p.getProduct_id());
			ps.setString(2, p.getProduct_name());
			ps.setString(3, p.getBrand_name());
			ps.setString(4, p.getFormula());
			ps.setString(5, p.getProduct_form());
			ps.setString(6, p.getCategory());
			ps.setDouble(7, p.getPrice());
			ps.setInt(8, p.getQuantity());
			r=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception = "+e);
		}
		return r;
	}

}
