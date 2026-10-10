package com.ironsource.environment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.rong.common.LibStorageUtils;
import io.rong.common.dlog.DLog;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: compiled from: DeviceStatus.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14590a;

    private static long a(File file) {
        long availableBlocksLong;
        long blockSizeLong;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 19) {
            availableBlocksLong = statFs.getAvailableBlocks();
            blockSizeLong = statFs.getBlockSize();
        } else {
            availableBlocksLong = statFs.getAvailableBlocksLong();
            blockSizeLong = statFs.getBlockSizeLong();
        }
        return (availableBlocksLong * blockSizeLong) / 1048576;
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String[] c(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        Object objInvoke = cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(cls, context);
        Method method = objInvoke.getClass().getMethod("getId", new Class[0]);
        Method method2 = objInvoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        return new String[]{method.invoke(objInvoke, new Object[0]).toString(), "" + ((Boolean) method2.invoke(objInvoke, new Object[0])).booleanValue()};
    }

    public static int d(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static long e() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    public static String f() {
        return Build.MODEL;
    }

    public static String g() {
        return Build.MANUFACTURER;
    }

    public static String h() {
        return "android";
    }

    public static List<ApplicationInfo> h(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static int i() {
        return -(TimeZone.getDefault().getOffset(e()) / 60000);
    }

    public static boolean j(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    public static String k(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
    }

    public static int l() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static boolean m() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
    }

    public static long n(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static boolean o(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean p(Context context) {
        int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean q(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static boolean r(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    private static boolean b(String str) {
        try {
            for (String str2 : new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}) {
                if (new File(str2 + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int f(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static File g(Context context) {
        return context.getExternalCacheDir();
    }

    public static String i(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static float m(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(LibStorageUtils.AUDIO);
        return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
    }

    public static int d() {
        return k();
    }

    public static int k() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static synchronized String l(Context context) {
        if (!TextUtils.isEmpty(f14590a)) {
            return f14590a;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Mediation_Shared_Preferences", 0);
            if (sharedPreferences.getBoolean("uuidEnabled", true)) {
                String string = sharedPreferences.getString("cachedUUID", "");
                if (TextUtils.isEmpty(string)) {
                    f14590a = UUID.randomUUID().toString();
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("cachedUUID", f14590a);
                    editorEdit.apply();
                } else {
                    f14590a = string;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return f14590a;
    }

    public static int e(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int j() {
        return l();
    }

    public static boolean n() {
        return b("su");
    }

    public static int a(Context context) {
        return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
    }

    public static int b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static float c() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static long a(String str) {
        return a(new File(str));
    }

    @TargetApi(19)
    public static boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | DLog.CRS) == systemUiVisibility;
    }
}
