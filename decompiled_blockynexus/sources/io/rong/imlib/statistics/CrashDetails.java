package io.rong.imlib.statistics;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.FeatureInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.rong.common.LibStorageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class CrashDetails {
    private static final String TAG = "CrashDetails";
    private static ArrayList<String> logs = new ArrayList<>();
    private static int startTime = Statistics.currentTimestamp();
    private static Map<String, String> customSegments = null;
    private static boolean inBackground = true;
    private static long totalMemory = 0;

    static void addLog(String str) {
        logs.add(str);
    }

    static void fillJSONIfValuesNotEmpty(JSONObject jSONObject, String... strArr) {
        try {
            if (strArr.length <= 0 || strArr.length % 2 != 0) {
                return;
            }
            for (int i = 0; i < strArr.length; i += 2) {
                String str = strArr[i];
                String str2 = strArr[i + 1];
                if (str2 != null && str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            }
        } catch (JSONException unused) {
        }
    }

    static String getBatteryLevel(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
            if (intExtra > -1 && intExtra2 > 0) {
                return Float.toString((intExtra / intExtra2) * 100.0f);
            }
        } catch (Exception unused) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.i("Statistics", "Can't get batter level");
            }
        }
        return null;
    }

    static String getCpu() {
        return Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
    }

    static String getCrashData(Context context, String str, Boolean bool) {
        JSONObject jSONObject = new JSONObject();
        fillJSONIfValuesNotEmpty(jSONObject, "_error", str, "_nonfatal", Boolean.toString(bool.booleanValue()), "_logs", getLogs(), "_device", DeviceInfo.getDevice(), "_os", DeviceInfo.getOS(), "_os_version", DeviceInfo.getOSVersion(), "_resolution", DeviceInfo.getResolution(context), "_app_version", DeviceInfo.getAppVersion(context), "_manufacture", getManufacturer(), "_cpu", getCpu(), "_opengl", getOpenGL(context), "_ram_current", getRamCurrent(context), "_ram_total", getRamTotal(context), "_disk_current", getDiskCurrent(), "_disk_total", getDiskTotal(), "_bat", getBatteryLevel(context), "_run", getRunningTime(), "_orientation", getOrientation(context), "_root", isRooted(), "_online", isOnline(context), "_muted", isMuted(context), "_background", isInBackground());
        try {
            jSONObject.put("_custom", getCustomSegments());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    static JSONObject getCustomSegments() {
        Map<String, String> map = customSegments;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return new JSONObject(customSegments);
    }

    static String getDiskCurrent() {
        if (Build.VERSION.SDK_INT < 18) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            return Long.toString((((long) (statFs.getBlockCount() * statFs.getBlockSize())) - ((long) (statFs.getAvailableBlocks() * statFs.getBlockSize()))) / 1048576);
        }
        StatFs statFs2 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        return Long.toString(((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) - (statFs2.getAvailableBlocksLong() * statFs2.getBlockSizeLong())) / 1048576);
    }

    static String getDiskTotal() {
        if (Build.VERSION.SDK_INT < 18) {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            return Long.toString(((long) (statFs.getBlockCount() * statFs.getBlockSize())) / 1048576);
        }
        StatFs statFs2 = new StatFs(Environment.getRootDirectory().getAbsolutePath());
        return Long.toString((statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576);
    }

    public static String getIMCrashData(Context context, String str) {
        return getCrashData(context, "", true);
    }

    static String getLogs() {
        Iterator<String> it = logs.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + UMCustomLogInfoBuilder.LINE_SEP;
        }
        logs.clear();
        return str;
    }

    static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    static String getOpenGL(Context context) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        if (systemAvailableFeatures != null && systemAvailableFeatures.length > 0) {
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                if (featureInfo.name == null) {
                    int i = featureInfo.reqGlEsVersion;
                    return i != 0 ? Integer.toString((i & (-65536)) >> 16) : "1";
                }
            }
        }
        return "1";
    }

    static String getOrientation(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i == 0) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (i == 1) {
            return "Portrait";
        }
        if (i == 2) {
            return "Landscape";
        }
        if (i != 3) {
            return null;
        }
        return "Square";
    }

    static String getRamCurrent(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Long.toString(getTotalRAM() - (memoryInfo.availMem / 1048576));
    }

    static String getRamTotal(Context context) {
        return Long.toString(getTotalRAM());
    }

    static String getRunningTime() {
        return Integer.toString(Statistics.currentTimestamp() - startTime);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long getTotalRAM() throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getTotalRAM"
            java.lang.String r1 = "CrashDetails"
            long r2 = io.rong.imlib.statistics.CrashDetails.totalMemory
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L67
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L49
            java.lang.String r4 = "/proc/meminfo"
            java.lang.String r5 = "r"
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L49
            java.lang.String r2 = r3.readLine()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            java.lang.String r4 = "(\\d+)"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            java.lang.String r4 = ""
        L26:
            boolean r5 = r2.find()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            if (r5 == 0) goto L32
            r4 = 1
            java.lang.String r4 = r2.group(r4)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            goto L26
        L32:
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            long r4 = java.lang.Long.parseLong(r4)     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            r6 = 1024(0x400, double:5.06E-321)
            long r4 = r4 / r6
            io.rong.imlib.statistics.CrashDetails.totalMemory = r4     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L5b
            r3.close()     // Catch: java.io.IOException -> L56
            goto L67
        L42:
            r2 = move-exception
            goto L4d
        L44:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L5c
        L49:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
        L4d:
            io.rong.common.rlog.RLog.e(r1, r0, r2)     // Catch: java.lang.Throwable -> L5b
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L56
            goto L67
        L56:
            r2 = move-exception
            io.rong.common.rlog.RLog.e(r1, r0, r2)
            goto L67
        L5b:
            r2 = move-exception
        L5c:
            if (r3 == 0) goto L66
            r3.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r3 = move-exception
            io.rong.common.rlog.RLog.e(r1, r0, r3)
        L66:
            throw r2
        L67:
            long r0 = io.rong.imlib.statistics.CrashDetails.totalMemory
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.statistics.CrashDetails.getTotalRAM():long");
    }

    static void inBackground() {
        inBackground = true;
    }

    static void inForeground() {
        inBackground = false;
    }

    static String isInBackground() {
        return Boolean.toString(inBackground);
    }

    static String isMuted(Context context) {
        int ringerMode = ((AudioManager) context.getSystemService(LibStorageUtils.AUDIO)).getRingerMode();
        return (ringerMode == 0 || ringerMode == 1) ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    static String isOnline(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isAvailable()) ? "false" : connectivityManager.getActiveNetworkInfo().isConnected() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        } catch (Exception e2) {
            if (!Statistics.sharedInstance().isLoggingEnabled()) {
                return null;
            }
            Log.w("Statistics", "Got exception determining connectivity", e2);
            return null;
        }
    }

    static String isRooted() {
        for (String str : new String[]{"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"}) {
            if (new File(str).exists()) {
                return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            }
        }
        return "false";
    }

    static void setCustomSegments(Map<String, String> map) {
        customSegments = new HashMap();
        customSegments.putAll(map);
    }
}
