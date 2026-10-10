package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: MarkableInputStream.java */
/* JADX INFO: loaded from: classes5.dex */
final class u extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f19317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f19319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f19321e;

    public u(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void d(long j) {
        try {
            if (this.f19319c >= this.f19318b || this.f19318b > this.f19320d) {
                this.f19319c = this.f19318b;
                this.f19317a.mark((int) (j - this.f19318b));
            } else {
                this.f19317a.reset();
                this.f19317a.mark((int) (j - this.f19319c));
                b(this.f19319c, this.f19318b);
            }
            this.f19320d = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    public long a(int i) {
        long j = this.f19318b + ((long) i);
        if (this.f19320d < j) {
            d(j);
        }
        return this.f19318b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f19317a.available();
    }

    public void b(long j) throws IOException {
        if (this.f19318b > this.f19320d || j < this.f19319c) {
            throw new IOException("Cannot reset");
        }
        this.f19317a.reset();
        b(this.f19319c, j);
        this.f19318b = j;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f19317a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f19321e = a(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f19317a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f19317a.read();
        if (i != -1) {
            this.f19318b++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        b(this.f19321e);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.f19317a.skip(j);
        this.f19318b += jSkip;
        return jSkip;
    }

    public u(InputStream inputStream, int i) {
        this.f19321e = -1L;
        this.f19317a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.f19317a.read(bArr);
        if (i != -1) {
            this.f19318b += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f19317a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f19318b += (long) i3;
        }
        return i3;
    }

    private void b(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.f19317a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }
}
