package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class x {
    private x() {
    }

    public static List<k> a() {
        ArrayList arrayList = new ArrayList();
        try {
            for (File file : new File("/proc").listFiles()) {
                if (file != null && file.isDirectory()) {
                    try {
                        int i = Integer.parseInt(file.getName());
                        k kVar = new k(-1);
                        if ((kVar.f20028b < 1000 || kVar.f20028b > 9999) && !kVar.f20029c.contains(":") && !kVar.f20029c.contains("/")) {
                            arrayList.add(new k(i));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    public static boolean b() {
        try {
            List<k> listA = a();
            int iMyPid = Process.myPid();
            for (k kVar : listA) {
                if (kVar.f20030d == iMyPid && kVar.f20027a) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<ActivityManager.RunningAppProcessInfo> b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 22) {
                List<k> listA = a();
                ArrayList arrayList = new ArrayList();
                for (k kVar : listA) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo(kVar.f20029c, kVar.f20030d, null);
                    runningAppProcessInfo.uid = kVar.f20028b;
                    arrayList.add(runningAppProcessInfo);
                }
                return arrayList;
            }
            return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<k> a(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrListFiles = new File("/proc").listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file != null && file.isDirectory()) {
                        try {
                            k kVar = new k(Integer.parseInt(file.getName()));
                            if (kVar.f20027a && ((kVar.f20028b < 1000 || kVar.f20028b > 9999) && !kVar.f20029c.contains(":") && !kVar.f20029c.contains("/"))) {
                                arrayList.add(kVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }

    public static String a(Context context, int i) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
