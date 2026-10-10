package com.bytedance.sdk.adnet.b;

import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonObjectRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends g<JSONObject> {
    public f(int i, String str, JSONObject jSONObject, m.a<JSONObject> aVar) {
        this(i, str, jSONObject == null ? null : jSONObject.toString(), aVar);
    }

    @Override // com.bytedance.sdk.adnet.b.g, com.bytedance.sdk.adnet.core.Request
    protected m<JSONObject> a(com.bytedance.sdk.adnet.core.i iVar) {
        try {
            return m.a(new JSONObject(new String(iVar.f5525b, com.bytedance.sdk.adnet.d.b.a(iVar.f5526c, "utf-8"))), com.bytedance.sdk.adnet.d.b.a(iVar));
        } catch (UnsupportedEncodingException e2) {
            return m.a(new com.bytedance.sdk.adnet.err.e(e2));
        } catch (JSONException e3) {
            return m.a(new com.bytedance.sdk.adnet.err.e(e3));
        }
    }

    public f(int i, String str, String str2, m.a<JSONObject> aVar) {
        super(i, str, str2, aVar);
    }
}
