package com.bytedance.sdk.a.a;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: Source.java */
/* JADX INFO: loaded from: classes.dex */
public interface s extends Closeable {
    long a(c cVar, long j) throws IOException;

    t a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
