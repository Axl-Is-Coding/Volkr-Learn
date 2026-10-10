package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdmk implements zzdlk {
    static final zzdlk zzhaw = new zzdmk();

    private zzdmk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzq(Object obj) throws RemoteException {
        ((zzaug) obj).onRewardedVideoCompleted();
    }
}
