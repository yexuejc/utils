package com.yexuejc.util.base.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * java.time.LocalDate 相关util
 *
 * @PackageName: com.yexuejc.util.base.util
 * @Description:
 * @author: maxf
 * @date: 2018/2/11 18:09
 */
public class LocalDateUtil {
    /**
     * LocalDate 转 Date
     *
     * @param localDate
     * @return
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = java.util.Date.from(zdt.toInstant());
        return date;
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
