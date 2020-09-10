package com.websales.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.websales.common.util.AuditorAwareImpl;
import com.websales.common.util.WebUtils;
import com.websales.entity.AppUser;
import com.websales.model.User;
import com.websales.repository.AppUserRepository;

public abstract class BaseController {

	@Autowired
	private AppUserRepository appUserRepo;

	@Autowired
	private HttpServletRequest request;

	private User user = new User();

	private AuditorAwareImpl auditorAwareImpl = new AuditorAwareImpl();

	public void initial(Model model) {

		AppUser entity = appUserRepo.findUserAccount(auditorAwareImpl.getCurrentAuditor().get());
		user.setUserId(entity.getUserId());
		user.setUserName(entity.getUserName());
		user.setLocale(new Locale(entity.getLocale()));
		user.setName(entity.getName());
		
		user.setRole(WebUtils.getUserRole());
		model.addAttribute("user", user);
		request.getSession().setAttribute("user", user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
