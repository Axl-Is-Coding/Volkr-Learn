package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: RealBufferedSink.java */
/* JADX INFO: loaded from: classes.dex */
final class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4877a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f4878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f4879c;

    m(r rVar) {
        if (rVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f4878b = rVar;
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return this.f4878b.a();
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.a_(cVar, j);
        u();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d b(String str) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.b(str);
        return u();
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this.f4877a;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f4879c) {
            return;
        }
        try {
            if (this.f4877a.f4852b > 0) {
                this.f4878b.a_(this.f4877a, this.f4877a.f4852b);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f4878b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f4879c = true;
        if (th == null) {
            return;
        }
        u.a(th);
        throw null;
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f4877a;
        long j = cVar.f4852b;
        if (j > 0) {
            this.f4878b.a_(cVar, j);
        }
        this.f4878b.flush();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d g(int i) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.g(i);
        return u();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d h(int i) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.h(i);
        return u();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d i(int i) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.i(i);
        return u();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f4879c;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d k(long j) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.k(j);
        return u();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d l(long j) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.l(j);
        return u();
    }

    public String toString() {
        return "buffer(" + this.f4878b + ")";
    }

    @Override // com.bytedance.sdk.a.a.d
    public d u() throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        long jG = this.f4877a.g();
        if (jG > 0) {
            this.f4878b.a_(this.f4877a, jG);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f4877a.write(byteBuffer);
        u();
        return iWrite;
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr) throws IOException {
        if (this.f4879c) {
            throw new IllegalStateException("closed");
        }
        this.f4877a.c(bArr);
        return u();
    }

    @Override // com.bytedance.sdk.a.a.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (!this.f4879c) {
            this.f4877a.c(bArr, i, i2);
            return u();
        }
        throw new IllegalStateException("closed");
    }
}
