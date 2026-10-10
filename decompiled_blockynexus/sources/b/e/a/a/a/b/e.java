package b.e.a.a.a.b;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebView f2562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f2563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ f f2564c;

    e(f fVar, WebView webView, String str) {
        this.f2564c = fVar;
        this.f2562a = webView;
        this.f2563b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2562a.loadUrl(this.f2563b);
    }
}
