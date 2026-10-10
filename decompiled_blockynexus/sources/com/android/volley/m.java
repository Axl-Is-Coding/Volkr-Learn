package com.android.volley;

import com.android.volley.a;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public class m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f4024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.C0049a f4025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VolleyError f4026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4027d;

    /* JADX INFO: compiled from: Response.java */
    public interface a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* JADX INFO: compiled from: Response.java */
    public interface b<T> {
        void onResponse(T t);
    }

    private m(T t, a.C0049a c0049a) {
        this.f4027d = false;
        this.f4024a = t;
        this.f4025b = c0049a;
        this.f4026c = null;
    }

    public static <T> m<T> a(T t, a.C0049a c0049a) {
        return new m<>(t, c0049a);
    }

    public static <T> m<T> a(VolleyError volleyError) {
        return new m<>(volleyError);
    }

    public boolean a() {
        return this.f4026c == null;
    }

    private m(VolleyError volleyError) {
        this.f4027d = false;
        this.f4024a = null;
        this.f4025b = null;
        this.f4026c = volleyError;
    }
}
