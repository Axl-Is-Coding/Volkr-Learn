package com.ironsource.mediationsdk.model;

/* JADX INFO: compiled from: Placement.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n f14920f;

    public l(int i, String str, boolean z, String str2, int i2, n nVar) {
        this.f14915a = i;
        this.f14916b = str;
        this.f14917c = z;
        this.f14918d = str2;
        this.f14919e = i2;
        this.f14920f = nVar;
    }

    public n a() {
        return this.f14920f;
    }

    public int b() {
        return this.f14915a;
    }

    public String c() {
        return this.f14916b;
    }

    public int d() {
        return this.f14919e;
    }

    public String e() {
        return this.f14918d;
    }

    public boolean f() {
        return this.f14917c;
    }

    public String toString() {
        return "placement name: " + this.f14916b + ", reward name: " + this.f14918d + " , amount: " + this.f14919e;
    }
}
