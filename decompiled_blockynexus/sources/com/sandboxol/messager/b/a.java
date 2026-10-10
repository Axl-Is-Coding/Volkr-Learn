package com.sandboxol.messager.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

/* JADX INFO: compiled from: ProcessUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
