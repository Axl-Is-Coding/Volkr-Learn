package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbim extends zzbil implements zzbir {
    private boolean zzepb;
    private boolean zzepu;
    private final zzbik zzeqx;

    public zzbim(Context context, zzbik zzbikVar) {
        super(context);
        com.google.android.gms.ads.internal.zzp.zzkv().zzwq();
        this.zzeqx = zzbikVar;
        super.setWebViewClient(zzbikVar);
    }

    private final synchronized void zzwr() {
        if (!this.zzepu) {
            this.zzepu = true;
            com.google.android.gms.ads.internal.zzp.zzkv().zzwr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbil, android.webkit.WebView
    public /* bridge */ /* synthetic */ void addJavascriptInterface(Object obj, String str) {
        super.addJavascriptInterface(obj, str);
    }

    @Override // android.webkit.WebView
    public synchronized void destroy() {
        if (this.zzepb) {
            return;
        }
        this.zzepb = true;
        this.zzeqx.zza(this);
        zzbe(false);
        zzayp.zzei("Initiating WebView self destruct sequence in 3...");
        zzayp.zzei("Loading blank page in WebView, 2...");
        try {
            super.loadUrl("about:blank");
        } catch (UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!isDestroyed()) {
                    zzbe(true);
                }
                zzwr();
            }
        } finally {
            super.finalize();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzepb;
    }

    @Override // android.webkit.WebView
    public synchronized void loadData(String str, String str2, String str3) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView
    public synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbil, android.webkit.WebView
    public synchronized void loadUrl(String str) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadUrl(str);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public void onPause() {
        if (isDestroyed()) {
            return;
        }
        super.onPause();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public void onResume() {
        if (isDestroyed()) {
            return;
        }
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !isDestroyed() && super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        super.stopLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzbir
    public final synchronized void zza(zzbin zzbinVar) {
        zzayp.zzei("Blank page loaded, 1...");
        zzacc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public synchronized void zzacc() {
        zzayp.zzei("Destroying WebView!");
        zzwr();
        zzbbz.zzeet.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbip
            private final zzbim zzeqz;

            {
                this.zzeqz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeqz.zzadf();
            }
        });
    }

    final /* synthetic */ void zzadf() {
        super.destroy();
    }

    protected void zzbe(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzbil, com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzaks
    public /* bridge */ /* synthetic */ void zzdc(String str) {
        super.zzdc(str);
    }
}
