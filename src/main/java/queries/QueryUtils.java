package queries;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class QueryUtils {
	public static Date toThePresent() {
		Date toThePresent = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			toThePresent = format.parse("9999-01-01");
		}
		catch (Exception e) {
			System.out.println("FATAL: Can't parse date!");
			System.exit(0);
		}
		return toThePresent;
	}

	public static Date DateParse(String s) {
		Date date = null;
		try {
			DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
			date = format.parse(s);
		}
		catch (Exception e) {
			System.out.println("FATAL: Can't parse date!");
			System.exit(0);
		}
		return date;
	}
}