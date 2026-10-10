package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        g gVarA = g.a(context);
        String str = jSONObject.has(au.aE) ? au.ay : au.at;
        if (jSONObject.has("st")) {
            str = au.az;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        UUID uuidRandomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ay.f20689e, str);
        contentValues.put(ay.f20690f, gVarA.c(jSONObject.toString()));
        contentValues.put(ay.g, gVarA.c(jSONObject2.toString()));
        contentValues.put(ay.h, String.valueOf(jCurrentTimeMillis));
        contentValues.put(ay.i, uuidRandomUUID.toString());
        aw.a(context).a(ay.f20687c, contentValues);
        if (au.ay.equalsIgnoreCase(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
            return new JSONObject();
        }
        try {
            if (jSONObject.has("st")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("analytics", jSONObject2.getJSONObject("analytics"));
                return jSONObject3;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("header", new JSONObject());
            jSONObject4.put("analytics", jSONObject2.getJSONObject("analytics"));
            return jSONObject4;
        } catch (JSONException unused) {
            return jSONObject2;
        }
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        if (!UMUtils.isMainProgress(context)) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("exception", 120);
                    return jSONObject3;
                } catch (JSONException unused) {
                    return jSONObject3;
                }
            } catch (JSONException unused2) {
                return null;
            }
        }
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
        if (aw.a(context).c()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
        JSONObject jSONObjectAdd2CacheTable = add2CacheTable(context, jSONObject, jSONObject2);
        if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.t)) {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.t, com.umeng.commonsdk.internal.b.a(context).a(), null);
        }
        return jSONObjectAdd2CacheTable;
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        if (UMUtils.isMainProgress(context)) {
            return new b().b(context.getApplicationContext(), jSONObject, jSONObject2);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("exception", 120);
                return jSONObject3;
            } catch (JSONException unused) {
                return jSONObject3;
            }
        } catch (JSONException unused2) {
            return null;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        return transmissionSendFlag;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6, boolean r7) {
        /*
            if (r5 == 0) goto L43
            android.content.Context r0 = r5.getApplicationContext()
            boolean r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            int r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3c
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r7 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            if (r6 != r7) goto L1f
            boolean r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r5 == 0) goto L1d
            goto L2d
        L1d:
            r7 = 1
            goto L3c
        L1f:
            boolean r7 = com.umeng.commonsdk.framework.a.a()
            if (r7 == 0) goto L2f
            int r5 = com.umeng.commonsdk.framework.a.b()
            long r5 = (long) r5
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r5)
        L2d:
            r7 = 0
            goto L3c
        L2f:
            boolean r6 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r6 != 0) goto L2d
            boolean r5 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5)
            if (r5 == 0) goto L1d
            goto L2d
        L3c:
            if (r1 == 0) goto L43
            if (r2 <= 0) goto L43
            com.umeng.commonsdk.framework.a.d()
        L43:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(context.getApplicationContext());
    }

    public static synchronized void setTransmissionSendFlag(boolean z) {
        transmissionSendFlag = z;
    }
}
