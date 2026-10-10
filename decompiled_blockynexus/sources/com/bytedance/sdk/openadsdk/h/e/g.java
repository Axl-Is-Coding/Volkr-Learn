package com.bytedance.sdk.openadsdk.h.e;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: VolleyResponseWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HttpResponse f6903c;

    public g(HttpResponse httpResponse, f fVar) {
        this.f6903c = httpResponse;
        this.f6894a = new ArrayList();
        for (int i = 0; i < this.f6903c.getHeaders().size(); i++) {
            Header header = this.f6903c.getHeaders().get(i);
            if (header != null) {
                this.f6894a.add(new i.b(header.getName(), header.getValue()));
            }
        }
        this.f6895b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public int a() {
        return this.f6903c.getStatusCode();
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public boolean b() {
        return this.f6903c.getStatusCode() >= 200 && this.f6903c.getStatusCode() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public List<i.b> c() {
        return this.f6894a;
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public InputStream d() {
        return this.f6903c.getContent();
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String e() {
        return "http/1.1";
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String f() {
        return a(this.f6903c.getStatusCode());
    }

    @Override // com.bytedance.sdk.openadsdk.h.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).f6965b : str2;
    }
}
