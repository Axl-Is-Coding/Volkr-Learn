package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaen extends zzgu implements zzael {
    zzaen(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final void unregisterNativeAd() throws RemoteException {
        zza(2, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(1, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }
}
