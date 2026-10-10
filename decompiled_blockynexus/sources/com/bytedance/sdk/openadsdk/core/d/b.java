package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.openadsdk.utils.o;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.pro.au;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6066f;

    public String a() {
        return this.f6061a;
    }

    public String b() {
        return this.f6062b;
    }

    public String c() {
        return this.f6063c;
    }

    public int d() {
        return this.f6064d;
    }

    public int e() {
        return this.f6065e;
    }

    public int f() {
        return this.f6066f;
    }

    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, b());
            jSONObject.put("app_size", f());
            jSONObject.put("comment_num", e());
            jSONObject.put("download_url", a());
            jSONObject.put(au.n, c());
            jSONObject.put(FirebaseAnalytics.Param.SCORE, d());
        } catch (Exception e2) {
            o.b(e2.toString());
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f6061a = str;
    }

    public void b(String str) {
        this.f6062b = str;
    }

    public void c(String str) {
        this.f6063c = str;
    }

    public void a(int i) {
        this.f6064d = i;
    }

    public void b(int i) {
        this.f6065e = i;
    }

    public void c(int i) {
        this.f6066f = i;
    }
}
