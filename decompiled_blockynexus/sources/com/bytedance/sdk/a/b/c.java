package com.bytedance.sdk.a.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.a.e f5222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.bytedance.sdk.a.b.a.a.d f5223b;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5223b.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f5223b.flush();
    }
}
