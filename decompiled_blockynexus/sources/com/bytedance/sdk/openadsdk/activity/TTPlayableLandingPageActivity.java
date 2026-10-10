package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import b.a.a.a.a.a.b;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTPlayableLandingPageActivity extends Activity implements d, ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RelativeLayout f5677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ad f5678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SSWebView f5679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SSWebView f5680d;
    private Context g;
    private int h;
    private ProgressBar i;
    private String j;
    private String k;
    private v l;
    private v m;
    private int n;
    private String o;
    private String p;
    private String q;
    private h r;
    private boolean s;
    private boolean t;
    private b u;
    private int w;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f5681e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5682f = true;
    private AtomicBoolean v = new AtomicBoolean(false);

    private void f() {
        this.l = new v(this);
        this.l.a((WebView) this.f5679c).a(this.r).a(this.j).b(this.k).b(this.n).a(this).c(ab.e(this.r));
        this.m = new v(this);
        this.m.a((WebView) this.f5680d).a(this.r).a(this.j).b(this.k).a(this).b(this.n).c(false).c(ab.e(this.r));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            o.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        setContentView(t.f(this, "tt_activity_ttlandingpage_playable"));
        a();
        this.g = this;
        h hVar = this.r;
        if (hVar == null) {
            return;
        }
        this.w = hVar.N();
        f();
        this.f5679c.setWebViewClient(new c(this.g, this.l, this.j, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTPlayableLandingPageActivity.this.i != null && !TTPlayableLandingPageActivity.this.isFinishing()) {
                        TTPlayableLandingPageActivity.this.i.setVisibility(8);
                    }
                    if (TTPlayableLandingPageActivity.this.f5681e) {
                        TTPlayableLandingPageActivity.this.b();
                        TTPlayableLandingPageActivity.this.a("py_loading_success");
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.f5681e = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTPlayableLandingPageActivity.this.o != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.o.equals(webResourceRequest.getUrl().toString())) {
                    TTPlayableLandingPageActivity.this.f5681e = false;
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableLandingPageActivity.this.f5681e = false;
            }
        });
        a(this.f5679c);
        a(this.f5680d);
        c();
        this.f5679c.loadUrl(this.o);
        this.f5679c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.l, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTPlayableLandingPageActivity.this.i == null || TTPlayableLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTPlayableLandingPageActivity.this.i.isShown()) {
                    TTPlayableLandingPageActivity.this.i.setProgress(i);
                } else {
                    TTPlayableLandingPageActivity.this.i.setVisibility(8);
                    TTPlayableLandingPageActivity.this.b();
                }
            }
        });
        this.f5678b = new ad(Looper.getMainLooper(), this);
        if (this.r.x() == 4) {
            this.u = b.a.a.a.a.a.c.a(this.g, this.r, this.q);
        }
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
        y.a(this.g, this.f5679c);
        y.a(this.f5679c);
        this.f5679c = null;
        v vVar = this.l;
        if (vVar != null) {
            vVar.g();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.g();
        }
        e();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        s.a().b(true);
        v vVar = this.l;
        if (vVar != null) {
            vVar.f();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        v vVar = this.l;
        if (vVar != null) {
            vVar.e();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.e();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.r != null ? this.r.Z().toString() : null);
            bundle.putInt("sdk_version", this.h);
            bundle.putString("adid", this.j);
            bundle.putString("log_extra", this.k);
            bundle.putInt("source", this.n);
            bundle.putBoolean("ad_pending_download", this.s);
            bundle.putString("url", this.o);
            bundle.putString("web_title", this.p);
            bundle.putString("event_tag", this.q);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private boolean c() {
        if (this.f5680d == null) {
            return false;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        this.f5680d.setWebViewClient(new c(this.g, this.m, this.j, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableLandingPageActivity.this.f5682f) {
                    TTPlayableLandingPageActivity.this.a("loading_h5_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.f5682f = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableLandingPageActivity.this.f5682f = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTPlayableLandingPageActivity.this.f5682f = false;
            }
        });
        this.f5680d.loadUrl(strD);
        return true;
    }

    private String d() {
        h hVar;
        String strK = o.h().k();
        if (TextUtils.isEmpty(strK) || (hVar = this.r) == null || hVar.K() == null) {
            return strK;
        }
        String strB = this.r.K().b();
        int iD = this.r.K().d();
        int iE = this.r.K().e();
        String strA = this.r.y().a();
        String strJ = this.r.J();
        String strC = this.r.K().c();
        String strA2 = this.r.K().a();
        String strB2 = this.r.K().b();
        StringBuffer stringBuffer = new StringBuffer(strK);
        stringBuffer.append("?appname=");
        stringBuffer.append(strB);
        stringBuffer.append("&stars=");
        stringBuffer.append(iD);
        stringBuffer.append("&comments=");
        stringBuffer.append(iE);
        stringBuffer.append("&icon=");
        stringBuffer.append(strA);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(strJ);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(strC);
        stringBuffer.append("&download_url=");
        stringBuffer.append(strA2);
        stringBuffer.append("&name=");
        stringBuffer.append(strB2);
        return stringBuffer.toString();
    }

    private void e() {
        b bVar;
        if (this.t || !this.s || (bVar = this.u) == null) {
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        SSWebView sSWebView;
        if (this.v.getAndSet(true) || (sSWebView = this.f5679c) == null || this.f5680d == null) {
            return;
        }
        ac.a((View) sSWebView, 0);
        ac.a((View) this.f5680d, 8);
        if (o.h().r(String.valueOf(ab.d(this.r.M()))).s >= 0) {
            this.f5678b.sendEmptyMessageDelayed(1, r0 * 1000);
        } else {
            ac.a((View) this.f5677a, 0);
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.h = intent.getIntExtra("sdk_version", 1);
        this.j = intent.getStringExtra("adid");
        this.k = intent.getStringExtra("log_extra");
        this.n = intent.getIntExtra("source", -1);
        this.s = intent.getBooleanExtra("ad_pending_download", false);
        this.o = intent.getStringExtra("url");
        this.p = intent.getStringExtra("web_title");
        this.q = intent.getStringExtra("event_tag");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra != null) {
                try {
                    this.r = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.utils.o.c("TTPlayableLandingPageActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.r = s.a().c();
            s.a().g();
        }
        if (bundle != null) {
            try {
                this.h = bundle.getInt("sdk_version", 1);
                this.j = bundle.getString("adid");
                this.k = bundle.getString("log_extra");
                this.n = bundle.getInt("source", -1);
                this.s = bundle.getBoolean("ad_pending_download", false);
                this.o = bundle.getString("url");
                this.p = bundle.getString("web_title");
                this.q = bundle.getString("event_tag");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.r = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.r == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTPlayableLandingPageActivity", "material is null, no data to display");
            finish();
        }
    }

    private void a() {
        this.f5679c = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.f5680d = (SSWebView) findViewById(t.e(this, "tt_browser_webview_loading"));
        this.f5677a = (RelativeLayout) findViewById(t.e(this, "tt_playable_ad_close_layout"));
        RelativeLayout relativeLayout = this.f5677a;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTPlayableLandingPageActivity.this.a("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        this.i = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        a.a(this.g).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(l.a(sSWebView, this.h));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.d.b(this, this.r, this.q, str, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 1) {
            ac.a((View) this.f5677a, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.d
    public void a(boolean z) {
        b bVar;
        this.s = true;
        this.t = z;
        if (!z) {
            Toast.makeText(this.g, t.a(o.a(), "tt_toast_later_download"), 0).show();
        }
        if (!this.t || (bVar = this.u) == null) {
            return;
        }
        bVar.a();
    }
}
