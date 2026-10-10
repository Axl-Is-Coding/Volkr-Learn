package com.ironsource.sdk.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceData.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15409a = "b";

    public static JSONObject a(Context context) {
        i.b(context);
        String strB = i.b();
        Boolean boolValueOf = Boolean.valueOf(i.k());
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(strB)) {
            try {
                com.ironsource.sdk.utils.f.c(f15409a, "add AID and LAT");
                jSONObject.put("isLimitAdTrackingEnabled", boolValueOf);
                jSONObject.put("deviceIds[AID]", i.b(strB));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        d(context, jSONObject);
        f(context, jSONObject);
        b(context, jSONObject);
        e(context, jSONObject);
        b(jSONObject);
        g(context, jSONObject);
        c(context, jSONObject);
        a(context, jSONObject);
        h(context, jSONObject);
        return jSONObject;
    }

    private static void c(Context context, JSONObject jSONObject) {
        try {
            if (a("chargingType")) {
                jSONObject.put(i.b("chargingType"), com.ironsource.environment.b.a(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            String strB = b.f.c.b.b(context);
            if (!TextUtils.isEmpty(strB) && !strB.equals("none")) {
                jSONObject.put(i.b("connectionType"), i.b(strB));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put(i.b("hasVPN"), b.f.c.b.c(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(i.b("deviceVolume"), com.ironsource.sdk.utils.a.b(context).a(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(i.b("diskFreeSize"), i.b(String.valueOf(com.ironsource.environment.b.a(com.ironsource.sdk.utils.e.a(context)))));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            if (a("isCharging")) {
                jSONObject.put(i.b("isCharging"), com.ironsource.environment.b.p(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        try {
            if (a("stayOnWhenPluggedIn")) {
                jSONObject.put(i.b("stayOnWhenPluggedIn"), com.ironsource.environment.b.r(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONObject c(Context context) {
        com.ironsource.sdk.utils.a aVarB = com.ironsource.sdk.utils.a.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String strD = aVarB.d();
            if (strD != null) {
                jSONObject.put(i.b("deviceOEM"), i.b(strD));
            }
            String strC = aVarB.c();
            if (strC != null) {
                jSONObject.put(i.b("deviceModel"), i.b(strC));
            }
            String strE = aVarB.e();
            if (strE != null) {
                jSONObject.put(i.b("deviceOs"), i.b(strE));
            }
            String strF = aVarB.f();
            if (strF != null) {
                jSONObject.put(i.b("deviceOSVersion"), strF.replaceAll("[^0-9/.]", ""));
            }
            String strF2 = aVarB.f();
            if (strF2 != null) {
                jSONObject.put(i.b("deviceOSVersionFull"), i.b(strF2));
            }
            jSONObject.put(i.b("deviceApiLevel"), String.valueOf(aVarB.a()));
            String strG = com.ironsource.sdk.utils.a.g();
            if (strG != null) {
                jSONObject.put(i.b("SDKVersion"), i.b(strG));
            }
            if (aVarB.b() != null && aVarB.b().length() > 0) {
                jSONObject.put(i.b("mobileCarrier"), i.b(aVarB.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(i.b("deviceLanguage"), i.b(language.toUpperCase()));
            }
            if (a("totalDeviceRAM")) {
                jSONObject.put(i.b("totalDeviceRAM"), i.b(String.valueOf(com.ironsource.environment.b.n(context))));
            }
            String strF3 = com.ironsource.environment.a.f(context);
            if (!TextUtils.isEmpty(strF3)) {
                jSONObject.put(i.b("bundleId"), i.b(strF3));
            }
            String strValueOf = String.valueOf(com.ironsource.environment.b.c());
            if (!TextUtils.isEmpty(strValueOf)) {
                jSONObject.put(i.b("deviceScreenScale"), i.b(strValueOf));
            }
            String strValueOf2 = String.valueOf(com.ironsource.environment.b.n());
            if (!TextUtils.isEmpty(strValueOf2)) {
                jSONObject.put(i.b("unLocked"), i.b(strValueOf2));
            }
            jSONObject.put(i.b("gpi"), e.a(context));
            jSONObject.put(i.b("mcc"), b.f.c.a.b(context));
            jSONObject.put(i.b("mnc"), b.f.c.a.c(context));
            jSONObject.put(i.b("phoneType"), b.f.c.a.d(context));
            jSONObject.put(i.b("simOperator"), i.b(b.f.c.a.e(context)));
            jSONObject.put(i.b("lastUpdateTime"), com.ironsource.environment.a.e(context));
            jSONObject.put(i.b("firstInstallTime"), com.ironsource.environment.a.c(context));
            jSONObject.put(i.b("appVersion"), i.b(com.ironsource.environment.a.b(context)));
            String strD2 = com.ironsource.environment.a.d(context);
            if (!TextUtils.isEmpty(strD2)) {
                jSONObject.put(i.b("installerPackageName"), i.b(strD2));
            }
            jSONObject.put("localTime", i.b(String.valueOf(com.ironsource.environment.b.e())));
            jSONObject.put("timezoneOffset", i.b(String.valueOf(com.ironsource.environment.b.i())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(i.b("batteryLevel"), com.ironsource.environment.b.e(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void b(JSONObject jSONObject) {
        try {
            if (a("sdCardAvailable")) {
                jSONObject.put(i.b("sdCardAvailable"), com.ironsource.environment.b.m());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, i.b(str2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(String str) {
        return i.d().optBoolean(str);
    }

    private static void a(JSONObject jSONObject) {
        try {
            a(jSONObject, "displaySizeWidth", String.valueOf(com.ironsource.environment.b.l()));
            a(jSONObject, "displaySizeHeight", String.valueOf(com.ironsource.environment.b.k()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            if (a("airplaneMode")) {
                jSONObject.put(i.b("airplaneMode"), com.ironsource.environment.b.o(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
