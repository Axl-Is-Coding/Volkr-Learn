package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import io.grpc.internal.GrpcUtil;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: HurlStack.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends com.android.volley.toolbox.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f4065b;

    /* JADX INFO: compiled from: HurlStack.java */
    static class a extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f4066a;

        a(HttpURLConnection httpURLConnection) {
            super(k.b(httpURLConnection));
            this.f4066a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f4066a.disconnect();
        }
    }

    /* JADX INFO: compiled from: HurlStack.java */
    public interface b {
        String a(String str);
    }

    public k() {
        this(null);
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    @Override // com.android.volley.toolbox.b
    public i b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String strA;
        String strT = request.t();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(request.e());
        b bVar = this.f4064a;
        if (bVar != null) {
            strA = bVar.a(strT);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strT);
            }
        } else {
            strA = strT;
        }
        HttpURLConnection httpURLConnectionA = a(new URL(strA), request);
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionA.setRequestProperty(str, (String) map2.get(str));
            }
            a(httpURLConnectionA, request);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (a(request.f(), responseCode)) {
                return new i(responseCode, a(httpURLConnectionA.getHeaderFields()), httpURLConnectionA.getContentLength(), new a(httpURLConnectionA));
            }
            i iVar = new i(responseCode, a(httpURLConnectionA.getHeaderFields()));
            httpURLConnectionA.disconnect();
            return iVar;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public k(b bVar) {
        this(bVar, null);
    }

    static List<com.android.volley.g> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.android.volley.g(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public k(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f4064a = bVar;
        this.f4065b = sSLSocketFactory;
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionA = a(url);
        int iR = request.r();
        httpURLConnectionA.setConnectTimeout(iR);
        httpURLConnectionA.setReadTimeout(iR);
        httpURLConnectionA.setUseCaches(false);
        httpURLConnectionA.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f4065b) != null) {
            ((HttpsURLConnection) httpURLConnectionA).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionA;
    }

    static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.f()) {
            case -1:
                byte[] bArrI = request.i();
                if (bArrI != null) {
                    httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                    a(httpURLConnection, request, bArrI);
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod(GrpcUtil.HTTP_METHOD);
                b(httpURLConnection, request);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, request);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] bArrA = request.a();
        if (bArrA != null) {
            a(httpURLConnection, request, bArrA);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", request.b());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
