package com.neuedu.dao.mapper;

import java.util.Map;

import com.neuedu.pojo.Wife;

/**
 * select *
from t_wife a,t_hus b
where a.h_id=b.h_id
 * @author Administrator
 *
 */
public interface TWifeMapper {
	public Wife findAllByWname(String w_name);
	//根据妻子名字查询个人信息及伴侣信息，结果集是一条记录
	public Map<String, Object> findWifeMapByWname(String w_name);
}
