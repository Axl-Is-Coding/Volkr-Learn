package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.m;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: BridgeInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f4972a;

    public a(m mVar) {
        this.f4972a = mVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        y yVarA = aVar.a();
        y.a aVarE = yVarA.e();
        z zVarD = yVarA.d();
        if (zVarD != null) {
            u uVarA = zVarD.a();
            if (uVarA != null) {
                aVarE.a("Content-Type", uVarA.toString());
            }
            long jB = zVarD.b();
            if (jB != -1) {
                aVarE.a("Content-Length", Long.toString(jB));
                aVarE.b("Transfer-Encoding");
            } else {
                aVarE.a("Transfer-Encoding", "chunked");
                aVarE.b("Content-Length");
            }
        }
        boolean z = false;
        if (yVarA.a("Host") == null) {
            aVarE.a("Host", com.bytedance.sdk.a.b.a.c.a(yVarA.a(), false));
        }
        if (yVarA.a("Connection") == null) {
            aVarE.a("Connection", "Keep-Alive");
        }
        if (yVarA.a("Accept-Encoding") == null && yVarA.a("Range") == null) {
            z = true;
            aVarE.a("Accept-Encoding", "gzip");
        }
        List<com.bytedance.sdk.a.b.l> listA = this.f4972a.a(yVarA.a());
        if (!listA.isEmpty()) {
            aVarE.a("Cookie", a(listA));
        }
        if (yVarA.a(AbstractSpiCall.HEADER_USER_AGENT) == null) {
            aVarE.a(AbstractSpiCall.HEADER_USER_AGENT, com.bytedance.sdk.a.b.a.d.a());
        }
        aa aaVarA = aVar.a(aVarE.d());
        e.a(this.f4972a, yVarA.a(), aaVarA.f());
        aa.a aVarA = aaVarA.h().a(yVarA);
        if (z && "gzip".equalsIgnoreCase(aaVarA.a("Content-Encoding")) && e.b(aaVarA)) {
            com.bytedance.sdk.a.a.j jVar = new com.bytedance.sdk.a.a.j(aaVarA.g().c());
            aVarA.a(aaVarA.f().b().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(aaVarA.a("Content-Type"), -1L, com.bytedance.sdk.a.a.l.a(jVar)));
        }
        return aVarA.a();
    }

    private String a(List<com.bytedance.sdk.a.b.l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.bytedance.sdk.a.b.l lVar = list.get(i);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }
}
