package cn.oyjg.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	public static SimpleDateFormat sdf = null;

	public static String getDateFormat(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	public static String getDateFormat(String format,Date date) {
		return new SimpleDateFormat(format).format(date);
	}
}
