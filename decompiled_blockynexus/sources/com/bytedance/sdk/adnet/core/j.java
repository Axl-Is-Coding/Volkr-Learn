package com.bytedance.sdk.adnet.core;

import android.text.TextUtils;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.u;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import com.bytedance.sdk.adnet.face.IHttpStack;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OkStack.java */
/* JADX INFO: loaded from: classes.dex */
public class j implements IHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f5530a = new v.a().a(10000, TimeUnit.MILLISECONDS).b(10000, TimeUnit.MILLISECONDS).c(10000, TimeUnit.MILLISECONDS).a();

    /* JADX INFO: compiled from: OkStack.java */
    static class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ab f5531a;

        a(ab abVar) {
            super(j.b(abVar));
            this.f5531a = abVar;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            try {
                this.f5531a.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    private String b(Request<?> request) {
        if (request == null || request.getUrl() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(new URL(request.getUrl()).getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private y.a c(Request request) throws IOException {
        if (request == null || request.getUrl() == null) {
            return null;
        }
        y.a aVar = new y.a();
        URL url = new URL(request.getUrl());
        String host = url.getHost();
        n nVar = com.bytedance.sdk.adnet.a.f5354a;
        String strA = nVar != null ? nVar.a(host) : null;
        boolean z = false;
        if (!TextUtils.isEmpty(strA)) {
            try {
                aVar.a(new URL(url.toString().replaceFirst(host, strA))).b("Host", host);
                z = true;
            } catch (Exception unused) {
            }
        }
        if (!z) {
            aVar.a(url);
        }
        return aVar;
    }

    private static z d(Request request) throws com.bytedance.sdk.adnet.err.a {
        byte[] body = request.getBody();
        if (body == null) {
            if (request.getMethod() != 1) {
                return null;
            }
            body = "".getBytes();
        }
        return z.a(u.a(request.getBodyContentType()), body);
    }

    @Override // com.bytedance.sdk.adnet.face.IHttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws Throwable {
        long timeoutMs = request.getTimeoutMs();
        v vVarA = this.f5530a.y().a(timeoutMs, TimeUnit.MILLISECONDS).b(timeoutMs, TimeUnit.MILLISECONDS).c(timeoutMs, TimeUnit.MILLISECONDS).b(true).a(true).a();
        y.a aVarC = c(request);
        if (aVarC == null) {
            throw new IllegalArgumentException("request params maybe null");
        }
        a(request);
        if (!TextUtils.isEmpty(request.getUserAgent())) {
            aVarC.b(AbstractSpiCall.HEADER_USER_AGENT).b(AbstractSpiCall.HEADER_USER_AGENT, request.getUserAgent() + " " + com.bytedance.sdk.a.b.a.d.a());
        }
        Map<String, String> headers = request.getHeaders();
        if (headers != null) {
            for (String str : headers.keySet()) {
                aVarC.b(str, headers.get(str));
            }
        }
        if (map != null) {
            for (String str2 : map.keySet()) {
                aVarC.a(str2, map.get(str2));
            }
        }
        a(aVarC, request);
        aa aaVarA = vVarA.a(aVarC.d()).a();
        com.bytedance.sdk.a.b.a.c.k kVarA = com.bytedance.sdk.a.b.a.c.k.a(aaVarA);
        ab abVarG = aaVarA.g();
        boolean z = false;
        try {
            int i = kVarA.f4994b;
            if (i == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!a(request.getMethod(), i)) {
                HttpResponse httpResponse = new HttpResponse(i, a(aaVarA.f()));
                abVarG.close();
                return httpResponse;
            }
            try {
                return new HttpResponse(i, a(aaVarA.f()), (int) abVarG.a(), new a(abVarG));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    abVarG.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void a(Request<?> request) {
        if (request != null) {
            request.setIpAddrStr(b(request));
        }
    }

    private static List<Header> a(r rVar) {
        if (rVar == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(rVar.a());
        int iA = rVar.a();
        for (int i = 0; i < iA; i++) {
            String strA = rVar.a(i);
            String strB = rVar.b(i);
            if (strA != null) {
                arrayList.add(new Header(strA, strB));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(ab abVar) {
        if (abVar == null) {
            return null;
        }
        return abVar.b();
    }

    private static void a(y.a aVar, Request<?> request) throws IOException, com.bytedance.sdk.adnet.err.a {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    aVar.a(z.a(u.a(request.getBodyContentType()), postBody));
                    return;
                }
                return;
            case 0:
                aVar.a();
                return;
            case 1:
                aVar.a(d(request));
                return;
            case 2:
                aVar.c(d(request));
                return;
            case 3:
                aVar.c();
                return;
            case 4:
                aVar.b();
                return;
            case 5:
                aVar.a("OPTIONS", (z) null);
                return;
            case 6:
                aVar.a("TRACE", (z) null);
                return;
            case 7:
                aVar.d(d(request));
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
