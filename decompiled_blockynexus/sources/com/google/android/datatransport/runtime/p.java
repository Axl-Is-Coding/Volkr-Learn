package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.d;

/* JADX INFO: compiled from: SendRequest.java */
/* JADX INFO: loaded from: classes.dex */
abstract class p {

    /* JADX INFO: compiled from: SendRequest.java */
    public static abstract class a {
        abstract a a(com.google.android.datatransport.b bVar);

        abstract a a(com.google.android.datatransport.c<?> cVar);

        abstract a a(com.google.android.datatransport.d<?, byte[]> dVar);

        public abstract a a(q qVar);

        public abstract a a(String str);

        public abstract p a();
    }

    p() {
    }

    public static a a() {
        return new d.a();
    }

    public abstract com.google.android.datatransport.b b();

    abstract com.google.android.datatransport.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    abstract com.google.android.datatransport.d<?, byte[]> e();

    public abstract q f();

    public abstract String g();
}
