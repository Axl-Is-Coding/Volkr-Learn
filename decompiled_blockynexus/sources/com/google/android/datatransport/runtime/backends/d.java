package com.google.android.datatransport.runtime.backends;

import android.content.Context;

/* JADX INFO: compiled from: AutoValue_CreationContext.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f12823d;

    d(Context context, com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f12820a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f12821b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f12822c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f12823d = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public Context a() {
        return this.f12820a;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public String b() {
        return this.f12823d;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public com.google.android.datatransport.runtime.e.a c() {
        return this.f12822c;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public com.google.android.datatransport.runtime.e.a d() {
        return this.f12821b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f12820a.equals(hVar.a()) && this.f12821b.equals(hVar.d()) && this.f12822c.equals(hVar.c()) && this.f12823d.equals(hVar.b());
    }

    public int hashCode() {
        return ((((((this.f12820a.hashCode() ^ 1000003) * 1000003) ^ this.f12821b.hashCode()) * 1000003) ^ this.f12822c.hashCode()) * 1000003) ^ this.f12823d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f12820a + ", wallClock=" + this.f12821b + ", monotonicClock=" + this.f12822c + ", backendName=" + this.f12823d + "}";
    }
}
