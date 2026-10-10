package com.ironsource.mediationsdk.model;

/* JADX INFO: compiled from: OfferwallPlacement.java */
/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14914c;

    public k(int i, String str, boolean z) {
        this.f14912a = i;
        this.f14913b = str;
        this.f14914c = z;
    }

    public int a() {
        return this.f14912a;
    }

    public String toString() {
        return "placement name: " + this.f14913b + ", placement id: " + this.f14912a;
    }
}
