package com.google.gson.internal.bind;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: renamed from: com.google.gson.internal.bind.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: JsonTreeReader.java */
/* JADX INFO: loaded from: classes2.dex */
class C2275c extends Reader {
    C2275c() {
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        throw new AssertionError();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        throw new AssertionError();
    }
}
