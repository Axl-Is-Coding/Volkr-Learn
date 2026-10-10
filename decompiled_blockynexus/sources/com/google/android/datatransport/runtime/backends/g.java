package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.b;

/* JADX INFO: compiled from: BackendRequest.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: compiled from: BackendRequest.java */
    public static abstract class a {
        public abstract a a(Iterable<com.google.android.datatransport.runtime.l> iterable);

        public abstract a a(byte[] bArr);

        public abstract g a();
    }

    public static a a() {
        return new b.a();
    }

    public abstract Iterable<com.google.android.datatransport.runtime.l> b();

    public abstract byte[] c();
}
