package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaah extends zzys {
    private final VideoController.VideoLifecycleCallbacks zzads;

    public zzaah(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zzads = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoEnd() {
        this.zzads.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoMute(boolean z) {
        this.zzads.onVideoMute(z);
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoPause() {
        this.zzads.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoPlay() {
        this.zzads.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoStart() {
        this.zzads.onVideoStart();
    }
}
