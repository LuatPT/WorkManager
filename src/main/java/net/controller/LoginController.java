package net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.entities.User;
import net.service.UserService;
import net.service.WorkService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
		userService.save(user);
		return "workList";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model) {
		User userForCheck = userService.checkUser(user);
		if (userForCheck != null) {
			model.addAttribute("status", "OK");
		}else {
			model.addAttribute("status", "404");
		}
		return "login";
	}

	@RequestMapping("/showLogin")
	public String showLogin(@ModelAttribute("user") User user, Model model) {
		return "login";
	}
}
