package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ForwardingTimeout.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private t f4861a;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4861a = tVar;
    }

    public final t a() {
        return this.f4861a;
    }

    @Override // com.bytedance.sdk.a.a.t
    public long b_() {
        return this.f4861a.b_();
    }

    @Override // com.bytedance.sdk.a.a.t
    public boolean c() {
        return this.f4861a.c();
    }

    @Override // com.bytedance.sdk.a.a.t
    public long c_() {
        return this.f4861a.c_();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t e() {
        return this.f4861a.e();
    }

    @Override // com.bytedance.sdk.a.a.t
    public t f() {
        return this.f4861a.f();
    }

    @Override // com.bytedance.sdk.a.a.t
    public void g() throws IOException {
        this.f4861a.g();
    }

    public final i a(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4861a = tVar;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.t
    public t a(long j, TimeUnit timeUnit) {
        return this.f4861a.a(j, timeUnit);
    }

    @Override // com.bytedance.sdk.a.a.t
    public t a(long j) {
        return this.f4861a.a(j);
    }
}
