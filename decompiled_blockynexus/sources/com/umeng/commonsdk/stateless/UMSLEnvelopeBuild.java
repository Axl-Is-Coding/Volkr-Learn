package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.map.geolocation.TencentLocationListener;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.g;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UMSLEnvelopeBuild {
    private static final String TAG = "UMSLEnvelopeBuild";
    private static String cacheSystemheader;
    private static boolean isEncryptEnabled;
    public static Context mContext;
    public static String module;

    private synchronized c constructEnvelope(Context context, byte[] bArr) {
        c cVarA;
        int iIntValue = -1;
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "slcodex", null);
        ULog.i("walle", "[stateless] build envelope, codexStr is " + strImprintProperty);
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 0");
            cVarA = c.a(context, UMUtils.getAppkey(context), bArr);
        } else if (iIntValue == 1) {
            ULog.i("walle", "[stateless] build envelope, codexValue is 1");
            cVarA = c.b(context, UMUtils.getAppkey(context), bArr);
        } else if (isEncryptEnabled) {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is true");
            cVarA = c.b(context, UMUtils.getAppkey(context), bArr);
        } else {
            ULog.i("walle", "[stateless] build envelope, isEncryptEnabled is false");
            cVarA = c.a(context, UMUtils.getAppkey(context), bArr);
        }
        return cVarA;
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return UMEnvelopeBuild.getTransmissionSendFlag();
    }

    private synchronized JSONObject makeErrorResult(int i, JSONObject jSONObject) {
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

    public static void setEncryptEnabled(boolean z) {
        isEncryptEnabled = z;
    }

    public synchronized JSONObject buildSLBaseHeader(Context context) {
        JSONObject jSONObject;
        ULog.i("walle", "[stateless] begin build hader, thread is " + Thread.currentThread());
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            if (TextUtils.isEmpty(cacheSystemheader)) {
                jSONObject = new JSONObject();
                jSONObject.put(au.o, DeviceConfig.getAppMD5Signature(applicationContext));
                jSONObject.put(au.p, DeviceConfig.getAppSHA1Key(applicationContext));
                jSONObject.put(au.q, DeviceConfig.getAppHashKey(applicationContext));
                jSONObject.put("app_version", DeviceConfig.getAppVersionName(applicationContext));
                jSONObject.put("version_code", Integer.parseInt(DeviceConfig.getAppVersionCode(applicationContext)));
                jSONObject.put(au.u, DeviceConfig.getDeviceIdUmengMD5(applicationContext));
                jSONObject.put(au.v, DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(applicationContext);
                if (TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(au.A, "");
                } else {
                    jSONObject.put(au.A, mccmnc);
                }
                String subOSName = DeviceConfig.getSubOSName(applicationContext);
                if (!TextUtils.isEmpty(subOSName)) {
                    jSONObject.put(au.J, subOSName);
                }
                String subOSVersion = DeviceConfig.getSubOSVersion(applicationContext);
                if (!TextUtils.isEmpty(subOSVersion)) {
                    jSONObject.put(au.K, subOSVersion);
                }
                String deviceType = DeviceConfig.getDeviceType(applicationContext);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(au.ah, deviceType);
                }
                jSONObject.put(au.n, DeviceConfig.getPackageName(applicationContext));
                jSONObject.put(au.t, "Android");
                jSONObject.put("device_id", DeviceConfig.getDeviceId(applicationContext));
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put(au.D, Build.BOARD);
                jSONObject.put(au.E, Build.BRAND);
                jSONObject.put(au.F, Build.TIME);
                jSONObject.put(au.G, Build.MANUFACTURER);
                jSONObject.put(au.H, Build.ID);
                jSONObject.put(au.I, Build.DEVICE);
                jSONObject.put(au.x, Build.VERSION.RELEASE);
                jSONObject.put(au.w, "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(applicationContext);
                if (resolutionArray != null) {
                    jSONObject.put(au.y, resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(au.z, DeviceConfig.getMac(applicationContext));
                jSONObject.put(au.L, DeviceConfig.getTimeZone(applicationContext));
                String[] localeInfo = DeviceConfig.getLocaleInfo(applicationContext);
                jSONObject.put("country", localeInfo[0]);
                jSONObject.put(au.M, localeInfo[1]);
                jSONObject.put(au.O, DeviceConfig.getNetworkOperatorName(applicationContext));
                jSONObject.put(au.r, DeviceConfig.getAppName(applicationContext));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(applicationContext);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject.put(au.P, TencentLocationListener.WIFI);
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject.put(au.P, "2G/3G");
                } else {
                    jSONObject.put(au.P, "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(au.Q, networkAccessMode[1]);
                }
                jSONObject.put(au.f20659b, "9.1.6+000");
                jSONObject.put(au.f20660c, SdkVersion.SDK_TYPE);
                if (!TextUtils.isEmpty(module)) {
                    jSONObject.put(au.f20661d, module);
                }
                jSONObject.put(au.ai, Build.VERSION.SDK_INT);
                cacheSystemheader = jSONObject.toString();
            } else {
                try {
                    jSONObject = new JSONObject(cacheSystemheader);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(au.aj, UMUtils.getOaidRequiredTime(applicationContext));
            } catch (Exception unused2) {
            }
            jSONObject.put("channel", UMUtils.getChannel(applicationContext));
            jSONObject.put("appkey", UMUtils.getAppkey(applicationContext));
            try {
                String strImprintProperty = UMEnvelopeBuild.imprintProperty(applicationContext, au.f20663f, null);
                if (!TextUtils.isEmpty(strImprintProperty)) {
                    jSONObject.put(au.f20663f, strImprintProperty);
                }
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("wrapper_type", a.f21102a);
                jSONObject.put("wrapper_version", a.f21103b);
            } catch (Exception unused4) {
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                ULog.i("walle", "[stateless] build header end , header is " + jSONObject.toString() + ", thread is " + Thread.currentThread());
                return jSONObject2.put("header", jSONObject);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(applicationContext, th);
        }
        ULog.i("walle", "[stateless] build header end , header is null !!! thread is " + Thread.currentThread());
        return null;
    }

    public synchronized JSONObject buildSLEnvelope(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        c cVarConstructEnvelope;
        String str2;
        ULog.i("walle", "[stateless] build envelope, heade is " + jSONObject.toString());
        ULog.i("walle", "[stateless] build envelope, body is " + jSONObject2.toString());
        ULog.i("walle", "[stateless] build envelope, thread is " + Thread.currentThread());
        if (context == null || jSONObject == null || jSONObject2 == null || str == null) {
            ULog.i("walle", "[stateless] build envelope, context is null or header is null or body is null");
            return makeErrorResult(110, null);
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (jSONObject != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject != null) {
                try {
                    g gVarA = g.a(applicationContext);
                    if (gVarA != null) {
                        gVarA.a();
                        String strEncodeToString = Base64.encodeToString(new bl().a(gVarA.b()), 0);
                        if (!TextUtils.isEmpty(strEncodeToString)) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("header");
                            jSONObject3.put(au.X, strEncodeToString);
                            jSONObject.put("header", jSONObject3);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject != null && f.a(jSONObject.toString().getBytes().length, a.f21104c)) {
                ULog.i("walle", "[stateless] build envelope, json overstep!!!! size is " + jSONObject.toString().getBytes().length);
                return makeErrorResult(113, jSONObject);
            }
            ULog.i("walle", "[stateless] build envelope, json size is " + jSONObject.toString().getBytes().length);
            if (jSONObject != null) {
                cVarConstructEnvelope = constructEnvelope(applicationContext, jSONObject.toString().getBytes());
                if (cVarConstructEnvelope == null) {
                    ULog.i("walle", "[stateless] build envelope, envelope is null !!!!");
                    return makeErrorResult(111, jSONObject);
                }
            } else {
                cVarConstructEnvelope = null;
            }
            if (cVarConstructEnvelope != null && f.a(cVarConstructEnvelope.b().length, a.f21105d)) {
                ULog.i("walle", "[stateless] build envelope, envelope overstep!!!! size is " + cVarConstructEnvelope.b().length);
                return makeErrorResult(114, jSONObject);
            }
            if (!f.a(applicationContext, Base64.encodeToString(str.getBytes(), 0), Base64.encodeToString((str + "_" + System.currentTimeMillis()).getBytes(), 0), cVarConstructEnvelope.b())) {
                ULog.i("walle", "[stateless] build envelope, save fail ----->>>>>");
                return makeErrorResult(101, jSONObject);
            }
            ULog.i("walle", "[stateless] build envelope, save ok ----->>>>>");
            ULog.i("walle", "[stateless] envelope file size is " + jSONObject.toString().getBytes().length);
            new d(applicationContext);
            d.b(273);
            ULog.i("walle", "[stateless] build envelope end, thread is " + Thread.currentThread());
            return jSONObject;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            ULog.i("walle", "build envelope end, thread is " + Thread.currentThread());
            return makeErrorResult(110, null);
        }
    }
}
