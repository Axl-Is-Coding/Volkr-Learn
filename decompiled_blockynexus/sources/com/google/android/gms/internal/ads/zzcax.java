package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcax implements zzbyt {
    static final zzbyt zzfur = new zzcax();

    private zzcax() {
    }

    @Override // com.google.android.gms.internal.ads.zzbyt
    public final void zzp(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoPlay();
    }
}
