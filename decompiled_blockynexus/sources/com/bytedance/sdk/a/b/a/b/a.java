package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;

/* JADX INFO: compiled from: ConnectInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f4936a;

    public a(v vVar) {
        this.f4936a = vVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        com.bytedance.sdk.a.b.a.c.g gVar = (com.bytedance.sdk.a.b.a.c.g) aVar;
        y yVarA = gVar.a();
        g gVarF = gVar.f();
        return gVar.a(yVarA, gVarF, gVarF.a(this.f4936a, aVar, !yVarA.b().equals("GET")), gVarF.b());
    }
}
