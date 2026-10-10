package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.f;

/* JADX INFO: compiled from: TransportContext.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: compiled from: TransportContext.java */
    public static abstract class a {
        public abstract a a(Priority priority);

        public abstract a a(String str);

        public abstract a a(byte[] bArr);

        public abstract q a();
    }

    public static a a() {
        f.a aVar = new f.a();
        aVar.a(Priority.DEFAULT);
        return aVar;
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract Priority d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }

    public q a(Priority priority) {
        a aVarA = a();
        aVarA.a(b());
        aVarA.a(priority);
        aVarA.a(c());
        return aVarA.a();
    }
}
