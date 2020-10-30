package com.neuedu.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neuedu.pojo.Dept;

public interface DeptMapper {
	//一对多关联映射方式
	public Dept getDeptById(int deptno);
	
	//通用map方式
	public List<Map<String, Object>> getDeptByIdMap(int deptno);
	
	public List<Map<String, Object>> selectCartList(@Param(value="userId")int userId,@Param(value="businessId")int businessId);
}
