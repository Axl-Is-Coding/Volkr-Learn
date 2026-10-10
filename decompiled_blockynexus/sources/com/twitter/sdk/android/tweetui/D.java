package com.twitter.sdk.android.tweetui;

import android.content.res.Resources;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: TweetDateUtils.java */
/* JADX INFO: loaded from: classes5.dex */
final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final SimpleDateFormat f20324a = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final a f20325b = new a();

    /* JADX INFO: compiled from: TweetDateUtils.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a.a.j<SimpleDateFormat> f20326a = new a.a.j<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Locale f20327b;

        a() {
        }

        synchronized String a(Resources resources, Date date) {
            return a(resources, R.string.tw__relative_date_format_long).format(date);
        }

        synchronized String b(Resources resources, Date date) {
            return a(resources, R.string.tw__relative_date_format_short).format(date);
        }

        private synchronized DateFormat a(Resources resources, int i) {
            SimpleDateFormat simpleDateFormatA;
            if (this.f20327b == null || this.f20327b != resources.getConfiguration().locale) {
                this.f20327b = resources.getConfiguration().locale;
                this.f20326a.b();
            }
            simpleDateFormatA = this.f20326a.a(i);
            if (simpleDateFormatA == null) {
                simpleDateFormatA = new SimpleDateFormat(resources.getString(i), Locale.getDefault());
                this.f20326a.c(i, simpleDateFormatA);
            }
            return simpleDateFormatA;
        }
    }

    static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return f20324a.parse(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }

    static String b(String str) {
        return "• " + str;
    }

    static boolean c(String str) {
        return a(str) != -1;
    }

    static String a(Resources resources, long j, long j2) {
        long j3 = j - j2;
        if (j3 < 0) {
            return f20325b.a(resources, new Date(j2));
        }
        if (j3 < 60000) {
            int i = (int) (j3 / 1000);
            return resources.getQuantityString(R.plurals.tw__time_secs, i, Integer.valueOf(i));
        }
        if (j3 < 3600000) {
            int i2 = (int) (j3 / 60000);
            return resources.getQuantityString(R.plurals.tw__time_mins, i2, Integer.valueOf(i2));
        }
        if (j3 < 86400000) {
            int i3 = (int) (j3 / 3600000);
            return resources.getQuantityString(R.plurals.tw__time_hours, i3, Integer.valueOf(i3));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j2);
        Date date = new Date(j2);
        return calendar.get(1) == calendar2.get(1) ? f20325b.b(resources, date) : f20325b.a(resources, date);
    }
}
