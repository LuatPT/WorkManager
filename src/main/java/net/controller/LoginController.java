package net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.entities.User;
import net.service.UserService;

@Controller
public class LoginController {
	final String userIdString = "U000";

	@Autowired
	private UserService userService;

	@RequestMapping("/showRegister")
	public String showRegister(@ModelAttribute("user") User user, Model model) {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
		boolean check = userService.findById(user.getUser_name());
		String maxId = userIdString + (userService.checkMaxId()+1);
		if (check == false) {
			model.addAttribute("statusRegister", "OK");
			userService.save(user, maxId);
		}else {
			model.addAttribute("statusRegister", "404");
		}
		return "login";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model) {
		User userForCheck = userService.checkUser(user);
		if (userForCheck != null) {
			model.addAttribute("statusLogin", "OK");
		}else {
			model.addAttribute("statusLogin", "404");
		}
		return  "redirect:/work-list/" + userForCheck.getUser_id();
	}

	@RequestMapping("/showLogin")
	public String showLogin(@ModelAttribute("user") User user, Model model) {
		return "login";
	}
}
