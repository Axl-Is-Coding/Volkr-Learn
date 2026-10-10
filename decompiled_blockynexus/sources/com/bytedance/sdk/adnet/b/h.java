package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonStringRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends g<String> {
    public h(int i, String str, JSONObject jSONObject, m.a<String> aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    protected m<String> a(com.bytedance.sdk.adnet.core.i iVar) {
        try {
            return m.a(new String(iVar.f5525b, com.bytedance.sdk.adnet.d.b.a(iVar.f5526c, "utf-8")), com.bytedance.sdk.adnet.d.b.a(iVar));
        } catch (UnsupportedEncodingException e2) {
            return m.a(new com.bytedance.sdk.adnet.err.e(e2));
        }
    }
}
