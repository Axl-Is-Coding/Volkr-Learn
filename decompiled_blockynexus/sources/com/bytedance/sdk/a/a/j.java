package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class j implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f4863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Inflater f4864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f4865d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4862a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CRC32 f4866e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f4864c = new Inflater(true);
        this.f4863b = l.a(sVar);
        this.f4865d = new k(this.f4863b, this.f4864c);
    }

    private void b() throws IOException {
        this.f4863b.a(10L);
        byte b2 = this.f4863b.c().b(3L);
        boolean z = ((b2 >> 1) & 1) == 1;
        if (z) {
            a(this.f4863b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.f4863b.i());
        this.f4863b.h(8L);
        if (((b2 >> 2) & 1) == 1) {
            this.f4863b.a(2L);
            if (z) {
                a(this.f4863b.c(), 0L, 2L);
            }
            long jK = this.f4863b.c().k();
            this.f4863b.a(jK);
            if (z) {
                a(this.f4863b.c(), 0L, jK);
            }
            this.f4863b.h(jK);
        }
        if (((b2 >> 3) & 1) == 1) {
            long jA = this.f4863b.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f4863b.c(), 0L, jA + 1);
            }
            this.f4863b.h(jA + 1);
        }
        if (((b2 >> 4) & 1) == 1) {
            long jA2 = this.f4863b.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.f4863b.c(), 0L, jA2 + 1);
            }
            this.f4863b.h(jA2 + 1);
        }
        if (z) {
            a("FHCRC", this.f4863b.k(), (short) this.f4866e.getValue());
            this.f4866e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.f4863b.l(), (int) this.f4866e.getValue());
        a("ISIZE", this.f4863b.l(), (int) this.f4864c.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f4862a == 0) {
            b();
            this.f4862a = 1;
        }
        if (this.f4862a == 1) {
            long j2 = cVar.f4852b;
            long jA = this.f4865d.a(cVar, j);
            if (jA != -1) {
                a(cVar, j2, jA);
                return jA;
            }
            this.f4862a = 2;
        }
        if (this.f4862a == 2) {
            c();
            this.f4862a = 3;
            if (!this.f4863b.e()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4865d.close();
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.f4863b.a();
    }

    private void a(c cVar, long j, long j2) {
        o oVar = cVar.f4851a;
        while (true) {
            int i = oVar.f4886c;
            int i2 = oVar.f4885b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            oVar = oVar.f4889f;
        }
        while (j2 > 0) {
            int i3 = (int) (((long) oVar.f4885b) + j);
            int iMin = (int) Math.min(oVar.f4886c - i3, j2);
            this.f4866e.update(oVar.f4884a, i3, iMin);
            j2 -= (long) iMin;
            oVar = oVar.f4889f;
            j = 0;
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
