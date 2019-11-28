package com.company.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.bean.Userinfo;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan("com.company.dao")
public class TestUserDao {
	@Autowired
	private UserinfoDao userinfoDao;

	public void test01() {
		Userinfo userinfo = new Userinfo("baihu", "123");
		int i = userinfoDao.add(userinfo);
		System.out.println(i);
	}

	@Test
	public void test02() {
		List<Userinfo> list = userinfoDao.findAll();
		for (Userinfo userinfo : list) {
			System.out.println(userinfo);
		}
	}
}
