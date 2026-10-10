package com.iab.omid.library.ironsrc.publisher;

import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f14555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f14556b;

    b(c cVar) {
        this.f14556b = cVar;
        this.f14555a = this.f14556b.f14557e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14555a.destroy();
    }
}
