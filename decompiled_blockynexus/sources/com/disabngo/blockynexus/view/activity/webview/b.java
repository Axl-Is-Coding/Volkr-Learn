package com.disabngo.blockynexus.view.activity.webview;

/* JADX INFO: compiled from: WebViewActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewActivity f11243a;

    b(WebViewActivity webViewActivity) {
        this.f11243a = webViewActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f11243a.g.setSelected(true);
    }
}
