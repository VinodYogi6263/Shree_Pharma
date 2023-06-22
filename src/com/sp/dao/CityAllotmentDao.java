package com.sp.dao;

import java.util.List;

import com.sp.dto.CityAllotmentDto;

public interface CityAllotmentDao {
	public List<CityAllotmentDto> ShowMRListByAreaID(int id);
	public int CityAllotToMR(CityAllotmentDto c);
	public int transferOfMR(CityAllotmentDto c);
	public int removeMRFromCityByMrID(int id);
	public CityAllotmentDto getCityDetailByCityID(int cid);

}
