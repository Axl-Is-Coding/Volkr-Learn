package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: UtcDates.java */
/* JADX INFO: loaded from: classes2.dex */
class C {
    static Calendar a() {
        return a(Calendar.getInstance());
    }

    static Calendar b() {
        return b((Calendar) null);
    }

    @TargetApi(24)
    static DateFormat c(Locale locale) {
        return a("yMMMEd", locale);
    }

    private static TimeZone d() {
        return TimeZone.getTimeZone("UTC");
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone e() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar a(Calendar calendar) {
        Calendar calendarB = b(calendar);
        Calendar calendarB2 = b();
        calendarB2.set(calendarB.get(1), calendarB.get(2), calendarB.get(5));
        return calendarB2;
    }

    static Calendar b(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(d());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    static SimpleDateFormat c() {
        return d(Locale.getDefault());
    }

    private static SimpleDateFormat d(Locale locale) {
        return b("MMMM, yyyy", locale);
    }

    private static SimpleDateFormat b(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(d());
        return simpleDateFormat;
    }

    static java.text.DateFormat b(Locale locale) {
        return a(0, locale);
    }

    static long a(long j) {
        Calendar calendarB = b();
        calendarB.setTimeInMillis(j);
        return a(calendarB).getTimeInMillis();
    }

    @TargetApi(24)
    private static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(e());
        return instanceForSkeleton;
    }

    private static java.text.DateFormat a(int i, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i, locale);
        dateInstance.setTimeZone(d());
        return dateInstance;
    }

    @TargetApi(24)
    static DateFormat a(Locale locale) {
        return a("MMMEd", locale);
    }
}
