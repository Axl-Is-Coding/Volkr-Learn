package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.umeng.analytics.pro.au;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(boolean z) {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        boolean z2 = inetAddress instanceof Inet4Address;
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        if (z) {
                            if (z2) {
                                return upperCase;
                            }
                        } else if (!z2) {
                            int iIndexOf = upperCase.indexOf(37);
                            return iIndexOf < 0 ? upperCase : upperCase.substring(0, iIndexOf);
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("type", c(context));
            jSONObject.put(au.w, 1);
            jSONObject.put(au.x, Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", q.b(context));
            jSONObject.put("screen_width", ac.c(context));
            jSONObject.put("screen_height", ac.d(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put("android_id", com.bytedance.sdk.openadsdk.core.j.c(context));
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.j.d(context));
            jSONObject.put("rom_version", u.a());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.j.b(context));
            jSONObject.put(au.L, ab.o());
            jSONObject.put(au.M, com.bytedance.sdk.openadsdk.core.j.a());
            jSONObject.put("carrier_name", w.a());
            jSONObject.put("mnc", w.c());
            jSONObject.put("mcc", w.b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        return d(context);
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        if (com.bytedance.sdk.openadsdk.core.h.b().g() != 1) {
            c(jSONObject);
        }
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("gaid", b.a.a.a.a.b.b.a().b());
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        int iF = com.bytedance.sdk.openadsdk.core.h.b().f();
        if ((com.bytedance.sdk.openadsdk.core.o.h().u() == -1 && ab.m()) || com.bytedance.sdk.openadsdk.core.o.h().u() == 1) {
            if (iF == 1 || iF == -1) {
                return;
            }
            b(jSONObject);
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.o.h().u() == 1 && iF == 0) {
            c(jSONObject);
            return;
        }
        boolean z = com.bytedance.sdk.openadsdk.core.o.h().u() == 1 && (iF == 1 || iF == -1);
        boolean z2 = com.bytedance.sdk.openadsdk.core.o.h().u() == -1 && iF == 1;
        if (z || z2) {
            return;
        }
        b(jSONObject);
    }
}
