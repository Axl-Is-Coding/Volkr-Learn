package com.bytedance.sdk.a.a;

import java.io.IOException;

/* JADX INFO: compiled from: ForwardingSink.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f4859a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f4859a = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return this.f4859a.a();
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j) throws IOException {
        this.f4859a.a_(cVar, j);
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4859a.close();
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        this.f4859a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f4859a.toString() + ")";
    }
}
