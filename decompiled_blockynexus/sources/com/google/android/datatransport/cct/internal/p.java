package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.i;

/* JADX INFO: compiled from: LogEvent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: compiled from: LogEvent.java */
    public static abstract class a {
        public abstract a a(long j);

        public abstract a a(NetworkConnectionInfo networkConnectionInfo);

        public abstract a a(Integer num);

        abstract a a(String str);

        abstract a a(byte[] bArr);

        public abstract p a();

        public abstract a b(long j);

        public abstract a c(long j);
    }

    public static a a(byte[] bArr) {
        a aVarH = h();
        aVarH.a(bArr);
        return aVarH;
    }

    private static a h() {
        return new i.a();
    }

    public abstract Integer a();

    public abstract long b();

    public abstract long c();

    public abstract NetworkConnectionInfo d();

    public abstract byte[] e();

    public abstract String f();

    public abstract long g();

    public static a a(String str) {
        a aVarH = h();
        aVarH.a(str);
        return aVarH;
    }
}
