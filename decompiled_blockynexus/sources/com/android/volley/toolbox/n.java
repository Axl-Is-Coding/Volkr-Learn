package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.m;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: JsonRequest.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class n<T> extends Request<T> {
    private static final String p = String.format("application/json; charset=%s", "utf-8");
    private final Object q;
    private m.b<T> r;
    private final String s;

    public n(int i, String str, String str2, m.b<T> bVar, m.a aVar) {
        super(i, str, aVar);
        this.q = new Object();
        this.r = bVar;
        this.s = str2;
    }

    @Override // com.android.volley.Request
    protected void a(T t) {
        m.b<T> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.onResponse(t);
        }
    }

    @Override // com.android.volley.Request
    public String b() {
        return p;
    }

    @Override // com.android.volley.Request
    @Deprecated
    public byte[] i() {
        return a();
    }

    @Override // com.android.volley.Request
    @Deprecated
    public String m() {
        return b();
    }

    @Override // com.android.volley.Request
    public byte[] a() {
        try {
            if (this.s == null) {
                return null;
            }
            return this.s.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            com.android.volley.p.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.s, "utf-8");
            return null;
        }
    }
}
