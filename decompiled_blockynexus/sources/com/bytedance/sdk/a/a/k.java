package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: InflaterSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class k implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f4867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Inflater f4868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4870d;

    k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f4867a = eVar;
        this.f4868b = inflater;
    }

    private void c() throws IOException {
        int i = this.f4869c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.f4868b.getRemaining();
        this.f4869c -= remaining;
        this.f4867a.h(remaining);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) throws IOException {
        boolean zB;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f4870d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zB = b();
            try {
                o oVarE = cVar.e(1);
                int iInflate = this.f4868b.inflate(oVarE.f4884a, oVarE.f4886c, (int) Math.min(j, 8192 - oVarE.f4886c));
                if (iInflate > 0) {
                    oVarE.f4886c += iInflate;
                    long j2 = iInflate;
                    cVar.f4852b += j2;
                    return j2;
                }
                if (!this.f4868b.finished() && !this.f4868b.needsDictionary()) {
                }
                c();
                if (oVarE.f4885b != oVarE.f4886c) {
                    return -1L;
                }
                cVar.f4851a = oVarE.b();
                p.a(oVarE);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!zB);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean b() throws IOException {
        if (!this.f4868b.needsInput()) {
            return false;
        }
        c();
        if (this.f4868b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.f4867a.e()) {
            return true;
        }
        o oVar = this.f4867a.c().f4851a;
        int i = oVar.f4886c;
        int i2 = oVar.f4885b;
        this.f4869c = i - i2;
        this.f4868b.setInput(oVar.f4884a, i2, this.f4869c);
        return false;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4870d) {
            return;
        }
        this.f4868b.end();
        this.f4870d = true;
        this.f4867a.close();
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.f4867a.a();
    }
}
