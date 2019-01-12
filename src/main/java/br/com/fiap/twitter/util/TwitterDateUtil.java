package br.com.fiap.twitter.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TwitterDateUtil {

	public static LocalDateTime dateToLocalDateTime(Date data) {
		LocalDateTime localDateTime = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return localDateTime;
	}
	
	public static boolean dateSmaller(LocalDateTime date1, LocalDateTime date2) {
		LocalDate localDate1 = date1.toLocalDate();
		LocalDate localDate2 = date1.toLocalDate();
		int diff = localDate1.compareTo(localDate2);
		return diff <= 0 ? true : false;
	}
	
}
