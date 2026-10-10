package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: StringRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends Request<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f5437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m.a<String> f5438d;

    public j(int i, String str, m.a<String> aVar) {
        super(i, str, aVar);
        this.f5437c = new Object();
        this.f5438d = aVar;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<String> mVar) {
        m.a<String> aVar;
        synchronized (this.f5437c) {
            aVar = this.f5438d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f5437c) {
            this.f5438d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<String> a(com.bytedance.sdk.adnet.core.i iVar) {
        String str;
        try {
            str = new String(iVar.f5525b, com.bytedance.sdk.adnet.d.b.a(iVar.f5526c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(iVar.f5525b);
        }
        return m.a(str, com.bytedance.sdk.adnet.d.b.a(iVar));
    }
}
