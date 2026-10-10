package io.rong.imkit.utils;

import android.content.Context;
import android.provider.Settings;
import com.umeng.analytics.pro.au;
import io.rong.imkit.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class RongDateUtils {
    private static final int OTHER = 2014;
    private static final int TODAY = 6;
    private static final int YESTERDAY = 15;

    public static String formatDate(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String getConversationFormatDate(long j, Context context) {
        return getDateTimeString(j, true, context);
    }

    public static String getConversationListFormatDate(long j, Context context) {
        return getDateTimeString(j, false, context);
    }

    private static String getDateTimeString(long j, boolean z, Context context) {
        String date;
        if (j <= 0) {
            return "";
        }
        Date date2 = new Date(j);
        int iJudgeDate = judgeDate(date2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j);
        calendar.setTimeInMillis(jCurrentTimeMillis);
        int i = calendar2.get(2);
        int i2 = calendar2.get(1);
        int i3 = calendar2.get(4);
        int i4 = calendar.get(2);
        int i5 = calendar.get(1);
        int i6 = calendar.get(4);
        if (iJudgeDate == 6) {
            return getTimeString(j, context);
        }
        if (iJudgeDate == 15) {
            String string = context.getResources().getString(R.string.rc_yesterday_format);
            if (!z) {
                return string;
            }
            return string + " " + getTimeString(j, context);
        }
        if (iJudgeDate != OTHER) {
            return null;
        }
        if (i2 == i5) {
            if (i == i4 && i3 == i6) {
                date = getWeekDay(context, calendar2.get(7));
            } else if (context.getResources().getConfiguration().locale.getCountry().equals("CN")) {
                date = formatDate(date2, "M" + context.getResources().getString(R.string.rc_month_format) + au.au + context.getResources().getString(R.string.rc_day_format));
            } else {
                date = formatDate(date2, "M/d");
            }
        } else if (context.getResources().getConfiguration().locale.getCountry().equals("CN")) {
            date = formatDate(date2, "yyyy" + context.getResources().getString(R.string.rc_year_format) + "M" + context.getResources().getString(R.string.rc_month_format) + au.au + context.getResources().getString(R.string.rc_day_format));
        } else {
            date = formatDate(date2, "M/d/yy");
        }
        if (!z) {
            return date;
        }
        return date + " " + getTimeString(j, context);
    }

    private static String getTimeString(long j, Context context) {
        String string;
        if (j <= 0) {
            return "";
        }
        Date date = new Date(j);
        if (isTime24Hour(context)) {
            return formatDate(date, "HH:mm");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(10);
        if (calendar.get(9) == 0) {
            if (i < 6) {
                if (i == 0) {
                    i = 12;
                }
                string = context.getResources().getString(R.string.rc_daybreak_format);
            } else {
                string = context.getResources().getString(R.string.rc_morning_format);
            }
        } else if (i == 0) {
            string = context.getResources().getString(R.string.rc_noon_format);
            i = 12;
        } else {
            string = i <= 5 ? context.getResources().getString(R.string.rc_afternoon_format) : context.getResources().getString(R.string.rc_night_format);
        }
        int i2 = calendar.get(12);
        String string2 = Integer.toString(i2);
        if (i2 < 10) {
            string2 = "0" + string2;
        }
        String str = i + ":" + string2;
        if (context.getResources().getConfiguration().locale.getCountry().equals("CN")) {
            return string + str;
        }
        return str + " " + string;
    }

    private static String getWeekDay(Context context, int i) {
        switch (i) {
            case 1:
                return context.getResources().getString(R.string.rc_sunsay_format);
            case 2:
                return context.getResources().getString(R.string.rc_monday_format);
            case 3:
                return context.getResources().getString(R.string.rc_tuesday_format);
            case 4:
                return context.getResources().getString(R.string.rc_wednesday_format);
            case 5:
                return context.getResources().getString(R.string.rc_thuresday_format);
            case 6:
                return context.getResources().getString(R.string.rc_friday_format);
            case 7:
                return context.getResources().getString(R.string.rc_saturday_format);
            default:
                return "";
        }
    }

    public static boolean isShowChatTime(long j, long j2, int i) {
        return judgeDate(new Date(j)) != judgeDate(new Date(j2)) || j - j2 > ((long) (i * 1000));
    }

    public static boolean isTime24Hour(Context context) {
        String string = Settings.System.getString(context.getContentResolver(), "time_12_24");
        return string != null && string.equals("24");
    }

    public static int judgeDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(5, -1);
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.add(5, 1);
        calendar3.set(11, 0);
        calendar3.set(12, 0);
        calendar3.set(13, 0);
        calendar3.set(14, 0);
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime(date);
        if (calendar4.before(calendar2)) {
            return OTHER;
        }
        if (calendar4.before(calendar)) {
            return 15;
        }
        if (calendar4.before(calendar3)) {
            return 6;
        }
        return OTHER;
    }
}
