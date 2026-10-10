package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.q;
import com.google.android.gms.plus.PlusShare;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f5742b;

    a(String str, JSONObject jSONObject) {
        this.f5741a = str;
        this.f5742b = jSONObject;
    }

    static a a(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(context, str, str2, str3, jSONObject));
    }

    private static JSONObject b(Context context, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str);
            jSONObject2.putOpt(PlusShare.KEY_CALL_TO_ACTION_LABEL, str2);
            jSONObject2.putOpt("category", "app_union");
            try {
                jSONObject2.putOpt("value", Long.valueOf(Long.parseLong(str3)));
            } catch (NumberFormatException unused) {
                jSONObject2.putOpt("value", 0L);
            }
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("nt", Integer.valueOf(q.c(context)));
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    static a a(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(str, str2, str3, j, j2, jSONObject));
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("localId", null);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event");
            if (!TextUtils.isEmpty(strOptString) && jSONObjectOptJSONObject != null) {
                return new a(strOptString, jSONObjectOptJSONObject);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f5741a) || this.f5742b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.f5741a);
            jSONObject.put("event", this.f5742b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    private static JSONObject b(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_ts", System.currentTimeMillis());
            jSONObject2.putOpt("tag", str2);
            jSONObject2.putOpt(PlusShare.KEY_CALL_TO_ACTION_LABEL, str3);
            jSONObject2.putOpt("category", str);
            jSONObject2.putOpt("value", Long.valueOf(j));
            jSONObject2.putOpt("is_ad_event", "1");
            jSONObject2.putOpt("ext_value", Long.valueOf(j2));
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }

    @Override // com.bytedance.sdk.openadsdk.c.i
    public String b() {
        return this.f5741a;
    }
}
