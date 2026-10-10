package com.alibaba.sdk.android.feedback.xblink.f;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3870a = "m";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3871b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f3872c = new JSONObject();

    public void a() {
        this.f3871b = 1;
    }

    public void a(String str) {
        try {
            this.f3872c.put("ret", str);
            this.f3871b = -1;
        } catch (JSONException e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(f3870a, e2 + "");
        }
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            this.f3872c.put(str, str2);
        } catch (JSONException e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(f3870a, e2 + "");
        }
    }

    public void a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            return;
        }
        try {
            this.f3872c.put(str, jSONObject);
        } catch (JSONException e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(f3870a, e2 + "");
        }
    }

    public String b() {
        JSONObject jSONObject;
        String str;
        try {
        } catch (JSONException e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(f3870a, e2 + "");
        }
        if (this.f3871b != 1) {
            if (this.f3871b == 0) {
                jSONObject = this.f3872c;
                str = "HY_FAILED";
            }
            return this.f3872c.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace(UMCustomLogInfoBuilder.LINE_SEP, "\\n").replaceAll("\t", "\\t").replace("'", "");
        }
        jSONObject = this.f3872c;
        str = "HY_SUCCESS";
        jSONObject.put("ret", str);
        return this.f3872c.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\r", "\\r").replace(UMCustomLogInfoBuilder.LINE_SEP, "\\n").replaceAll("\t", "\\t").replace("'", "");
    }
}
