package com.ironsource.mediationsdk.logger;

/* JADX INFO: compiled from: IronSourceError.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14864b;

    public b(int i, String str) {
        this.f14864b = i;
        this.f14863a = str == null ? "" : str;
    }

    public int a() {
        return this.f14864b;
    }

    public String b() {
        return this.f14863a;
    }

    public String toString() {
        return "errorCode:" + this.f14864b + ", errorMessage:" + this.f14863a;
    }
}
