package com.disabngo.blockynexus.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.util.Log;
import com.disabngo.blockynexus.entity.SandboxDeviceInfo;
import java.util.List;

/* JADX INFO: compiled from: ProcessHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7185a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f7186b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f7187c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f7188d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f7189e = 4;

    public static int a(Context context) {
        String strB = b(context);
        String packageName = context.getApplicationContext().getPackageName();
        if ("special machine".equals(strB)) {
            return f7187c;
        }
        if (packageName.equals(strB)) {
            return f7185a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(":ipc");
        return sb.toString().equals(strB) ? f7188d : "io.rong.push".equals(strB) ? f7189e : f7186b;
    }

    public static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "special machine";
        }
        String str = "";
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.pid == iMyPid) {
                str = runningAppProcessInfo.processName;
            }
        }
        return str;
    }

    public static SandboxDeviceInfo c(Context context) {
        long blockSize;
        String strSubstring;
        SandboxDeviceInfo sandboxDeviceInfo = new SandboxDeviceInfo();
        sandboxDeviceInfo.setName(Build.BRAND + "_" + Build.MODEL);
        StringBuilder sb = new StringBuilder();
        sb.append("Android");
        sb.append(Build.VERSION.RELEASE);
        sandboxDeviceInfo.setVersion(sb.toString());
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            sandboxDeviceInfo.setRam((memoryInfo.totalMem / 1048576) + "M");
        }
        if (Build.VERSION.SDK_INT >= 18) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockCountLong = statFs.getBlockCountLong();
            statFs.getAvailableBlocksLong();
            blockSize = blockCountLong * statFs.getBlockSizeLong();
        } else {
            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
            blockSize = ((long) statFs2.getBlockSize()) * ((long) statFs2.getBlockCount());
        }
        sandboxDeviceInfo.setRom((blockSize / 1048576) + "M");
        String[] strArr = Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        StringBuilder sb2 = new StringBuilder();
        for (String str : strArr) {
            sb2.append(str);
            sb2.append(",");
        }
        try {
            strSubstring = sb2.toString().substring(0, sb2.toString().length() - 1);
        } catch (Exception e2) {
            Log.e("app", e2.getMessage());
            strSubstring = "";
        }
        sandboxDeviceInfo.setCpu(strSubstring + "");
        return sandboxDeviceInfo;
    }
}
