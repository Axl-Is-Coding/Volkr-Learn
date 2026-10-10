package okhttp3.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.H;
import okhttp3.J;
import okhttp3.internal.connection.g;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.h;
import okhttp3.internal.http.i;
import okhttp3.internal.http.k;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: Http1Codec.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements HttpCodec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z f23062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g f23063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BufferedSource f23064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final BufferedSink f23065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f23066e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f23067f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* JADX INFO: compiled from: Http1Codec.java */
    private abstract class a implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final ForwardingTimeout f23068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f23069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected long f23070c;

        private a() {
            this.f23068a = new ForwardingTimeout(b.this.f23064c.timeout());
            this.f23070c = 0L;
        }

        protected final void a(boolean z, IOException iOException) throws IOException {
            b bVar = b.this;
            int i = bVar.f23066e;
            if (i == 6) {
                return;
            }
            if (i != 5) {
                throw new IllegalStateException("state: " + b.this.f23066e);
            }
            bVar.a(this.f23068a);
            b bVar2 = b.this;
            bVar2.f23066e = 6;
            g gVar = bVar2.f23063b;
            if (gVar != null) {
                gVar.a(!z, bVar2, this.f23070c, iOException);
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long j2 = b.this.f23064c.read(buffer, j);
                if (j2 > 0) {
                    this.f23070c += j2;
                }
                return j2;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f23068a;
        }
    }

    /* JADX INFO: renamed from: okhttp3.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Http1Codec.java */
    private final class C0249b implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f23072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f23073b;

        C0249b() {
            this.f23072a = new ForwardingTimeout(b.this.f23065d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f23073b) {
                return;
            }
            this.f23073b = true;
            b.this.f23065d.writeUtf8("0\r\n\r\n");
            b.this.a(this.f23072a);
            b.this.f23066e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f23073b) {
                return;
            }
            b.this.f23065d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f23072a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f23073b) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            b.this.f23065d.writeHexadecimalUnsignedLong(j);
            b.this.f23065d.writeUtf8("\r\n");
            b.this.f23065d.write(buffer, j);
            b.this.f23065d.writeUtf8("\r\n");
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class c extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final v f23075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f23076f;
        private boolean g;

        c(v vVar) {
            super();
            this.f23076f = -1L;
            this.g = true;
            this.f23075e = vVar;
        }

        private void a() throws IOException {
            if (this.f23076f != -1) {
                b.this.f23064c.readUtf8LineStrict();
            }
            try {
                this.f23076f = b.this.f23064c.readHexadecimalUnsignedLong();
                String strTrim = b.this.f23064c.readUtf8LineStrict().trim();
                if (this.f23076f < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f23076f + strTrim + "\"");
                }
                if (this.f23076f == 0) {
                    this.g = false;
                    okhttp3.internal.http.e.a(b.this.f23062a.h(), this.f23075e, b.this.c());
                    a(true, null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f23069b) {
                return;
            }
            if (this.g && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f23069b = true;
        }

        @Override // okhttp3.a.a.b.a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f23069b) {
                throw new IllegalStateException("closed");
            }
            if (!this.g) {
                return -1L;
            }
            long j2 = this.f23076f;
            if (j2 == 0 || j2 == -1) {
                a();
                if (!this.g) {
                    return -1L;
                }
            }
            long j3 = super.read(buffer, Math.min(j, this.f23076f));
            if (j3 != -1) {
                this.f23076f -= j3;
                return j3;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private final class d implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingTimeout f23077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f23078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f23079c;

        d(long j) {
            this.f23077a = new ForwardingTimeout(b.this.f23065d.timeout());
            this.f23079c = j;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f23078b) {
                return;
            }
            this.f23078b = true;
            if (this.f23079c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            b.this.a(this.f23077a);
            b.this.f23066e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f23078b) {
                return;
            }
            b.this.f23065d.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.f23077a;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f23078b) {
                throw new IllegalStateException("closed");
            }
            okhttp3.a.e.a(buffer.size(), 0L, j);
            if (j <= this.f23079c) {
                b.this.f23065d.write(buffer, j);
                this.f23079c -= j;
                return;
            }
            throw new ProtocolException("expected " + this.f23079c + " bytes but received " + j);
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class e extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f23081e;

        e(long j) throws IOException {
            super();
            this.f23081e = j;
            if (this.f23081e == 0) {
                a(true, null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f23069b) {
                return;
            }
            if (this.f23081e != 0 && !okhttp3.a.e.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, null);
            }
            this.f23069b = true;
        }

        @Override // okhttp3.a.a.b.a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f23069b) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f23081e;
            if (j2 == 0) {
                return -1L;
            }
            long j3 = super.read(buffer, Math.min(j2, j));
            if (j3 == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a(false, protocolException);
                throw protocolException;
            }
            this.f23081e -= j3;
            if (this.f23081e == 0) {
                a(true, null);
            }
            return j3;
        }
    }

    /* JADX INFO: compiled from: Http1Codec.java */
    private class f extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f23083e;

        f() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f23069b) {
                return;
            }
            if (!this.f23083e) {
                a(false, null);
            }
            this.f23069b = true;
        }

        @Override // okhttp3.a.a.b.a, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f23069b) {
                throw new IllegalStateException("closed");
            }
            if (this.f23083e) {
                return -1L;
            }
            long j2 = super.read(buffer, j);
            if (j2 != -1) {
                return j2;
            }
            this.f23083e = true;
            a(true, null);
            return -1L;
        }
    }

    public b(z zVar, g gVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f23062a = zVar;
        this.f23063b = gVar;
        this.f23064c = bufferedSource;
        this.f23065d = bufferedSink;
    }

    private String d() throws IOException {
        String utf8LineStrict = this.f23064c.readUtf8LineStrict(this.f23067f);
        this.f23067f -= (long) utf8LineStrict.length();
        return utf8LineStrict;
    }

    public void a(u uVar, String str) throws IOException {
        if (this.f23066e != 0) {
            throw new IllegalStateException("state: " + this.f23066e);
        }
        this.f23065d.writeUtf8(str).writeUtf8("\r\n");
        int iB = uVar.b();
        for (int i = 0; i < iB; i++) {
            this.f23065d.writeUtf8(uVar.a(i)).writeUtf8(": ").writeUtf8(uVar.b(i)).writeUtf8("\r\n");
        }
        this.f23065d.writeUtf8("\r\n");
        this.f23066e = 1;
    }

    public Source b(long j) throws IOException {
        if (this.f23066e == 4) {
            this.f23066e = 5;
            return new e(j);
        }
        throw new IllegalStateException("state: " + this.f23066e);
    }

    public u c() throws IOException {
        u.a aVar = new u.a();
        while (true) {
            String strD = d();
            if (strD.length() == 0) {
                return aVar.a();
            }
            okhttp3.a.a.f23061a.a(aVar, strD);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        okhttp3.internal.connection.d dVarC = this.f23063b.c();
        if (dVarC != null) {
            dVarC.a();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(C c2, long j) {
        if ("chunked".equalsIgnoreCase(c2.a("Transfer-Encoding"))) {
            return a();
        }
        if (j != -1) {
            return a(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.f23065d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.f23065d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public J openResponseBody(H h) throws IOException {
        g gVar = this.f23063b;
        gVar.f23231f.e(gVar.f23230e);
        String strA = h.a("Content-Type");
        if (!okhttp3.internal.http.e.b(h)) {
            return new h(strA, 0L, Okio.buffer(b(0L)));
        }
        if ("chunked".equalsIgnoreCase(h.a("Transfer-Encoding"))) {
            return new h(strA, -1L, Okio.buffer(a(h.y().g())));
        }
        long jA = okhttp3.internal.http.e.a(h);
        return jA != -1 ? new h(strA, jA, Okio.buffer(b(jA))) : new h(strA, -1L, Okio.buffer(b()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public H.a readResponseHeaders(boolean z) throws IOException {
        int i = this.f23066e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f23066e);
        }
        try {
            k kVarA = k.a(d());
            H.a aVar = new H.a();
            aVar.a(kVarA.f23255a);
            aVar.a(kVarA.f23256b);
            aVar.a(kVarA.f23257c);
            aVar.a(c());
            if (z && kVarA.f23256b == 100) {
                return null;
            }
            if (kVarA.f23256b == 100) {
                this.f23066e = 3;
                return aVar;
            }
            this.f23066e = 4;
            return aVar;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f23063b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(C c2) throws IOException {
        a(c2.c(), i.a(c2, this.f23063b.c().route().b().type()));
    }

    public Source b() throws IOException {
        if (this.f23066e == 4) {
            g gVar = this.f23063b;
            if (gVar != null) {
                this.f23066e = 5;
                gVar.e();
                return new f();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        throw new IllegalStateException("state: " + this.f23066e);
    }

    public Sink a() {
        if (this.f23066e == 1) {
            this.f23066e = 2;
            return new C0249b();
        }
        throw new IllegalStateException("state: " + this.f23066e);
    }

    public Sink a(long j) {
        if (this.f23066e == 1) {
            this.f23066e = 2;
            return new d(j);
        }
        throw new IllegalStateException("state: " + this.f23066e);
    }

    public Source a(v vVar) throws IOException {
        if (this.f23066e == 4) {
            this.f23066e = 5;
            return new c(vVar);
        }
        throw new IllegalStateException("state: " + this.f23066e);
    }

    void a(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }
}
