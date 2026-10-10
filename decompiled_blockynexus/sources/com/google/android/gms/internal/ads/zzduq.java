package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzduq extends zzgu implements zzdun {
    zzduq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdun
    public final zzdul zza(zzduj zzdujVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzdujVar);
        Parcel parcelTransactAndReadException = transactAndReadException(1, parcelObtainAndWriteInterfaceToken);
        zzdul zzdulVar = (zzdul) zzgw.zza(parcelTransactAndReadException, zzdul.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzdulVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdun
    public final void zza(zzdui zzduiVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzduiVar);
        zza(2, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzdun
    public final zzduv zza(zzdut zzdutVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzdutVar);
        Parcel parcelTransactAndReadException = transactAndReadException(3, parcelObtainAndWriteInterfaceToken);
        zzduv zzduvVar = (zzduv) zzgw.zza(parcelTransactAndReadException, zzduv.CREATOR);
        parcelTransactAndReadException.recycle();
        return zzduvVar;
    }
}
