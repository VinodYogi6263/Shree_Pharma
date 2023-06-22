package com.sp.dao;

import java.util.List;

import com.sp.dto.AreaTableDto;

public interface AreaTableDao {
	public int addNewArea(AreaTableDto a);
	public List<AreaTableDto> viewAreaTable();
	public int updateAreaByAreaID(AreaTableDto a);
	public AreaTableDto getAreaByID(int id);
	public int deleteAreaFromAreaTable(int id);

}
