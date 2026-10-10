package com.alibaba.sdk.android.feedback.xblink.webview;

/* JADX INFO: loaded from: classes.dex */
class b extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ HybridPlusWebView f3905d;

    private b(HybridPlusWebView hybridPlusWebView) {
        this.f3905d = hybridPlusWebView;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"htmlFinsh".equals(str)) {
            return false;
        }
        this.f3905d.mHandler.sendEmptyMessage(HybridPlusWebView.DOMREADY);
        if (!com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            return true;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.c("HybridPlusWebView", "dom ready time:" + (System.currentTimeMillis() - this.f3905d.beginTime));
        return true;
    }
}
