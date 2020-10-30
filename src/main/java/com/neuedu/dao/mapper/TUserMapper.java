package com.neuedu.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuedu.pojo.TUser;

public interface TUserMapper {
	//通过xml配置方式执行sql语句
	public TUser findUserById(int userId);
	
	
	//通过注解方式执行sql语句
	@Select("select * from t_user")
	public List<TUser> findAllUser();
	
	@Insert("insert into t_user values(null,#{password},#{userName},#{userSex},1)")
	public int inserUser(TUser tuser);
	
	@Update("update t_user set password=#{password} where userId=#{userId}")
	public int updateUser(TUser tuser);
	
	public int delUser(int userId);
	
	//用户可以输入的查询条件有用户名和性别
	public List<TUser> findByParam(TUser user);
	
	//智能修改
	public int updateByParam(TUser user);
	
	//智能插入
	public int saveByParam(TUser user);
	//批量删除
	public int delByListParam(List<Integer> ids);
	public int delByArrayParam(Integer[] ids);
	
	//批量插入
	public int multiInsert(@Param("List") List<TUser> list);
}
