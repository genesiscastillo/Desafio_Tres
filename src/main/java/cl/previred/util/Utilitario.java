package cl.previred.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Utilitario {
	
	private static String patronFecha = "yyyy-MM-dd";
	
	public static Date getDate(LocalDate localDate) {
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
		return date;
	}
	
	public static String getDateString(Date date ) {
		DateFormat dateFormat = new SimpleDateFormat(patronFecha);  
		String strDate = dateFormat.format(date);
		return strDate;
	}
	
	public static String getDateString(LocalDate localDate) {
		Date date = getDate(localDate);
		DateFormat dateFormat = new SimpleDateFormat(patronFecha);  
		String strDate = dateFormat.format(date);
		return strDate;
	}

}
