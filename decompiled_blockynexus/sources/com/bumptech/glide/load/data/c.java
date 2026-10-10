package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BufferedOutputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f4374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f4375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f4376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4377d;

    public c(OutputStream outputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void b() throws IOException {
        int i = this.f4377d;
        if (i > 0) {
            this.f4374a.write(this.f4375b, 0, i);
            this.f4377d = 0;
        }
    }

    private void d() throws IOException {
        if (this.f4377d == this.f4375b.length) {
            b();
        }
    }

    private void g() {
        byte[] bArr = this.f4375b;
        if (bArr != null) {
            this.f4376c.put(bArr);
            this.f4375b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f4374a.close();
            g();
        } catch (Throwable th) {
            this.f4374a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        b();
        this.f4374a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f4375b;
        int i2 = this.f4377d;
        this.f4377d = i2 + 1;
        bArr[i2] = (byte) i;
        d();
    }

    c(OutputStream outputStream, com.bumptech.glide.load.engine.a.b bVar, int i) {
        this.f4374a = outputStream;
        this.f4376c = bVar;
        this.f4375b = (byte[]) bVar.a(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f4377d == 0 && i4 >= this.f4375b.length) {
                this.f4374a.write(bArr, i5, i4);
                return;
            }
            int iMin = Math.min(i4, this.f4375b.length - this.f4377d);
            System.arraycopy(bArr, i5, this.f4375b, this.f4377d, iMin);
            this.f4377d += iMin;
            i3 += iMin;
            d();
        } while (i3 < i2);
    }
}
