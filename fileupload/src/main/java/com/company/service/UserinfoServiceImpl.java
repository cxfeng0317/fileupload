package com.company.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bean.Userinfo;
import com.company.dao.UserinfoDao;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoDao userinfoDao;

	@Override
	public List<Userinfo> findAll() {
		List<Userinfo> list = userinfoDao.findAll();
		return list;
	}

	@Override
	public Userinfo findById(int id) {
		return userinfoDao.findById(id);
	}

	@Override
	public Userinfo findByNameAndPadd(String username, String userpass) {
		Map<String, String> map = new HashMap<>();
		map.put("username", username);
		map.put("userpass", userpass);
		return userinfoDao.findByNameAndPadd(map);
	}

	@Override
	public boolean add(Userinfo userinfo) {
		return userinfoDao.add(userinfo) > 0 ? true : false;
	}

	@Override
	public boolean update(Userinfo userinfo) {
		return userinfoDao.update(userinfo) > 0 ? true : false;
	}

	@Override
	public boolean deleteById(int id) {
		return userinfoDao.deleteById(id) > 0 ? true : false;
	}

}
