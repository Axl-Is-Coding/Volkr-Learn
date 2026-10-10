package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzsi extends zzgu implements zzsg {
    zzsi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsm zzsmVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzsmVar);
        zza(3, parcelObtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzxc zzdw() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
        zzxc zzxcVarZzc = zzxf.zzc(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzxcVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final zzyn zzki() throws RemoteException {
        Parcel parcelTransactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
        zzyn zzynVarZzj = zzym.zzj(parcelTransactAndReadException.readStrongBinder());
        parcelTransactAndReadException.recycle();
        return zzynVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsqVar) throws RemoteException {
        Parcel parcelObtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(parcelObtainAndWriteInterfaceToken, iObjectWrapper);
        zzgw.zza(parcelObtainAndWriteInterfaceToken, zzsqVar);
        zza(4, parcelObtainAndWriteInterfaceToken);
    }
}
