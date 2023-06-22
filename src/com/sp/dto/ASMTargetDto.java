package com.sp.dto;

public class ASMTargetDto {
	private int target_id;
	private String target_mode;
	private String target_qtr_yr;
	private String target;
	private int asm_id;
	public int getTarget_id() {
		return target_id;
	}
	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}
	public String getTarget_mode() {
		return target_mode;
	}
	public void setTarget_mode(String target_mode) {
		this.target_mode = target_mode;
	}
	public String getTarget_qtr_yr() {
		return target_qtr_yr;
	}
	public void setTarget_qtr_yr(String target_qtr_yr) {
		this.target_qtr_yr = target_qtr_yr;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getAsm_id() {
		return asm_id;
	}
	public void setAsm_id(int asm_id) {
		this.asm_id = asm_id;
	}

}
