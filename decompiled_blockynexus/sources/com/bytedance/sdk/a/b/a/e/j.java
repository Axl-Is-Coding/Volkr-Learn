package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Http2Writer.java */
/* JADX INFO: loaded from: classes.dex */
final class j implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f5133b = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.a.a.d f5135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f5136d;
    private boolean g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.sdk.a.a.c f5137e = new com.bytedance.sdk.a.a.c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final d.b f5134a = new d.b(this.f5137e);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5138f = 16384;

    j(com.bytedance.sdk.a.a.d dVar, boolean z) {
        this.f5135c = dVar;
        this.f5136d = z;
    }

    public synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (this.f5136d) {
            if (f5133b.isLoggable(Level.FINE)) {
                f5133b.fine(com.bytedance.sdk.a.b.a.c.a(">> CONNECTION %s", e.f5045a.e()));
            }
            this.f5135c.c(e.f5045a.h());
            this.f5135c.flush();
        }
    }

    public synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f5135c.flush();
    }

    public int c() {
        return this.f5138f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.g = true;
        this.f5135c.close();
    }

    public synchronized void b(n nVar) throws IOException {
        if (!this.g) {
            int i = 0;
            a(0, nVar.b() * 6, (byte) 4, (byte) 0);
            while (i < 10) {
                if (nVar.a(i)) {
                    this.f5135c.h(i == 4 ? 3 : i == 7 ? 4 : i);
                    this.f5135c.g(nVar.b(i));
                }
                i++;
            }
            this.f5135c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(n nVar) throws IOException {
        if (!this.g) {
            this.f5138f = nVar.d(this.f5138f);
            if (nVar.c() != -1) {
                this.f5134a.a(nVar.c());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f5135c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.f5138f, j);
            long j2 = iMin;
            j -= j2;
            a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f5135c.a_(this.f5137e, j2);
        }
    }

    public synchronized void a(int i, int i2, List<c> list) throws IOException {
        if (!this.g) {
            this.f5134a.a(list);
            long jB = this.f5137e.b();
            int iMin = (int) Math.min(this.f5138f - 4, jB);
            long j = iMin;
            a(i, iMin + 4, (byte) 5, jB == j ? (byte) 4 : (byte) 0);
            this.f5135c.g(i2 & Integer.MAX_VALUE);
            this.f5135c.a_(this.f5137e, j);
            if (jB > j) {
                b(i, jB - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, int i2, List<c> list) throws IOException {
        if (!this.g) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, b bVar) throws IOException {
        if (!this.g) {
            if (bVar.g != -1) {
                a(i, 4, (byte) 3, (byte) 0);
                this.f5135c.g(bVar.g);
                this.f5135c.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(boolean z, int i, com.bytedance.sdk.a.a.c cVar, int i2) throws IOException {
        if (!this.g) {
            a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i, byte b2, com.bytedance.sdk.a.a.c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f5135c.a_(cVar, i2);
        }
    }

    public synchronized void a(boolean z, int i, int i2) throws IOException {
        if (!this.g) {
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.f5135c.g(i);
            this.f5135c.g(i2);
            this.f5135c.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, b bVar, byte[] bArr) throws IOException {
        if (!this.g) {
            if (bVar.g != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f5135c.g(i);
                this.f5135c.g(bVar.g);
                if (bArr.length > 0) {
                    this.f5135c.c(bArr);
                }
                this.f5135c.flush();
            } else {
                e.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            a(i, 4, (byte) 8, (byte) 0);
            this.f5135c.g((int) j);
            this.f5135c.flush();
        } else {
            e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (f5133b.isLoggable(Level.FINE)) {
            f5133b.fine(e.a(false, i, i2, b2, b3));
        }
        int i3 = this.f5138f;
        if (i2 > i3) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            a(this.f5135c, i2);
            this.f5135c.i(b2 & 255);
            this.f5135c.i(b3 & 255);
            this.f5135c.g(i & Integer.MAX_VALUE);
            return;
        }
        e.a("reserved bit set: %s", Integer.valueOf(i));
        throw null;
    }

    private static void a(com.bytedance.sdk.a.a.d dVar, int i) throws IOException {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    void a(boolean z, int i, List<c> list) throws IOException {
        if (!this.g) {
            this.f5134a.a(list);
            long jB = this.f5137e.b();
            int iMin = (int) Math.min(this.f5138f, jB);
            long j = iMin;
            byte b2 = jB == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, iMin, (byte) 1, b2);
            this.f5135c.a_(this.f5137e, j);
            if (jB > j) {
                b(i, jB - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
