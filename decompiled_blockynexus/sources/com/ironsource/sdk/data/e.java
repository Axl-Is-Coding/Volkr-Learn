package com.ironsource.sdk.data;

import io.rong.common.LibStorageUtils;

/* JADX INFO: compiled from: SSAFile.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15397f;
    private String g;
    private String h;

    public e(String str) {
        super(str);
        this.f15393b = LibStorageUtils.FILE;
        this.f15394c = "path";
        this.f15395d = "lastUpdateTime";
        if (a(this.f15393b)) {
            h(d(this.f15393b));
        }
        if (a(this.f15394c)) {
            i(d(this.f15394c));
        }
        if (a(this.f15395d)) {
            g(d(this.f15395d));
        }
    }

    private void h(String str) {
        this.f15396e = str;
    }

    private void i(String str) {
        this.f15397f = str;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return this.f15396e;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.f15397f;
    }

    public void f(String str) {
        this.g = str;
    }

    public void g(String str) {
        this.h = str;
    }

    public e(String str, String str2) {
        this.f15393b = LibStorageUtils.FILE;
        this.f15394c = "path";
        this.f15395d = "lastUpdateTime";
        h(str);
        i(str2);
    }
}
