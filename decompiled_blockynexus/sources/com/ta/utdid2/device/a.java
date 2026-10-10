package com.ta.utdid2.device;

/* JADX INFO: compiled from: Device.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    private String g = "";
    private String h = "";
    private String i = "";
    private String j = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f19371a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19372b = 0;

    void a(long j) {
        this.f19372b = j;
    }

    void b(long j) {
        this.f19371a = j;
    }

    void c(String str) {
        this.h = str;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.j;
    }

    public String getDeviceId() {
        return this.i;
    }

    long a() {
        return this.f19371a;
    }

    void b(String str) {
        this.g = str;
    }

    void d(String str) {
        this.i = str;
    }

    void e(String str) {
        this.j = str;
    }
}
