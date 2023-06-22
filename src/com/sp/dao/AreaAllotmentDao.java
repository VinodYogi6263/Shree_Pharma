package com.sp.dao;

import java.util.List;

import com.sp.dto.AreaAllotmentDto;
import com.sp.dto.AreaTableDto;
import com.sp.dto.ShreePharmaDto;

public interface AreaAllotmentDao {
	public int assignAreaToASM(AreaAllotmentDto a);
	public List<AreaAllotmentDto> getAllAreaAndASMId();
	public int TransferOfASM(AreaAllotmentDto a);
	public int removeASMFromArea(AreaAllotmentDto a);
	public AreaAllotmentDto searchEmpByAreaID(int id);

}
