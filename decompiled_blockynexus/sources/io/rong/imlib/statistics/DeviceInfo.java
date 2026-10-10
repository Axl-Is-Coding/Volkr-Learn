package io.rong.imlib.statistics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.map.geolocation.TencentLocation;
import com.umeng.analytics.pro.au;
import io.rong.imlib.common.BuildVar;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
class DeviceInfo {
    DeviceInfo() {
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

    static String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.i("Statistics", "No app version found");
            }
            return "1.0";
        }
    }

    static String getCarrier(Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (SecurityException unused) {
        }
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        if (networkOperatorName != null && networkOperatorName.length() != 0) {
            return networkOperatorName;
        }
        if (Statistics.sharedInstance().isLoggingEnabled()) {
            Log.i("Statistics", "No carrier found");
        }
        return "";
    }

    static String getDensity(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i != 120 ? i != 160 ? i != 213 ? i != 240 ? i != 320 ? i != 400 ? i != 480 ? i != 640 ? "" : "XXXHDPI" : "XXHDPI" : "XMHDPI" : "XHDPI" : "HDPI" : "TVDPI" : "MDPI" : "LDPI";
    }

    static String getDevice() {
        return Build.MODEL;
    }

    static String getLocale() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    static String getMetrics(Context context) {
        String displayName;
        JSONObject jSONObject = new JSONObject();
        try {
            displayName = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError unused) {
            displayName = "";
        }
        fillJSONIfValuesNotEmpty(jSONObject, "device", getDevice(), "osName", getOS(), "osVersion", getOSVersion(), au.O, getCarrier(context), au.y, getResolution(context), "density", getDensity(context), "locale", getLocale(), "appVersion", getAppVersion(context), "channel", getStore(context), "bundleId", context.getPackageName(), "sdkVersion", BuildVar.SDK_VERSION, TencentLocation.NETWORK_PROVIDER, getNetworkType(context), "timeZone", displayName);
        String string = jSONObject.toString();
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException unused2) {
            return string;
        }
    }

    static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "MOBILE";
            }
        }
        return "UNKNOWN";
    }

    static String getOS() {
        return "Android";
    }

    static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    static String getResolution(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        } catch (Throwable unused) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.i("Statistics", "Device resolution cannot be determined");
            }
            return "";
        }
    }

    static String getStore(Context context) {
        String installerPackageName;
        if (Build.VERSION.SDK_INT < 3) {
            return "";
        }
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Exception unused) {
            if (Statistics.sharedInstance().isLoggingEnabled()) {
                Log.i("Statistics", "Can't get Installer package");
            }
            installerPackageName = "";
        }
        if (installerPackageName != null && installerPackageName.length() != 0) {
            return installerPackageName;
        }
        if (!Statistics.sharedInstance().isLoggingEnabled()) {
            return "";
        }
        Log.i("Statistics", "No store found");
        return "";
    }
}
