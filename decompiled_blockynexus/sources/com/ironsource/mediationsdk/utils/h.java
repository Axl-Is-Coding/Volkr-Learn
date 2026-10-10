package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.U;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.C2353h;
import com.umeng.analytics.pro.au;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: GeneralPropertiesWorker.java */
/* JADX INFO: loaded from: classes2.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15031a = h.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15032b = "bundleId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f15033c = "advertisingId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15034d = "isLimitAdTrackingEnabled";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f15035e = "appKey";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15036f = "deviceOS";
    private final String g = "osVersion";
    private final String h = "connectionType";
    private final String i = au.M;
    private final String j = "deviceOEM";
    private final String k = "deviceModel";
    private final String l = "mobileCarrier";
    private final String m = "externalFreeMemory";
    private final String n = "internalFreeMemory";
    private final String o = au.Y;
    private final String p = "gmtMinutesOffset";
    private final String q = "appVersion";
    private final String r = "sessionId";
    private final String s = "pluginType";
    private final String t = "pluginVersion";
    private final String u = "plugin_fw_v";
    private final String v = "jb";
    private final String w = "advertisingIdType";
    private final String x = "mt";
    private Context y;

    public h(Context context) {
        this.y = context.getApplicationContext();
    }

    private Map<String, Object> a() {
        String strL;
        String[] strArrC;
        String str = "";
        HashMap map = new HashMap();
        map.put("sessionId", j.e());
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("bundleId", strE);
            String strA = com.ironsource.environment.a.a(this.y, strE);
            if (!TextUtils.isEmpty(strA)) {
                map.put("appVersion", strA);
            }
        }
        map.put("appKey", c());
        boolean zBooleanValue = false;
        try {
            strArrC = com.ironsource.environment.b.c(this.y);
        } catch (Exception unused) {
        }
        if (strArrC == null || strArrC.length != 2) {
            strL = "";
        } else {
            strL = !TextUtils.isEmpty(strArrC[0]) ? strArrC[0] : "";
            try {
                zBooleanValue = Boolean.valueOf(strArrC[1]).booleanValue();
            } catch (Exception unused2) {
            }
        }
        if (TextUtils.isEmpty(strL)) {
            strL = com.ironsource.environment.b.l(this.y);
            if (!TextUtils.isEmpty(strL)) {
                str = "UUID";
            }
        } else {
            str = "GAID";
        }
        if (!TextUtils.isEmpty(strL)) {
            map.put("advertisingId", strL);
            map.put("advertisingIdType", str);
            map.put("isLimitAdTrackingEnabled", Boolean.valueOf(zBooleanValue));
        }
        map.put("deviceOS", h());
        if (!TextUtils.isEmpty(b())) {
            map.put("osVersion", b());
        }
        String strB = j.b(this.y);
        if (!TextUtils.isEmpty(strB)) {
            map.put("connectionType", strB);
        }
        map.put("sdkVersion", r());
        String strL2 = l();
        if (!TextUtils.isEmpty(strL2)) {
            map.put(au.M, strL2);
        }
        String strG = g();
        if (!TextUtils.isEmpty(strG)) {
            map.put("deviceOEM", strG);
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            map.put("deviceModel", strF);
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            map.put("mobileCarrier", strN);
        }
        map.put("internalFreeMemory", Long.valueOf(k()));
        map.put("externalFreeMemory", Long.valueOf(i()));
        map.put(au.Y, Integer.valueOf(d()));
        int iJ = j();
        if (a(iJ)) {
            map.put("gmtMinutesOffset", Integer.valueOf(iJ));
        }
        String strP = p();
        if (!TextUtils.isEmpty(strP)) {
            map.put("pluginType", strP);
        }
        String strQ = q();
        if (!TextUtils.isEmpty(strQ)) {
            map.put("pluginVersion", strQ);
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            map.put("plugin_fw_v", strO);
        }
        String strValueOf = String.valueOf(com.ironsource.environment.b.n());
        if (!TextUtils.isEmpty(strValueOf)) {
            map.put("jb", strValueOf);
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            map.put("mt", strM);
        }
        return map;
    }

    private String b() {
        try {
            String str = Build.VERSION.RELEASE;
            return "" + Build.VERSION.SDK_INT + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private String c() {
        return U.e().f();
    }

    private int d() {
        try {
            Intent intentRegisterReceiver = this.y.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, this.f15031a + ":getBatteryLevel()", e2);
            return -1;
        }
    }

    private String e() {
        try {
            return this.y.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private String h() {
        return "Android";
    }

    private long i() {
        if (!s()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, this.f15031a + ":getGmtMinutesOffset()", e2);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private String m() {
        return U.e().i();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.y.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, this.f15031a + ":getMobileCarrier()", e2);
            return "";
        }
    }

    private String o() {
        try {
            return com.ironsource.mediationsdk.a.a.a().b();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e2);
            return "";
        }
    }

    private String p() {
        try {
            return com.ironsource.mediationsdk.a.a.a().c();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e2);
            return "";
        }
    }

    private String q() {
        try {
            return com.ironsource.mediationsdk.a.a.a().d();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e2);
            return "";
        }
    }

    private String r() {
        return j.c();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C2353h.a().a(a());
            j.a(this.y, C2353h.a().b());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.c().a(IronSourceLogger.IronSourceTag.NATIVE, "Thread name = " + h.class.getSimpleName(), e2);
        }
    }

    private boolean a(int i) {
        return i <= 840 && i >= -720 && i % 15 == 0;
    }
}
