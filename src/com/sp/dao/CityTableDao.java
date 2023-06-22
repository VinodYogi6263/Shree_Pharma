package com.sp.dao;

import java.util.List;
import com.sp.dto.CityTableDto;

public interface CityTableDao {
	public List<CityTableDto> viewCitiesById(int id);
	public CityTableDto getCityById(int id);
	public int updateCityNameById(CityTableDto c);
	public int deleteCityFromCityTable(int id);
	public int addNewCity(CityTableDto c);
	public List<CityTableDto> viewCityList();

}
