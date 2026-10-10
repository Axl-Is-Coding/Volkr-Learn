package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzse extends zzsl {
    private final AppOpenAdPresentationCallback zzbur;

    public zzse(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbur = appOpenAdPresentationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsm
    public final void onAppOpenAdClosed() {
        this.zzbur.onAppOpenAdClosed();
    }
}
