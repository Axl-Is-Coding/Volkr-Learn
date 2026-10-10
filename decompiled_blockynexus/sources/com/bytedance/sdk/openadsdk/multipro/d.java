package com.bytedance.sdk.openadsdk.multipro;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: compiled from: TTMultiInitHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a(context.getApplicationContext());
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            int iMyPid = Process.myPid();
            String str = context.getPackageName() + iMyPid;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    str = runningAppProcessInfo.processName;
                }
            }
            WebView.setDataDirectorySuffix(str);
        } catch (Exception e2) {
            o.b(e2.toString());
        }
    }
}
