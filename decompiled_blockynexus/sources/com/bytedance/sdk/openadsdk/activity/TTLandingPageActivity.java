package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.a.a.a.a.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTLandingPageActivity extends Activity implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5663b = "TTLandingPageActivity";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j f5664a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SSWebView f5665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f5666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ImageView f5667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f5668f;
    private Context g;
    private int h;
    private ViewStub i;
    private ViewStub j;
    private ViewStub k;
    private Button l;
    private ProgressBar m;
    private String n;
    private String o;
    private v p;
    private int q;
    private String r;
    private h s;
    private b t;
    private String u;
    private AtomicBoolean v = new AtomicBoolean(true);
    private JSONArray w = null;
    private String x = "ダウンロード";

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!e() || this.v.getAndSet(true)) {
            super.onBackPressed();
        } else {
            a(true);
            a(0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            o.a(this);
        } catch (Throwable unused) {
        }
        setContentView(t.f(this, "tt_activity_ttlandingpage"));
        c();
        this.g = this;
        a.a(this.g).a(false).b(false).a(this.f5665c);
        Intent intent = getIntent();
        this.h = intent.getIntExtra("sdk_version", 1);
        this.n = intent.getStringExtra("adid");
        this.o = intent.getStringExtra("log_extra");
        this.q = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        this.u = stringExtra;
        a(4);
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra("icon_url");
        this.r = intent.getStringExtra("event_tag");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.s = c.a(new JSONObject(stringExtra3));
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.utils.o.c(f5663b, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.s = s.a().c();
            s.a().g();
        }
        h hVar = this.s;
        if (hVar == null) {
            finish();
            return;
        }
        this.f5664a = new j(this, hVar, this.f5665c).a(true);
        d();
        this.f5665c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.g, this.p, this.n, this.f5664a) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTLandingPageActivity.this.m == null || TTLandingPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTLandingPageActivity.this.m.setVisibility(8);
                } catch (Throwable unused2) {
                }
            }
        });
        this.f5665c.getSettings().setUserAgentString(l.a(this.f5665c, this.h));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5665c.getSettings().setMixedContentMode(0);
        }
        this.f5665c.loadUrl(stringExtra);
        this.f5665c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.p, this.f5664a) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTLandingPageActivity.this.m == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTLandingPageActivity.this.m.isShown()) {
                    TTLandingPageActivity.this.m.setVisibility(8);
                } else {
                    TTLandingPageActivity.this.m.setProgress(i);
                }
            }
        });
        this.f5665c.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (TTLandingPageActivity.this.t != null) {
                    TTLandingPageActivity.this.t.a();
                }
            }
        });
        TextView textView = this.f5668f;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = t.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        a();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        y.a(this.g, this.f5665c);
        y.a(this.f5665c);
        this.f5665c = null;
        v vVar = this.p;
        if (vVar != null) {
            vVar.g();
        }
        j jVar = this.f5664a;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        s.a().b(true);
        v vVar = this.p;
        if (vVar != null) {
            vVar.f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        v vVar = this.p;
        if (vVar != null) {
            vVar.e();
        }
        j jVar = this.f5664a;
        if (jVar != null) {
            jVar.b();
        }
        f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        j jVar = this.f5664a;
        if (jVar != null) {
            jVar.c();
        }
    }

    private String b() {
        h hVar = this.s;
        if (hVar != null && !TextUtils.isEmpty(hVar.I())) {
            this.x = this.s.I();
        }
        return this.x;
    }

    private void c() {
        this.f5665c = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.k = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
        this.i = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_view_stub"));
        this.j = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_dark_view_stub"));
        int iK = com.bytedance.sdk.openadsdk.core.h.b().k();
        if (iK == 0) {
            this.i.setVisibility(0);
        } else if (iK == 1) {
            this.j.setVisibility(0);
        }
        this.f5666d = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
        ImageView imageView = this.f5666d;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTLandingPageActivity.this.f5665c != null) {
                        if (TTLandingPageActivity.this.f5665c.canGoBack()) {
                            TTLandingPageActivity.this.f5665c.goBack();
                        } else if (TTLandingPageActivity.this.e()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        this.f5667e = (ImageView) findViewById(t.e(this, "tt_titlebar_close"));
        ImageView imageView2 = this.f5667e;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.f5668f = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
        this.m = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
    }

    private void d() {
        this.p = new v(this);
        this.p.a((WebView) this.f5665c).a(this.n).b(this.o).a(this.s).b(this.q).a(this.s.t()).c(ab.e(this.s)).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return !TextUtils.isEmpty(this.u) && this.u.contains("__luban_sdk");
    }

    private void f() {
        if (this.s == null) {
            return;
        }
        JSONArray jSONArrayB = b(this.u);
        int iD = ab.d(this.o);
        int iC = ab.c(this.o);
        p<com.bytedance.sdk.openadsdk.c.a> pVarF = o.f();
        if (jSONArrayB == null || pVarF == null || iD <= 0 || iC <= 0) {
            return;
        }
        i iVar = new i();
        iVar.f6118d = jSONArrayB;
        AdSlot adSlotK = this.s.k();
        if (adSlotK == null) {
            return;
        }
        adSlotK.setAdCount(6);
        pVarF.a(adSlotK, iVar, iC, new p.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                TTLandingPageActivity.this.a(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    try {
                        TTLandingPageActivity.this.v.set(false);
                        TTLandingPageActivity.this.p.b(new JSONObject(aVar.d()));
                    } catch (Exception unused) {
                        TTLandingPageActivity.this.a(0);
                    }
                }
            }
        });
    }

    private void a() {
        h hVar = this.s;
        if (hVar == null || hVar.x() != 4) {
            return;
        }
        this.k.setVisibility(0);
        this.l = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
        if (this.l != null) {
            a(b());
            if (this.t == null) {
                this.t = b.a.a.a.a.a.c.a(this, this.s, TextUtils.isEmpty(this.r) ? ab.a(this.q) : this.r);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.s, this.r, this.q);
            aVar.a(false);
            this.l.setOnClickListener(aVar);
            this.l.setOnTouchListener(aVar);
            aVar.c(true);
            aVar.a(this.t);
        }
    }

    private JSONArray b(String str) {
        int i;
        JSONArray jSONArray = this.w;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.w;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    private void a(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.l) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.l == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.l.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.f5667e == null || !e()) {
            return;
        }
        ac.a((View) this.f5667e, i);
    }

    private void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.p.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.w = jSONArray;
        f();
    }
}
