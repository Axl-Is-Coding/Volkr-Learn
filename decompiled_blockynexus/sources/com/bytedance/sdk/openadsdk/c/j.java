package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: LandingPageLog.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5773f;
    private final Context g;
    private final com.bytedance.sdk.openadsdk.core.d.h h;
    private WebView p;
    private p s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5768a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5769b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5770c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f5771d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5772e = -1;
    private String i = "landingpage";
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private boolean n = false;
    private AtomicInteger o = new AtomicInteger(0);
    private boolean q = false;
    private String r = "";

    /* JADX INFO: compiled from: LandingPageLog.java */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public String getUrl() {
            return j.this.r;
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i = 0;
            sb.append(j.this.p == null ? 0 : j.this.p.getMeasuredHeight());
            com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", sb.toString());
            com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            j.this.o.set(i);
        }
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, WebView webView) {
        this.g = context;
        this.h = hVar;
        this.p = webView;
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onDestroy");
        this.p = null;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
    }

    public void b() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onResume");
        this.j = System.currentTimeMillis();
    }

    public void c() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onStop");
        boolean z = this.f5768a == 2;
        this.k = System.currentTimeMillis();
        long j = this.k - this.j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.f5768a);
            jSONObject.put("stay_page_duration", j);
            jSONObject.put("max_scroll_percent", z ? this.o.get() : 0);
        } catch (JSONException unused) {
        }
        a("landing_close", jSONObject);
    }

    public p a() {
        return this.s;
    }

    public void a(p pVar) {
        this.s = pVar;
    }

    public j a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(WebView webView, int i) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebProgress: " + i);
        if (this.l == 0 && i > 0) {
            this.l = System.currentTimeMillis();
        } else if (this.m == 0 && i == 100) {
            this.m = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        p pVar = this.s;
        if (pVar != null) {
            pVar.e();
        }
        if (this.f5769b) {
            return;
        }
        this.f5769b = true;
        a("load_start", new JSONObject());
    }

    public void a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        p pVar = this.s;
        if (pVar != null) {
            pVar.f();
        }
        if (webView != null && !this.n) {
            this.n = true;
            com.bytedance.sdk.openadsdk.utils.n.a(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.f5768a != 3) {
            this.f5768a = 2;
        }
        if (this.f5768a == 2) {
            long j = this.m - this.l;
            if (this.f5770c) {
                return;
            }
            this.f5770c = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_duration", j);
            } catch (Exception unused) {
            }
            a("load_finish", jSONObject);
            return;
        }
        if (this.f5771d) {
            return;
        }
        this.f5771d = true;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, this.f5772e);
            jSONObject2.put("error_msg", this.f5773f);
        } catch (Exception unused2) {
        }
        a("load_fail", jSONObject2);
    }

    public void a(WebView webView, int i, String str, String str2) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebError: " + i + ", " + String.valueOf(str) + ", " + String.valueOf(str2));
        p pVar = this.s;
        if (pVar != null) {
            pVar.g();
        }
        this.f5768a = 3;
        this.f5772e = i;
        this.f5773f = str;
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        if (!this.q || this.h == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                int i = 1;
                jSONObject.put("is_playable", this.h.r() ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.video.c.a.a().a(this.h)) {
                    i = 0;
                }
                jSONObject.put("usecache", i);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "sendEvent: " + String.valueOf(this.i) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
        d.b(this.g, this.h, this.i, str, jSONObject2);
    }
}
