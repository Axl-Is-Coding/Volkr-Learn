package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebviewTimeTrack.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.h f5794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f5795c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f5796d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f5797e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f5798f = new JSONObject();

    public p(int i, String str, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.f5793a = "embeded_ad";
        this.f5793a = str;
        this.f5794b = hVar;
        a(this.f5798f, "webview_source", Integer.valueOf(i));
    }

    private boolean j() {
        return this.f5797e.booleanValue() || (this.f5796d.booleanValue() && this.f5795c.booleanValue());
    }

    public void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "render_start", jSONObject);
    }

    public void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "render_success", jSONObject);
    }

    public void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "native_render_start", jSONObject);
    }

    public void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "native_render_end", jSONObject);
    }

    public void e() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "webview_load_start", jSONObject);
    }

    public void f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "webview_load_success", jSONObject);
    }

    public void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(this.f5798f, "webview_load_error", jSONObject);
    }

    public void h() {
        this.f5795c = true;
    }

    public void i() {
        if (j()) {
            HashMap map = new HashMap();
            map.put("webview_time_track", this.f5798f);
            d.e(com.bytedance.sdk.openadsdk.core.o.a(), this.f5794b, this.f5793a, "webview_time_track", map);
        }
    }

    public void a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(jSONObject, "code", Integer.valueOf(i));
        a(this.f5798f, "render_error", jSONObject);
    }

    public void b(String str, long j, long j2, int i) {
        if (TextUtils.isEmpty(str) || j2 < j) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(j));
        a(jSONObject, "url", str);
        a(jSONObject, "intercept_type", Integer.valueOf(i));
        a(this.f5798f, "intercept_js_start", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "ts", Long.valueOf(j2));
        a(jSONObject2, "url", str);
        a(jSONObject2, "intercept_type", Integer.valueOf(i));
        a(this.f5798f, "intercept_js_end", jSONObject2);
    }

    public void a(String str, long j, long j2, int i) {
        if (TextUtils.isEmpty(str) || j2 < j) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(j));
        a(jSONObject, "url", str);
        a(jSONObject, "intercept_type", Integer.valueOf(i));
        a(this.f5798f, "intercept_html_start", jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "ts", Long.valueOf(j2));
        a(jSONObject2, "url", str);
        a(jSONObject2, "intercept_type", Integer.valueOf(i));
        a(this.f5798f, "intercept_html_end", jSONObject2);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(jSONObject, "jsb", str);
        a(this.f5798f, "webview_jsb_end", jSONObject);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
        a(jSONObject, "jsb", str);
        a(this.f5798f, "webview_jsb_start", jSONObject);
    }

    public void a(JSONObject jSONObject) {
        if (this.f5798f == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(this.f5798f, next, jSONObject.opt(next));
        }
        this.f5796d = true;
        i();
    }

    public void a(boolean z) {
        this.f5797e = Boolean.valueOf(z);
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Exception unused) {
        }
    }
}
