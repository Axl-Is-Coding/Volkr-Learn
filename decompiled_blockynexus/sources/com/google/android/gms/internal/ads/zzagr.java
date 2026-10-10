package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagr extends zzagc {
    private final UnifiedNativeAd.UnconfirmedClickListener zzden;

    public zzagr(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zzden = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void onUnconfirmedClickCancelled() {
        this.zzden.onUnconfirmedClickCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzafz
    public final void onUnconfirmedClickReceived(String str) {
        this.zzden.onUnconfirmedClickReceived(str);
    }
}
