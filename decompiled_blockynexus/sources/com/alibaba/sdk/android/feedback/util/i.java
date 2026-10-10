package com.alibaba.sdk.android.feedback.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.facebook.internal.AnalyticsEvents;
import com.ta.utdid2.device.UTDevice;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3721a = "i";

    public static Map a(Context context) {
        String string;
        HashMap map = new HashMap();
        if (context != null) {
            try {
                map.put("package", context.getPackageName());
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                String str = packageInfo.versionName;
                if (str == null || str.length() <= 0) {
                    str = "";
                }
                if (FeedbackAPI.mExtInfo == null || !FeedbackAPI.mExtInfo.has("AppVersionReplacement")) {
                    string = str;
                } else {
                    string = FeedbackAPI.mExtInfo.getString("AppVersionReplacement");
                    com.alibaba.sdk.android.feedback.xblink.i.g.a(f3721a, "FeedbackAPI Read property of AppVersionReplacement, the actual app_version " + packageInfo.versionName + " has been replaced with " + string);
                }
                if (string == null || string.length() <= 0) {
                    string = "";
                }
                map.put("app_version", string);
                map.put("sdk_version", "2.0.0");
                map.put(au.w, "0");
                map.put(au.x, Build.VERSION.RELEASE);
                map.put("device_model", Build.MODEL);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                int i = displayMetrics.widthPixels;
                map.put(au.y, displayMetrics.heightPixels + "x" + i);
                try {
                    String[] strArrC = c(context);
                    map.put(au.P, strArrC[0]);
                    if (strArrC[0].equals("2G/3G")) {
                        map.put(au.Q, strArrC[1]);
                    } else {
                        map.put(au.Q, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
                    }
                } catch (Exception unused) {
                    map.put(au.P, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
                    map.put(au.Q, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkOperatorName = telephonyManager.getNetworkOperatorName();
                    if (TextUtils.isEmpty(networkOperatorName)) {
                        networkOperatorName = "";
                    }
                    map.put(au.O, networkOperatorName);
                }
                map.put(au.D, Build.BOARD);
                map.put(au.E, Build.BRAND);
                map.put(au.G, Build.MANUFACTURER);
                map.put("device_uuid", b(context));
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a(f3721a, "getDeviceInfo Exception", e2);
            }
        }
        return map;
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    private static String[] c(Context context) {
        String[] strArr = {AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN};
        try {
        } catch (Exception e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(f3721a, "getNetworkState Exception", e2);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            strArr[0] = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "2G/3G";
            strArr[1] = networkInfo2.getSubtypeName();
            return strArr;
        }
        return strArr;
    }
}
