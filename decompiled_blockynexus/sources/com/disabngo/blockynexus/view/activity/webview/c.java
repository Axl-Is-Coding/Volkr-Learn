package com.disabngo.blockynexus.view.activity.webview;

import android.view.View;

/* JADX INFO: compiled from: WebViewActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewActivity f11244a;

    c(WebViewActivity webViewActivity) {
        this.f11244a = webViewActivity;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return this.f11244a.m();
    }
}
