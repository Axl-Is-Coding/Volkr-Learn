package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: compiled from: HttpClientStack.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HttpClient f4059a;

    /* JADX INFO: compiled from: HttpClientStack.java */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public a(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }

    public g(HttpClient httpClient) {
        this.f4059a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    static HttpUriRequest b(Request<?> request, Map<String, String> map) throws AuthFailureError {
        switch (request.f()) {
            case -1:
                byte[] bArrI = request.i();
                if (bArrI == null) {
                    return new HttpGet(request.t());
                }
                HttpPost httpPost = new HttpPost(request.t());
                httpPost.addHeader("Content-Type", request.m());
                httpPost.setEntity(new ByteArrayEntity(bArrI));
                return httpPost;
            case 0:
                return new HttpGet(request.t());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.t());
                httpPost2.addHeader("Content-Type", request.b());
                a(httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.t());
                httpPut.addHeader("Content-Type", request.b());
                a(httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.t());
            case 4:
                return new HttpHead(request.t());
            case 5:
                return new HttpOptions(request.t());
            case 6:
                return new HttpTrace(request.t());
            case 7:
                a aVar = new a(request.t());
                aVar.addHeader("Content-Type", request.b());
                a(aVar, request);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    protected void a(HttpUriRequest httpUriRequest) throws IOException {
    }

    @Override // com.android.volley.toolbox.j
    public HttpResponse a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest httpUriRequestB = b(request, map);
        a(httpUriRequestB, map);
        a(httpUriRequestB, request.e());
        a(httpUriRequestB);
        HttpParams params = httpUriRequestB.getParams();
        int iR = request.r();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iR);
        return this.f4059a.execute(httpUriRequestB);
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] bArrA = request.a();
        if (bArrA != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrA));
        }
    }
}
