package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzagp implements Runnable {
    private final /* synthetic */ PublisherAdView zzdej;
    private final /* synthetic */ zzxc zzdek;
    private final /* synthetic */ zzagq zzdel;

    zzagp(zzagq zzagqVar, PublisherAdView publisherAdView, zzxc zzxcVar) {
        this.zzdel = zzagqVar;
        this.zzdej = publisherAdView;
        this.zzdek = zzxcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzdej.zza(this.zzdek)) {
            this.zzdel.zzdem.onPublisherAdViewLoaded(this.zzdej);
        } else {
            zzbbq.zzfe("Could not bind.");
        }
    }
}
