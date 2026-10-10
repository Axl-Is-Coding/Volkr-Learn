package com.bytedance.sdk.openadsdk.core.d;

import com.umeng.analytics.pro.au;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f6147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f6149f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l = 0;
    private int m = 0;

    public int a() {
        return this.k;
    }

    public int b() {
        return this.f6144a;
    }

    public int c() {
        return this.f6145b;
    }

    public long d() {
        return this.f6146c;
    }

    public double e() {
        return this.f6147d;
    }

    public String f() {
        return this.f6148e;
    }

    public String g() {
        return this.f6149f;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public String j() {
        return this.i;
    }

    public String k() {
        return this.j;
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", g());
            jSONObject.put("cover_width", c());
            jSONObject.put("endcard", i());
            jSONObject.put("file_hash", k());
            jSONObject.put(au.y, f());
            jSONObject.put("size", d());
            jSONObject.put("video_duration", e());
            jSONObject.put("video_url", h());
            jSONObject.put("playable_download_url", j());
            jSONObject.put("if_playable_loading_show", m());
            jSONObject.put("remove_loading_page_type", n());
            jSONObject.put("fallback_endcard_judge", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int m() {
        return this.l;
    }

    public int n() {
        return this.m;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(int i) {
        this.f6144a = i;
    }

    public void c(int i) {
        this.f6145b = i;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void a(long j) {
        this.f6146c = j;
    }

    public void b(String str) {
        this.f6149f = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(int i) {
        this.l = i;
    }

    public void e(int i) {
        this.m = i;
    }

    public void a(double d2) {
        this.f6147d = d2;
    }

    public void a(String str) {
        this.f6148e = str;
    }
}
