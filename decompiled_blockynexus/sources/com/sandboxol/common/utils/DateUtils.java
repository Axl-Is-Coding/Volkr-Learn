package com.sandboxol.common.utils;

import com.sandboxol.common.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DateUtils {
    public static String DayFormatDuring(long j) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String strValueOf4 = String.valueOf((((j / 1000) / 60) / 60) / 24);
        long j2 = (j % 86400000) / 3600000;
        if (j2 < 10) {
            strValueOf = "0" + j2;
        } else {
            strValueOf = String.valueOf(j2);
        }
        long j3 = (j % 3600000) / 60000;
        if (j3 < 10) {
            strValueOf2 = "0" + j3;
        } else {
            strValueOf2 = String.valueOf(j3);
        }
        long j4 = (j % 60000) / 1000;
        if (j4 < 10) {
            strValueOf3 = "0" + j4;
        } else {
            strValueOf3 = String.valueOf(j4);
        }
        return strValueOf4 + BaseApplication.getContext().getString(R.string.day) + "  " + strValueOf + " : " + strValueOf2 + " : " + strValueOf3;
    }

    public static String DayFormatDuringBySeconds(long j) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String strValueOf4 = String.valueOf(((j / 60) / 60) / 24);
        long j2 = (j % 86400) / 3600;
        if (j2 < 10) {
            strValueOf = "0" + j2;
        } else {
            strValueOf = String.valueOf(j2);
        }
        long j3 = (j % 3600) / 60;
        if (j3 < 10) {
            strValueOf2 = "0" + j3;
        } else {
            strValueOf2 = String.valueOf(j3);
        }
        long j4 = j % 60;
        if (j4 < 10) {
            strValueOf3 = "0" + j4;
        } else {
            strValueOf3 = String.valueOf(j4);
        }
        return strValueOf4 + BaseApplication.getContext().getString(R.string.day) + "  " + strValueOf + " : " + strValueOf2 + " : " + strValueOf3;
    }

    public static String HoursFormatDuring(long j) {
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        long j2 = (j % 86400000) / 3600000;
        if (j2 < 10) {
            strValueOf = "0" + j2;
        } else {
            strValueOf = String.valueOf(j2);
        }
        long j3 = (j % 3600000) / 60000;
        if (j3 < 10) {
            strValueOf2 = "0" + j3;
        } else {
            strValueOf2 = String.valueOf(j3);
        }
        long j4 = (j % 60000) / 1000;
        if (j4 < 10) {
            strValueOf3 = "0" + j4;
        } else {
            strValueOf3 = String.valueOf(j4);
        }
        return strValueOf + " : " + strValueOf2 + " : " + strValueOf3;
    }

    private static long completMilliseconds(long j) {
        return Long.toString(j).length() == 10 ? j * 1000 : j;
    }

    public static long date2TimeStamp(String str, String str2) {
        try {
            return new SimpleDateFormat(str2).parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static long getDayTime(long j) {
        return (((j / 1000) / 60) / 60) / 24;
    }

    public static long getHourTime(long j) {
        return (((j / 1000) / 60) / 60) % 24;
    }

    public static long getMinuteTime(long j) {
        return ((j / 1000) / 60) % 60;
    }

    public static String hoursFormatDuringBySeconds(long j) {
        String strValueOf;
        String strValueOf2;
        long j2 = j % 3600;
        long j3 = j2 / 3600;
        String strValueOf3 = String.valueOf(j3);
        long j4 = j2 / 60;
        if (j3 == 0 || j4 >= 10) {
            strValueOf = String.valueOf(j4);
        } else {
            strValueOf = "0" + j4;
        }
        long j5 = j % 60;
        if (j4 == 0 || j5 >= 10) {
            strValueOf2 = String.valueOf(j5);
        } else {
            strValueOf2 = "0" + j5;
        }
        if (j3 == 0) {
            return strValueOf + ":" + strValueOf2;
        }
        return strValueOf3 + ":" + strValueOf + ":" + strValueOf2;
    }

    public static boolean isWeekend(long j) {
        Calendar calendarZeroFromHour = zeroFromHour(j);
        return calendarZeroFromHour.get(7) == 7 || calendarZeroFromHour.get(7) == 1;
    }

    public static String timeStamp2Date(long j, String str) {
        if (str == null || str.isEmpty()) {
            str = "yyyy-MM-dd HH:mm:ss.SSS";
        }
        return new SimpleDateFormat(str).format(new Date(j));
    }

    private static Calendar zeroFromHour(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(completMilliseconds(j));
        zeroFromHour(calendar);
        return calendar;
    }

    private static void zeroFromHour(Calendar calendar) {
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }
}
