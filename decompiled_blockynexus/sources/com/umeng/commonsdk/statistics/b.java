package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocationListener;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManagerEx;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfigEx;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21142a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f21143b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f21144c = "EnvelopeManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f21145d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f21146f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f21147e = 0;

    public static long a(Context context) {
        long j = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(f21144c, "free size is " + j);
        }
        return j;
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("header", new JSONObject());
            if (jSONObject != null) {
                a(jSONObject3, jSONObject);
            }
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelopeA = a(context, jSONObject3.toString().getBytes());
            if (envelopeA == null) {
                return a(111, jSONObject3);
            }
            if (envelopeA != null && DataHelper.largeThanMaxSize(envelopeA.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelopeA, "z==1.2.0", jSONObject3.optJSONObject("header").optString("app_version"));
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(f21144c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private JSONObject a(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str;
        String string;
        Envelope envelopeA;
        String str2;
        String str3;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(f21144c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(f21144c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context != null && jSONObject2 != null) {
            try {
                JSONObject jSONObjectB = b(context);
                if (jSONObjectB != null && jSONObject != null) {
                    a(jSONObjectB, jSONObject);
                }
                if (jSONObjectB != null && jSONObject2 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null && (next instanceof String) && (str3 = next) != null && jSONObject2.opt(str3) != null) {
                            try {
                                jSONObjectB.put(str3, jSONObject2.opt(str3));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (jSONObjectB != null) {
                    StringBuilder sb = new StringBuilder();
                    if (jSONObjectB.length() > 0) {
                        if (jSONObjectB.has("push")) {
                            String strOptString = jSONObjectB.optJSONObject("header").optString(au.aC);
                            if (!TextUtils.isEmpty(au.aw) && !TextUtils.isEmpty(strOptString)) {
                                sb.append(au.aw);
                                sb.append("==");
                                sb.append(strOptString);
                                sb.append("&=");
                            }
                        }
                        if (jSONObjectB.has("share")) {
                            String strOptString2 = jSONObjectB.optJSONObject("header").optString(au.aD);
                            if (!TextUtils.isEmpty(au.ax) && !TextUtils.isEmpty(strOptString2)) {
                                sb.append(au.ax);
                                sb.append("==");
                                sb.append(strOptString2);
                                sb.append("&=");
                            }
                        }
                        if (jSONObjectB.has("analytics")) {
                            if (jSONObjectB.has("dplus")) {
                                str2 = au.av;
                            } else {
                                str2 = jSONObjectB.optJSONObject("header").has("st") ? au.az : au.at;
                            }
                            String strOptString3 = jSONObjectB.optJSONObject("header").optString("sdk_version");
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strOptString3)) {
                                sb.append(str2);
                                sb.append("==");
                                sb.append(strOptString3);
                                sb.append("&=");
                            }
                        }
                        if (jSONObjectB.has("dplus")) {
                            String strOptString4 = jSONObjectB.optJSONObject("header").optString("sdk_version");
                            if (jSONObjectB.has("analytics")) {
                                if (!sb.toString().contains(au.av) && !TextUtils.isEmpty(au.av) && !TextUtils.isEmpty(strOptString4)) {
                                    sb.append(au.av);
                                    sb.append("==");
                                    sb.append(strOptString4);
                                    sb.append("&=");
                                }
                            } else if (!TextUtils.isEmpty(au.au) && !TextUtils.isEmpty(strOptString4)) {
                                sb.append(au.au);
                                sb.append("==");
                                sb.append(strOptString4);
                                sb.append("&=");
                            }
                        }
                        if (jSONObjectB.has(au.as)) {
                            String strOptString5 = jSONObjectB.optJSONObject("header").optString(au.aE);
                            if (!TextUtils.isEmpty(au.ay) && !TextUtils.isEmpty(strOptString5)) {
                                sb.append(au.ay);
                                sb.append("==");
                                sb.append(strOptString5);
                                sb.append("&=");
                            }
                        }
                    }
                    string = sb.toString();
                    if (TextUtils.isEmpty(string)) {
                        return a(101, jSONObjectB);
                    }
                    if (string.endsWith("&=")) {
                        string = string.substring(0, string.length() - 2);
                    }
                } else {
                    string = null;
                }
                if (jSONObjectB != null) {
                    try {
                        h hVarA = h.a(context);
                        if (hVarA != null) {
                            hVarA.a();
                            String strEncodeToString = Base64.encodeToString(new bl().a(hVarA.b()), 0);
                            if (!TextUtils.isEmpty(strEncodeToString)) {
                                JSONObject jSONObject5 = jSONObjectB.getJSONObject("header");
                                jSONObject5.put(au.X, strEncodeToString);
                                jSONObjectB.put("header", jSONObject5);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObjectB != null && DataHelper.largeThanMaxSize(jSONObjectB.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObjectB);
                }
                if (jSONObjectB != null) {
                    envelopeA = a(context, jSONObjectB.toString().getBytes());
                    if (envelopeA == null) {
                        return a(111, jSONObjectB);
                    }
                } else {
                    envelopeA = null;
                }
                if (envelopeA != null && DataHelper.largeThanMaxSize(envelopeA.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObjectB);
                }
                int iA = a(context, envelopeA, string, jSONObjectB != null ? jSONObjectB.optJSONObject("header").optString("app_version") : null);
                if (iA != 0) {
                    return a(iA, jSONObjectB);
                }
                if (ULog.DEBUG) {
                    Log.i(f21144c, "constructHeader size is " + jSONObjectB.toString().getBytes().length);
                }
                return jSONObjectB;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
                if (jSONObject != null) {
                    try {
                        jSONObject3 = new JSONObject();
                        try {
                            try {
                                jSONObject3.put("header", jSONObject);
                            } catch (Exception e2) {
                                e = e2;
                                UMCrashManager.reportCrash(context, e);
                                return a(110, jSONObject3);
                            }
                        } catch (JSONException unused3) {
                        }
                        jSONObject4 = jSONObject2;
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject3 = null;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                } else {
                    jSONObject4 = jSONObject2;
                    jSONObject3 = null;
                }
                if (jSONObject4 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    if (jSONObject4 != null) {
                        Iterator<String> itKeys2 = jSONObject2.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            if (next2 != null && (next2 instanceof String) && (str = next2) != null && jSONObject4.opt(str) != null) {
                                try {
                                    jSONObject3.put(str, jSONObject4.opt(str));
                                } catch (Exception unused4) {
                                }
                            }
                        }
                    }
                }
                return a(110, jSONObject3);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static JSONObject b(Context context) {
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(f21145d)) {
                try {
                    jSONObject = new JSONObject(f21145d);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(au.o, DeviceConfigEx.getAppMD5Signature(context));
                jSONObject2.put(au.p, DeviceConfigEx.getAppSHA1Key(context));
                jSONObject2.put(au.q, DeviceConfigEx.getAppHashKey(context));
                jSONObject2.put("app_version", DeviceConfigEx.getAppVersionName(context));
                jSONObject2.put("version_code", Integer.parseInt(DeviceConfigEx.getAppVersionCode(context)));
                jSONObject2.put(au.u, DeviceConfigEx.getDeviceIdUmengMD5(context));
                jSONObject2.put(au.v, DeviceConfigEx.getCPU());
                String mccmnc = DeviceConfigEx.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject2.put(au.A, mccmnc);
                    f21143b = mccmnc;
                } else {
                    jSONObject2.put(au.A, "");
                }
                String subOSName = DeviceConfigEx.getSubOSName(context);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject2.put(au.J, subOSName);
                }
                String subOSVersion = DeviceConfigEx.getSubOSVersion(context);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject2.put(au.K, subOSVersion);
                }
                String deviceType = DeviceConfigEx.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject2.put(au.ah, deviceType);
                }
                jSONObject2.put(au.n, DeviceConfigEx.getPackageName(context));
                jSONObject2.put(au.t, "Android");
                jSONObject2.put("device_id", DeviceConfigEx.getDeviceId(context));
                if (FieldManagerEx.allow(com.umeng.commonsdk.utils.b.k)) {
                    jSONObject2.put("device_model", Build.MODEL);
                    jSONObject2.put(au.D, Build.BOARD);
                    jSONObject2.put(au.E, Build.BRAND);
                    jSONObject2.put(au.F, Build.TIME);
                    jSONObject2.put(au.G, Build.MANUFACTURER);
                    jSONObject2.put(au.H, Build.ID);
                    jSONObject2.put(au.I, Build.DEVICE);
                    jSONObject2.put(au.x, Build.VERSION.RELEASE);
                }
                jSONObject2.put(au.w, "Android");
                int[] resolutionArray = DeviceConfigEx.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject2.put(au.y, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject2.put(au.z, DeviceConfigEx.getMac(context));
                jSONObject2.put(au.L, DeviceConfigEx.getTimeZone(context));
                String[] localeInfo = DeviceConfigEx.getLocaleInfo(context);
                jSONObject2.put("country", localeInfo[0]);
                jSONObject2.put(au.M, localeInfo[1]);
                jSONObject2.put(au.O, DeviceConfigEx.getNetworkOperatorName(context));
                jSONObject2.put(au.r, DeviceConfigEx.getAppName(context));
                String[] networkAccessMode = DeviceConfigEx.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject2.put(au.P, TencentLocationListener.WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject2.put(au.P, "2G/3G");
                } else {
                    jSONObject2.put(au.P, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject2.put(au.Q, networkAccessMode[1]);
                }
                jSONObject2.put(au.R, DeviceConfigEx.getIPAddress(context));
                jSONObject2.put(au.S, DeviceConfigEx.getNetworkType(context));
                jSONObject2.put(au.f20659b, "9.1.6+000");
                jSONObject2.put(au.f20660c, SdkVersion.SDK_TYPE);
                if (!TextUtils.isEmpty(f21142a)) {
                    jSONObject2.put(au.f20661d, f21142a);
                }
                jSONObject2.put(au.ai, Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMConfigure.VALUE_REC_VERSION_NAME)) {
                    jSONObject2.put(au.ae, UMConfigure.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject2.put("session_id", uUIDForZid);
                } catch (Throwable unused2) {
                }
                f21145d = jSONObject2.toString();
                jSONObject = jSONObject2;
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(au.aj, UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put(au.T, sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(au.U, sharedPreferences.getInt(au.U, 0));
                jSONObject.put(au.V, sharedPreferences.getInt("last_request_spent_ms", 0));
                if (UMConfigure.sShouldCollectZData) {
                    String zData = UMUtils.getZData(context);
                    if (!TextUtils.isEmpty(zData)) {
                        jSONObject.put(au.ak, zData);
                        jSONObject.put(au.al, UMUtils.getZDataRequestTime(context));
                        jSONObject.put(au.am, com.umeng.commonsdk.internal.c.a());
                    }
                }
            } catch (Exception unused4) {
            }
            jSONObject.put("channel", UMUtils.getChannel(context));
            jSONObject.put("appkey", UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(au.f20658a, deviceToken);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, au.f20663f, null);
                if (!TextUtils.isEmpty(strImprintProperty)) {
                    jSONObject.put(au.f20663f, strImprintProperty);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put("wrapper_type", a.f21139a);
                jSONObject.put("wrapper_version", a.f21140b);
            } catch (Exception unused5) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean zCheckPermission = UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE");
                boolean zCheckPermission2 = UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION");
                boolean zCheckPermission3 = UMUtils.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION");
                jSONObject.put(au.aK, targetSdkVersion);
                if (zCheckPermission) {
                    jSONObject.put(au.aL, "yes");
                } else {
                    jSONObject.put(au.aL, "no");
                }
                if (zCheckPermission2) {
                    jSONObject.put(au.aM, "yes");
                } else {
                    jSONObject.put(au.aM, "no");
                }
                if (zCheckPermission3) {
                    jSONObject.put(au.aN, "yes");
                } else {
                    jSONObject.put(au.aN, "no");
                }
            } catch (Throwable unused6) {
            }
            byte[] bArrA = ImprintHandler.getImprintService(context).a();
            if (bArrA != null && bArrA.length > 0) {
                try {
                    jSONObject.put(au.W, Base64.encodeToString(bArrA, 0));
                } catch (JSONException e4) {
                    UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                return new JSONObject().put("header", jSONObject);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return null;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt("header") != null && (jSONObject.opt("header") instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt("header");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(com.umeng.analytics.pro.b.i) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f21147e = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f21146f) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfigEx.getAppVersionName(context);
        }
        return UMFrUtils.saveEnvelopeFile(context, str + "&&" + str2 + "_" + System.currentTimeMillis() + "_envelope.log", envelope.toBinary());
    }

    public static void a(boolean z) {
        f21146f = z;
    }
}
