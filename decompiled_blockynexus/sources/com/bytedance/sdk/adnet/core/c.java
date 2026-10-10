package com.bytedance.sdk.adnet.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: ByteArrayPoolOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
class c extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5484a;

    public c(b bVar, int i) {
        this.f5484a = bVar;
        ((ByteArrayOutputStream) this).buf = this.f5484a.a(Math.max(i, 256));
    }

    private void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrA = this.f5484a.a((i2 + i) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        this.f5484a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5484a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f5484a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
