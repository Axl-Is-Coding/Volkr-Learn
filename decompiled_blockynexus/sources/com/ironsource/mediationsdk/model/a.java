package com.ironsource.mediationsdk.model;

import org.json.JSONObject;

/* JADX INFO: compiled from: AdapterConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f14870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f14871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14874e;

    public a(p pVar, JSONObject jSONObject) {
        this.f14870a = pVar;
        this.f14871b = jSONObject;
        this.f14873d = jSONObject.optInt("instanceType");
        this.f14872c = this.f14873d == 2;
        this.f14874e = jSONObject.optInt("maxAdsPerSession", 99);
    }

    public String a() {
        return this.f14870a.a();
    }

    public JSONObject b() {
        return this.f14871b;
    }

    public int c() {
        return this.f14873d;
    }

    public int d() {
        return this.f14874e;
    }

    public String e() {
        return this.f14870a.h();
    }

    public String f() {
        return this.f14870a.i();
    }

    public p g() {
        return this.f14870a;
    }

    public String h() {
        return this.f14870a.l();
    }

    public boolean i() {
        return this.f14872c;
    }
}
