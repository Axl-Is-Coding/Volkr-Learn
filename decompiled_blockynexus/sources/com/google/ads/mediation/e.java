package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class e extends AdMetadataListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AbstractAdViewAdapter f12567a;

    e(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f12567a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.f12567a.zzmm == null || this.f12567a.zzmn == null) {
            return;
        }
        this.f12567a.zzmn.zzb(this.f12567a.zzmm.getAdMetadata());
    }
}
