package com.company.service;

import java.util.List;
import java.util.Map;

import com.company.bean.Userinfo;

/**
 * @author CJF
 * @category 用户信息业务逻辑层
 */
public interface UserinfoService {
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
	Userinfo findByNameAndPadd(String username, String userpass);

	/**
	 * 增加用户
	 */
	boolean add(Userinfo userinfo);

	/**
	 * 更新用户
	 */
	boolean update(Userinfo userinfo);

	/**
	 * 删除用户
	 */
	boolean deleteById(int id);
}
