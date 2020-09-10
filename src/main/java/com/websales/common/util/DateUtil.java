package com.websales.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static final Date convertStringtoDate(String date, String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(date);

	}
}