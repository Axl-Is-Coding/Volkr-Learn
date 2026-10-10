package cn.qqtheme.framework.util;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DateUtils extends android.text.format.DateUtils {
    public static final int Day = 3;
    public static final int Hour = 2;
    public static final int Minute = 1;
    public static final int Second = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DifferenceMode {
    }

    public static int calculateDaysInMonth(int i) {
        return calculateDaysInMonth(0, i);
    }

    public static long calculateDifference(long j, long j2, int i) {
        return calculateDifference(new Date(j), new Date(j2), i);
    }

    public static long calculateDifferentDay(Date date, Date date2) {
        return calculateDifference(date, date2, 3);
    }

    public static long calculateDifferentHour(Date date, Date date2) {
        return calculateDifference(date, date2, 2);
    }

    public static long calculateDifferentMinute(Date date, Date date2) {
        return calculateDifference(date, date2, 1);
    }

    public static long calculateDifferentSecond(Date date, Date date2) {
        return calculateDifference(date, date2, 0);
    }

    public static String fillZero(int i) {
        StringBuilder sb;
        String str;
        if (i < 10) {
            sb = new StringBuilder();
            str = "0";
        } else {
            sb = new StringBuilder();
            str = "";
        }
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String formatDate(Date date, String str) {
        return new SimpleDateFormat(str, Locale.PRC).format(date);
    }

    public static boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("date is null");
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date parseDate(String str, String str2) {
        try {
            return new Date(new SimpleDateFormat(str2, Locale.PRC).parse(str).getTime());
        } catch (ParseException e2) {
            LogUtils.warn(e2);
            return null;
        }
    }

    public static int trimZero(String str) {
        try {
            if (str.startsWith("0")) {
                str = str.substring(1);
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            LogUtils.warn(e2);
            return 0;
        }
    }

    public static int calculateDaysInMonth(int i, int i2) {
        String[] strArr = {"1", "3", VipSubscribeStatus.SUBSCRIPTION_ON_HOLD, VipSubscribeStatus.SUBSCRIPTION_RESTARTED, VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED, VipSubscribeStatus.SUBSCRIPTION_PAUSED, VipSubscribeStatus.SUBSCRIPTION_REVOKED};
        String[] strArr2 = {VipSubscribeStatus.SUBSCRIPTION_PURCHASED, VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD, VipSubscribeStatus.SUBSCRIPTION_DEFERRED, VipSubscribeStatus.SUBSCRIPTION_PAUSE_SCHEDULE_CHANGED};
        List listAsList = Arrays.asList(strArr);
        List listAsList2 = Arrays.asList(strArr2);
        if (listAsList.contains(String.valueOf(i2))) {
            return 31;
        }
        if (listAsList2.contains(String.valueOf(i2))) {
            return 30;
        }
        if (i <= 0) {
            return 29;
        }
        return ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) ? 28 : 29;
    }

    public static long calculateDifference(Date date, Date date2, int i) {
        long[] jArrCalculateDifference = calculateDifference(date, date2);
        return i == 1 ? jArrCalculateDifference[2] : i == 2 ? jArrCalculateDifference[1] : i == 3 ? jArrCalculateDifference[0] : jArrCalculateDifference[3];
    }

    public static long calculateDifferentDay(long j, long j2) {
        return calculateDifference(j, j2, 3);
    }

    public static long calculateDifferentHour(long j, long j2) {
        return calculateDifference(j, j2, 2);
    }

    public static long calculateDifferentMinute(long j, long j2) {
        return calculateDifference(j, j2, 1);
    }

    public static long calculateDifferentSecond(long j, long j2) {
        return calculateDifference(j, j2, 0);
    }

    public static String formatDate(String str) {
        return formatDate(Calendar.getInstance(Locale.CHINA).getTime(), str);
    }

    public static Date parseDate(String str) {
        return parseDate(str, "yyyy-MM-dd HH:mm:ss");
    }

    private static long[] calculateDifference(Date date, Date date2) {
        return calculateDifference(date2.getTime() - date.getTime());
    }

    private static long[] calculateDifference(long j) {
        long j2 = j / 86400000;
        long j3 = j % 86400000;
        long j4 = j3 / 3600000;
        long j5 = j3 % 3600000;
        long j6 = j5 / 60000;
        long j7 = j5 % 60000;
        long j8 = j7 / 1000;
        LogUtils.verbose(String.format(Locale.CHINA, "different: %d ms, %d days, %d hours, %d minutes, %d seconds", Long.valueOf(j7), Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j8)));
        return new long[]{j2, j4, j6, j8};
    }
}
