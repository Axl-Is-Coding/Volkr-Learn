package com.alibaba.mtl.log;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.d.s;
import com.alibaba.mtl.log.sign.IRequestAuth;
import com.alibaba.mtl.log.upload.UploadEngine;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UTDC.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String B = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IRequestAuth f3601a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f51a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f3602b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f3603d;
    private static Context mContext = null;
    public static boolean o = false;
    public static boolean p = false;
    private static boolean q = false;
    public static boolean r = false;
    public static int s = 10000;

    /* JADX INFO: renamed from: s, reason: collision with other field name */
    public static boolean f52s;
    public static int t;

    static {
        q = t <= s;
        B = String.valueOf(System.currentTimeMillis());
        f3603d = new AtomicInteger(0);
        r = true;
        f3601a = null;
        f52s = true;
    }

    public static synchronized void a(Context context) {
        if (context == null) {
            i.a("UTDC", "UTDC init failed ,context:" + context);
            return;
        }
        if (!f51a) {
            f51a = true;
            mContext = context.getApplicationContext();
            UploadEngine.getInstance().start();
        }
    }

    private static void b(final String str, final String str2, final String str3, final String str4, final String str5, Map<String, String> map) {
        final HashMap map2 = new HashMap(map);
        s.a().b(new Runnable() { // from class: com.alibaba.mtl.log.a.1
            @Override // java.lang.Runnable
            public void run() {
                i.a("UTDC", "[commit] page:", str, "eventId:", str2, "arg1:", str3, "arg2:", str4, "arg3:", str5, "args:", map2);
                try {
                    com.alibaba.mtl.log.b.a.m(str2);
                    com.alibaba.mtl.log.c.c.a().a(new com.alibaba.mtl.log.model.a(str, str2, str3, str4, str5, map2));
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static String c() {
        try {
            String[] networkState = l.getNetworkState(getContext());
            return networkState[0].equals("2G/3G") ? networkState[1] : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        } catch (Exception unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static String d() {
        return "";
    }

    public static String e() {
        return "";
    }

    public static Context getContext() {
        return mContext;
    }

    public static void k() {
        i.a("UTDC", "[onBackground]");
        o = true;
        com.alibaba.mtl.log.b.a.C();
    }

    public static void l() {
        i.a("UTDC", "[onForeground]");
        o = false;
        UploadEngine.getInstance().start();
    }

    public static void m() {
        UploadEngine.getInstance().start();
    }

    public static void setChannel(String str) {
        com.alibaba.mtl.log.d.b.o(str);
    }

    public static String b() {
        try {
            return l.getNetworkState(getContext())[0];
        } catch (Exception unused) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static void a(IRequestAuth iRequestAuth) {
        f3601a = iRequestAuth;
        IRequestAuth iRequestAuth2 = f3601a;
        if (iRequestAuth2 != null) {
            com.alibaba.mtl.log.d.b.p(iRequestAuth2.getAppkey());
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (mContext == null) {
            i.a("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (f3601a == null) {
            i.a("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            b(str, str2, str3, str4, str5, map);
        }
    }

    public static IRequestAuth a() {
        IRequestAuth iRequestAuth = f3601a;
        if (iRequestAuth == null || TextUtils.isEmpty(iRequestAuth.getAppkey())) {
            if (!i.l()) {
                Log.w("UTDC", "please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            } else {
                throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
            }
        }
        return f3601a;
    }
}
