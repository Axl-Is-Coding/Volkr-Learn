package com.ironsource.mediationsdk.model;

/* JADX INFO: compiled from: InterstitialPlacement.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f14908d;

    public i(int i, String str, boolean z, n nVar) {
        this.f14905a = i;
        this.f14906b = str;
        this.f14907c = z;
        this.f14908d = nVar;
    }

    public n a() {
        return this.f14908d;
    }

    public int b() {
        return this.f14905a;
    }

    public String c() {
        return this.f14906b;
    }

    public boolean d() {
        return this.f14907c;
    }

    public String toString() {
        return "placement name: " + this.f14906b;
    }
}
