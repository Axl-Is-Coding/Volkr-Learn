package okhttp3.internal.http;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.util.List;
import okhttp3.C;
import okhttp3.CookieJar;
import okhttp3.G;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.n;
import okhttp3.u;
import okhttp3.w;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: compiled from: BridgeInterceptor.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CookieJar f23233a;

    public a(CookieJar cookieJar) {
        this.f23233a = cookieJar;
    }

    private String a(List<n> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            n nVar = list.get(i);
            sb.append(nVar.a());
            sb.append('=');
            sb.append(nVar.b());
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public H intercept(Interceptor.Chain chain) throws IOException {
        C cRequest = chain.request();
        C.a aVarF = cRequest.f();
        G gA = cRequest.a();
        if (gA != null) {
            w wVarContentType = gA.contentType();
            if (wVarContentType != null) {
                aVarF.b("Content-Type", wVarContentType.toString());
            }
            long jContentLength = gA.contentLength();
            if (jContentLength != -1) {
                aVarF.b("Content-Length", Long.toString(jContentLength));
                aVarF.a("Transfer-Encoding");
            } else {
                aVarF.b("Transfer-Encoding", "chunked");
                aVarF.a("Content-Length");
            }
        }
        boolean z = false;
        if (cRequest.a("Host") == null) {
            aVarF.b("Host", okhttp3.a.e.a(cRequest.g(), false));
        }
        if (cRequest.a("Connection") == null) {
            aVarF.b("Connection", "Keep-Alive");
        }
        if (cRequest.a("Accept-Encoding") == null && cRequest.a("Range") == null) {
            z = true;
            aVarF.b("Accept-Encoding", "gzip");
        }
        List<n> listLoadForRequest = this.f23233a.loadForRequest(cRequest.g());
        if (!listLoadForRequest.isEmpty()) {
            aVarF.b("Cookie", a(listLoadForRequest));
        }
        if (cRequest.a(AbstractSpiCall.HEADER_USER_AGENT) == null) {
            aVarF.b(AbstractSpiCall.HEADER_USER_AGENT, okhttp3.a.f.a());
        }
        H hProceed = chain.proceed(aVarF.a());
        e.a(this.f23233a, cRequest.g(), hProceed.o());
        H.a aVarT = hProceed.t();
        aVarT.a(cRequest);
        if (z && "gzip".equalsIgnoreCase(hProceed.a("Content-Encoding")) && e.b(hProceed)) {
            GzipSource gzipSource = new GzipSource(hProceed.b().source());
            u.a aVarA = hProceed.o().a();
            aVarA.c("Content-Encoding");
            aVarA.c("Content-Length");
            aVarT.a(aVarA.a());
            aVarT.a(new h(hProceed.a("Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return aVarT.a();
    }
}
