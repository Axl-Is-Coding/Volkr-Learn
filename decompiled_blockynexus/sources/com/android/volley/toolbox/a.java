package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: compiled from: AdaptedHttpStack.java */
/* JADX INFO: loaded from: classes.dex */
class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f4037a;

    a(j jVar) {
        this.f4037a = jVar;
    }

    @Override // com.android.volley.toolbox.b
    public i b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        try {
            HttpResponse httpResponseA = this.f4037a.a(request, map);
            int statusCode = httpResponseA.getStatusLine().getStatusCode();
            Header[] allHeaders = httpResponseA.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new com.android.volley.g(header.getName(), header.getValue()));
            }
            if (httpResponseA.getEntity() == null) {
                return new i(statusCode, arrayList);
            }
            long contentLength = httpResponseA.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new i(statusCode, arrayList, (int) httpResponseA.getEntity().getContentLength(), httpResponseA.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e2) {
            throw new SocketTimeoutException(e2.getMessage());
        }
    }
}
