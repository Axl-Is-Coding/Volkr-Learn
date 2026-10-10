package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyv extends zzgu implements zzyt {
    zzyv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoEnd() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoMute(boolean z) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.writeBoolean(parcelObtainAndWriteInterfaceToken, z);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoPause() throws RemoteException {
        zza(3, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoPlay() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzyt
    public final void onVideoStart() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
