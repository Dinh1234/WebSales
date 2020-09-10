package com.websales.common.tag;

import java.io.Serializable;

public class MessageTag implements Serializable {

	private static final long serialVersionUID = 1L;

//	public String message(String key, HttpServletRequest req) {
//
//		User user = (User) req.getAttribute(CommonConstant.USER_INFO);
//		if (user == null) {
//			user = new User();
//			user.setLocale(new Locale("vn"));
//		}
//
//		return MessagesUtil.getMessage(user, key);
//	}
//
//	public String message(String key, HttpServletRequest req, String... arg) throws Exception {
//
//		User user = (User) req.getAttribute(CommonConstant.USER_INFO);
//		if (user == null) {
//			user = new User();
//			user.setLocale(new Locale("vn"));
//		}
//
//		return MessagesUtil.getMessage(user, key, arg);
//	}
}