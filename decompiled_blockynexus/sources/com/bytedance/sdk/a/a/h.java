package com.bytedance.sdk.a.a;

import java.io.IOException;

/* JADX INFO: compiled from: ForwardingSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class h implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f4860a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4860a = sVar;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        return this.f4860a.a(cVar, j);
    }

    public final s b() {
        return this.f4860a;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4860a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4860a.toString() + ")";
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.f4860a.a();
    }
}
