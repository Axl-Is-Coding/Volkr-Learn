package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: WebViewPool.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f6677c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f6678d = 10;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f6679e = 3;
    private static volatile d g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<WeakReference<SSWebView>> f6680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<WeakReference<SSWebView>> f6681b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f6682f = new AtomicBoolean(false);

    private d() {
        this.f6680a = new ArrayList();
        this.f6681b = new ArrayList();
        this.f6680a = new ArrayList();
        this.f6681b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (int i = 0; i < f6679e; i++) {
            SSWebView sSWebView = new SSWebView(o.a());
            sSWebView.loadUrl("about:blank");
            this.f6680a.add(new WeakReference<>(sSWebView));
        }
    }

    public void b() {
        if (this.f6682f.getAndSet(true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d();
                }
            });
        }
    }

    public WeakReference<SSWebView> c() {
        WeakReference<SSWebView> weakReference;
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===start getWebView available:" + this.f6680a.size() + " ,inuse:" + this.f6681b.size());
        synchronized (f6677c) {
            try {
                if (this.f6680a.size() <= 0 || this.f6680a.get(0) == null) {
                    weakReference = new WeakReference<>(new SSWebView(o.a()));
                    this.f6681b.add(weakReference);
                } else {
                    WeakReference<SSWebView> weakReference2 = this.f6680a.get(0);
                    if (weakReference2.get() != null) {
                        this.f6680a.remove(0);
                        this.f6681b.add(weakReference2);
                        weakReference = weakReference2;
                    } else {
                        this.f6680a.remove(0);
                        weakReference = new WeakReference<>(new SSWebView(o.a()));
                        this.f6681b.add(weakReference);
                    }
                }
                com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===end getWebView available:" + this.f6680a.size() + " ,inuse:" + this.f6681b.size());
                weakReference.get().loadUrl("about:blank");
            } catch (Exception unused) {
                weakReference = new WeakReference<>(new SSWebView(o.a()));
                this.f6681b.add(weakReference);
            }
        }
        return weakReference;
    }

    public static d a() {
        if (g == null) {
            synchronized (d.class) {
                if (g == null) {
                    g = new d();
                }
            }
        }
        return g;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===start removeWebView available:" + this.f6680a.size() + " ,inuse:" + this.f6681b.size());
        if (!z || weakReference == null || weakReference.get() == null) {
            return;
        }
        try {
            SSWebView sSWebView = weakReference.get();
            viewGroup.removeView(sSWebView);
            sSWebView.loadUrl("");
            sSWebView.stopLoading();
            sSWebView.setWebChromeClient(null);
            sSWebView.setWebViewClient(null);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            sSWebView.getSettings().setJavaScriptEnabled(true);
            sSWebView.getSettings().setCacheMode(2);
            sSWebView.getSettings().setAppCacheEnabled(false);
            sSWebView.getSettings().setSupportZoom(false);
            sSWebView.getSettings().setUseWideViewPort(true);
            sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.getSettings().setDomStorageEnabled(true);
            sSWebView.getSettings().setBuiltInZoomControls(false);
            sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            sSWebView.getSettings().setLoadWithOverviewMode(false);
            sSWebView.getSettings().setUserAgentString("android_client");
            sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
            sSWebView.getSettings().setDefaultFontSize(16);
            y.a(o.a(), sSWebView);
            y.a(sSWebView);
            synchronized (f6677c) {
                this.f6681b.remove(weakReference);
                if (this.f6680a.size() < f6679e) {
                    SSWebView sSWebView2 = new SSWebView(o.a());
                    sSWebView2.loadUrl("about:blank");
                    this.f6680a.add(new WeakReference<>(sSWebView2));
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===end removeWebView available:" + this.f6680a.size() + " ,inuse:" + this.f6681b.size());
    }
}
