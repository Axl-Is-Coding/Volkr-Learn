package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f3802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected XBHybridWebView f3803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f3804c = true;

    public void a() {
        this.f3804c = false;
        this.f3802a = null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(Context context, XBHybridWebView xBHybridWebView) {
        this.f3802a = context;
        this.f3803b = xBHybridWebView;
    }

    public abstract boolean a(String str, String str2, b bVar);

    public void b() {
        this.f3804c = false;
    }

    public void c() {
        this.f3804c = true;
    }
}
