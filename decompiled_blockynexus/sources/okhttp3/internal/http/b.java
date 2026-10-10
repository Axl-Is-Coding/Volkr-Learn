package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C;
import okhttp3.H;
import okhttp3.Interceptor;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: compiled from: CallServerInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f23234a;

    /* JADX INFO: compiled from: CallServerInterceptor.java */
    static final class a extends ForwardingSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f23235a;

        a(Sink sink) {
            super(sink);
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            this.f23235a += j;
        }
    }

    public b(boolean z) {
        this.f23234a = z;
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        H hA;
        g gVar = (g) chain;
        HttpCodec httpCodecB = gVar.b();
        okhttp3.internal.connection.g gVarC = gVar.c();
        okhttp3.internal.connection.d dVar = (okhttp3.internal.connection.d) gVar.connection();
        C cRequest = gVar.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.a().d(gVar.call());
        httpCodecB.writeRequestHeaders(cRequest);
        gVar.a().a(gVar.call(), cRequest);
        H.a responseHeaders = null;
        if (f.b(cRequest.e()) && cRequest.a() != null) {
            if ("100-continue".equalsIgnoreCase(cRequest.a("Expect"))) {
                httpCodecB.flushRequest();
                gVar.a().f(gVar.call());
                responseHeaders = httpCodecB.readResponseHeaders(true);
            }
            if (responseHeaders == null) {
                gVar.a().c(gVar.call());
                a aVar = new a(httpCodecB.createRequestBody(cRequest, cRequest.a().contentLength()));
                BufferedSink bufferedSinkBuffer = Okio.buffer(aVar);
                cRequest.a().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
                gVar.a().a(gVar.call(), aVar.f23235a);
            } else if (!dVar.b()) {
                gVarC.e();
            }
        }
        httpCodecB.finishRequest();
        if (responseHeaders == null) {
            gVar.a().f(gVar.call());
            responseHeaders = httpCodecB.readResponseHeaders(false);
        }
        responseHeaders.a(cRequest);
        responseHeaders.a(gVarC.c().handshake());
        responseHeaders.b(jCurrentTimeMillis);
        responseHeaders.a(System.currentTimeMillis());
        H hA2 = responseHeaders.a();
        int iG = hA2.g();
        if (iG == 100) {
            H.a responseHeaders2 = httpCodecB.readResponseHeaders(false);
            responseHeaders2.a(cRequest);
            responseHeaders2.a(gVarC.c().handshake());
            responseHeaders2.b(jCurrentTimeMillis);
            responseHeaders2.a(System.currentTimeMillis());
            hA2 = responseHeaders2.a();
            iG = hA2.g();
        }
        gVar.a().a(gVar.call(), hA2);
        if (this.f23234a && iG == 101) {
            H.a aVarT = hA2.t();
            aVarT.a(okhttp3.a.e.f23115c);
            hA = aVarT.a();
        } else {
            H.a aVarT2 = hA2.t();
            aVarT2.a(httpCodecB.openResponseBody(hA2));
            hA = aVarT2.a();
        }
        if ("close".equalsIgnoreCase(hA.y().a("Connection")) || "close".equalsIgnoreCase(hA.a("Connection"))) {
            gVarC.e();
        }
        if ((iG != 204 && iG != 205) || hA.b().contentLength() <= 0) {
            return hA;
        }
        throw new ProtocolException("HTTP " + iG + " had non-zero Content-Length: " + hA.b().contentLength());
    }
}
