package com.bytedance.sdk.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: RealBufferedSource.java */
/* JADX INFO: loaded from: classes.dex */
final class n implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4880a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f4881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f4882c;

    n(s sVar) {
        if (sVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f4881b = sVar;
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f4882c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f4880a;
        if (cVar2.f4852b == 0 && this.f4881b.a(cVar2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.f4880a.a(cVar, Math.min(j, this.f4880a.f4852b));
    }

    public boolean b(long j) throws IOException {
        c cVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f4882c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f4880a;
            if (cVar.f4852b >= j) {
                return true;
            }
        } while (this.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // com.bytedance.sdk.a.a.e
    public c c() {
        return this.f4880a;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4882c) {
            return;
        }
        this.f4882c = true;
        this.f4881b.close();
        this.f4880a.r();
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() throws IOException {
        if (this.f4882c) {
            throw new IllegalStateException("closed");
        }
        return this.f4880a.e() && this.f4881b.a(this.f4880a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.n.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                n nVar = n.this;
                if (nVar.f4882c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(nVar.f4880a.f4852b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                n.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                n nVar = n.this;
                if (nVar.f4882c) {
                    throw new IOException("closed");
                }
                c cVar = nVar.f4880a;
                if (cVar.f4852b == 0 && nVar.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return n.this.f4880a.h() & 255;
            }

            public String toString() {
                return n.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!n.this.f4882c) {
                    u.a(bArr.length, i, i2);
                    n nVar = n.this;
                    c cVar = nVar.f4880a;
                    if (cVar.f4852b == 0 && nVar.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                        return -1;
                    }
                    return n.this.f4880a.a(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j) throws IOException {
        a(j);
        return this.f4880a.g(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() throws IOException {
        a(1L);
        return this.f4880a.h();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() throws IOException {
        a(2L);
        return this.f4880a.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f4882c;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() throws IOException {
        a(4L);
        return this.f4880a.j();
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() throws IOException {
        a(2L);
        return this.f4880a.k();
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() throws IOException {
        a(4L);
        return this.f4880a.l();
    }

    @Override // com.bytedance.sdk.a.a.e
    public long m() throws IOException {
        byte b2;
        a(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!b(i2)) {
                break;
            }
            b2 = this.f4880a.b(i);
            if ((b2 < 48 || b2 > 57) && ((b2 < 97 || b2 > 102) && (b2 < 65 || b2 > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b2)));
        }
        return this.f4880a.m();
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws IOException {
        return e(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f4880a;
        if (cVar.f4852b == 0 && this.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f4880a.read(byteBuffer);
    }

    public String toString() {
        return "buffer(" + this.f4881b + ")";
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j) throws IOException {
        a(j);
        return this.f4880a.c(j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws IOException {
        if (this.f4882c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            c cVar = this.f4880a;
            if (cVar.f4852b == 0 && this.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f4880a.b());
            this.f4880a.h(jMin);
            j -= jMin;
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long jA = a((byte) 10, 0L, j2);
            if (jA != -1) {
                return this.f4880a.f(jA);
            }
            if (j2 < Long.MAX_VALUE && b(j2) && this.f4880a.b(j2 - 1) == 13 && b(1 + j2) && this.f4880a.b(j2) == 10) {
                return this.f4880a.f(j2);
            }
            c cVar = new c();
            c cVar2 = this.f4880a;
            cVar2.a(cVar, 0L, Math.min(32L, cVar2.b()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f4880a.b(), j) + " content=" + cVar.n().e() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: " + j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws IOException {
        if (!b(j)) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws IOException {
        try {
            a(bArr.length);
            this.f4880a.a(bArr);
        } catch (EOFException e2) {
            int i = 0;
            while (true) {
                c cVar = this.f4880a;
                long j = cVar.f4852b;
                if (j <= 0) {
                    throw e2;
                }
                int iA = cVar.a(bArr, i, (int) j);
                if (iA == -1) {
                    throw new AssertionError();
                }
                i += iA;
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b2) throws IOException {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) throws IOException {
        if (this.f4882c) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jA = this.f4880a.a(b2, j, j2);
            if (jA != -1) {
                return jA;
            }
            c cVar = this.f4880a;
            long j3 = cVar.f4852b;
            if (j3 >= j2 || this.f4881b.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.f4881b.a();
    }
}
