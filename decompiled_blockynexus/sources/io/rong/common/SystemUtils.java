package io.rong.common;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import io.rong.common.fwlog.FwLog;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class SystemUtils {
    private static String currentProcessName;

    public static String getCurrentProcessName(Context context) {
        if (context == null) {
            return currentProcessName;
        }
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(currentProcessName)) {
            writeFwlog(packageName);
            return currentProcessName;
        }
        currentProcessName = getCurrentProcessNameByApplication();
        if (!TextUtils.isEmpty(currentProcessName)) {
            writeFwlog(packageName);
            return currentProcessName;
        }
        currentProcessName = getCurrentProcessNameByActivityThread();
        if (!TextUtils.isEmpty(currentProcessName)) {
            writeFwlog(packageName);
            return currentProcessName;
        }
        currentProcessName = getCurrentProcessNameByActivityManager(context);
        if (!TextUtils.isEmpty(currentProcessName)) {
            writeFwlog(packageName);
        }
        return currentProcessName;
    }

    private static String getCurrentProcessNameByActivityManager(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.URL getLegalServer(java.lang.String r6, boolean r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.String r0 = "http"
            boolean r0 = r6.startsWith(r0)
            java.lang.String r2 = "http://"
            if (r0 == 0) goto L1f
            java.lang.String r0 = ""
            java.lang.String r2 = r6.replace(r2, r0)
            java.lang.String r3 = "https://"
            java.lang.String r0 = r2.replace(r3, r0)
            goto L31
        L1f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r5 = r0
            r0 = r6
            r6 = r5
        L31:
            java.net.URL r2 = new java.net.URL     // Catch: java.net.MalformedURLException -> L7f
            r2.<init>(r6)     // Catch: java.net.MalformedURLException -> L7f
            r6 = 1
            r3 = 0
            if (r7 == 0) goto L6b
            java.lang.String r7 = r2.getHost()     // Catch: java.net.MalformedURLException -> L7f
            if (r7 == 0) goto L69
            int r7 = r2.getPort()     // Catch: java.net.MalformedURLException -> L7f
            if (r7 < 0) goto L69
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.net.MalformedURLException -> L7f
            r7.<init>()     // Catch: java.net.MalformedURLException -> L7f
            java.lang.String r4 = r2.getHost()     // Catch: java.net.MalformedURLException -> L7f
            r7.append(r4)     // Catch: java.net.MalformedURLException -> L7f
            java.lang.String r4 = ":"
            r7.append(r4)     // Catch: java.net.MalformedURLException -> L7f
            int r4 = r2.getPort()     // Catch: java.net.MalformedURLException -> L7f
            r7.append(r4)     // Catch: java.net.MalformedURLException -> L7f
            java.lang.String r7 = r7.toString()     // Catch: java.net.MalformedURLException -> L7f
            boolean r7 = r7.equals(r0)     // Catch: java.net.MalformedURLException -> L7f
            if (r7 == 0) goto L69
            goto L7b
        L69:
            r6 = 0
            goto L7b
        L6b:
            java.lang.String r7 = r2.getHost()     // Catch: java.net.MalformedURLException -> L7f
            if (r7 == 0) goto L69
            java.lang.String r7 = r2.getHost()     // Catch: java.net.MalformedURLException -> L7f
            boolean r7 = r7.equals(r0)     // Catch: java.net.MalformedURLException -> L7f
            if (r7 == 0) goto L69
        L7b:
            if (r6 == 0) goto L83
            r1 = r2
            goto L83
        L7f:
            r6 = move-exception
            r6.printStackTrace()
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.common.SystemUtils.getLegalServer(java.lang.String, boolean):java.net.URL");
    }

    public static boolean isLegalServer(String str) {
        return (getLegalServer(str, true) == null && getLegalServer(str, false) == null) ? false : true;
    }

    public static boolean isValidAppKey(String str) {
        return Pattern.compile("^[a-z0-9A-Z]+$").matcher(str).find();
    }

    private static void writeFwlog(String str) {
        if (currentProcessName.equals(str)) {
            return;
        }
        FwLog.write(2, 1, FwLog.LogTag.L_INIT_S.getTag(), "packageName|currentProcessName", str, currentProcessName);
    }
}
