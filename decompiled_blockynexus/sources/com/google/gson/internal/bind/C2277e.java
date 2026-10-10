package com.google.gson.internal.bind;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: renamed from: com.google.gson.internal.bind.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonTreeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
class C2277e extends Writer {
    C2277e() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new AssertionError();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        throw new AssertionError();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        throw new AssertionError();
    }
}
