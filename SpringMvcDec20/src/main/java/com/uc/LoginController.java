package com.uc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public String checkLogin(@RequestParam("name")String name,@RequestParam("password") String password,Model m) {
		if(name.equals("admin") && password.equals("password")) {
			String msg="Welcome"+name;
			m.addAttribute("message",msg);
			return "success";
		}
		else {
			String msg="Wrong Credentials";
			m.addAttribute("message",msg);
			return "errorpage";
		}
	}
}
