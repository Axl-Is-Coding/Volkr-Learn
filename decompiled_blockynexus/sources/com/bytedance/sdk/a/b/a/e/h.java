package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.e.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Http2Reader.java */
/* JADX INFO: loaded from: classes.dex */
final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f5104a = Logger.getLogger(e.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d.a f5105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.sdk.a.a.e f5106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f5107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f5108e;

    /* JADX INFO: compiled from: Http2Reader.java */
    interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<c> list) throws IOException;

        void a(int i, long j);

        void a(int i, com.bytedance.sdk.a.b.a.e.b bVar);

        void a(int i, com.bytedance.sdk.a.b.a.e.b bVar, com.bytedance.sdk.a.a.f fVar);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<c> list);

        void a(boolean z, int i, com.bytedance.sdk.a.a.e eVar, int i2) throws IOException;

        void a(boolean z, n nVar);
    }

    h(com.bytedance.sdk.a.a.e eVar, boolean z) {
        this.f5106c = eVar;
        this.f5108e = z;
        this.f5107d = new a(this.f5106c);
        this.f5105b = new d.a(4096, this.f5107d);
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short sH = (b2 & 8) != 0 ? (short) (this.f5106c.h() & 255) : (short) 0;
        bVar.a(z, i2, this.f5106c, a(i, b2, sH));
        this.f5106c.h(sH);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            a(bVar, i2);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int iJ = this.f5106c.j();
        com.bytedance.sdk.a.b.a.e.b bVarA = com.bytedance.sdk.a.b.a.e.b.a(iJ);
        if (bVarA != null) {
            bVar.a(i2, bVarA);
        } else {
            e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(iJ));
            throw null;
        }
    }

    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i == 0) {
                bVar.a();
                return;
            } else {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 != 0) {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        n nVar = new n();
        for (int i3 = 0; i3 < i; i3 += 6) {
            short sI = this.f5106c.i();
            int iJ = this.f5106c.j();
            switch (sI) {
                case 2:
                    if (iJ != 0 && iJ != 1) {
                        e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 3:
                    sI = 4;
                    break;
                case 4:
                    sI = 7;
                    if (iJ < 0) {
                        e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 5:
                    if (iJ < 16384 || iJ > 16777215) {
                        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(iJ));
                        throw null;
                    }
                    break;
                    break;
            }
            nVar.a(sI, iJ);
        }
        bVar.a(false, nVar);
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short sH = (b2 & 8) != 0 ? (short) (this.f5106c.h() & 255) : (short) 0;
        bVar.a(i2, this.f5106c.j() & Integer.MAX_VALUE, a(a(i - 4, b2, sH), sH, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        bVar.a((b2 & 1) != 0, this.f5106c.j(), this.f5106c.j());
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int iJ = this.f5106c.j();
        int iJ2 = this.f5106c.j();
        int i3 = i - 8;
        com.bytedance.sdk.a.b.a.e.b bVarA = com.bytedance.sdk.a.b.a.e.b.a(iJ2);
        if (bVarA == null) {
            e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(iJ2));
            throw null;
        }
        com.bytedance.sdk.a.a.f fVarC = com.bytedance.sdk.a.a.f.f4855b;
        if (i3 > 0) {
            fVarC = this.f5106c.c(i3);
        }
        bVar.a(iJ, bVarA, fVarC);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long j = ((long) this.f5106c.j()) & 2147483647L;
        if (j != 0) {
            bVar.a(i2, j);
        } else {
            e.b("windowSizeIncrement was 0", Long.valueOf(j));
            throw null;
        }
    }

    public void a(b bVar) throws IOException {
        if (this.f5108e) {
            if (a(true, bVar)) {
                return;
            }
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        com.bytedance.sdk.a.a.f fVarC = this.f5106c.c(e.f5045a.g());
        if (f5104a.isLoggable(Level.FINE)) {
            f5104a.fine(com.bytedance.sdk.a.b.a.c.a("<< CONNECTION %s", fVarC.e()));
        }
        if (e.f5045a.equals(fVarC)) {
            return;
        }
        e.b("Expected a connection header but was %s", fVarC.a());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5106c.close();
    }

    /* JADX INFO: compiled from: Http2Reader.java */
    static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte f5110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f5111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5112d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        short f5113e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.bytedance.sdk.a.a.e f5114f;

        a(com.bytedance.sdk.a.a.e eVar) {
            this.f5114f = eVar;
        }

        private void b() throws IOException {
            int i = this.f5111c;
            int iA = h.a(this.f5114f);
            this.f5112d = iA;
            this.f5109a = iA;
            byte bH = (byte) (this.f5114f.h() & 255);
            this.f5110b = (byte) (this.f5114f.h() & 255);
            if (h.f5104a.isLoggable(Level.FINE)) {
                h.f5104a.fine(e.a(true, this.f5111c, this.f5109a, bH, this.f5110b));
            }
            this.f5111c = this.f5114f.j() & Integer.MAX_VALUE;
            if (bH != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(bH));
                throw null;
            }
            if (this.f5111c == i) {
                return;
            }
            e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            while (true) {
                int i = this.f5112d;
                if (i != 0) {
                    long jA = this.f5114f.a(cVar, Math.min(j, i));
                    if (jA == -1) {
                        return -1L;
                    }
                    this.f5112d = (int) (((long) this.f5112d) - jA);
                    return jA;
                }
                this.f5114f.h(this.f5113e);
                this.f5113e = (short) 0;
                if ((this.f5110b & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.f5114f.a();
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.f5106c.a(9L);
            int iA = a(this.f5106c);
            if (iA >= 0 && iA <= 16384) {
                byte bH = (byte) (this.f5106c.h() & 255);
                if (z && bH != 4) {
                    e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(bH));
                    throw null;
                }
                byte bH2 = (byte) (this.f5106c.h() & 255);
                int iJ = this.f5106c.j() & Integer.MAX_VALUE;
                if (f5104a.isLoggable(Level.FINE)) {
                    f5104a.fine(e.a(true, iJ, iA, bH, bH2));
                }
                switch (bH) {
                    case 0:
                        b(bVar, iA, bH2, iJ);
                        return true;
                    case 1:
                        a(bVar, iA, bH2, iJ);
                        return true;
                    case 2:
                        c(bVar, iA, bH2, iJ);
                        return true;
                    case 3:
                        d(bVar, iA, bH2, iJ);
                        return true;
                    case 4:
                        e(bVar, iA, bH2, iJ);
                        return true;
                    case 5:
                        f(bVar, iA, bH2, iJ);
                        return true;
                    case 6:
                        g(bVar, iA, bH2, iJ);
                        return true;
                    case 7:
                        h(bVar, iA, bH2, iJ);
                        return true;
                    case 8:
                        i(bVar, iA, bH2, iJ);
                        return true;
                    default:
                        this.f5106c.h(iA);
                        return true;
                }
            }
            e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            boolean z = (b2 & 1) != 0;
            short sH = (b2 & 8) != 0 ? (short) (this.f5106c.h() & 255) : (short) 0;
            if ((b2 & 32) != 0) {
                a(bVar, i2);
                i -= 5;
            }
            bVar.a(z, i2, -1, a(a(i, b2, sH), sH, b2, i2));
            return;
        }
        e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        throw null;
    }

    private List<c> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.f5107d;
        aVar.f5112d = i;
        aVar.f5109a = i;
        aVar.f5113e = s;
        aVar.f5110b = b2;
        aVar.f5111c = i2;
        this.f5105b.a();
        return this.f5105b.b();
    }

    private void a(b bVar, int i) throws IOException {
        int iJ = this.f5106c.j();
        bVar.a(i, iJ & Integer.MAX_VALUE, (this.f5106c.h() & 255) + 1, (Integer.MIN_VALUE & iJ) != 0);
    }

    static int a(com.bytedance.sdk.a.a.e eVar) throws IOException {
        return (eVar.h() & 255) | ((eVar.h() & 255) << 16) | ((eVar.h() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
