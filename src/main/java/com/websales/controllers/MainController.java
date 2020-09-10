package com.websales.controllers;

import java.security.Principal;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.WebUtils;

@Controller
public class MainController extends BaseController {

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		initial(model);
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "auths/homePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "auths/adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "auths/loginPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "auths/logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("User Name: " + userName);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "auths/userInfoPage";
	}
}