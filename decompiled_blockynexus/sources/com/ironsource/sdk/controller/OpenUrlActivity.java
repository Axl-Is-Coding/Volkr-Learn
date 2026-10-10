package com.ironsource.sdk.controller;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OpenUrlActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f15188a = com.ironsource.sdk.utils.i.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f15189b = com.ironsource.sdk.utils.i.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WebController f15191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ProgressBar f15192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f15193f;
    private RelativeLayout g;
    private String h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f15190c = null;
    private Handler i = new Handler();
    private boolean j = false;
    private final Runnable k = new RunnableC2384aa(this);

    private class a extends WebViewClient {
        private a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            OpenUrlActivity.this.f15192e.setVisibility(4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            OpenUrlActivity.this.f15192e.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> listC = com.ironsource.sdk.utils.d.d().c();
            if (listC != null && !listC.isEmpty()) {
                Iterator<String> it = listC.iterator();
                while (it.hasNext()) {
                    if (str.contains(it.next())) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            OpenUrlActivity.this.f15191d.interceptedUrlToStore();
                        } catch (Exception e2) {
                            StringBuilder sb = new StringBuilder();
                            if (e2 instanceof ActivityNotFoundException) {
                                sb.append("no activity to handle url");
                            } else {
                                sb.append("activity failed to open with unspecified reason");
                            }
                            if (OpenUrlActivity.this.f15191d != null) {
                                OpenUrlActivity.this.f15191d.failedToStartStoreActivity(sb.toString(), str);
                            }
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ a(OpenUrlActivity openUrlActivity, Z z) {
            this();
        }
    }

    private void f() {
        ViewGroup viewGroup;
        WebController webController = this.f15191d;
        if (webController != null) {
            webController.viewableChange(false, "secondary");
            if (this.g == null || (viewGroup = (ViewGroup) this.f15190c.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(f15188a) != null) {
                viewGroup.removeView(this.f15190c);
            }
            if (viewGroup.findViewById(f15189b) != null) {
                viewGroup.removeView(this.f15192e);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        WebController webController;
        if (this.f15193f && (webController = this.f15191d) != null) {
            webController.engageEnd("secondaryClose");
        }
        super.finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f15190c.canGoBack()) {
            this.f15190c.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.ironsource.sdk.utils.f.c("OpenUrlActivity", "onCreate()");
        try {
            this.f15191d = (WebController) b.f.d.c.p.c(this).a().f();
            d();
            e();
            Bundle extras = getIntent().getExtras();
            this.h = extras.getString(WebController.EXTERNAL_URL);
            this.f15193f = extras.getBoolean(WebController.SECONDARY_WEB_VIEW);
            this.j = getIntent().getBooleanExtra("immersive", false);
            if (this.j) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new Z(this));
                runOnUiThread(this.k);
            }
            this.g = new RelativeLayout(this);
            setContentView(this.g, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.j && (i == 25 || i == 24)) {
            this.i.postDelayed(this.k, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        f();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.j && z) {
            runOnUiThread(this.k);
        }
    }

    private void a() {
        if (this.f15192e == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f15192e = new ProgressBar(new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog));
            } else {
                this.f15192e = new ProgressBar(this);
            }
            this.f15192e.setId(f15189b);
        }
        if (findViewById(f15189b) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f15192e.setLayoutParams(layoutParams);
            this.f15192e.setVisibility(4);
            this.g.addView(this.f15192e);
        }
    }

    private void b() {
        if (this.f15190c == null) {
            this.f15190c = new WebView(getApplicationContext());
            this.f15190c.setId(f15188a);
            this.f15190c.getSettings().setJavaScriptEnabled(true);
            this.f15190c.setWebViewClient(new a(this, null));
            a(this.h);
        }
        if (findViewById(f15188a) == null) {
            this.g.addView(this.f15190c, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        WebController webController = this.f15191d;
        if (webController != null) {
            webController.viewableChange(true, "secondary");
        }
    }

    private void c() {
        WebView webView = this.f15190c;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        requestWindowFeature(1);
    }

    private void e() {
        getWindow().setFlags(1024, 1024);
    }

    public void a(String str) {
        this.f15190c.stopLoading();
        this.f15190c.clearHistory();
        try {
            this.f15190c.loadUrl(str);
        } catch (Throwable th) {
            com.ironsource.sdk.utils.f.b("OpenUrlActivity", "OpenUrlActivity:: loadUrl: " + th.toString());
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + th.getStackTrace()[0].getMethodName());
        }
    }
}
