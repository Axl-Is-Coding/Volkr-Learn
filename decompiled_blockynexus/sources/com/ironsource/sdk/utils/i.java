package com.ironsource.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SDKUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15437a = "i";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15438b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f15439c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f15440d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f15441e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f15442f = null;
    private static Map<String, String> g = null;
    private static String h = "";
    private static final AtomicInteger i = new AtomicInteger(1);

    public static int a(long j) {
        return (int) ((j * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String b(int i2) {
        return i2 != 1 ? i2 != 2 ? "none" : "landscape" : "portrait";
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String c(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 11) {
                    if (i2 != 12) {
                        switch (i2) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return "portrait";
        }
        return "landscape";
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str.split(File.separator)[r1.length - 1].split("\\?")[0], "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        try {
            String string = new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())).toString(16);
            while (string.length() < 32) {
                string = "0" + string;
            }
            return string;
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String e() {
        return !TextUtils.isEmpty(f15440d) ? f15440d : "";
    }

    public static void f(String str) {
        f15442f = str;
    }

    public static void g(String str) {
        f15440d = str;
    }

    public static String h() {
        return "5.88";
    }

    public static String i() {
        return h;
    }

    public static boolean j() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static boolean k() {
        return f15439c;
    }

    private static int l() {
        int i2;
        int i3;
        do {
            i2 = i.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!i.compareAndSet(i2, i3));
        return i2;
    }

    public static void b(Context context) {
        try {
            String[] strArrC = com.ironsource.environment.b.c(context);
            f15438b = strArrC[0];
            f15439c = Boolean.valueOf(strArrC[1]).booleanValue();
        } catch (Exception e2) {
            if (e2.getMessage() != null) {
                f.c(f15437a, e2.getClass().getSimpleName() + ": " + e2.getMessage());
            }
            if (e2.getCause() != null) {
                f.c(f15437a, e2.getClass().getSimpleName() + ": " + e2.getCause());
            }
        }
    }

    public static Map<String, String> f() {
        return g;
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            return d().getJSONObject("networkConfig");
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, b(com.ironsource.environment.b.f(context)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static SSAEnums$ProductType e(String str) {
        if (str.equalsIgnoreCase(SSAEnums$ProductType.RewardedVideo.toString())) {
            return SSAEnums$ProductType.RewardedVideo;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.Interstitial.toString())) {
            return SSAEnums$ProductType.Interstitial;
        }
        if (str.equalsIgnoreCase(SSAEnums$ProductType.OfferWall.toString())) {
            return SSAEnums$ProductType.OfferWall;
        }
        return null;
    }

    public static String a(String str, String str2) {
        return String.format("%s Failure occurred during initiation at: %s", str, str2);
    }

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            f.a(f15437a, "Failed decoding string " + e2.getMessage());
            return "";
        }
    }

    public static String c() {
        return f15442f;
    }

    public static String c(String str, String str2) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException(str2);
    }

    public static JSONObject d() {
        try {
            return new JSONObject(c());
        } catch (Exception e2) {
            e2.printStackTrace();
            return new JSONObject();
        }
    }

    public static void a(int i2) {
        f15441e = i2;
    }

    public static int a(boolean z) {
        int i2 = Build.VERSION.SDK_INT >= 14 ? 2 : 0;
        if (Build.VERSION.SDK_INT >= 16) {
            i2 |= 1796;
        }
        return (Build.VERSION.SDK_INT < 19 || !z) ? i2 : i2 | 4096;
    }

    public static String b() {
        return f15438b;
    }

    public static void b(Map<String, String> map) {
        g = map;
    }

    public static String b(String str, String str2) {
        try {
            return new JSONObject(str).getString(str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int a() {
        if (Build.VERSION.SDK_INT < 17) {
            return l();
        }
        return View.generateViewId();
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            jSONObject3 = new JSONObject(jSONObject.toString());
        }
        if (jSONObject2 != null) {
            jSONArray = jSONObject2.names();
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                jSONObject3.putOpt(string, jSONObject2.opt(string));
            }
        }
        return jSONObject3;
    }

    public static String a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                try {
                    jSONObject.putOpt(next.getKey(), b(next.getValue()));
                } catch (JSONException e2) {
                    f.c(f15437a, "flatMapToJsonAsStringfailed " + e2.toString());
                }
                it.remove();
            }
        }
        return jSONObject.toString();
    }

    public static Map<String, String> a(Map<String, String>[] mapArr) {
        HashMap map = new HashMap();
        if (mapArr == null) {
            return map;
        }
        for (Map<String, String> map2 : mapArr) {
            if (map2 != null) {
                map.putAll(map2);
            }
        }
        return map;
    }

    public static String a(com.ironsource.sdk.data.f fVar) {
        return a(fVar.a());
    }

    public static String a(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("demandSourceId");
        return !TextUtils.isEmpty(strOptString) ? strOptString : jSONObject.optString("demandSourceName");
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Activity activity) {
        return (activity instanceof ControllerActivity) || (activity instanceof OpenUrlActivity);
    }
}
