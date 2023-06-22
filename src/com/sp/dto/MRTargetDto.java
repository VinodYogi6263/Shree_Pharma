package com.sp.dto;

public class MRTargetDto {
	private String month;
	private int target;
	private int mr_id;
	private int asm_id;
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getMr_id() {
		return mr_id;
	}
	public void setMr_id(int mr_id) {
		this.mr_id = mr_id;
	}
	public int getAsm_id() {
		return asm_id;
	}
	public void setAsm_id(int asm_id) {
		this.asm_id = asm_id;
	}

}