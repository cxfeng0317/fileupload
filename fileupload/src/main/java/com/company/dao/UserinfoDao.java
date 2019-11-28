package com.company.dao;

import java.util.List;
import java.util.Map;

import com.company.bean.Userinfo;

/**
 * @author CJF
 * @category 用户信息数据访问接口
 */
public interface UserinfoDao {
	/**
	 * 查询全部用户
	 */
	List<Userinfo> findAll();

	/**
	 * 通过id查询用户
	 */
	Userinfo findById(int id);

	/**
	 * 通过用户名密码查询用户
	 */
	Userinfo findByNameAndPadd(Map<String, String> map);

	/**
	 * 增加用户
	 */
	int add(Userinfo userinfo);

	/**
	 * 更新用户
	 */
	int update(Userinfo userinfo);

	/**
	 * 删除用户
	 */
	int deleteById(int id);

}
