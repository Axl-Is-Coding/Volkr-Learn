package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: compiled from: BaseHttpStack.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements j {
    @Override // com.android.volley.toolbox.j
    @Deprecated
    public final HttpResponse a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        i iVarB = b(request, map);
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), iVarB.d(), ""));
        ArrayList arrayList = new ArrayList();
        for (com.android.volley.g gVar : iVarB.c()) {
            arrayList.add(new BasicHeader(gVar.a(), gVar.b()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStreamA = iVarB.a();
        if (inputStreamA != null) {
            BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStreamA);
            basicHttpEntity.setContentLength(iVarB.b());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }

    public abstract i b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
