package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.widget.Toast;

/* JADX INFO: loaded from: classes.dex */
class s implements DownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ XBHybridWebView f3930a;

    s(XBHybridWebView xBHybridWebView) {
        this.f3930a = xBHybridWebView;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("HybridWebView", "Download start, url: " + str + " contentDisposition: " + str3 + " mimetype: " + str4 + " contentLength: " + j);
        }
        if (!this.f3930a.supportDownload) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("HybridWebView", "DownloadListener is not support for webview.");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            this.f3930a.context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this.f3930a.context, "对不起，您的设备找不到相应的程序", 1).show();
            com.alibaba.sdk.android.feedback.xblink.i.g.b("HybridWebView", "DownloadListener not found activity to open this url.");
        }
    }
}
