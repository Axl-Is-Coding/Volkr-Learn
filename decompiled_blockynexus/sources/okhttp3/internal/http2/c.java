package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.J;
import okhttp3.Protocol;
import okhttp3.internal.http.HttpCodec;
import okhttp3.u;
import okhttp3.z;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: Http2Codec.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements HttpCodec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f23293a = okhttp3.a.e.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f23294b = okhttp3.a.e.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Interceptor.Chain f23295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final okhttp3.internal.connection.g f23296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j f23297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o f23298f;
    private final Protocol g;

    /* JADX INFO: compiled from: Http2Codec.java */
    class a extends ForwardingSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f23299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f23300b;

        a(Source source) {
            super(source);
            this.f23299a = false;
            this.f23300b = 0L;
        }

        private void a(IOException iOException) {
            if (this.f23299a) {
                return;
            }
            this.f23299a = true;
            c cVar = c.this;
            cVar.f23296d.a(false, cVar, this.f23300b, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long j2 = delegate().read(buffer, j);
                if (j2 > 0) {
                    this.f23300b += j2;
                }
                return j2;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }
    }

    public c(z zVar, Interceptor.Chain chain, okhttp3.internal.connection.g gVar, j jVar) {
        this.f23295c = chain;
        this.f23296d = gVar;
        this.f23297e = jVar;
        this.g = zVar.t().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
    }

    public static List<Header> a(C c2) {
        u uVarC = c2.c();
        ArrayList arrayList = new ArrayList(uVarC.b() + 4);
        arrayList.add(new Header(Header.f23260c, c2.e()));
        arrayList.add(new Header(Header.f23261d, okhttp3.internal.http.i.a(c2.g())));
        String strA = c2.a("Host");
        if (strA != null) {
            arrayList.add(new Header(Header.f23263f, strA));
        }
        arrayList.add(new Header(Header.f23262e, c2.g().o()));
        int iB = uVarC.b();
        for (int i = 0; i < iB; i++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(uVarC.a(i).toLowerCase(Locale.US));
            if (!f23293a.contains(byteStringEncodeUtf8.utf8())) {
                arrayList.add(new Header(byteStringEncodeUtf8, uVarC.b(i)));
            }
        }
        return arrayList;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        o oVar = this.f23298f;
        if (oVar != null) {
            oVar.b(ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    public Sink createRequestBody(C c2, long j) {
        return this.f23298f.d();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void finishRequest() throws IOException {
        this.f23298f.d().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void flushRequest() throws IOException {
        this.f23297e.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    public J openResponseBody(H h) throws IOException {
        okhttp3.internal.connection.g gVar = this.f23296d;
        gVar.f23231f.e(gVar.f23230e);
        return new okhttp3.internal.http.h(h.a("Content-Type"), okhttp3.internal.http.e.a(h), Okio.buffer(new a(this.f23298f.e())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public H.a readResponseHeaders(boolean z) throws IOException {
        H.a aVarA = a(this.f23298f.j(), this.g);
        if (z && okhttp3.a.a.f23061a.a(aVarA) == 100) {
            return null;
        }
        return aVarA;
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void writeRequestHeaders(C c2) throws IOException {
        if (this.f23298f != null) {
            return;
        }
        this.f23298f = this.f23297e.a(a(c2), c2.a() != null);
        this.f23298f.h().timeout(this.f23295c.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f23298f.l().timeout(this.f23295c.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    public static H.a a(u uVar, Protocol protocol) throws IOException {
        u.a aVar = new u.a();
        int iB = uVar.b();
        okhttp3.internal.http.k kVarA = null;
        for (int i = 0; i < iB; i++) {
            String strA = uVar.a(i);
            String strB = uVar.b(i);
            if (strA.equals(":status")) {
                kVarA = okhttp3.internal.http.k.a("HTTP/1.1 " + strB);
            } else if (!f23294b.contains(strA)) {
                okhttp3.a.a.f23061a.a(aVar, strA, strB);
            }
        }
        if (kVarA != null) {
            H.a aVar2 = new H.a();
            aVar2.a(protocol);
            aVar2.a(kVarA.f23256b);
            aVar2.a(kVarA.f23257c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }
}
