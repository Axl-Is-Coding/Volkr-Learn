package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzss extends zzgu implements zzsq {
    zzss(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAdDismissedFullScreenContent() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void onAdShowedFullScreenContent() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzsq
    public final void zzb(zzva zzvaVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzvaVar);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }
}
