package com.bytedance.sdk.openadsdk.core.b;

import android.content.Context;
import com.bytedance.sdk.adnet.b.h;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: FrequentCallEventHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Context context, String str, long j) {
        new h(1, ab.i("/api/ad/union/sdk/stats/"), a(str, j), null).setRetryPolicy(d.b().a(10000));
    }

    private static JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", "3.1.5.3");
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
