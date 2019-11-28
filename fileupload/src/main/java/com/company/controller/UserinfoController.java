package com.company.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.bean.Userinfo;
import com.company.service.UserinfoService;
import com.company.util.FileUpload;

@Controller
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private FileUpload fileUpload;

	@RequestMapping("/tologin")
	public String tologin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("userAccount") String username, @RequestParam("userPass") String userpass) {
		Userinfo userinfo = userinfoService.findByNameAndPadd(username, userpass);
		if (userinfo != null) {
			return "redirect:userlist";
		} else {
			return "login";
		}
	}

	@RequestMapping("/userlist")
	public String userlist(Model model) {
		List<Userinfo> list = userinfoService.findAll();
		model.addAttribute("list", list);
		return "userlist";
	}

	@RequestMapping("/toregist")
	public String toregist() {
		return "regist";
	}

	@RequestMapping("/regist")
	public String regist(@RequestParam("userAccount") String username, @RequestParam("userPass") String userpass,
			HttpServletRequest request) {
		String userheadimage = null;
		try {
			userheadimage = fileUpload.upload(request);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Userinfo userinfo = new Userinfo(username, userpass, userheadimage);
		boolean flag = userinfoService.add(userinfo);
		if (flag) {
			return "registok";
		} else {
			return "toregist";
		}
	}
}
