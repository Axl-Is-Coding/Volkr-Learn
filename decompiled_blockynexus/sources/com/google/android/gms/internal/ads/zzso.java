package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzso extends zzgu implements zzsm {
    zzso(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsm
    public final void onAppOpenAdClosed() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
