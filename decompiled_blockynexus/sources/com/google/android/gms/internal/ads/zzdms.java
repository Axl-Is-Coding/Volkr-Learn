package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdms implements zzdlk {
    static final zzdlk zzhaw = new zzdms();

    private zzdms() {
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzq(Object obj) throws RemoteException {
        ((zzavd) obj).onRewardedAdOpened();
    }
}
