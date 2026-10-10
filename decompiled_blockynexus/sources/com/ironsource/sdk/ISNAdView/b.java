package com.ironsource.sdk.ISNAdView;

import b.f.d.a.g;

/* JADX INFO: compiled from: ISNAdView.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ISNAdView f15086d;

    b(ISNAdView iSNAdView, String str, String str2, String str3) {
        this.f15086d = iSNAdView;
        this.f15083a = str;
        this.f15084b = str2;
        this.f15085c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f15086d.mWebView == null) {
                this.f15086d.createWebView(this.f15083a, this.f15084b);
            }
            this.f15086d.addView(this.f15086d.mWebView);
            this.f15086d.mWebView.loadUrl(this.f15085c);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f15086d.mIsnAdViewLogic.a(this.f15084b, e2.getMessage());
            g.a aVar = b.f.d.a.g.r;
            b.f.d.a.a aVar2 = new b.f.d.a.a();
            aVar2.a("callfailreason", e2.getMessage());
            b.f.d.a.e.a(aVar, aVar2.a());
        }
    }
}
