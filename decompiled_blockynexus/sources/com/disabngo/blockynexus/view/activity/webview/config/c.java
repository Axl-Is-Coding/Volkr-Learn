package com.disabngo.blockynexus.view.activity.webview.config;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;

/* JADX INFO: compiled from: MyWebChromeClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11246a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11247b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ValueCallback<Uri> f11248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ValueCallback<Uri[]> f11249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f11250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebViewActivity f11251f;
    private a g;
    private View h;
    private WebChromeClient.CustomViewCallback i;

    public c(a aVar) {
        this.g = aVar;
        this.f11251f = (WebViewActivity) aVar;
    }

    public boolean a() {
        return this.h != null;
    }

    public void b(Intent intent, int i) {
        if (this.f11249d == null) {
            return;
        }
        Uri data = (intent == null || i != -1) ? null : intent.getData();
        if (data != null) {
            this.f11249d.onReceiveValue(new Uri[]{data});
        } else {
            this.f11249d.onReceiveValue(new Uri[0]);
        }
        this.f11249d = null;
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.f11250e == null) {
            this.f11250e = LayoutInflater.from(this.f11251f).inflate(R.layout.video_loading_progress, (ViewGroup) null);
        }
        return this.f11250e;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.h == null) {
            return;
        }
        this.f11251f.setRequestedOrientation(1);
        this.h.setVisibility(8);
        if (this.f11251f.g() != null) {
            this.f11251f.g().removeView(this.h);
        }
        this.h = null;
        this.g.f();
        this.i.onCustomViewHidden();
        this.g.a();
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.g.a(i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        this.f11251f.setTitle(str);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.f11251f.setRequestedOrientation(0);
        this.g.d();
        if (this.h != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.f11251f.fullViewAddView(view);
        this.h = view;
        this.i = customViewCallback;
        this.g.e();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        a(valueCallback);
        return true;
    }

    private void a(ValueCallback<Uri[]> valueCallback) {
        this.f11249d = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", "图片选择");
        this.f11251f.startActivityForResult(intent2, f11247b);
    }

    public void a(Intent intent, int i) {
        if (this.f11248c == null) {
            return;
        }
        this.f11248c.onReceiveValue((intent == null || i != -1) ? null : intent.getData());
        this.f11248c = null;
    }
}
