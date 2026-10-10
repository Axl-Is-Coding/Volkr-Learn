package com.bytedance.sdk.a.b.a.e;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5025a = com.bytedance.sdk.a.a.f.a(":");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5026b = com.bytedance.sdk.a.a.f.a(":status");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5027c = com.bytedance.sdk.a.a.f.a(":method");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5028d = com.bytedance.sdk.a.a.f.a(":path");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5029e = com.bytedance.sdk.a.a.f.a(":scheme");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.sdk.a.a.f f5030f = com.bytedance.sdk.a.a.f.a(":authority");
    public final com.bytedance.sdk.a.a.f g;
    public final com.bytedance.sdk.a.a.f h;
    final int i;

    public c(String str, String str2) {
        this(com.bytedance.sdk.a.a.f.a(str), com.bytedance.sdk.a.a.f.a(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.g.equals(cVar.g) && this.h.equals(cVar.h);
    }

    public int hashCode() {
        return ((527 + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.a.b.a.c.a("%s: %s", this.g.a(), this.h.a());
    }

    public c(com.bytedance.sdk.a.a.f fVar, String str) {
        this(fVar, com.bytedance.sdk.a.a.f.a(str));
    }

    public c(com.bytedance.sdk.a.a.f fVar, com.bytedance.sdk.a.a.f fVar2) {
        this.g = fVar;
        this.h = fVar2;
        this.i = fVar.g() + 32 + fVar2.g();
    }
}
