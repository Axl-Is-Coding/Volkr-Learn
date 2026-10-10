package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.C2353h;
import com.tencent.map.geolocation.TencentLocationListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f15038a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f15039b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f15040c = null;

    public static String a(String str) {
        try {
            String string = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (string.length() < 32) {
                string = "0" + string;
            }
            return string;
        } catch (Throwable th) {
            if (str == null) {
                com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:null)", th);
                return "";
            }
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:" + str + ")", th);
            return "";
        }
    }

    public static String b(String str) {
        return j(str);
    }

    public static String c() {
        return "7.0.2";
    }

    public static synchronized void c(Context context, String str, int[] iArr) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            String string = null;
            if (iArr != null) {
                StringBuilder sb = new StringBuilder();
                for (int i : iArr) {
                    sb.append(i);
                    sb.append(",");
                }
                string = sb.toString();
            }
            editorEdit.putString(h(str), string);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptOutEvents(eventType: " + str + ", optOutEvents:" + iArr + ")", e2);
        }
    }

    public static int d() {
        return f15038a;
    }

    private static String e(String str) {
        return "IS".equals(str) ? "default_is_events_formatter_type" : "RV".equals(str) ? "default_rv_events_formatter_type" : "";
    }

    private static String f(String str) {
        return "IS".equals(str) ? "default_is_non_connectivity_events" : "RV".equals(str) ? "default_rv_non_connectivity_events" : "";
    }

    private static String g(String str) {
        return "IS".equals(str) ? "default_is_opt_in_events" : "RV".equals(str) ? "default_rv_opt_in_events" : "";
    }

    private static String h(String str) {
        return "IS".equals(str) ? "default_is_opt_out_events" : "RV".equals(str) ? "default_rv_opt_out_events" : "";
    }

    private static String i(String str) {
        return "IS".equals(str) ? "default_is_trigger_events" : "RV".equals(str) ? "default_rv_trigger_events" : "";
    }

    private static String j(String str) {
        try {
            return String.format("%064x", new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e2) {
            if (str == null) {
                com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:null)", e2);
                return "";
            }
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:" + str + ")", e2);
            return "";
        }
    }

    public static String b(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities == null ? "none" : networkCapabilities.hasTransport(1) ? TencentLocationListener.WIFI : networkCapabilities.hasTransport(0) ? "cellular" : "none";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return TencentLocationListener.WIFI;
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return "cellular";
            }
        }
        return "none";
    }

    private static String d(String str) {
        return "IS".equals(str) ? "default_is_events_url" : "RV".equals(str) ? "default_rv_events_url" : "";
    }

    public static synchronized void e(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            editorEdit.putString(d(str), str2);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsURL(eventType: " + str + ", eventsUrl:" + str2 + ")", e2);
        }
    }

    public static synchronized void f(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putString("last_response", str);
        editorEdit.apply();
    }

    public static String g() {
        String strA = C2353h.a().a("userIdType");
        String strA2 = C2353h.a().a("userId");
        if (strA == null || !strA.equals("userGenerated") || TextUtils.isEmpty(strA2)) {
            return null;
        }
        return strA2;
    }

    public static boolean h() {
        try {
            Class.forName("androidx.appcompat.app.AppCompatActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized void d(Context context, String str, int[] iArr) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            String string = null;
            if (iArr != null) {
                StringBuilder sb = new StringBuilder();
                for (int i : iArr) {
                    sb.append(i);
                    sb.append(",");
                }
                string = sb.toString();
            }
            editorEdit.putString(i(str), string);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultTriggerEvents(eventType: " + str + ", triggerEvents:" + iArr + ")", e2);
        }
    }

    public static long f() {
        return System.currentTimeMillis();
    }

    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static synchronized void e(Context context, String str) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            editorEdit.putString("browser_user_agent", str);
            editorEdit.apply();
        } catch (Exception e2) {
            IronLog.NATIVE.error("failed to save browser user agent - exception = " + e2);
        }
    }

    static void f(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static synchronized void a(Context context, String str, int[] iArr) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            String string = null;
            if (iArr != null) {
                StringBuilder sb = new StringBuilder();
                for (int i : iArr) {
                    sb.append(i);
                    sb.append(",");
                }
                string = sb.toString();
            }
            editorEdit.putString(f(str), string);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultNonConnectivityEvents(eventType: " + str + ", nonConnectivityEvents:" + iArr + ")", e2);
        }
    }

    public static synchronized int[] c(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(h(str), null);
            if (!TextUtils.isEmpty(string)) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                ArrayList arrayList = new ArrayList();
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                }
                iArr = new int[arrayList.size()];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptOutEvents(eventType: " + str + ")", e2);
        }
        return iArr;
    }

    public static synchronized void b(Context context, String str, int[] iArr) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            String string = null;
            if (iArr != null) {
                StringBuilder sb = new StringBuilder();
                for (int i : iArr) {
                    sb.append(i);
                    sb.append(",");
                }
                string = sb.toString();
            }
            editorEdit.putString(g(str), string);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptInEvents(eventType: " + str + ", optInEvents:" + iArr + ")", e2);
        }
    }

    public static synchronized void d(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            editorEdit.putString(e(str), str2);
            editorEdit.commit();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsFormatterType(eventType: " + str + ", formatterType:" + str2 + ")", e2);
        }
    }

    public static synchronized String e() {
        if (f15039b.compareAndSet(false, true)) {
            f15040c = UUID.randomUUID().toString();
        }
        return f15040c;
    }

    public static synchronized String a(Context context, String str, String str2) {
        try {
            str2 = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(e(str), str2);
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsFormatterType(eventType: " + str + ", defaultFormatterType:" + str2 + ")", e2);
        }
        return str2;
    }

    public static synchronized int[] d(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(i(str), null);
            if (!TextUtils.isEmpty(string)) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                ArrayList arrayList = new ArrayList();
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                }
                iArr = new int[arrayList.size()];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultTriggerEvents(eventType: " + str + ")", e2);
        }
        return iArr;
    }

    public static synchronized String b(Context context, String str, String str2) {
        try {
            str2 = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(d(str), str2);
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsURL(eventType: " + str + ", defaultEventsURL:" + str2 + ")", e2);
        }
        return str2;
    }

    public static String c(Context context) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("last_response", "");
    }

    public static synchronized String a(Context context) {
        String string;
        string = "";
        try {
            string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("browser_user_agent", "");
        } catch (Exception e2) {
            IronLog.NATIVE.error("failed to get browser user agent - exception = " + e2);
        }
        return string;
    }

    static String c(Context context, String str, String str2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(str, str2);
    }

    public static synchronized int[] b(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(g(str), null);
            if (!TextUtils.isEmpty(string)) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                ArrayList arrayList = new ArrayList();
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                }
                iArr = new int[arrayList.size()];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptInEvents(eventType: " + str + ")", e2);
        }
        return iArr;
    }

    public static synchronized void c(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "automation_log:" + Long.toString(System.currentTimeMillis()) + " text: " + str, 1);
    }

    public static synchronized int[] a(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(f(str), null);
            if (!TextUtils.isEmpty(string)) {
                StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                ArrayList arrayList = new ArrayList();
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                }
                iArr = new int[arrayList.size()];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultNonConnectivityEvents(eventType: " + str + ")", e2);
        }
        return iArr;
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static JSONObject b(boolean z) {
        return a(z, false, 1);
    }

    static void b(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    static synchronized void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putString("general_properties", jSONObject.toString());
        editorEdit.apply();
    }

    static void b(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public static JSONObject a(AbstractSmash abstractSmash) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("providerPriority", abstractSmash.x());
            jSONObject.put("spId", abstractSmash.y());
            jSONObject.put(com.umeng.analytics.pro.b.L, abstractSmash.o());
            jSONObject.put("providerSDKVersion", abstractSmash.q().getCoreSDKVersion());
            jSONObject.put("providerAdapterVersion", abstractSmash.q().getVersion());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getProviderAdditionalData(adapter: " + abstractSmash.w() + ")", e2);
        }
        return jSONObject;
    }

    static void b(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public static String b() {
        return C2353h.a().a("userId");
    }

    public static JSONObject a(BannerSmash bannerSmash) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("spId", bannerSmash.e());
            jSONObject.put(com.umeng.analytics.pro.b.L, bannerSmash.a());
            jSONObject.put("providerSDKVersion", bannerSmash.b().getCoreSDKVersion());
            jSONObject.put("providerAdapterVersion", bannerSmash.b().getVersion());
            jSONObject.put("providerPriority", bannerSmash.d());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getProviderAdditionalData(adapter: " + bannerSmash.c() + ")", e2);
        }
        return jSONObject;
    }

    public static JSONObject a(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.b.L, "Mediation");
            if (z) {
                jSONObject.put("ext1", "dynamic");
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject a(boolean z, boolean z2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.analytics.pro.b.L, "Mediation");
            if (z) {
                jSONObject.put("isDemandOnly", 1);
            }
            if (z2) {
                jSONObject.put("programmatic", i);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    static boolean a(Context context, String str, boolean z) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getBoolean(str, z);
    }

    static int a(Context context, String str, int i) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getInt(str, i);
    }

    static long a(Context context, String str, long j) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getLong(str, j);
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.get(next));
            }
        }
        return jSONObject;
    }

    static Map<String, String> a(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        map.put(next, jSONObject.get(next).toString());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return map;
    }
}
