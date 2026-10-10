package com.ironsource.mediationsdk;

import android.content.Context;
import android.webkit.WebView;
import com.ironsource.mediationsdk.logger.IronLog;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AuctionDataUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2319f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f14812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AuctionDataUtils f14813b;

    RunnableC2319f(AuctionDataUtils auctionDataUtils, Context context) {
        this.f14813b = auctionDataUtils;
        this.f14812a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14813b.f14603b = new WebView(this.f14812a).getSettings().getUserAgentString();
            IronLog.INTERNAL.verbose("mBrowserUserAgent = " + this.f14813b.f14603b);
            com.ironsource.mediationsdk.utils.j.e(this.f14812a, this.f14813b.f14603b);
        } catch (Exception unused) {
        }
    }
}
