package com.tendcloud.tenddata;

import android.content.Context;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class w {
    public static void a(Context context, String str, String str2, long j) {
        try {
            context.getSharedPreferences(str, 0).edit().putLong(str2, j).commit();
        } catch (Throwable unused) {
        }
    }

    public static long b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        try {
            context.getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
        } catch (Throwable unused) {
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable unused) {
            return str3;
        }
    }
}
