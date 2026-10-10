package com.bumptech.glide.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MarkEnforcingInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4172a;

    public j(InputStream inputStream) {
        super(inputStream);
        this.f4172a = Integer.MIN_VALUE;
    }

    private long b(long j) {
        int i = this.f4172a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    private void d(long j) {
        int i = this.f4172a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f4172a = (int) (((long) i) - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f4172a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f4172a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (b(1L) == -1) {
            return -1;
        }
        int i = super.read();
        d(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f4172a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jB = b(j);
        if (jB == -1) {
            return 0L;
        }
        long jSkip = super.skip(jB);
        d(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iB = (int) b(i2);
        if (iB == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iB);
        d(i3);
        return i3;
    }
}
