package com.ironsource.mediationsdk.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ProviderSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f14941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f14942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private JSONObject f14943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f14944f;
    private String g;
    private String h;
    private boolean i;
    private String j;
    private int k;
    private int l;
    private int m;

    public p(String str) {
        this.f14939a = str;
        this.j = str;
        this.f14940b = str;
        this.f14942d = new JSONObject();
        this.f14943e = new JSONObject();
        this.f14944f = new JSONObject();
        this.f14941c = new JSONObject();
        this.k = -1;
        this.l = -1;
        this.m = -1;
    }

    public void a(JSONObject jSONObject) {
        this.f14944f = jSONObject;
    }

    public void b(JSONObject jSONObject) {
        this.f14943e = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.f14942d = jSONObject;
    }

    public JSONObject d() {
        return this.f14944f;
    }

    public int e() {
        return this.l;
    }

    public JSONObject f() {
        return this.f14943e;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.f14939a;
    }

    public String i() {
        return this.f14940b;
    }

    public int j() {
        return this.k;
    }

    public JSONObject k() {
        return this.f14942d;
    }

    public String l() {
        return this.g;
    }

    public boolean m() {
        return this.i;
    }

    public void a(String str, Object obj) {
        try {
            this.f14944f.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str, Object obj) {
        try {
            this.f14943e.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, Object obj) {
        try {
            this.f14942d.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(int i) {
        this.k = i;
    }

    public String a() {
        return this.h;
    }

    public JSONObject b() {
        return this.f14941c;
    }

    public int c() {
        return this.m;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(int i) {
        this.l = i;
    }

    public void a(int i) {
        this.m = i;
    }

    public p(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.f14939a = str;
        this.j = str;
        this.f14940b = str2;
        this.f14942d = jSONObject2;
        this.f14943e = jSONObject3;
        this.f14944f = jSONObject4;
        this.f14941c = jSONObject;
        this.k = -1;
        this.l = -1;
        this.m = -1;
    }

    public p(p pVar) {
        this.f14939a = pVar.h();
        this.j = pVar.h();
        this.f14940b = pVar.i();
        this.f14942d = pVar.k();
        this.f14943e = pVar.f();
        this.f14944f = pVar.d();
        this.f14941c = pVar.b();
        this.k = pVar.j();
        this.l = pVar.e();
        this.m = pVar.c();
    }
}
