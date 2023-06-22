package com.sp.dao;

import java.util.List;

import com.sp.dto.ASMTargetDto;

public interface ASMTargetDao {
	public int assignTargetToASM(ASMTargetDto a);
	public List<ASMTargetDto> viewASMTargetData();
	public int deleteASMTarget(int id);
	public ASMTargetDto searchTargetByASMID(int id);

}
