package com.bytedance.sdk.a.b.a.d;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.a.a.i;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.b.g;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.a.c.k;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http1Codec.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements com.bytedance.sdk.a.b.a.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final v f4996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g f4997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.bytedance.sdk.a.a.e f4998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final com.bytedance.sdk.a.a.d f4999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f5000e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f5001f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: renamed from: com.bytedance.sdk.a.b.a.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Http1Codec.java */
    private abstract class AbstractC0066a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final i f5002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f5003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected long f5004c;

        private AbstractC0066a() {
            this.f5002a = new i(a.this.f4998c.a());
            this.f5004c = 0L;
        }

        @Override // com.bytedance.sdk.a.a.s
        public t a() {
            return this.f5002a;
        }

        @Override // com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            try {
                long jA = a.this.f4998c.a(cVar, j);
                if (jA > 0) {
                    this.f5004c += jA;
                }
                return jA;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i = aVar.f5000e;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                aVar.a(this.f5002a);
                a aVar2 = a.this;
                aVar2.f5000e = 6;
                g gVar = aVar2.f4997b;
                if (gVar != null) {
                    gVar.a(!z, aVar2, this.f5004c, iOException);
                    return;
                }
                return;
            }
            throw new IllegalStateException("state: " + a.this.f5000e);
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private final class b implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f5007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5008c;

        b() {
            this.f5007b = new i(a.this.f4999d.a());
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.f5007b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.f5008c) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            a.this.f4999d.k(j);
            a.this.f4999d.b("\r\n");
            a.this.f4999d.a_(cVar, j);
            a.this.f4999d.b("\r\n");
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f5008c) {
                return;
            }
            this.f5008c = true;
            a.this.f4999d.b("0\r\n\r\n");
            a.this.a(this.f5007b);
            a.this.f5000e = 3;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f5008c) {
                return;
            }
            a.this.f4999d.flush();
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class c extends AbstractC0066a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.bytedance.sdk.a.b.s f5010f;
        private long g;
        private boolean h;

        c(com.bytedance.sdk.a.b.s sVar) {
            super();
            this.g = -1L;
            this.h = true;
            this.f5010f = sVar;
        }

        private void b() throws IOException {
            if (this.g != -1) {
                a.this.f4998c.p();
            }
            try {
                this.g = a.this.f4998c.m();
                String strTrim = a.this.f4998c.p().trim();
                if (this.g < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.g + strTrim + "\"");
                }
                if (this.g == 0) {
                    this.h = false;
                    com.bytedance.sdk.a.b.a.c.e.a(a.this.f4996a.f(), this.f5010f, a.this.c());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0066a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5003b) {
                throw new IllegalStateException("closed");
            }
            if (!this.h) {
                return -1L;
            }
            long j2 = this.g;
            if (j2 == 0 || j2 == -1) {
                b();
                if (!this.h) {
                    return -1L;
                }
            }
            long jA = super.a(cVar, Math.min(j, this.g));
            if (jA != -1) {
                this.g -= jA;
                return jA;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, (IOException) protocolException);
            throw protocolException;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f5003b) {
                return;
            }
            if (this.h && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f5003b = true;
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private final class d implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final i f5012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f5014d;

        d(long j) {
            this.f5012b = new i(a.this.f4999d.a());
            this.f5014d = j;
        }

        @Override // com.bytedance.sdk.a.a.r
        public t a() {
            return this.f5012b;
        }

        @Override // com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (this.f5013c) {
                throw new IllegalStateException("closed");
            }
            com.bytedance.sdk.a.b.a.c.a(cVar.b(), 0L, j);
            if (j <= this.f5014d) {
                a.this.f4999d.a_(cVar, j);
                this.f5014d -= j;
                return;
            }
            throw new ProtocolException("expected " + this.f5014d + " bytes but received " + j);
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f5013c) {
                return;
            }
            this.f5013c = true;
            if (this.f5014d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.f5012b);
            a.this.f5000e = 3;
        }

        @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.f5013c) {
                return;
            }
            a.this.f4999d.flush();
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class e extends AbstractC0066a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f5016f;

        e(long j) throws IOException {
            super();
            this.f5016f = j;
            if (this.f5016f == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0066a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5003b) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f5016f;
            if (j2 == 0) {
                return -1L;
            }
            long jA = super.a(cVar, Math.min(j2, j));
            if (jA == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, (IOException) protocolException);
                throw protocolException;
            }
            this.f5016f -= jA;
            if (this.f5016f == 0) {
                a(true, (IOException) null);
            }
            return jA;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f5003b) {
                return;
            }
            if (this.f5016f != 0 && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.f5003b = true;
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class f extends AbstractC0066a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f5018f;

        f() {
            super();
        }

        @Override // com.bytedance.sdk.a.b.a.d.a.AbstractC0066a, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f5003b) {
                throw new IllegalStateException("closed");
            }
            if (this.f5018f) {
                return -1L;
            }
            long jA = super.a(cVar, j);
            if (jA != -1) {
                return jA;
            }
            this.f5018f = true;
            a(true, (IOException) null);
            return -1L;
        }

        @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f5003b) {
                return;
            }
            if (!this.f5018f) {
                a(false, (IOException) null);
            }
            this.f5003b = true;
        }
    }

    public a(v vVar, g gVar, com.bytedance.sdk.a.a.e eVar, com.bytedance.sdk.a.a.d dVar) {
        this.f4996a = vVar;
        this.f4997b = gVar;
        this.f4998c = eVar;
        this.f4999d = dVar;
    }

    private String f() throws IOException {
        String strE = this.f4998c.e(this.f5001f);
        this.f5001f -= (long) strE.length();
        return strE;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return d();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.f4999d.flush();
    }

    public com.bytedance.sdk.a.b.r c() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String strF = f();
            if (strF.length() == 0) {
                return aVar.a();
            }
            com.bytedance.sdk.a.b.a.a.f4904a.a(aVar, strF);
        }
    }

    public com.bytedance.sdk.a.a.r d() {
        if (this.f5000e == 1) {
            this.f5000e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f5000e);
    }

    public s e() throws IOException {
        if (this.f5000e != 4) {
            throw new IllegalStateException("state: " + this.f5000e);
        }
        g gVar = this.f4997b;
        if (gVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f5000e = 5;
        gVar.d();
        return new f();
    }

    public s b(long j) throws IOException {
        if (this.f5000e == 4) {
            this.f5000e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f5000e);
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), com.bytedance.sdk.a.b.a.c.i.a(yVar, this.f4997b.b().a().b().type()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        g gVar = this.f4997b;
        gVar.f4960c.f(gVar.f4959b);
        String strA = aaVar.a("Content-Type");
        if (!com.bytedance.sdk.a.b.a.c.e.b(aaVar)) {
            return new h(strA, 0L, l.a(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(aaVar.a("Transfer-Encoding"))) {
            return new h(strA, -1L, l.a(a(aaVar.a().a())));
        }
        long jA = com.bytedance.sdk.a.b.a.c.e.a(aaVar);
        if (jA != -1) {
            return new h(strA, jA, l.a(b(jA)));
        }
        return new h(strA, -1L, l.a(e()));
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.f4999d.flush();
    }

    public void a(com.bytedance.sdk.a.b.r rVar, String str) throws IOException {
        if (this.f5000e == 0) {
            this.f4999d.b(str).b("\r\n");
            int iA = rVar.a();
            for (int i = 0; i < iA; i++) {
                this.f4999d.b(rVar.a(i)).b(": ").b(rVar.b(i)).b("\r\n");
            }
            this.f4999d.b("\r\n");
            this.f5000e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f5000e);
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        int i = this.f5000e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f5000e);
        }
        try {
            k kVarA = k.a(f());
            aa.a aVarA = new aa.a().a(kVarA.f4993a).a(kVarA.f4994b).a(kVarA.f4995c).a(c());
            if (z && kVarA.f4994b == 100) {
                return null;
            }
            this.f5000e = 4;
            return aVarA;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f4997b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    public com.bytedance.sdk.a.a.r a(long j) {
        if (this.f5000e == 1) {
            this.f5000e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.f5000e);
    }

    public s a(com.bytedance.sdk.a.b.s sVar) throws IOException {
        if (this.f5000e == 4) {
            this.f5000e = 5;
            return new c(sVar);
        }
        throw new IllegalStateException("state: " + this.f5000e);
    }

    void a(i iVar) {
        t tVarA = iVar.a();
        iVar.a(t.f4893c);
        tVarA.f();
        tVarA.e();
    }
}
