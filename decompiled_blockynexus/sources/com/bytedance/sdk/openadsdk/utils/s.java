package com.bytedance.sdk.openadsdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7127a;

    public static String a(Context context) {
        int iMyPid;
        String str = f7127a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            iMyPid = Process.myPid();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                if (o.a()) {
                    o.b("Process", "processName = " + runningAppProcessInfo.processName);
                }
                f7127a = runningAppProcessInfo.processName;
                return f7127a;
            }
            f7127a = a();
            return f7127a;
        }
        f7127a = a();
        return f7127a;
    }

    private static String a() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i <= 0) {
                        break;
                    }
                    sb.append((char) i);
                }
                if (o.a()) {
                    o.b("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th = th;
        }
    }
}
