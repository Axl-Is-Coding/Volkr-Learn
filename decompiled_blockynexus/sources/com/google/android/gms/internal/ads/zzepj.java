package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepj {
    private static String zziuw;

    public static String zzcl(Context context) {
        String str = zziuw;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        String str2 = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.activityInfo.packageName : null;
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            Intent intent2 = new Intent();
            intent2.setAction("android.support.customtabs.action.CustomTabsService");
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            if (packageManager.resolveService(intent2, 0) != null) {
                arrayList.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (arrayList.isEmpty()) {
            zziuw = null;
        } else if (arrayList.size() == 1) {
            zziuw = (String) arrayList.get(0);
        } else if (!TextUtils.isEmpty(str2) && !zzd(context, intent) && arrayList.contains(str2)) {
            zziuw = str2;
        } else if (arrayList.contains("com.android.chrome")) {
            zziuw = "com.android.chrome";
        } else if (arrayList.contains("com.chrome.beta")) {
            zziuw = "com.chrome.beta";
        } else if (arrayList.contains("com.chrome.dev")) {
            zziuw = "com.chrome.dev";
        } else if (arrayList.contains("com.google.android.apps.chrome")) {
            zziuw = "com.google.android.apps.chrome";
        }
        return zziuw;
    }

    private static boolean zzd(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities;
        try {
            listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        } catch (RuntimeException unused) {
            Log.e("CustomTabsHelper", "Runtime exception while getting specialized handlers");
        }
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() != 0) {
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                IntentFilter intentFilter = resolveInfo.filter;
                if (intentFilter != null && intentFilter.countDataAuthorities() != 0 && intentFilter.countDataPaths() != 0 && resolveInfo.activityInfo != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
