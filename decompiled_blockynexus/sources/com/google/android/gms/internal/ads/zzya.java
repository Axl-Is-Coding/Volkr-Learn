package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzya extends zzxy {
    private final MuteThisAdListener zzcjj;

    public zzya(MuteThisAdListener muteThisAdListener) {
        this.zzcjj = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final void onAdMuted() {
        this.zzcjj.onAdMuted();
    }
}
