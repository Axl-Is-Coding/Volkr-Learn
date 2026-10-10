package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: InternalConfig.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f20594a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f20594a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static void b(Context context) {
        String[] strArr = f20594a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }

    public static String[] a(Context context) {
        String[] strArrA;
        if (!TextUtils.isEmpty(f20594a[0]) && !TextUtils.isEmpty(f20594a[1])) {
            return f20594a;
        }
        if (context == null || (strArrA = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f20594a;
        strArr[0] = strArrA[0];
        strArr[1] = strArrA[1];
        return strArr;
    }
}
