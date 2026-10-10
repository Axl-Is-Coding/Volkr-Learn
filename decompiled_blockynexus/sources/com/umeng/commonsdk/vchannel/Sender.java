package com.umeng.commonsdk.vchannel;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.au;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class Sender {
    private static long INTERVAL_THRESHOLD = 500;
    private static Map<String, String> customHeader;
    private static long lastTriggerTime;

    public static void handleEvent(Context context, b bVar) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender:handleEvent: context is null.");
            return;
        }
        try {
            UMSLEnvelopeBuild uMSLEnvelopeBuild = new UMSLEnvelopeBuild();
            JSONObject jSONObjectBuildSLBaseHeader = uMSLEnvelopeBuild.buildSLBaseHeader(context);
            if (jSONObjectBuildSLBaseHeader != null && jSONObjectBuildSLBaseHeader.has("header")) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONObjectBuildSLBaseHeader.opt("header");
                    if (jSONObject != null) {
                        jSONObject.put(au.aE, com.umeng.commonsdk.internal.a.f21089d);
                    }
                    if (customHeader != null && customHeader.size() > 0) {
                        for (String str : customHeader.keySet()) {
                            jSONObject.put(str, customHeader.get(str));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("analytics", bVar.d());
            uMSLEnvelopeBuild.buildSLEnvelope(context, jSONObjectBuildSLBaseHeader, jSONObject2, a.f21338c);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void onEvent(Context context, String str, Map<String, Object> map) {
        if (context == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: context is null.");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: eventID is null or an empty string.");
            return;
        }
        if (map == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: map is null.");
            return;
        }
        if (!UMFrUtils.isOnline(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: Network unavailable.");
            return;
        }
        if (System.currentTimeMillis() - lastTriggerTime < INTERVAL_THRESHOLD) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> Sender: onEvent: The interval between events is less than 500 milliseconds.");
            return;
        }
        b bVar = new b(context);
        bVar.a(str);
        bVar.a(System.currentTimeMillis());
        bVar.a(map);
        try {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.o, com.umeng.commonsdk.internal.b.a(context).a(), bVar);
        } catch (Throwable unused) {
        }
        lastTriggerTime = System.currentTimeMillis();
    }

    public static void setCustomHeader(Map<String, String> map) {
        if (map != null) {
            customHeader = map;
        }
    }
}
