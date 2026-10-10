package com.google.firebase.crashlytics.internal.network;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.C2942g;
import okhttp3.G;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;
import okhttp3.z;

/* JADX INFO: loaded from: classes2.dex */
public class HttpRequest {
    private static final z CLIENT;
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private x.a bodyBuilder = null;
    private final Map<String, String> headers = new HashMap();
    private final HttpMethod method;
    private final Map<String, String> queryParams;
    private final String url;

    static {
        z.a aVarR = new z().r();
        aVarR.a(10000L, TimeUnit.MILLISECONDS);
        CLIENT = aVarR.a();
    }

    public HttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        this.method = httpMethod;
        this.url = str;
        this.queryParams = map;
    }

    private C build() {
        C.a aVar = new C.a();
        C2942g.a aVar2 = new C2942g.a();
        aVar2.b();
        aVar.a(aVar2.a());
        v.a aVarI = v.d(this.url).i();
        for (Map.Entry<String, String> entry : this.queryParams.entrySet()) {
            aVarI.a(entry.getKey(), entry.getValue());
        }
        aVar.a(aVarI.a());
        for (Map.Entry<String, String> entry2 : this.headers.entrySet()) {
            aVar.b(entry2.getKey(), entry2.getValue());
        }
        x.a aVar3 = this.bodyBuilder;
        aVar.a(this.method.name(), aVar3 == null ? null : aVar3.a());
        return aVar.a();
    }

    private x.a getOrCreateBodyBuilder() {
        if (this.bodyBuilder == null) {
            x.a aVar = new x.a();
            aVar.a(x.f23488e);
            this.bodyBuilder = aVar;
        }
        return this.bodyBuilder;
    }

    public HttpResponse execute() throws IOException {
        return HttpResponse.create(CLIENT.newCall(build()).execute());
    }

    public HttpRequest header(String str, String str2) {
        this.headers.put(str, str2);
        return this;
    }

    public String method() {
        return this.method.name();
    }

    public HttpRequest part(String str, String str2) {
        x.a orCreateBodyBuilder = getOrCreateBodyBuilder();
        orCreateBodyBuilder.a(str, str2);
        this.bodyBuilder = orCreateBodyBuilder;
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        G gCreate = G.create(w.b(str3), file);
        x.a orCreateBodyBuilder = getOrCreateBodyBuilder();
        orCreateBodyBuilder.a(str, str2, gCreate);
        this.bodyBuilder = orCreateBodyBuilder;
        return this;
    }
}
