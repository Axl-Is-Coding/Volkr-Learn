package com.sandboxol.ads.mob;

import com.google.android.gms.ads.AdListener;
import com.sandboxol.common.interfaces.InterstitialAdapter;

/* JADX INFO: compiled from: AdsMobUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InterstitialAdapter f16040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f16041b;

    b(c cVar, InterstitialAdapter interstitialAdapter) {
        this.f16041b = cVar;
        this.f16040a = interstitialAdapter;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        super.onAdClosed();
        this.f16040a.onAdClosed();
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        super.onAdLoaded();
        this.f16040a.onAdLoaded();
    }
}
