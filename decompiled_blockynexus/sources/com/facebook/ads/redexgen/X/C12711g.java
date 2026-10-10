package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.AdError;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C12711g extends WebViewClient {
    public boolean A00 = false;
    public final C1R A01;
    public final InterfaceC12701f A02;
    public final boolean A03;

    public C12711g(C1R c1r, InterfaceC12701f interfaceC12701f, boolean z) {
        this.A01 = c1r;
        this.A02 = interfaceC12701f;
        this.A03 = z;
    }

    private void A00() {
        InterfaceC12701f interfaceC12701f = this.A02;
        if (interfaceC12701f != null) {
            interfaceC12701f.AAl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01(WebResourceError webResourceError) {
        if (this.A03) {
            this.A02.AAk(AdError.CACHE_ERROR);
        } else {
            A00();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.A00 = true;
        A00();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        new Handler().postDelayed(new RU(this), this.A01.A09());
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.A00 = true;
        A01(webResourceError);
    }
}
