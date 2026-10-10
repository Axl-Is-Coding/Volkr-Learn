package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajg extends zzgu implements zzaje {
    zzajg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void destroy() throws RemoteException {
        zza(4, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final zzyo getVideoController() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
        zzyo zzyoVarZzk = zzyr.zzk(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzyoVarZzk;
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zza(IObjectWrapper iObjectWrapper, zzajf zzajfVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzajfVar);
        zza(5, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zza(6, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzaje
    public final zzadz zzsw() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
        zzadz zzadzVarZzn = zzaec.zzn(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzadzVarZzn;
    }
}
