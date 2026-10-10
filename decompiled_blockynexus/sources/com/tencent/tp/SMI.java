package com.tencent.tp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SMI implements d {
    @Override // com.tencent.tp.d
    public String a(Context context) {
        try {
            return Build.BRAND;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tencent.tp.d
    public List b(Context context) {
        PackageManager packageManager;
        if (context != null && (packageManager = context.getPackageManager()) != null) {
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            try {
                HashSet hashSet = new HashSet();
                Iterator<PackageInfo> it = installedPackages.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().packageName);
                }
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent("android.intent.action.MAIN"), 1)) {
                    if (hashSet.add(resolveInfo.activityInfo.applicationInfo.packageName)) {
                        PackageInfo packageInfo = new PackageInfo();
                        packageInfo.applicationInfo = resolveInfo.activityInfo.applicationInfo;
                        packageInfo.packageName = null;
                        installedPackages.add(packageInfo);
                    }
                }
            } catch (Throwable unused) {
            }
            return installedPackages;
        }
        return new ArrayList();
    }

    @Override // com.tencent.tp.d
    public List c(Context context) {
        ActivityManager activityManager;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService("activity")) != null) {
            return activityManager.getRunningServices(10000);
        }
        return new ArrayList();
    }
}
