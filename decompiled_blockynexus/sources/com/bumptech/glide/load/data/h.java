package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ExifOrientationStream.java */
/* JADX INFO: loaded from: classes.dex */
public final class h extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f4381a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f4382b = f4381a.length;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4383c = f4382b + 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte f4384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4385e;

    public h(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f4384d = (byte) i;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.f4385e;
        int i3 = (i2 < 2 || i2 > (i = f4383c)) ? super.read() : i2 == i ? this.f4384d : f4381a[i2 - 2] & 255;
        if (i3 != -1) {
            this.f4385e++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.f4385e = (int) (((long) this.f4385e) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f4385e;
        int i5 = f4383c;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f4384d;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int iMin = Math.min(i5 - i4, i2);
            System.arraycopy(f4381a, this.f4385e - 2, bArr, i, iMin);
            i3 = iMin;
        }
        if (i3 > 0) {
            this.f4385e += i3;
        }
        return i3;
    }
}
