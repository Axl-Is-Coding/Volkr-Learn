package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdmp implements zzdlk {
    static final zzdlk zzhaw = new zzdmp();

    private zzdmp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzq(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
