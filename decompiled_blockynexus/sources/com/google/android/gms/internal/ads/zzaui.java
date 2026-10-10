package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaui extends zzgu implements zzaug {
    zzaui(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdClosed() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        parcelObtainAndWriteInterfaceToken.writeInt(i);
        zza(7, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        zza(6, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdLoaded() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoAdOpened() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoCompleted() throws RemoteException {
        zza(8, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void onRewardedVideoStarted() throws RemoteException {
        zza(3, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void zza(zzatw zzatwVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzatwVar);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }
}
