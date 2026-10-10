package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.m;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StringRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends Request<String> {
    private final Object p;
    private m.b<String> q;

    public q(int i, String str, m.b<String> bVar, m.a aVar) {
        super(i, str, aVar);
        this.p = new Object();
        this.q = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        m.b<String> bVar;
        synchronized (this.p) {
            bVar = this.q;
        }
        if (bVar != null) {
            bVar.onResponse(str);
        }
    }

    @Override // com.android.volley.Request
    protected com.android.volley.m<String> a(com.android.volley.j jVar) {
        String str;
        try {
            str = new String(jVar.f4010b, h.a(jVar.f4011c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(jVar.f4010b);
        }
        return com.android.volley.m.a(str, h.a(jVar));
    }
}
