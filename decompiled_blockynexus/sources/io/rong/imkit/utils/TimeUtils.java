package io.rong.imkit.utils;

import android.content.Context;
import io.rong.imkit.R;
import io.rong.imkit.RongIM;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class TimeUtils {
    public static String formatData(long j) {
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        if (applicationContext == null || j == 0) {
            return "";
        }
        int i = (int) (j / 86400000);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        return i == iCurrentTimeMillis ? formatDate(j, "HH:mm") : i + 1 == iCurrentTimeMillis ? applicationContext.getResources().getString(R.string.rc_yesterday_format) : formatDate(j, "yyyy-MM-dd");
    }

    private static String formatDate(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String formatTime(long j) {
        Context applicationContext = RongIM.getInstance().getApplicationContext();
        if (applicationContext == null || j == 0) {
            return "";
        }
        int i = (int) (j / 86400000);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 86400000);
        return i == iCurrentTimeMillis ? formatDate(j, "HH:mm") : i + 1 == iCurrentTimeMillis ? applicationContext.getResources().getString(R.string.rc_yesterday_format) : formatDate(j, "yyyy-MM-dd HH:mm");
    }
}
