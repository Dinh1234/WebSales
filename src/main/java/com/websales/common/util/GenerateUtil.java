package com.websales.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.websales.model.User;

public class GenerateUtil {

	public static String generateID(User user) {
		Date date = new Date();
		Random rd = new Random();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		return format.format(date) + (rd.nextInt(90) + 10);
	}
}