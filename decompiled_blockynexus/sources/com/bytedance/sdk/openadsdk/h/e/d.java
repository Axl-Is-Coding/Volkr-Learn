package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.j;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.IOException;

/* JADX INFO: compiled from: NetworkSoureVolleyImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IHttpStack f6897a;

    public d() {
        this.f6897a = com.bytedance.sdk.openadsdk.g.d.a();
        if (this.f6897a == null) {
            this.f6897a = new j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.b
    public a a(f fVar) throws IOException, VAdError {
        e eVar = new e(fVar.f6898a, fVar.f6899b);
        if (fVar.f6900c != -1) {
            eVar.setRetryPolicy(new com.bytedance.sdk.adnet.core.e().a((int) fVar.f6900c));
        }
        return new g(this.f6897a.performRequest(eVar, fVar.f6902e), fVar);
    }
}
