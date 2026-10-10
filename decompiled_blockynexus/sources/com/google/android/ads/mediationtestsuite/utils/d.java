package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.umeng.analytics.pro.m;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppInfoUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<ActivityInfo> f12670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<String> f12671b;

    public static void a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), m.a.f20899a);
            f12671b = Arrays.asList(packageInfo.requestedPermissions);
            f12670a = Arrays.asList(packageInfo.activities);
        } catch (Exception unused) {
            Log.e("TESTTOOL", "Failed to load permissions and activities from PackageManager.");
        }
    }

    public static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean c(String str) {
        return f12671b.contains(str);
    }

    public static boolean b(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean a(String str) {
        Iterator<ActivityInfo> it = f12670a.iterator();
        while (it.hasNext()) {
            if (it.next().name.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
