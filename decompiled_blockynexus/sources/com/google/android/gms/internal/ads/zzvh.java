package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvh extends zzxi {
    private final AdMetadataListener zzchq;

    public zzvh(AdMetadataListener adMetadataListener) {
        this.zzchq = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzchq;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
