package com.bytedance.sdk.adnet.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: ProcessUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5560a;

    public static boolean a(Context context) {
        String strC = c(context);
        return strC != null && (strC.endsWith(":push") || strC.endsWith(":pushservice"));
    }

    public static boolean b(Context context) {
        String strC = c(context);
        return (strC == null || !strC.contains(":")) && strC != null && strC.equals(context.getPackageName());
    }

    public static String c(Context context) {
        int iMyPid;
        String str = f5560a;
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
                f5560a = runningAppProcessInfo.processName;
                return f5560a;
            }
            f5560a = a();
            return f5560a;
        }
        f5560a = a();
        return f5560a;
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
