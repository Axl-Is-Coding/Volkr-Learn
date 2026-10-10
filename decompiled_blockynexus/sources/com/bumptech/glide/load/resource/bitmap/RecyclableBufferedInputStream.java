package com.bumptech.glide.load.resource.bitmap;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f4658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4663f;

    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this(inputStream, bVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f4661d;
        if (i != -1) {
            int i2 = this.f4662e - i;
            int i3 = this.f4660c;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.f4659b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i3) {
                        length = i3;
                    }
                    byte[] bArr2 = (byte[]) this.f4663f.a(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f4658a = bArr2;
                    this.f4663f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i4 = this.f4661d;
                    if (i4 > 0) {
                        System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
                    }
                }
                this.f4662e -= this.f4661d;
                this.f4661d = 0;
                this.f4659b = 0;
                int i5 = this.f4662e;
                int i6 = inputStream.read(bArr, i5, bArr.length - i5);
                this.f4659b = i6 <= 0 ? this.f4662e : this.f4662e + i6;
                return i6;
            }
        }
        int i7 = inputStream.read(bArr);
        if (i7 > 0) {
            this.f4661d = -1;
            this.f4662e = 0;
            this.f4659b = i7;
        }
        return i7;
    }

    private static IOException g() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f4658a == null || inputStream == null) {
            g();
            throw null;
        }
        return (this.f4659b - this.f4662e) + inputStream.available();
    }

    public synchronized void b() {
        this.f4660c = this.f4658a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4658a != null) {
            this.f4663f.put(this.f4658a);
            this.f4658a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        if (this.f4658a != null) {
            this.f4663f.put(this.f4658a);
            this.f4658a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.f4660c = Math.max(this.f4660c, i);
        this.f4661d = this.f4662e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f4658a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            g();
            throw null;
        }
        if (this.f4662e >= this.f4659b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f4658a && (bArr = this.f4658a) == null) {
            g();
            throw null;
        }
        if (this.f4659b - this.f4662e <= 0) {
            return -1;
        }
        int i = this.f4662e;
        this.f4662e = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f4658a == null) {
            throw new IOException("Stream is closed");
        }
        if (-1 == this.f4661d) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f4662e + " markLimit: " + this.f4660c);
        }
        this.f4662e = this.f4661d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f4658a;
        if (bArr == null) {
            g();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            g();
            throw null;
        }
        if (this.f4659b - this.f4662e >= j) {
            this.f4662e = (int) (((long) this.f4662e) + j);
            return j;
        }
        long j2 = ((long) this.f4659b) - ((long) this.f4662e);
        this.f4662e = this.f4659b;
        if (this.f4661d == -1 || j > this.f4660c) {
            return j2 + inputStream.skip(j - j2);
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        if (this.f4659b - this.f4662e >= j - j2) {
            this.f4662e = (int) ((((long) this.f4662e) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) this.f4659b)) - ((long) this.f4662e);
        this.f4662e = this.f4659b;
        return j3;
    }

    RecyclableBufferedInputStream(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar, int i) {
        super(inputStream);
        this.f4661d = -1;
        this.f4663f = bVar;
        this.f4658a = (byte[]) bVar.a(i, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f4658a;
        if (bArr2 == null) {
            g();
            throw null;
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            if (this.f4662e < this.f4659b) {
                int i5 = this.f4659b - this.f4662e >= i2 ? i2 : this.f4659b - this.f4662e;
                System.arraycopy(bArr2, this.f4662e, bArr, i, i5);
                this.f4662e += i5;
                if (i5 == i2 || inputStream.available() == 0) {
                    return i5;
                }
                i += i5;
                i3 = i2 - i5;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.f4661d == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i3 != i2 ? i2 - i3 : -1;
                    }
                    if (bArr2 != this.f4658a && (bArr2 = this.f4658a) == null) {
                        g();
                        throw null;
                    }
                    i4 = this.f4659b - this.f4662e >= i3 ? i3 : this.f4659b - this.f4662e;
                    System.arraycopy(bArr2, this.f4662e, bArr, i, i4);
                    this.f4662e += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            g();
            throw null;
        }
    }
}
