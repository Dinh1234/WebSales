
package com.websales.common.util;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.websales.model.User;

@Component
public final class MessagesUtil {

	private static MessageSource messageSource;

	@Autowired
	private MessageSource messageSourceAutowired;

	@PostConstruct
	private void initMessageSource() {
		messageSource = this.messageSourceAutowired;
	}

	public static String getMessage(User user, String code, String[] args) {

		String message = messageSource.getMessage(code, args, user.getLocale());
		return message;
	}

	public static String getMessage(User user, String code) {

		String message = messageSource.getMessage(code, null, user.getLocale());
		return message;
	}
}