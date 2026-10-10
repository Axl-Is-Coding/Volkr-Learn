package com.alibaba.sdk.android.feedback.windvane;

import android.webkit.WebView;
import android.widget.ProgressBar;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridWebChromeClient;

/* JADX INFO: loaded from: classes.dex */
public class CustomWebChromeClient extends HybridWebChromeClient {
    private ProgressBar progressbar;

    public CustomWebChromeClient(ProgressBar progressBar) {
        this.progressbar = progressBar;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.HybridWebChromeClient, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar = this.progressbar;
        if (progressBar != null) {
            progressBar.setProgress(i);
            if (i == 100) {
                this.progressbar.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i);
    }
}
