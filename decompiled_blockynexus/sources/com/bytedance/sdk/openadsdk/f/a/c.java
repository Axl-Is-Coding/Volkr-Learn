package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.f.a.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.umeng.analytics.pro.au;
import org.json.JSONObject;

/* JADX INFO: compiled from: LogStatsBase.java */
/* JADX INFO: loaded from: classes.dex */
public class c<T extends c> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6743c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6745e;
    private String h;
    private String j;
    private String k;
    private String l;
    private String m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6744d = "3.1.5.3";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6746f = System.currentTimeMillis() / 1000;
    private int g = 0;
    private int i = 0;

    public static c<c> b() {
        return new c<>();
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(au.w, 1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private T q() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.f.a.a
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put("type", c());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject.put("rit", e());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("creative_id", f());
            }
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("ad_sdk_version", g());
            }
            if (TextUtils.isEmpty(h())) {
                jSONObject.put("app_version", ab.h());
            } else {
                jSONObject.put("app_version", h());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (j() > 0) {
                jSONObject.put("adtype", j());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("req_id", k());
            }
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, l());
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("error_msg", m());
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put("extra", n());
            }
            if (!TextUtils.isEmpty(o())) {
                jSONObject.put(MessengerShareContentUtility.IMAGE_URL, o());
            }
            if (!TextUtils.isEmpty(d())) {
                jSONObject.put("event_extra", d());
            }
            jSONObject.put("conn_type", q.b(o.a()));
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, p());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String c() {
        return this.f6741a;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.f6742b;
    }

    public String f() {
        return this.f6743c;
    }

    public String g() {
        return this.f6744d;
    }

    public String h() {
        return this.f6745e;
    }

    public long i() {
        return this.f6746f;
    }

    public int j() {
        return this.g;
    }

    public String k() {
        return this.h;
    }

    public int l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.k;
    }

    public String o() {
        return this.l;
    }

    public T b(String str) {
        this.m = str;
        q();
        return this;
    }

    public T c(String str) {
        this.f6742b = str;
        q();
        return this;
    }

    public T d(String str) {
        this.f6743c = str;
        q();
        return this;
    }

    public T e(String str) {
        this.h = str;
        q();
        return this;
    }

    public T f(String str) {
        this.j = str;
        q();
        return this;
    }

    public T g(String str) {
        this.k = str;
        q();
        return this;
    }

    public T b(int i) {
        this.i = i;
        q();
        return this;
    }

    public T c(long j) {
        this.f6746f = j;
        q();
        return this;
    }

    public T a(String str) {
        this.f6741a = str;
        q();
        return this;
    }

    public T a(int i) {
        this.g = i;
        q();
        return this;
    }
}
