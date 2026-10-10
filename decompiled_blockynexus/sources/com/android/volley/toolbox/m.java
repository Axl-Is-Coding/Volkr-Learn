package com.android.volley.toolbox;

import com.android.volley.ParseError;
import com.android.volley.m;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonObjectRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends n<JSONObject> {
    public m(int i, String str, JSONObject jSONObject, m.b<JSONObject> bVar, m.a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    @Override // com.android.volley.Request
    protected com.android.volley.m<JSONObject> a(com.android.volley.j jVar) {
        try {
            return com.android.volley.m.a(new JSONObject(new String(jVar.f4010b, h.a(jVar.f4011c, "utf-8"))), h.a(jVar));
        } catch (UnsupportedEncodingException e2) {
            return com.android.volley.m.a(new ParseError(e2));
        } catch (JSONException e3) {
            return com.android.volley.m.a(new ParseError(e3));
        }
    }
}
