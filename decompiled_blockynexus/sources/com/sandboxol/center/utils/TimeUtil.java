package com.sandboxol.center.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class TimeUtil {
    public static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String DEFAULT_DATE_NO_SEPRATOR_FORMAT = "yyyyMMddHHmmss";
    public static String DEFAULT_DAY_FORMAT = "yyyy-MM-dd";
    public static final String DEFAULT_DAY_NO_SEPRATOR = "yyyy.MM.dd";
    public static final String DEFAULT_DAY_NO_SEPRATOR_FORMAT = "yyyyMMdd";
    public static final String DEFAULT_FORMAT = "yyyy/MM/dd/";
    public static final String DEFAULT_FORMAT_NO_YEAR = "MMddHHmmss";
    public static String DEFAULT_HOUR_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
    public static String DEFAULT_MONTH_FORMAT = "yyyy-MM";
    public static final String DEFAULT_SLASH_FORMAT = "dd/MM/yyyy";
    public static String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    public static String HOUR = "HH:mm";
    public static String HOUR_MINUTE_FORMAT = "MM月dd日  HH:mm";

    public static Long dateToLong(String str) {
        Date date;
        try {
            date = new SimpleDateFormat(DEFAULT_DATE_FORMAT).parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        return Long.valueOf(date.getTime());
    }

    public static String getDateToString(long j) {
        return new SimpleDateFormat(HOUR_MINUTE_FORMAT).format(new Date(j));
    }

    public static String getDateToStringHour(long j) {
        return new SimpleDateFormat(HOUR).format(new Date(j));
    }

    public static String getDateToStringOrder(long j) {
        return new SimpleDateFormat(DEFAULT_HOUR_MINUTE_FORMAT).format(new Date(j));
    }

    public static String getDateToStringday(long j) {
        return new SimpleDateFormat(DEFAULT_DAY_NO_SEPRATOR).format(new Date(j));
    }

    public static String getDateToStringss(long j) {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(new Date(j));
    }

    public static Date parseDate(String str, String str2) {
        try {
            return new SimpleDateFormat(str).parse(str2);
        } catch (Exception unused) {
            return new Date();
        }
    }

    public static String parseString(String str, Date date) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String parseString(Date date) {
        return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
    }

    public static String getDateToString(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static Date parseDate(String str) {
        return parseDate(DEFAULT_DATE_FORMAT, str);
    }

    public static Long dateToLong(String str, String str2) {
        Date date;
        try {
            date = new SimpleDateFormat(str).parse(str2);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        return Long.valueOf(date.getTime());
    }

    public static String parseString(String str) {
        return new SimpleDateFormat("yyyy年MM月dd日HH时mm分").format(parseDate(str));
    }
}
