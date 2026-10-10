package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagn extends zzafi {
    private final NativeContentAd.OnContentAdLoadedListener zzdeh;

    public zzagn(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdeh = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void zza(zzaew zzaewVar) {
        this.zzdeh.onContentAdLoaded(new zzaex(zzaewVar));
    }
}
