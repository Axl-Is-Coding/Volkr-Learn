package com.bumptech.glide.load;

import java.security.MessageDigest;

/* JADX INFO: compiled from: Option.java */
/* JADX INFO: loaded from: classes.dex */
public final class k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a<Object> f4630a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f4631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a<T> f4632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile byte[] f4634e;

    /* JADX INFO: compiled from: Option.java */
    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private k(String str, T t, a<T> aVar) {
        com.bumptech.glide.e.l.a(str);
        this.f4633d = str;
        this.f4631b = t;
        com.bumptech.glide.e.l.a(aVar);
        this.f4632c = aVar;
    }

    public static <T> k<T> a(String str) {
        return new k<>(str, null, b());
    }

    private static <T> a<T> b() {
        return (a<T>) f4630a;
    }

    private byte[] c() {
        if (this.f4634e == null) {
            this.f4634e = this.f4633d.getBytes(h.f4628a);
        }
        return this.f4634e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f4633d.equals(((k) obj).f4633d);
        }
        return false;
    }

    public int hashCode() {
        return this.f4633d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f4633d + "'}";
    }

    public static <T> k<T> a(String str, T t) {
        return new k<>(str, t, b());
    }

    public static <T> k<T> a(String str, T t, a<T> aVar) {
        return new k<>(str, t, aVar);
    }

    public T a() {
        return this.f4631b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f4632c.a(c(), t, messageDigest);
    }
}
