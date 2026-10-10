package com.bumptech.glide.e;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4160b;

    private c(InputStream inputStream, long j) {
        super(inputStream);
        this.f4159a = j;
    }

    public static InputStream a(InputStream inputStream, long j) {
        return new c(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f4159a - ((long) this.f4160b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        i = super.read();
        a(i >= 0 ? 1 : -1);
        return i;
    }

    private int a(int i) throws IOException {
        if (i >= 0) {
            this.f4160b += i;
        } else if (this.f4159a - ((long) this.f4160b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f4159a + ", but read: " + this.f4160b);
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        i3 = super.read(bArr, i, i2);
        a(i3);
        return i3;
    }
}
