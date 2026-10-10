package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabz extends zzabx {
    private final OnCustomRenderedAdLoadedListener zzcjv;

    public zzabz(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjv = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaby
    public final void zza(zzabt zzabtVar) {
        this.zzcjv.onCustomRenderedAdLoaded(new zzabu(zzabtVar));
    }
}
