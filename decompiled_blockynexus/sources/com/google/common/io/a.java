package com.google.common.io;

import com.google.common.base.m;
import java.io.OutputStream;

/* JADX INFO: compiled from: ByteStreams.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends OutputStream {
    a() {
    }

    public String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        m.a(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        m.a(bArr);
    }
}
