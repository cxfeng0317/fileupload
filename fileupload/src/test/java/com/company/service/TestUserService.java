package com.company.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.bean.Userinfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserService {
	@Autowired
	private UserinfoService userinfoService;

	@Test
	public void test01() {
		List<Userinfo> list = userinfoService.findAll();
		for (Userinfo userinfo : list) {
			System.out.println(userinfo);
		}
	}
}
