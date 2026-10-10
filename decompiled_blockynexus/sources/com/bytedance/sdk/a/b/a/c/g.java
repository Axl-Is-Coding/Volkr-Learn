package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: RealInterceptorChain.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements t.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<t> f4979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.sdk.a.b.a.b.g f4980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f4981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.sdk.a.b.a.b.c f4982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f4984f;
    private final com.bytedance.sdk.a.b.e g;
    private final p h;
    private final int i;
    private final int j;
    private final int k;
    private int l;

    public g(List<t> list, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2, int i, y yVar, com.bytedance.sdk.a.b.e eVar, p pVar, int i2, int i3, int i4) {
        this.f4979a = list;
        this.f4982d = cVar2;
        this.f4980b = gVar;
        this.f4981c = cVar;
        this.f4983e = i;
        this.f4984f = yVar;
        this.g = eVar;
        this.h = pVar;
        this.i = i2;
        this.j = i3;
        this.k = i4;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public y a() {
        return this.f4984f;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int b() {
        return this.i;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int c() {
        return this.j;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public int d() {
        return this.k;
    }

    public com.bytedance.sdk.a.b.i e() {
        return this.f4982d;
    }

    public com.bytedance.sdk.a.b.a.b.g f() {
        return this.f4980b;
    }

    public c g() {
        return this.f4981c;
    }

    public com.bytedance.sdk.a.b.e h() {
        return this.g;
    }

    public p i() {
        return this.h;
    }

    @Override // com.bytedance.sdk.a.b.t.a
    public aa a(y yVar) throws IOException {
        return a(yVar, this.f4980b, this.f4981c, this.f4982d);
    }

    public aa a(y yVar, com.bytedance.sdk.a.b.a.b.g gVar, c cVar, com.bytedance.sdk.a.b.a.b.c cVar2) throws IOException {
        if (this.f4983e < this.f4979a.size()) {
            this.l++;
            if (this.f4981c != null && !this.f4982d.a(yVar.a())) {
                throw new IllegalStateException("network interceptor " + this.f4979a.get(this.f4983e - 1) + " must retain the same host and port");
            }
            if (this.f4981c != null && this.l > 1) {
                throw new IllegalStateException("network interceptor " + this.f4979a.get(this.f4983e - 1) + " must call proceed() exactly once");
            }
            g gVar2 = new g(this.f4979a, gVar, cVar, cVar2, this.f4983e + 1, yVar, this.g, this.h, this.i, this.j, this.k);
            t tVar = this.f4979a.get(this.f4983e);
            aa aaVarA = tVar.a(gVar2);
            if (cVar != null && this.f4983e + 1 < this.f4979a.size() && gVar2.l != 1) {
                throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
            }
            if (aaVarA != null) {
                if (aaVarA.g() != null) {
                    return aaVarA;
                }
                throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
            }
            throw new NullPointerException("interceptor " + tVar + " returned null");
        }
        throw new AssertionError();
    }
}
