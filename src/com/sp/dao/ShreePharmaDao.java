package com.sp.dao;
import java.util.List;

import com.sp.dto.ShreePharmaDto;

public interface ShreePharmaDao {
	public int employeeRegistration(ShreePharmaDto s);
	public ShreePharmaDto checkLogin(int id,String Password);
	public ShreePharmaDto searchEmployeeData(int id);
	public int forgetEmployeePassword(ShreePharmaDto s );
	public List<ShreePharmaDto> searchNewRegistrationByStatus(String s);
	public int approveEmployeeRegistrationByID(ShreePharmaDto s);
	public int deleteNewRegistration(int id);
	public int editEmployeeProfile(ShreePharmaDto s);
	public List<ShreePharmaDto> searchASMByRole(String s);
}
