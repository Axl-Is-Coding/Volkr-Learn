package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Process;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: InitChecker.java */
/* JADX INFO: loaded from: classes.dex */
public class k {
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ad A[Catch: Throwable -> 0x00d4, TRY_LEAVE, TryCatch #1 {Throwable -> 0x00d4, blocks: (B:34:0x00a5, B:37:0x00ad), top: B:46:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.k.a():void");
    }

    private static String b(Context context) {
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return "unknown";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.WAKE_LOCK");
        return arrayList;
    }

    public static boolean a(Context context) {
        o.e("TTAdSdk-InitChecker", "Start to check if TTMultiProvider and FileProvider are registered in AndroidManifest");
        boolean z = false;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders != null && listQueryContentProviders.size() != 0) {
            boolean z2 = false;
            for (ProviderInfo providerInfo : listQueryContentProviders) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (!TextUtils.isEmpty(str) && str.equals(providerInfo.authority)) {
                        o.e("TTAdSdk-InitChecker", "TTMultiProvider configuration in AndroidManifest.xml is normal");
                        z = true;
                        z2 = true;
                    } else {
                        o.e("TTAdSdk-InitChecker", "TTMultiProvider configuration exception in AndroidManifest.xml: android: authorities, please refer to the access documentation");
                        z = true;
                    }
                }
            }
            if (!z) {
                o.e("TTAdSdk-InitChecker", "You have not configured TTMultiProvider, please refer to the access documentation, otherwise it will affect the conversion");
            }
            o.e("TTAdSdk-InitChecker", "End the check of whether TTMultiProvider and FileProvider are registered in AndroidManifest");
            return z2;
        }
        o.e("TTAdSdk-InitChecker", "TTMultiProvider isTTMultiProviderRegistered pInfos == null or pInfos.size() == 0");
        return false;
    }
}
