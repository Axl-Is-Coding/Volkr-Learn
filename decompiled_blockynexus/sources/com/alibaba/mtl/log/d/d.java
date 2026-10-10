package com.alibaba.mtl.log.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.log.model.LogField;
import com.facebook.internal.AnalyticsEvents;
import com.umeng.analytics.pro.au;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: DeviceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static Map<String, String> v;

    public static synchronized Map<String, String> a(Context context) {
        if (v != null) {
            v.put(LogField.CHANNEL.toString(), b.m());
            v.put(LogField.APPKEY.toString(), b.getAppkey());
            a(v, context);
            return v;
        }
        if (context == null) {
            return null;
        }
        v = new HashMap();
        try {
            String imei = m.getImei(context);
            String imsi = m.getImsi(context);
            if (TextUtils.isEmpty(imei) || TextUtils.isEmpty(imsi)) {
                imei = "";
                imsi = "";
            }
            v.put(LogField.IMEI.toString(), imei);
            v.put(LogField.IMSI.toString(), imsi);
            v.put(LogField.BRAND.toString(), Build.BRAND);
            v.put(LogField.DEVICE_MODEL.toString(), Build.MODEL);
            v.put(LogField.RESOLUTION.toString(), c(context));
            v.put(LogField.CHANNEL.toString(), b.m());
            v.put(LogField.APPKEY.toString(), b.getAppkey());
            v.put(LogField.APPVERSION.toString(), d(context));
            v.put(LogField.LANGUAGE.toString(), b(context));
            v.put(LogField.OS.toString(), q());
            v.put(LogField.OSVERSION.toString(), p());
            v.put(LogField.SDKVERSION.toString(), SdkMeta.SDK_VERSION);
            v.put(LogField.SDKTYPE.toString(), "mini");
            try {
                v.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
            } catch (Throwable th) {
                Log.e("DeviceUtil", "utdid4all jar doesn't exist, please copy the libs folder.");
                th.printStackTrace();
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperatorName = "";
                if (telephonyManager != null && telephonyManager.getSimState() == 5) {
                    networkOperatorName = telephonyManager.getNetworkOperatorName();
                }
                if (TextUtils.isEmpty(networkOperatorName)) {
                    networkOperatorName = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                }
                v.put(LogField.CARRIER.toString(), networkOperatorName);
            } catch (Exception unused) {
            }
            a(v, context);
            return v;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static String b(Context context) {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    private static String c(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i > i2) {
                int i3 = i ^ i2;
                i2 ^= i3;
                i = i3 ^ i2;
            }
            return i2 + "*" + i;
        } catch (Exception unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String d(Context context) {
        String strF = com.alibaba.mtl.log.b.a().f();
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            v.put(LogField.APPVERSION.toString(), packageInfo.versionName);
            return packageInfo.versionName;
        } catch (Throwable unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static boolean i() {
        try {
            if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null && TextUtils.isEmpty(r.get("ro.yunos.build.version"))) {
                return j();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean j() {
        return (TextUtils.isEmpty(r.get("ro.yunos.product.chip")) && TextUtils.isEmpty(r.get("ro.yunos.hardware"))) ? false : true;
    }

    private static String p() {
        String strT = Build.VERSION.RELEASE;
        if (i()) {
            String property = System.getProperty("ro.yunos.version");
            if (!TextUtils.isEmpty(property)) {
                return property;
            }
            strT = t();
            if (!TextUtils.isEmpty(strT)) {
            }
        }
        return strT;
    }

    private static String q() {
        return (!i() || j()) ? au.at : "y";
    }

    public static String r() {
        String str = r.get("ro.aliyun.clouduuid", "false");
        if ("false".equals(str)) {
            str = r.get("ro.sys.aliyun.clouduuid", "false");
        }
        return TextUtils.isEmpty(str) ? s() : str;
    }

    private static String s() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String t() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField == null) {
                return null;
            }
            declaredField.setAccessible(true);
            return (String) declaredField.get(new String());
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Map<String, String> map, Context context) {
        try {
            String[] networkState = l.getNetworkState(context);
            map.put(LogField.ACCESS.toString(), networkState[0]);
            if (networkState[0].equals("2G/3G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), networkState[1]);
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            }
        } catch (Exception unused) {
            map.put(LogField.ACCESS.toString(), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            map.put(LogField.ACCESS_SUBTYPE.toString(), AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        }
    }
}
