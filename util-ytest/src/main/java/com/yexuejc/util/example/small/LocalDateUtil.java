package com.yexuejc.util.example.small;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


public class LocalDateUtil {
	public static void main(String[] args) {
//		a();
		b();
	}

	private static void b() {
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_ORDINAL_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
		System.out.println(ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
	}

	private static void a() {
		System.out.println(LocalDate.now());
		System.out.println(ZonedDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0).plusDays(-30).toEpochSecond());
		System.out.println(System.currentTimeMillis()-1000*60*60*24);
		System.out.println(ZonedDateTime.now().toEpochSecond());
		System.out.println(System.currentTimeMillis());
		//本月第一天
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));

		//上一天
		System.out.println(LocalDate.now().plusDays(-1));
		//上周
		System.out.println("plusWeeks:"+LocalDate.now().plusWeeks(-1));
		System.out.println(LocalDate.parse("2017-11-18").plusWeeks(-1));
		//上一个月
		System.out.println(LocalDate.now().plusMonths(-1));
		//上一年
		System.out.println(LocalDate.now().plusYears(-1));

	}

	/**
     * LocalDateTime 转 Date
     *
     * @param localDate
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atZone(zoneId);
        Date date = java.util.Date.from(zdt.toInstant());
        return date;
    }
}
