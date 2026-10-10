package com.alibaba.sdk.android.feedback.xblink.webview;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
public class HybridWebChromeClient extends WebChromeClient {
    private static final long MAX_QUOTA = 20971520;
    private static final String TAG = "HybridWebChromeClient";
    protected Context mContext;

    @Deprecated
    public HybridWebChromeClient() {
    }

    public HybridWebChromeClient(Context context) {
        this.mContext = context;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.c(TAG, "onConsoleMessage:" + consoleMessage.message() + " at " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber());
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (j2 < MAX_QUOTA) {
            quotaUpdater.updateQuota(j2);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    @Override // android.webkit.WebChromeClient
    @TargetApi(5)
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str2);
        builder.setTitle("提示");
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.ok, new d(this, jsResult));
        builder.setOnCancelListener(new e(this, jsResult));
        builder.create();
        builder.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Context context = this.mContext;
        if (!(context instanceof Activity)) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str2);
        builder.setTitle("提示");
        builder.setCancelable(true);
        builder.setPositiveButton(R.string.ok, new f(this, jsResult));
        builder.setNegativeButton(R.string.cancel, new g(this, jsResult));
        builder.setOnCancelListener(new h(this, jsResult));
        builder.create();
        builder.show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.c(TAG, "onJsPrompt: " + str2 + "; defaultValue: " + str3 + "; url: " + str);
        }
        if (str3 == null || !str3.equals("wv_hybrid:")) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.f.d.a().a((XBHybridWebView) webView, str2);
        jsPromptResult.confirm("");
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }
}
