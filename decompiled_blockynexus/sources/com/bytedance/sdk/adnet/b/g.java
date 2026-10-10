package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: JsonRequest.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g<T> extends Request<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5430c = String.format("application/json; charset=%s", "utf-8");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f5431d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m.a<T> f5432e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5433f;

    public g(int i, String str, String str2, m.a<T> aVar) {
        super(i, str, aVar);
        this.f5431d = new Object();
        this.f5432e = aVar;
        this.f5433f = str2;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected abstract m<T> a(com.bytedance.sdk.adnet.core.i iVar);

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.f5431d) {
            aVar = this.f5432e;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f5431d) {
            this.f5432e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            if (this.f5433f == null) {
                return null;
            }
            return this.f5433f.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            o.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f5433f, "utf-8");
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return f5430c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
