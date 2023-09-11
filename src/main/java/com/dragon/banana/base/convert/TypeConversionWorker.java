package com.dragon.banana.base.convert;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author liulongxiang
 * @Date 2023/9/11 10:00
 * @Description convert util
 */
@Component
public class TypeConversionWorker {
    public static final String DATE_WEEK_TIME_FORMAT = "yyyy-MM-dd E HH:mm";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static final String DATE_WEEK_FORMAT = "yyyy-MM-dd E";

    public static final String DATE_FORMAT = "yyyy/MM/dd";

    public static final String DATE_FORMAT2 = "yyyy.MM.dd";

    public static final String DATE_FORMAT3 = "yyyy年MM月dd日";

    public static final String DATE_FORMAT4 = "yyyy-MM-dd";

    public String formatTime(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_WEEK_TIME_FORMAT, Locale.CHINA).format(localDateTime);
    }

    @Named("getDateTimeFormat")
    public String getDateTimeFormat(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_TIME_FORMAT, Locale.CHINA).format(localDateTime);
    }

    @Named("formatDateAndWeek")
    public String formatDateAndWeek(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_WEEK_FORMAT, Locale.CHINA).format(localDateTime);
    }

    @Named("formatDate")
    public String formatDate(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.CHINA).format(localDateTime);
    }

    @Named("formatDate2")
    public String formatDate2(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_FORMAT2, Locale.CHINA).format(localDateTime);
    }

    @Named("formatDate3")
    public String formatDate3(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_FORMAT3, Locale.CHINA).format(localDateTime);
    }

    @Named("formatDate4")
    public String formatDate4(LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        return DateTimeFormatter.ofPattern(DATE_FORMAT4, Locale.CHINA).format(localDateTime);
    }

    @Named("parseDate")
    public LocalDateTime parseDate(String dateTime) {
        if (null == dateTime) {
            return null;
        }
        return LocalDate.parse(dateTime, DateTimeFormatter.ofPattern(DATE_FORMAT4, Locale.CHINA)).atStartOfDay();
    }

    @Named("parseDate3")
    public LocalDateTime parseDate3(String dateTime) {
        if (null == dateTime) {
            return null;
        }
        return LocalDate.parse(dateTime, DateTimeFormatter.ofPattern(DATE_FORMAT3, Locale.CHINA)).atStartOfDay();
    }
}
